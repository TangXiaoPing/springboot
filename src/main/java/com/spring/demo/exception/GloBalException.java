package com.spring.demo.exception;

import com.spring.demo.base.UcenterResult;
import com.spring.demo.enums.UcenterResultConstant;
import io.swagger.annotations.ApiModelProperty;

public class GloBalException extends RuntimeException {
    @ApiModelProperty(value = "请求是否成功", name = "isSuccess", example = "true")
    private boolean success;

    /**
     * 状态码
     */
    @ApiModelProperty(value = "请求状态（业务）", name = "status", example = "1")
    public int status;

    /**
     * 成功为success，其他为失败原因
     */
    @ApiModelProperty(value = "返回信息", name = "message", example = "成功")
    public String message;

    /**
     * 数据结果集
     */
    @ApiModelProperty(value = "返回对象", name = "data")
    public Object data;

    public GloBalException(UcenterResultConstant ucenterResultConstant) {
        this.message = ucenterResultConstant.getMessage();
        this.status = ucenterResultConstant.getStatus();
        this.success = ucenterResultConstant.isSuccess();
    }

    public GloBalException(UcenterResult ucenterResult) {
        this.message = ucenterResult.getMessage();
        this.status = ucenterResult.getStatus();
        this.success = ucenterResult.isSuccess();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
