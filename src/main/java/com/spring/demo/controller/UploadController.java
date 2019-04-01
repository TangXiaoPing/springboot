package com.spring.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spring.demo.util.UeditorResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/ueditor")
    @ResponseBody
    public String ueditor(HttpServletRequest request, HttpServletResponse response) {

        String s = "{\n" +
                "            \"imageActionName\": \"uploadimage\",\n" +
                "                \"imageFieldName\": \"file\", \n" +
                "                \"imageMaxSize\": 2048000, \n" +
                "                \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" +
                "                \"imageCompressEnable\": true, \n" +
                "                \"imageCompressBorder\": 1600, \n" +
                "                \"imageInsertAlign\": \"none\", \n" +
                "                \"imageUrlPrefix\": \"\",\n" +
                "                \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\" }";
        return s;

    }

    /*@RequestMapping(value = "/imageUpload")
    @ResponseBody
    public String imgUpdate(MultipartFile[] multipartFiles) {
        if(multipartFiles != null && multipartFiles.length != 0){
            if(null != multipartFiles && multipartFiles.length > 0){
                //遍历并保存文件
                for(MultipartFile file : multipartFiles){
                    System.out.println(file.getName()+"--"+file.getOriginalFilename());
                }
            }
        }
        return "ok";
    }*/

    @RequestMapping(value = "/ueditor/imageUpload")
    @ResponseBody
    public String imgUpdate(MultipartFile file) {
        if (file != null) {
            System.out.println(file.getName() + "--" + file.getOriginalFilename());
        }
        UeditorResult ueditorResult = new UeditorResult("5dfcfea3e3b442bda3972053266c3bd3.jpg", "5dfcfea3e3b442bda3972053266c3bd3.jpg", "http://pics.sc.chinaz.com/files/pic/pic9/201707/zzpic5399.jpg");
        return JSON.toJSONString(ueditorResult);
    }
}
