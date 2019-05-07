package com.spring.demo.controller.web;


import com.spring.demo.service.VisitorService;
import com.spring.demo.util.PageDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/visitorList")
    public String index() {
        return "visitor/visitorList";
    }

    @GetMapping("/getVisitorList")
    @ResponseBody
    public PageDataResult getVisitorList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                         @RequestParam(value = "visitorName", required = false) String visitorName) {
        PageDataResult pdr = null;
        pdr = visitorService.getPageVisitorList(page, limit, visitorName);
        return pdr;
    }
}

