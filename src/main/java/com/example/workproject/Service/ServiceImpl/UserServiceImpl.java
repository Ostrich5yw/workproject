package com.example.workproject.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workproject.Service.UserService;
import com.example.workproject.entity.Mapper.MybatisPlusMapper;
import com.example.workproject.entity.Mapper.MybatisPlusMapper2;
import com.example.workproject.entity.Mapper.MysqlMapper;
import com.example.workproject.entity.PoJo.materialsBean;
import com.example.workproject.entity.PoJo.userBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private MysqlMapper MysqlMapper;
    @Resource
    private MybatisPlusMapper mybatisPlusMapper;
    @Resource
    private MybatisPlusMapper2 mybatisPlusMapper2;

    public String getData(int page, int limit) {
        Page<userBean> pagesize = new Page<>(page, limit);
        int num = MysqlMapper.getDataNum();
        List<userBean> userBean = mybatisPlusMapper.selectPage(pagesize, null).getRecords();
//        List<userBean> userBean = testMapper.getData();
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
//        System.out.println(res);
        return res;
    }
    public String getData2(int page, int limit) {
        Page<materialsBean> pagesize = new Page<>(page, limit);
        int num = MysqlMapper.getDataNum();
        List<materialsBean> materialsBean = mybatisPlusMapper2.selectPage(pagesize, null).getRecords();
        System.out.println(materialsBean);
//        List<userBean> userBean = testMapper.getData();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();
        String res;
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ num +",\"data\": [");
        for(int i = 0;i < materialsBean.size();i ++) {
            res = gson.toJson(materialsBean.get(i));
            ss.append(res);
            ss.setCharAt(ss.length() - 1, ',');
            ss.append("\"roles\":" + materialsBean.get(i).getRoles() + "},");
        }
        ss.deleteCharAt(ss.length() - 1);
        ss.append("]}");
        res = ss.toString();
//        System.out.println(res);
        return res;
    }
    public void updateData(String username, int userId){
        MysqlMapper.updateData(username, userId);
    }
    public void deleteData(int userId){
        MysqlMapper.deleteData(userId);
    }
    public void insertData(int userId, String username, String nickName, String phone, String sex){
        String password = "123";
        int num = MysqlMapper.getDataNum() + 1;
        int state = 0;
        int roleId = 1;
        String roleName = "管理员";
        String roles = "[{\"roleId\": 1, \"comments\": null, \"isDelete\": null, \"roleName\": \"管理员\", \"createTime\": null, \"updateTime\": null}]";
//                + ", {\"roleId\": 2, \"comments\": null, \"isDelete\": null, \"roleName\": \"普通用户\", \"createTime\": null, \"updateTime\": null}]";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createTime = simpleDateFormat.format(date);
        String updateTime = simpleDateFormat.format(date);
        MysqlMapper.insertData(num, username, nickName, phone, sex, password, state, roleId, roleName, roles, createTime, updateTime);
    }

}
