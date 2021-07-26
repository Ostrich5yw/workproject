package com.example.workproject.controller;

import com.example.workproject.Service.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/operator_request")
public class OperatorController {
    @Resource
    OperatorService operatorService;

    @ResponseBody
    @RequestMapping("/getOperatorByInstitutionDM")
    public String getOperatorByInstitutionDM(int institutionId, int page, int limit) {
//        System.out.println(institutionId + " " + page+ " " +limit);
        return operatorService.getOperatorByInstitutionDM(institutionId, page, limit);
    }

    @ResponseBody
    @RequestMapping("/insertOperator")
    public void insertOperator(String param[]) {
//        System.out.println(param);
        operatorService.insertOperator(param);
    }

    @ResponseBody
    @RequestMapping("/updateOperator")
    public void updateOperator(String czydm, String zt) {
//        System.out.println(param);
        operatorService.updateOperator(czydm, zt);
    }
}
