package com.example.demo.util;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;

@RestController
public class testController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @Autowired
    message message;

    @RequestMapping("/test1")
    @test1(name = "testxjd",age = 23,score = {99,66,77})
    public boolean ab(@RequestBody Map Json) {
        System.out.println("123");
        throw new busnisExp("test");
//        int i = 1/0;
//        int[] a= new int[]{1,2};
//        int b =a[3];
//        return useLocalCache;
    }

    @RequestMapping("/test3")
    @test1(name = "testxjd",age = 23,score = {99,66,77})
    public String ab3(@RequestBody humen Json) {
//        LocaleContextHolder.setLocale(Locale.forLanguageTag(Json.getLangu()));
       return message.getMessage("sc");
//        System.out.println("123");
//        throw new busnisExp("test");
//        int i = 1/0;
//        int[] a= new int[]{1,2};
//        int b =a[3];
//        return useLocalCache;
    }
}
