package com.eagle.controller.dto;

/**
 * Created by jiang on 15/7/28.
 */
public class ResponseBase<T> {

    private boolean succeed=Boolean.TRUE;

    private String errorCode;

    private String message;

    private T payLoad;

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(T payLoad) {
        this.payLoad = payLoad;
    }
}
