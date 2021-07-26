package com.example.workproject.controller;


import com.example.workproject.entity.PoJo.operatorBean;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @RequestMapping("/")
    public String test2(Model model){
        return "iframe/page/login";
    }
    @RequestMapping("/index1")
    public String MainPage1(Model model){

        return "iframe/index1.html";
    }
    @RequestMapping("/index2")
    public String MainPage2(){
        return "iframe/index2.html";
    }
    @RequestMapping("/index3")
    public String MainPage3(){
        return "iframe/index3.html";
    }
    @RequestMapping("/unauth")
    public String Unauth(){
        return "iframe/unauth.html";
    }

}
