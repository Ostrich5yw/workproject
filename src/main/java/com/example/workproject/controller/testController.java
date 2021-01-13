package com.example.workproject.controller;


import com.example.workproject.entity.Repository.UserRepository;
import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class testController {
    @Resource
    private MongoTemplate mongoTemplate;

    @RequestMapping("/index")
    public String test(){
        return "test";
    }
    @RequestMapping("/index2")
    public String test2(Model model){
        Bson bson = eq("name", "user1");
        Query query = new Query(Criteria.where("name").is("user1"));
//        query.fields().exclude("_id").include("data");
        List<Map> list = mongoTemplate.find(query, Map.class,  "User");
        Gson gson = new Gson();
        String res = gson.toJson(list.get(0).get("data"));
        System.out.println(res);
        model.addAttribute("UserTree", res);


//        FindIterable<Map> documents = mongoTemplate.getCollection("User").find(bson,Map.class);
//        for (Map document : documents) {
//            System.out.println(document);
//        }
        return "test2";
    }
}
