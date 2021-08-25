package com.example.demo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.example.demo.util.message;
import com.example.demo.util.test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.nio.Buffer;
import java.util.Locale;
import java.util.Map;

@RestController
@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class DemoApplication {

    @Autowired
    message message1;

    @RequestMapping("/test")
    @test1(name = "cherry-peng",age = 23,score = {99,66,77})
    public String a(@RequestParam("lg") String lg, @RequestBody Map object){
        Map<String,Object> map = (Map)object;
        System.out.println(((Map)map.get("a")).get("b"));
        message message = new message();
        String a="a";String b="a";
        String str1 = new String("11");
        String str12 = new String("11");
        System.out.println(a==b);
        System.out.println(str1==str12);
        System.out.println(str1.equals(str12));
//        abc aa = new abc();
        Locale l = new Locale(lg);
//        String cc = message.getMessageSource().getMessage("sc",null,l);
        System.out.println(message1.getMessage("sc"));
        return message1.getMessage("sc");
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
