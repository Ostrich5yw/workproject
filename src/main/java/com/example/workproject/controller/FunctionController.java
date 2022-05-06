package com.example.workproject.controller;

import com.example.workproject.Service.MenuService;
import com.example.workproject.entity.Mapper.MysqlMapper;
import com.example.workproject.entity.PoJo.userBean;
import com.example.workproject.util.toJsonUtil;
import com.google.gson.Gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.shiro.SecurityUtils;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/request")
public class FunctionController {
//    @Resource
//    private MongoTemplate mongoTemplate;

    @Resource
    private MenuService menuService;

    @Resource
    private MysqlMapper mysqlMapper;
/***   存储在MongoDB中的Menu
    @RequestMapping(path = "/changeMongoJson", method = RequestMethod.POST)
    @ResponseBody
    public String changeMongoJson(String[] res, String name){
//        for (String s:res
//        ) {
//            System.out.println(s);
//        }
        int len = res.length;
        StringBuilder sb = new StringBuilder();
        sb.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ len +",\n" +
                "  \"name\": \""+ name +"\",\n" +
                "  \"data\": [");
        for(String temp : res){
            sb.append(temp + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" ]\n" +
                "}");

        Query query = new Query(Criteria.where("name").is(name));
//        query.fields().exclude("_id").include("data");
//        Update update = new Update();
//        update.set("count", res.length);
//        update.push("data", res);
        mongoTemplate.remove(query, Map.class,  "User");
//        System.out.println(1);
//        System.out.println(sb);
        mongoTemplate.insert(sb.toString(), "User");
//        System.out.println(sb);
//        Gson gson = new Gson();
//        TreeNode temp = gson.fromJson(res, TreeNode.class);
        return "iframe/index1.html";
    }

    @ResponseBody
    @RequestMapping(value = "/getMongoJson", method = RequestMethod.GET)
    public String getMongoJson(String name){
        System.out.println(((userBean) SecurityUtils.getSubject().getPrincipal()).getUsername());
        Query query = new Query(Criteria.where("name").is(name));
//        query.fields().exclude("_id").include("data");
        List<Map> list = mongoTemplate.find(query, Map.class,  "User");
        Gson gson = new Gson();
        String res = "";
        if (list.size() != 0)
            res = gson.toJson(list.get(0));
        System.out.println(res);
//        FindIterable<Map> documents = mongoTemplate.getCollection("User").find(bson,Map.class);
//        for (Map document : documents) {
//            System.out.println(document);
//        }
        return res;
    }
 ***/
//    @ResponseBody
//    @RequestMapping(value = "/getMenu", method = RequestMethod.GET)
//    public String getMenu(String name) {
//        return menuService.getMenu(name);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/changeMenu", method = RequestMethod.POST)
//    public void changeMenu(String[] res, String name) {
//        menuService.changeMenu(res, name);
//    }
//
//
//
//    @ResponseBody
//    @RequestMapping(value = "/getMongoJson_list", method = RequestMethod.GET)
//    public String getMongoJson_list(String name){
//        Query query = new Query(Criteria.where("name").is(name));
////        query.fields().exclude("_id").include("data");
//        List<Map> list = mongoTemplate.find(query, Map.class,  "Menu");
//        Gson gson = new Gson();
//        String res = "";
//        if (list.size() != 0)
//            res = gson.toJson(list.get(0));
//        System.out.println(res);
////        FindIterable<Map> documents = mongoTemplate.getCollection("User").find(bson,Map.class);
////        for (Map document : documents) {
////            System.out.println(document);
////        }
//        return res;
//    }

    /***************************************************************************************************************/
    /***************************************************************************************************************/
    /***************************************************************************************************************/
    /***************************************************************************************************************/
    /***************************************************************************************************************/


//    @RequestMapping(path = "/changeJson", method = RequestMethod.POST)
//    @ResponseBody
//    public String changeJson(String[] res){
//        StringBuilder sb = new StringBuilder();
//        sb.append("{\n" +
//                "  \"code\": 0,\n" +
//                "  \"msg\": \"\",\n" +
//                "  \"count\": "+ res.length +",\n" +
//                "  \"data\": [");
//        for(String temp : res){
//            sb.append(temp + ",");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        sb.append(" ]\n" +
//                "}");
//        toJsonUtil ts = new toJsonUtil();
//        ts.saveAsFileWriter(sb.toString(), "D:\\javaprojects\\workproject\\src\\main\\resources\\static\\iframe\\test.json");
////        System.out.println(sb);
////        Gson gson = new Gson();
////        TreeNode temp = gson.fromJson(res, TreeNode.class);
//        return "iframe/index1.html";
//    }
//
//    @RequestMapping(path = "/changenewJson", method = RequestMethod.POST)
//    @ResponseBody
//    public String changenewJson(String status, String filename, String title, String id, String parentId) throws FileNotFoundException {
//        System.out.println(status);
//        System.out.println(title +" "+ id + " "+parentId);
//        StringBuilder sb = new StringBuilder();
//        JsonParser parser=new JsonParser();
//        JsonObject object=(JsonObject) parser.parse(new FileReader("D:\\javaprojects\\workproject\\src\\main\\resources\\static\\iframe\\"+ filename +".json"));
//        JsonArray jsonArray = object.getAsJsonArray("data");
//        sb.append("{\n" +
//                "  \"status\":{\"code\":200,\"message\":\"操作成功\"},\n" +
//                "  \"data\": [");
//        switch (status) {
//            case "add":
//                String addParam = "{\"id\":\"" + id + "\",\"title\": \"" + title + "\",\"checkArr\": \"0\",\"parentId\": \"" + parentId + "\"}";
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    sb.append(jsonArray.get(i).toString() + ",");
//                    JsonObject tt = (JsonObject) jsonArray.get(i);
//                    if (tt.get("id").getAsString().equals(parentId)) {
//                        sb.append(addParam + ",");
//                    }
//                }
//                break;
//            case "del":
//                boolean mark = true;
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    JsonObject tt = (JsonObject) jsonArray.get(i);
//                    String temp = tt.get("id").getAsString();
//                    if (!mark && temp.length() <= id.length()){
//                        mark = true;
//                    }
//                    if (temp.equals(id)) {
//                        mark = false;
//                    }
//                    if(mark)
//                        sb.append(jsonArray.get(i).toString() + ",");
//
//                }
//                break;
//            case "edit":
//                String editParam = "{\"id\":\"" + id + "\",\"title\": \"" + title + "\",\"checkArr\": \"0\",\"parentId\": \"" + parentId + "\"}";
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    JsonObject tt = (JsonObject) jsonArray.get(i);
//                    if (!tt.get("id").getAsString().equals(id)) {
//                        sb.append(jsonArray.get(i).toString() + ",");
//                    } else {
//                        sb.append(editParam + ",");
//                    }
//                }
//                break;
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        sb.append("  ]\n" +
//                "}");
//        System.out.println(sb);
//        toJsonUtil.saveAsFileWriter(sb.toString(), "D:\\javaprojects\\workproject\\src\\main\\resources\\static\\iframe\\" + filename + ".json");
//        return "s";
//    }
}
