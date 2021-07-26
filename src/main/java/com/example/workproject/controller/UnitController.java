package com.example.workproject.controller;

import com.example.workproject.Service.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/unit_request")
public class UnitController {
    @Resource
    private UnitService unitService;

    @ResponseBody
    @RequestMapping(path = "/getAllUnit", method = RequestMethod.GET)
    public String getAllUnit(int page, int limit){
//        System.out.println(page+" " +limit);
        return unitService.getAllUnit(page, limit);
    }

    @ResponseBody
    @RequestMapping(path = "/insertUnit", method = RequestMethod.POST)
    public void insertUnit(String param[]){
//        System.out.println(param.length);
        unitService.insertUnit(param);
    }

    @ResponseBody
    @RequestMapping(path = "/deleteUnit", method = RequestMethod.POST)
    public void deleteUnit(String ID){
//        System.out.println(page+" " +limit);
        unitService.deleteUnit(ID);
    }

    @ResponseBody
    @RequestMapping(path = "/updateUnit", method = RequestMethod.POST)
    public void updateUnit(String param[]){
//        System.out.println(page+" " +limit);
        unitService.updateUnit(param);
    }

    @ResponseBody
    @RequestMapping(path = "/findUnit", method = RequestMethod.GET)
    public String findUnit(String param1, String param2, int page, int limit){
//        System.out.println(param1+" " +param2+" "+page+" "+limit);
        return unitService.findUnit(param1, param2, page, limit);
    }
}
