package com.example.workproject.Service.ServiceImpl;

import com.example.workproject.Service.UnitService;
import com.example.workproject.entity.Mapper.UnitMapper;
import com.example.workproject.entity.Mapper.Unit_MybatisPlus_Mapper;
import com.example.workproject.entity.PoJo.unitBean;
import com.example.workproject.util.mkDirUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    @Resource
    private Unit_MybatisPlus_Mapper unit_mybatisPlus_mapper;
    @Resource
    private UnitMapper unitMapper;

    @Override
    public String getAllUnit(int page, int limit){
//        Page<unitBean> pagesize = new Page<>(page, limit);
        int num = unitMapper.getUnitNum();
//        List<unitBean> list = unit_mybatisPlus_mapper.selectPage(pagesize, null).getRecords();
        List<unitBean> list = unitMapper.unitPageInfo((page - 1) * limit, limit);
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ num +",\"data\": ");
        ss.append(gson.toJson(list)+"}");
        return ss.toString();
    }

    @Override
    public void insertUnit(String param[]) {
        String path = unitMapper.getMediaDir();
        mkDirUtil.mkDirFile(param[0], path);
        path += "\\" + param[0];
        mkDirUtil.mkDirFile("VideosMedia", path);
        mkDirUtil.mkDirFile("AudiosMedia", path);
        mkDirUtil.mkDirFile("ImagesMedia", path);
        mkDirUtil.mkDirFile("TextsMedia", path);
        unitMapper.insertUnit(param[0], param[1], Integer.parseInt(param[2]), param[3], param[4], param[5], param[6], param[7], param[8],
                param[9], param[10], param[11], param[12]);
    }

    @Override
    public void updateUnit(String param[]) {
        unitMapper.updateUnit(param[0], param[1], Integer.parseInt(param[2]), param[3], param[4], param[5], param[6], param[7], param[8],
                param[9], param[10], param[11], param[12]);
    }

    @Override
    public void deleteUnit(String ID) {
        unitMapper.deleteUnit(ID);
    }

    @Override
    public String findUnit(String param1, String param2, int page, int limit) {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        List<unitBean> res = unitMapper.findUnit(param1, param2, (page - 1) * limit, limit);
        StringBuilder ss = new StringBuilder();
        if(res.size() == 0) {
            ss.append("{\n" +
                    "  \"code\": 1,\n" +
                    "  \"msg\": \"\",\n" +
                    "  \"count\": 0,\"data\": []");
        }else {
            ss.append("{\n" +
                    "  \"code\": 0,\n" +
                    "  \"msg\": \"find\",\n" +
                    "  \"count\": " + unitMapper.getConditionUnitNum(param1, param2) + ",\"data\": ");
            ss.append(gson.toJson(res) + "}");
        }
        return ss.toString();
    }
}
