package com.church.test.web;

import com.church.test.vo.HelloWorldVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Restful Test
 * JsonTemplate
 */
@Controller("helloworldController")
@RequestMapping(value = "/hello")
public class HelloWorldController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("list")
    public String HelloWorld(HttpServletRequest request, Model model){
        HelloWorldVo hello = new HelloWorldVo() ;

        hello.setId("leeminuk");
        hello.setName("이민욱");

        model.addAttribute("hello", hello);

        return "jsonTemplate";
    }

    @RequestMapping("{name}")
    public String HelloWorld2(@PathVariable String name,  Model model){
        HelloWorldVo hello = new HelloWorldVo() ;

        model.addAttribute("hello", hello);
        logger.debug("/hello/name ");
        return "template/sql/"+name;
    }


}
