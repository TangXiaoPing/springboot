package com.spring.demo.constant;


import com.spring.demo.base.BaseResult;

/**
 * ucenter系统常量枚举类
 * Created by shujdwin on 2017/4/26.
 */
public class UcenterResult extends BaseResult {

    public UcenterResult(UcenterResultConstant resultConstant, Object data) {
        super(resultConstant.isSuccess(), resultConstant.getStatus(), resultConstant.getMessage(), data);
    }

    public UcenterResult(boolean isSuccess, int status, String message, Object data) {
        super(isSuccess, status, message, data);
    }

    public UcenterResult(String message) {
        super(false, 999, message, null);
    }
}
