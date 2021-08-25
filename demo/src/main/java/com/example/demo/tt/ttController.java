package com.example.demo.tt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ttController {
    @RequestMapping("/test11")
    String cc() {
        return "ppp";
    }
}
