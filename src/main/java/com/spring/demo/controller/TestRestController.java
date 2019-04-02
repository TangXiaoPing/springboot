package com.spring.demo.controller;

import com.spring.demo.properties.AliyunOssProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestRestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/testGet")
    public String testGet(){
        return AliyunOssProperties.SPRING_FILE_ACCESS_KEY_ID;
    }
}
