package com.example.demo.exception;

import com.example.demo.util.Result;
import com.example.demo.util.busnisExp;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class MyException {

    public static void printError(Exception e) {
        e.printStackTrace();
    }
//    @ExceptionHandler(value = busnisExp.class)
//    @ResponseBody
//    public String exceptionHandler12(Exception e) {
//        System.out.println(e.getClass());
//        System.out.println(((busnisExp)e).getCode());
//        return ((busnisExp) e).getCode();
//    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    @ResponseBody
    public Result exceptionHandler1(Exception e) {
        printError(e);
        if (e instanceof IndexOutOfBoundsException) System.out.println(true);
        return Result.otherError(400);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        System.out.println(e.getClass());
        printError(e);
        return new Result(-1,((MethodArgumentNotValidException)e).getAllErrors()
                .stream()
                .map((t)-> t.getDefaultMessage()).collect(Collectors.joining(",")));
    }
}
