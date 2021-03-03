package com.example.workproject.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workproject.Service.testService;
import com.example.workproject.entity.Mapper.MybatisPlusMapper;
import com.example.workproject.entity.Mapper.testMapper;
import com.example.workproject.entity.PoJo.UserBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class testServiceImpl implements testService {
    @Resource
    private testMapper testMapper;
    @Resource
    private MybatisPlusMapper mybatisPlusMapper;

    public String getData(int page, int limit) {
        Page<UserBean> pagesize = new Page<>(page, limit);
        int num = testMapper.getDataNum();
        List<UserBean> userBean = mybatisPlusMapper.selectPage(pagesize, null).getRecords();
//        List<UserBean> userBean = testMapper.getData();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();
        String res;
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ num +",\"data\": [");
        for(int i = 0;i < userBean.size();i ++) {
            res = gson.toJson(userBean.get(i));
            ss.append(res);
            ss.setCharAt(ss.length() - 1, ',');
            ss.append("\"roles\":" + userBean.get(i).getRoles() + "},");
        }
        ss.deleteCharAt(ss.length() - 1);
        ss.append("]}");
        res = ss.toString();
        System.out.println(res);
        return res;
    }

    public void changeData(String username, int userId){
        testMapper.changeData(username, userId);
    }
}
