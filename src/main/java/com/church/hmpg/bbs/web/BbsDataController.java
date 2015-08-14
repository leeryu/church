package com.church.hmpg.bbs.web;

import com.church.common.ComConstants;
import com.church.common.util.PaginationCaculateUtil;
import com.church.hmpg.bbs.service.BbsDataService;
import com.church.hmpg.bbs.vo.BbsData;
import com.church.hmpg.bbs.vo.BbsDataVo;
import com.church.hmpg.bbs.vo.Default;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import java.util.Locale;

/**
 * Class Name   : com.church.hmpg.bbs.web
 * Description  :
 * <p/>
 * <p/>
 * Modification Information
 * -----------------------------------------------------------
 * 수정일                 수정자                 수정내용
 * -----------------------------------------------------------
 * <p/>
 * 2015. 8. 2.             ronkzoo             최초생성
 */
@Controller
@RequestMapping(value = "/hmpg")
public class BbsDataController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /** **/
    @Resource(name = "bbsDataService") BbsDataService bbsDataService;

    @Autowired MessageSource messageSource;

    /**
     * 목록 페이지
     * @param bbsDataVo
     * @param boardSid
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/boards/{boardSid}"}, method = RequestMethod.GET)
    public String selectBoardList(@ModelAttribute("bbsDataVo") BbsDataVo bbsDataVo, @PathVariable Integer boardSid, ModelMap model) throws Exception {

        bbsDataVo.setTotalRecordCount(this.bbsDataService.selectTotalCount(bbsDataVo));
        if(bbsDataVo.getSearchPageUnit() > 0){
            bbsDataVo.setPageUnit(bbsDataVo.getSearchPageUnit());
        }

        PaginationCaculateUtil.cacualtePagination(bbsDataVo);

        model.addAttribute("selectList", bbsDataService.selectList(bbsDataVo));
        model.addAttribute("paginationInfoVo", PaginationCaculateUtil.getPaginationInfoVo(bbsDataVo));

        return "hmpg/bbs/BbsDataList";
    }

    /**
     * 상세 페이지
     * @param model
     * @param dataSid
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/boards/{boardSid}/{dataSid}", method = RequestMethod.GET)
    public String selectBoard( ModelMap model, @PathVariable int dataSid,
        @ModelAttribute(value = "bbsDataVo") BbsDataVo bbsDataVo) throws  Exception {

        model.addAttribute("resultMap",bbsDataService.select(bbsDataVo));
        // 이전글
        model.addAttribute("resultPrevMap", bbsDataService.selectPrevView(bbsDataVo));
        // 다음글
        model.addAttribute("resultNextMap", bbsDataService.selectNextView(bbsDataVo));
        // 조회 수 증가
        bbsDataService.updateViewCount(bbsDataVo);

        return "hmpg/bbs/BbsDataView";
    }

    /**
     * 등록 페이지
     * @param model
     * @param
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/boards/{boardSid}/new", method = RequestMethod.GET)
    public String insertArticlePage( ModelMap model, @ModelAttribute(value = "bbsDataVo") BbsDataVo bbsDataVo) throws  Exception {

        model.addAttribute("resultMap",new BbsDataVo());
        model.addAttribute("cmd", ComConstants.INSERT.toString());
        model.addAttribute("method", HttpMethod.POST.toString());

        return "hmpg/bbs/BbsDataForm";
    }

    /**
     * 수정 페이지
     * @param model
     * @param
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/boards/{boardSid}/{dataSid}/edit", method = RequestMethod.GET)
    public String updateArticlePage( ModelMap model,
        @ModelAttribute(value = "bbsDataVo") BbsDataVo bbsDataVo) throws  Exception {

        model.addAttribute("cmd", ComConstants.UPDATE.toString());
        model.addAttribute("resultMap",bbsDataService.select(bbsDataVo));
        model.addAttribute("method", HttpMethod.PUT.toString());

        return "hmpg/bbs/BbsDataForm";
    }

    /**
     * 등록
     * @param
     * @param boardSid
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/boards/{boardSid}", method = RequestMethod.PUT)
    public String insertArticle(@PathVariable int boardSid,
        @Validated({Default.class}) BbsDataVo bbsDataVo,
        BindingResult result, final RedirectAttributes redirectAttributes) throws  Exception {

        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("msg.insert.failed",null, Locale.getDefault()));
        } else {
            bbsDataService.insert(bbsDataVo);
            redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("msg.insert.success",null, Locale.getDefault()));
        }

        return "redirect:/boards/"+boardSid;
    }

    /**
     * 수정
     * @param
     * @param
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/boards/{boardSid}/{dataSid}", method = RequestMethod.PUT)
    public String updateArticle(@PathVariable int boardSid,
        @Validated({BbsData.class}) BbsDataVo bbsDataVo,
        BindingResult result, final RedirectAttributes redirectAttributes) throws  Exception {

        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("msg",messageSource.getMessage("msg.update.failed",null,Locale.getDefault()));
        } else {
            bbsDataService.update(bbsDataVo);
            /**
             * 리다이렉트 전송시 RedirectAttributes를 사용하면 redirect post 구현이 가능
             * 리프레쉬 하면 사라짐.
             */
            redirectAttributes.addFlashAttribute("msg",messageSource.getMessage("msg.update.success",null,Locale.getDefault()));
        }

        return "redirect:/boards/"+boardSid;
    }

    /**
     * 삭제
     * @param model
     * @param boardSid
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/boards/{boardSid}/{dataSid}", method = RequestMethod.DELETE)
    public String deleteArticle( ModelMap model,
        @PathVariable int boardSid,
        @Validated({Default.class}) BbsDataVo bbsDataVo,
        BindingResult result, final RedirectAttributes redirectAttributes) throws  Exception {

        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("msg",messageSource.getMessage("msg.update.success",null,Locale.getDefault()));
        } else {
            bbsDataService.delete(bbsDataVo);
            redirectAttributes.addFlashAttribute("msg",messageSource.getMessage("msg.update.failed",null,Locale.getDefault()));
        }

        return "redirect:/boards/"+boardSid;
    }

}
