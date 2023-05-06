package com.experiment.ecrecommendersystem.common;

public class CommonRes {
    //状态有{success,fail}两种
    private String status;
    //若status=success，则data为返回的json数据
    //若status=fail，则data为通用的错误类格式
    private Object data;

    //如果仅传入data，默认success
    public static CommonRes create(Object data){
        return CommonRes.create("success",data);
    }



    //通用创建CommonRes的方法
    public static CommonRes create(String status, Object data) {
        CommonRes commonRes = new CommonRes();
        commonRes.setStatus(status);
        commonRes.setData(data);
        return commonRes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
