package com.church.mngr.bbs.web;

import com.church.mngr.bbs.service.BbsService;
import com.church.mngr.bbs.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.web
 */
@RequestMapping(value = "/mngr")
@Controller
public class MngrBoardController {

    @Resource(name = "bbsService") BbsService bbsService;

    @RequestMapping(value = {"/board", "/board/"})
    public String mngrBoardList(HttpServletRequest request, HttpServletResponse response,
        ModelMap model) throws Exception{

        model.addAttribute("bbsList", bbsService.selectT(new HashMap<String, Object>()));
        return "/test/list";
    }

    @RequestMapping(value = "/board/{boardSid}", method = RequestMethod.GET)
    public String mngrBoardView(HttpServletRequest request, HttpServletResponse response,
        ModelMap model,
        @PathVariable int boardSid,
        @ModelAttribute(value = "boardVO")BoardVO boardVO) throws  Exception {

        return "/test/view";
    }

}
