package com.example.workproject.controller;

import com.example.workproject.entity.PoJo.operatorBean;
import com.example.workproject.entity.PoJo.userBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/login")
    public String loginPage(){
        return "iframe/page/login.html";
    }
    @RequestMapping("/Menu")
    public String authoritiesPage(){
        return "iframe/page/Menu.html";
    }


    @RequestMapping("/unit")
    public String unitPage(Model model){
        model.addAttribute("userData", ((operatorBean)SecurityUtils.getSubject().getPrincipal()));
        return "iframe/page/Management/Unit.html";
    }
    @RequestMapping("/institution")
    public String institutionPage(){
        return "iframe/page/Management/Institution.html";
    }
    @RequestMapping("/menu")
    public String menuPage(Model model){
        model.addAttribute("userData", ((operatorBean)SecurityUtils.getSubject().getPrincipal()));
        return "iframe/page/Management/Menu.html";
    }
    @RequestMapping("/operator")
    public String operatorPage(){
        return "iframe/page/Management/Operator.html";
    }

    @RequestMapping("/organization")
    public String organizationPage(){
        return "iframe/page/organization.html";
    }
    @RequestMapping("/user")
    public String userPage(){
        return "iframe/page/user.html";
    }
    @RequestMapping("/areaChoose")
    public String areaChoosePage(){
        return "iframe/page/areaChoose.html";
    }
    @RequestMapping("/workplace")
    public String workplace(Model model){
        model.addAttribute("userData", ((operatorBean)SecurityUtils.getSubject().getPrincipal()).getCzyjs());
        return "iframe/page/workplace.html";
    }

    @RequestMapping("/test")
    public String testPage(){
        return "iframe/page/test.html";
    }
    @RequestMapping("/browse")
    public String browsePage(){
        return "iframe/page/Browse/Browse.html";
    }
}
