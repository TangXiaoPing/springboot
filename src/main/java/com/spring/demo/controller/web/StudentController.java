package com.spring.demo.controller.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.spring.demo.constant.UcenterResult;
import com.spring.demo.constant.UcenterResultConstant;
import com.spring.demo.entity.Student;
import com.spring.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("getStuByDormRoomId")
    @ResponseBody
    public UcenterResult getStuByDormRoomId(@RequestParam("dormRoomId") Integer dormRoomId) {
        EntityWrapper<Student> studentEntityWrapper = new EntityWrapper<>();
        studentEntityWrapper.eq("stu_dorm_room_id", dormRoomId);
        List<Student> studentList = studentService.selectList(studentEntityWrapper);
        return new UcenterResult(UcenterResultConstant.SUCCESS, studentList);
    }
}

