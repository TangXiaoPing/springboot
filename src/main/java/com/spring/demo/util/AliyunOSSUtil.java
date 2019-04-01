package com.spring.demo.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.spring.demo.properties.AliyunOssProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class AliyunOSSUtil {

    private static final String endpoint;
    private static final String accessKeyId;
    private static final String accessKeySecret;
    private static final String bucketName;
    private static final String fileHost;

    static {
        endpoint= AliyunOssProperties.SPRING_FILE_ENDPOINT;
        accessKeyId=AliyunOssProperties.SPRING_FILE_ACCESS_KEY_ID;
        accessKeySecret=AliyunOssProperties.SPRING_FILE_ACCESS_KEY_SECRET;
        bucketName=AliyunOssProperties.SPRING_FILE_BUCKET_NAME1;
        fileHost=AliyunOssProperties.SPRING_FILE_FILE_HOST;
    }

    public static String upload(File file){
        //logger.info("=========>OSS文件上传开始："+file.getName());
        LocalDateTime dateStr = LocalDateTime.now();
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-dd-MM");
            String landing = dateStr.format(format);
            System.out.printf("Arriving at : %s %n", landing);
        } catch(DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", dateStr);
            ex.printStackTrace();
        }

        if(null == file){
            return null;
        }

        OSSClient ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        try {
            //容器不存在，就创建
            if(! ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = dateStr + "/" + UUID.randomUUID().toString().replace("-","")+"-"+file.getName();
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
            if(null != result){
                return fileHost+fileUrl;
            }
        }catch (OSSException oe){

        }catch (ClientException ce){

        }finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }
}
