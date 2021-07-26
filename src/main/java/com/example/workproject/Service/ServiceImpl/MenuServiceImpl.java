package com.example.workproject.Service.ServiceImpl;

import com.example.workproject.Service.MenuService;
import com.example.workproject.entity.Mapper.InstitutionMapper;
import com.example.workproject.util.mkDirUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    InstitutionMapper institutionMapper;

    @Override
    public void updateMenu(String[] res, String name){
        String path = institutionMapper.getPath();
//        System.out.println(res);
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
        mkDirUtil.mkJsonFile(sb.toString(), String.valueOf(name), path);
    }

//    @Override
//    public String getMenu(String name) {
//        return mysqlMapper.getMenu(name);
//    }

//    @Override
//    public void changeMenu(String[] res, String name) {
//        int len = res.length;
//        StringBuilder sb = new StringBuilder();
//        sb.append("{\n" +
//                "  \"code\": 0,\n" +
//                "  \"msg\": \"\",\n" +
//                "  \"count\": "+ len +",\n" +
//                "  \"data\": [");
//        for(String temp : res){
//            sb.append(temp + ",");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        sb.append(" ]\n" +
//                "}");
//        mysqlMapper.changeMenu(sb.toString(), name);
//    }
}
