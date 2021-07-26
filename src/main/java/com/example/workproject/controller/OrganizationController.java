package com.example.workproject.controller;

import com.example.workproject.Service.OrganizationService;
import com.example.workproject.entity.PoJo.organizationBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/request")
public class OrganizationController {
    @Resource
    private OrganizationService organizationService;

    @ResponseBody
    @RequestMapping("/getOrganizationdata")
    public List<organizationBean> getOrganizationdata(){
        return organizationService.getOrganizationdata();
    }

    @ResponseBody
    @RequestMapping("/deleteOrganizationdata")
    public void deleteOrganizationdata(int start, int end){
        organizationService.deleteOrganizationdata(start, end);
    }

    @ResponseBody
    @RequestMapping("/updateOrganizationdata")
    public void updateOrganizationdata(String organizationName, int organizationId){
        organizationService.updateOrganizationdata(organizationName, organizationId);
    }

    @ResponseBody
    @RequestMapping("/insertOrganizationdata")
    public void insertOrganizationdata(String organizationName, String parentId){
        int t1 = Integer.parseInt(parentId);
        organizationService.insertOrganizationdata(organizationName, t1 + 1);
    }
}
