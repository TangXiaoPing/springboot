package com.spring.demo.controller.web;


import com.spring.demo.constant.UcenterResult;
import com.spring.demo.constant.UcenterResultConstant;
import com.spring.demo.entity.Visitor;
import com.spring.demo.service.VisitorService;
import com.spring.demo.util.PageDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;

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

    /**
     * 跳转列表首页
     *
     * @return
     */
    @GetMapping("/visitorList")
    public String index() {
        return "visitor/visitorList";
    }

    /**
     * layui分页查询
     *
     * @param page
     * @param limit
     * @param visitorName
     * @return
     */
    @GetMapping("/getVisitorList")
    @ResponseBody
    public PageDataResult getVisitorList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                         @RequestParam(value = "visitorName", required = false) String visitorName) {
        PageDataResult pdr = null;
        pdr = visitorService.getPageVisitorList(page, limit, visitorName);
        return pdr;
    }

    /**
     * 跳转增加页面
     *
     * @return
     */
    @GetMapping("/toAddVisitor")
    public String toAddVisitor() {
        return "visitor/addVisitor";
    }

    /**
     * 添加visitor
     *
     * @param visitor
     * @return
     */
    @PostMapping("/addVisitor")
    @ResponseBody
    public UcenterResult addVisitor(@Validated Visitor visitor) {
        //设置访问时间为当天
        visitor.setVisitorTime(new Date());
        visitor.setCreateTime(new Date());
        visitorService.insert(visitor);
        return new UcenterResult(UcenterResultConstant.SUCCESS, null);
    }

    /**
     * 跳转修改页面
     *
     * @param visitorId
     * @return
     */
    @GetMapping("/toEditVisitor")
    public ModelAndView toEditVisitor(@RequestParam("visitorId") Integer visitorId) {
        ModelAndView mav = new ModelAndView("visitor/editVisitor");
        Visitor visitor = visitorService.selectById(visitorId);
        mav.addObject("visitor", visitor);
        return mav;
    }

    /**
     * 修改visitor
     *
     * @param visitor
     * @return
     */
    @PostMapping("/editVisitor")
    @ResponseBody
    public UcenterResult editVisitor(@Validated Visitor visitor) {
        visitor.setUpdateTime(new Date());
        visitorService.updateById(visitor);
        return new UcenterResult(UcenterResultConstant.SUCCESS, null);
    }

    /**
     * 单个删除
     *
     * @param visitorId
     * @return
     */
    @PostMapping("/delVisitorById")
    @ResponseBody
    public UcenterResult delVisitor(@RequestParam("visitorId") Integer visitorId) {
        visitorService.deleteById(visitorId);
        return new UcenterResult(UcenterResultConstant.SUCCESS, null);
    }

    /**
     * 批量删除
     *
     * @param visitorIds
     * @return
     */
    @PostMapping("/delVisitors")
    @ResponseBody
    public UcenterResult delVisitors(@RequestParam("visitorIds") String visitorIds) {
        String[] visitorIdList = visitorIds.split(",");
        visitorService.deleteBatchIds(Arrays.asList(visitorIdList));
        return new UcenterResult(UcenterResultConstant.SUCCESS, null);
    }

    /**
     * 跳转查看页面
     *
     * @param visitorId
     * @return
     */
    @GetMapping("/lookVisitor")
    public ModelAndView lookVisitor(@RequestParam("visitorId") Integer visitorId) {
        ModelAndView mav = new ModelAndView("visitor/lookVisitor");
        Visitor visitor = visitorService.selectById(visitorId);
        mav.addObject("visitor", visitor);
        return mav;
    }
}

