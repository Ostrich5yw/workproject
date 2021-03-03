package com.example.workproject.controller;

import com.example.workproject.Service.testService;
import com.example.workproject.entity.Mapper.testMapper;
import com.example.workproject.entity.PoJo.UserBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/request")
public class MysqlController {
    @Resource
    private testService testservice;

    @RequestMapping(path = "/getMysqlData", method = RequestMethod.GET)
    @ResponseBody
    public String getData(int page, int limit){
        System.out.println(page + " " + limit);
        String res = testservice.getData(page, limit);
        return res;
    }

    @RequestMapping(path = "/changeMysqlData", method = RequestMethod.POST)
    @ResponseBody
    public boolean changeData(String username, int userId){
        testservice.changeData(username, userId);
        return true;
    }
}
