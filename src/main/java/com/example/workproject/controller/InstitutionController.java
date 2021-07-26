package com.example.workproject.controller;


import com.example.workproject.Service.InstitutionService;
import com.example.workproject.entity.PoJo.institutionBean;
import com.example.workproject.entity.PoJo.institutionTreeBean;
import com.example.workproject.entity.PoJo.unitBean;
import com.example.workproject.entity.PoJo.unitBean_Name_ID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/institution_request")
public class InstitutionController {
    @Resource
    InstitutionService institutionService;

    @ResponseBody
    @RequestMapping("/getInstitutionTree")
    List<institutionTreeBean> getInstitutionTree(String dwdm){
//        System.out.println(dwdm);
        return institutionService.getInstitutionTree(dwdm);
    }

    @ResponseBody
    @RequestMapping("/getAllInstitution")
    List<institutionBean> getAllInstitution(String dwdm){
//        System.out.println(dwdm);
        return institutionService.getAllInstitution(dwdm);
    }

    @ResponseBody
    @RequestMapping("/getUnit_Name_ID")
    List<unitBean_Name_ID> getUnit_Name_ID(){
//        System.out.println(dwdm);
        return institutionService.getUnit_Name_ID();
    }

    @ResponseBody
    @RequestMapping("/insertInstitution_fz")
    void insertInstitution_fz(String dwdm, String znjgdm, String znjgfzmc, String lxrxm, String lxryddh, String lxrgddh, String lxrmail){
//        System.out.println(dwdm);
        institutionService.insertInstitution_fz(dwdm, znjgdm, znjgfzmc, lxrxm, lxryddh, lxrgddh, lxrmail);
    }

    @ResponseBody
    @RequestMapping("/insertInstitution")
    void insertInstitution2(String dwdm, String znjgmc, String lxrxm, String lxryddh, String lxrgddh, String lxrmail){
//        System.out.println(dwdm);
        institutionService.insertInstitution(dwdm,znjgmc, lxrxm, lxryddh, lxrgddh, lxrmail);
    }
}
