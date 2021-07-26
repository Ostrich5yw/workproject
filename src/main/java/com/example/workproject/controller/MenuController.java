package com.example.workproject.controller;

import com.example.workproject.Service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/menu_request")
public class MenuController {
    @Resource
    MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "/updateJson", method = RequestMethod.POST)
    public void updateJson(String[] res, String name){
        menuService.updateMenu(res, name);
    }
}
