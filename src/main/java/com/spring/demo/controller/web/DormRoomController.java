package com.spring.demo.controller.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.spring.demo.constant.UcenterResult;
import com.spring.demo.constant.UcenterResultConstant;
import com.spring.demo.entity.DormRoom;
import com.spring.demo.service.DormRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@Controller
@RequestMapping("/dormRoom")
public class DormRoomController {

    @Autowired
    private DormRoomService dormRoomService;

    /**
     * 获得所有宿舍
     *
     * @return
     */
    @GetMapping("getDormRoomList")
    @ResponseBody
    public UcenterResult getDormRoomList() {
        List<DormRoom> dormRoomList = dormRoomService.selectList(new EntityWrapper<DormRoom>());
        return new UcenterResult(UcenterResultConstant.SUCCESS, dormRoomList);
    }
}

