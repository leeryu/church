package com.church.hmpg.bbs.web;

import com.church.common.util.PaginationCaculateUtil;
import com.church.hmpg.bbs.service.BbsDataService;
import com.church.hmpg.bbs.vo.BbsDataVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;

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

        @Resource(name = "bbsDataService") BbsDataService bbsDataService;

        @RequestMapping(value = {"/board", "/board/list"})
        public String selectBoardList(@ModelAttribute("bbsDataVo") BbsDataVo bbsDataVo, ModelMap model) throws Exception {

            PaginationCaculateUtil.cacualtePagination(bbsDataVo);

            model.addAttribute("selectList", bbsDataService.selectList(bbsDataVo));

            bbsDataVo.setTotalRecordCount(this.bbsDataService.selectTotalCount(bbsDataVo));

            model.addAttribute("paginationVo", PaginationCaculateUtil.getPaginationVo(bbsDataVo));

            return "hmpg/bbs/BbsDataList";
    }

    @RequestMapping(value = "/board/view/{dataSid}", method = RequestMethod.GET)
    public String selectBoard( ModelMap model, @PathVariable int dataSid,
        @ModelAttribute(value = "boardVO") BbsDataVo bbsDataVo) throws  Exception {
        bbsDataVo.setDataSid(dataSid);
        model.addAttribute("resultMap",bbsDataService.select(bbsDataVo));

        return "/hmpg/bbs/BoardDataView";
    }


}
