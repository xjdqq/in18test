package com.example.demo.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class test {

    @Pointcut("execution(* com.example.demo.tt..*.*(..)))")
    public void poontcut(){};

    @Around(value="poontcut()")
    public String beforeTest(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("beforeTest:" + test1.name());
        System.out.println("beforeTest:"+point.proceed());
        return "123";
    }


}
