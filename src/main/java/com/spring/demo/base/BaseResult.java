package com.spring.demo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统一返回结果类
 * Created by shujdwin on 2017/2/18.
 */
@ApiModel(value="通用返回对象",description="通用返回对象")
public class BaseResult<T>{

    @ApiModelProperty(value="请求是否成功",	name="isSuccess",	example="true")
    private boolean success;

    /**
     * 状态码
     */
    @ApiModelProperty(value="请求状态（业务）",	name="status",	example="1")
    public int status;

    /**
     * 成功为success，其他为失败原因
     */
    @ApiModelProperty(value="返回信息",	name="message",	example="成功")
    public String message;

    /**
     * 数据结果集
     */
    @ApiModelProperty(value="返回对象",	name="data")
    public T data;

    public BaseResult(boolean isSuccess, int status, String message, T data) {
        this.success = isSuccess;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

}
