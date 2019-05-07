package com.spring.demo.constant;

/**
 * ucenter系统接口结果常量枚举类
 * Created by shujdwin on 2017/4/26.
 */
public enum UcenterResultConstant {

    LOGIN_FORMAT_ERROR(false, -11, "登录数据格式验证失败"),
    PARAM_FORMAT_ERROR(false, -11, "登录数据格式验证失败"),
    EXIT_LOGIN_ERROR(false, -11, "token已失效"),
    USER_NAME_NOT_EXISTS(false, -13, "用户不存在"),
    GET_SMS_CODE_TIME_ERROR(false, -15, "请60秒之后再获取验证码"),
    SMS_CODE_IS_ERROR(false, -16, "短信验证码错误"),
    CUSTOMER_NOT_EXISTS(false, 61, "客户信息不存在"),
    CUSTOMER_REGISTER_ERROR(false, 70, "注册新账号失败"),
    CUSTOMER_ALREADY_REGISTER(false, 71, "该用户已注册"),
    SUCCESS(true, 1, "成功"),
    ERROR(false, 2, "失败"),
    CUSTOMER_NOT_REGISTER(false, -2, "该账号未绑定手机"),
    LOGIN_ERROE(false, -1, "登录失败，请重新尝试"),

    SHOP_NOTEXIST_ERROE(false, 10001, "购物车无此物品"),
    COMMUNITY_EXIST_ERROE(false, 10002, "该用户已申请该小区，请耐心等待"),
    ORDER_NOTEXIST_ERROE(false, 10003, "该用户已申请该小区，请耐心等待"),
    ADD_ORDER_ERROE(false, 10004, "该用户未选择商品"),
    ORDER_STATUS_ERROE(false, 10005, "订单状态不对"),
    FOOD_TYPE_DEL_ERROE(false, 10006, "该分类还有二级分类，删除失败"),
    ORDER_BINDDRIVER_ERROE(false, 10007, "司机不存在"),
    ORDER_BINDBOX_ERROE(false, 10008, "箱子不存或状态错误"),
    ORDER_BINDBOXED_ERROE(false, 10009, "该订单已绑定箱子"),

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
