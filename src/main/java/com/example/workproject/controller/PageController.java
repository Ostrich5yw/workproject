package com.example.workproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String MainPage(){
        return "iframe/index.html";
    }
    @RequestMapping("/authorities")
    public String authoritiesPage(){
        return "iframe/page/authorities.html";
    }
}
