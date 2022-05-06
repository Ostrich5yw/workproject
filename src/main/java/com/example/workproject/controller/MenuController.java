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
    @RequestMapping(value = "/getMenu", method = RequestMethod.GET)
    public String getMenu(long znjgfzdm, int menubz){
//        System.out.println(znjgfzdm + " " + menubz);
        return menuService.getMenu(znjgfzdm, menubz);
    }

    @ResponseBody
    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
    public void updateMenu(String[] res, long znjgfzdm, int menubz){
        menuService.updateMenu(res, znjgfzdm, menubz);
    }

//    @ResponseBody
//    @RequestMapping(value = "/insertJson", method = RequestMethod.POST)
//    public void insertMenu(String dwdm, long znjgdm, long znjgfzdm, int menubz, String[] res){
//        menuService.insertMenu(dwdm, znjgdm, znjgfzdm, menubz, res);
//    }
}
