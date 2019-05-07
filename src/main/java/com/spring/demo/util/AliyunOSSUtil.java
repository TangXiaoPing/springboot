package com.spring.demo.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.spring.demo.properties.AliyunOssProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class AliyunOSSUtil {
    private static final Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);


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

    public static String upload(File file,String fileUrl){
        logger.info("=========>OSS文件上传开始："+file.getName());

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
            //String fileUrl = dateStr + "/" + UUID.randomUUID().toString().replace("-","")+"-"+file.getName();
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

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String upload(InputStream inputStream, String fileUrl) {
        logger.info("=========>OSS文件上传开始");
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
            //String fileUrl =UUID.randomUUID().toString().replace("-","");
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, inputStream));
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
