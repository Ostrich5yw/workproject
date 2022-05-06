package com.example.workproject.controller;

import com.example.workproject.Service.BrowseService;
import com.example.workproject.entity.PoJo.textBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/browse_request")
public class BrowseController {
    @Resource
    private BrowseService browseService;

    @ResponseBody
    @RequestMapping("/getAllText")
    public String getAllText(int page, int limit) {
        return browseService.getAllText(page, limit);
    }

    @ResponseBody
    @RequestMapping("/getTextById")
    public void getTextById(String assetname, String asseturl) {
        browseService.getTextById(assetname, asseturl);
    }

    @ResponseBody
    @RequestMapping("/getAllImage")
    String getAllImage(int page, int limit) {
        return browseService.getAllImage(page, limit);
    }
    @ResponseBody
    @RequestMapping("/getAllAudio")
    String getAllAudio(int page, int limit) {
        return browseService.getAllAudio(page, limit);
    }
    @ResponseBody
    @RequestMapping("/getAllVideo")
    String getAllVideo(int page, int limit) {
        return browseService.getAllVideo(page, limit);
    }

    @ResponseBody
    @RequestMapping("/findFile")
    String findFile(int param1, String param2, long param3, String param4, String param5, int page, int limit) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
        System.out.println(param4);
        System.out.println(param5);
        System.out.println(page + " " + limit);
        switch (param1){
            case 100:
                return browseService.findText(param2, param3, param4, param5, page, limit);
            case 101:
                return browseService.findImage(param2, param3, param4, param5, page, limit);
            case 102:
                return browseService.findAudio(param2, param3, param4, param5, page, limit);
            case 103:
                return browseService.findVideo(param2, param3, param4, param5, page, limit);
        }
        return null;
    }
}
