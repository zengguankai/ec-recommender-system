package com.experiment.ecrecommendersystem.common;

//EmBusinessError与CommonError的组装类
public class BusinessException extends Exception{
    // 返回参数
    private CommonError commonError;

    //传入参数
    public BusinessException(EmBusinessError emBusinessError){
        super();
        this.commonError = new CommonError(emBusinessError);
    }

    //使用传进来的参数errMsg（校验错误）替换commonError中的errMsg
    public BusinessException(EmBusinessError emBusinessError,String errMsg){
        super();
        this.commonError = new CommonError(emBusinessError);
        this.commonError.setErrMsg(errMsg);
    }

    public CommonError getCommonError() {
        return commonError;
    }

    public void setCommonError(CommonError commonError) {
        this.commonError = commonError;
    }
}
