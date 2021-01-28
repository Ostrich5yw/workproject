package com.example.workproject.controller;

import com.example.workproject.util.toJsonUtil;
import com.google.gson.Gson;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

@Controller
@RequestMapping("/request")
public class FunctionController {
    @Resource
    private MongoTemplate mongoTemplate;

    @RequestMapping(path = "/changeJson", method = RequestMethod.POST)
    @ResponseBody
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
        ts.saveAsFileWriter(sb.toString(), "D:\\javaprojects\\workproject\\src\\main\\resources\\static\\iframe\\test.json");
//        System.out.println(sb);
//        Gson gson = new Gson();
//        TreeNode temp = gson.fromJson(res, TreeNode.class);
        return "iframe/index.html";
    }

    @RequestMapping(path = "/changeMongoJson", method = RequestMethod.POST)
    @ResponseBody
    public String changeMongoJson(String[] res, String name){
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

        Query query = new Query(Criteria.where("name").is("user1"));
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
        return "iframe/index.html";
    }

    @ResponseBody
    @RequestMapping(value = "/getMongoJson", method = RequestMethod.GET)
    public String getMongoJson(String name){
        System.out.println(name);
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
}
