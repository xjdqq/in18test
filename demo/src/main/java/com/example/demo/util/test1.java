package com.example.demo.util;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface test1 {
    String name();
    int age() default 18;
    int[] score();
}
