package com.experiment.ecrecommendersystem.common;

//枚举错误类
public enum EmBusinessError {
    //通用的错误类型以10000开头
    NO_OBJECT_FOUND(10001,"请求对象不存在"),
    UNKNOWN_ERROR(10002,"未知错误"),
    NO_HANDLER_FOUND(1003,"找不到执行的路由"),
    BIND_EXCEPTION_ERROR(1004,"请求参数错误"),
    PARAMETER_VALIDATION_ERROR(1005,"请求参数校验失败"),

    //服务端错误以20000开头
    REGISTER_DUP_FAIL(20001,"用户已存在"),
    LOGIN_FAIL(2002,"手机号或密码错误"),

    //admin相关错误
    ADMIN_SHOULD_LOGIN(30001,"管理员需登录"),

    //category相关错误
    CATEGORY_NAME_DUPLICATED(40001,"商家名已存在");



    private Integer errCode;
    private String errMsg;


    EmBusinessError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
