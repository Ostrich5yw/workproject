package com.example.workproject.controller;

import com.example.workproject.util.toJsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/request")
public class FunctionController {
    @RequestMapping(path = "/changeJson", method = RequestMethod.POST)
    public String changeJson(String[] res){
        StringBuilder sb = new StringBuilder();
        sb.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ res.length +",\n" +
                "  \"data\": [");
        for(String temp : res){
            sb.append(temp + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" ]\n" +
                "}");
        toJsonUtil ts = new toJsonUtil();
        ts.saveAsFileWriter(sb.toString(), "E:\\IdeaProjects\\workproject\\src\\main\\resources\\static\\layuimini\\api\\test.json");
//        Gson gson = new Gson();
//        TreeNode temp = gson.fromJson(res, TreeNode.class);
        return "Page/mainmenu";
    }
}
