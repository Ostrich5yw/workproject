package com.example.workproject.controller;

import com.example.workproject.entity.PoJo.operatorBean;
import com.example.workproject.entity.PoJo.userBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/func")
@Controller
public class LoginController {
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> Login(String username, String password, String rememberMe, Model model, HttpServletRequest request) throws IOException {
        Map<String, Object> res = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (rememberMe != null)
            token.setRememberMe(true);
        operatorBean currentUser;
        res.put("msg", "success");
        try {
            subject.login(token);
            currentUser = (operatorBean) subject.getPrincipal();
            res.put("usr", currentUser);
        } catch (UnknownAccountException e) {       //用户名错误
            res.put("msg", "用户名错误");
            model.addAttribute(res);
            return res;
        } catch (IncorrectCredentialsException e) {  //密码错误
            res.put("msg", "密码错误");
            model.addAttribute(res);
            return res;
        }
        model.addAttribute(res);
        return res;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "iframe/page/login.html";
    }
}
