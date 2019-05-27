package com.spring.demo.enums;

/**
 * ucenter系统接口结果常量枚举类
 * Created by shujdwin on 2017/4/26.
 */
public enum UcenterResultConstant {
    SUCCESS(true, 1, "成功"),
    ERROR(false, 2, "失败"),
    PARAM_ERROR(false, 3, "参数错误"),
    SYSTEM_ERROR(false, -999, "系统正在加载中...");


    private boolean isSuccess;

    public int status;

    public String message;


    UcenterResultConstant(boolean isSuccess, int status, String message) {
        this.isSuccess = isSuccess;
        this.status = status;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
