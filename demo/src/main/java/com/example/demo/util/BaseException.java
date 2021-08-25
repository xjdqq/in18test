package com.example.demo.util;

public class BaseException extends RuntimeException{
    private String Code;

    public BaseException(String code) {
        Code = code;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
