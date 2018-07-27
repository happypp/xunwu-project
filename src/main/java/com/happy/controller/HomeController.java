package com.happy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Administrator
 * @CreateDate: 23:13 2018/7/27
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
