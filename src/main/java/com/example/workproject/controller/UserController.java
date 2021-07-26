package com.example.workproject.controller;

import com.example.workproject.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/request")
public class UserController {
    @Resource
    private UserService testservice;

    @RequestMapping(path = "/getMysqlData", method = RequestMethod.GET)
    @ResponseBody
    public String getData(int page, int limit){
//        System.out.println(page + " " + limit);
        String res = testservice.getData(page, limit);
        return res;
    }
    @RequestMapping(path = "/getMysqlData2", method = RequestMethod.GET)
    @ResponseBody
    public String getData2(int page, int limit){
//        System.out.println(page + " " + limit);
        String res = testservice.getData2(page, limit);
        return res;
    }
    @RequestMapping(path = "/updateMysqlData", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateData(String username, int userId){
        testservice.updateData(username, userId);
        return true;
    }

    @RequestMapping(path = "/deleteMysqlData", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteData(int userId){
        testservice.deleteData(userId);
        return true;
    }

    @RequestMapping(path = "/insertMysqlData", method = RequestMethod.POST)
    @ResponseBody
    public boolean insertData(int userId, String username, String nickName, String phone, String sex){
        testservice.insertData(userId, username, nickName, phone, sex);
        return true;
    }
}
