package com.spring.demo.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.util.AliyunOSSUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
    public String imageUpload(MultipartFile file) throws IOException {
        String fileUrl = "image/" + UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") - 1);
        return AliyunOSSUtil.upload(file.getInputStream(), fileUrl);
    }

    @RequestMapping(value = "/layUiImageUpload", method = RequestMethod.POST)
    public String layUiImageUpload(MultipartFile file) throws IOException {
        String fileUrl = "image/" + UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") - 1);
        String url = AliyunOSSUtil.upload(file.getInputStream(), fileUrl);
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", 0);
        resultJson.put("msg", "上传成功");
        resultJson.put("url", url);
        return resultJson.toString();
    }

}
