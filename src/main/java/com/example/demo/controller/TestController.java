package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 陈睿
 * @date 2020-03-09 15:24
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        int i=10/0;
        return "test";
    }
}
