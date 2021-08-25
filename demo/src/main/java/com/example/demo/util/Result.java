package com.example.demo.util;

public class Result {

    private int errorCode;
    private String errorMsg;
    private Object errorm;

    public Result(){}
    public Result(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Result(int errorCode, Object errorm) {
        this.errorCode = errorCode;
        this.errorm = errorm;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getErrorm() {
        return errorm;
    }

    public void setErrorm(Object errorm) {
        this.errorm = errorm;
    }

    public static Result otherError(int errorCode) {
        Result result = new Result();
        result.setErrorCode(errorCode);
        result.setErrorMsg("報錯");
        return result;
    }
}
