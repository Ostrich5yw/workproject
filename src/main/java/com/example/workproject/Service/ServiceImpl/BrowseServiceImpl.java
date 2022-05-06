package com.example.workproject.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workproject.Service.BrowseService;
import com.example.workproject.entity.Mapper.*;
import com.example.workproject.entity.PoJo.audioBean;
import com.example.workproject.entity.PoJo.imageBean;
import com.example.workproject.entity.PoJo.textBean;
import com.example.workproject.entity.PoJo.videoBean;
//import com.example.workproject.util.asposeUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrowseServiceImpl implements BrowseService {
    @Resource
    BrowseTextMapper_MybatisPlus_Mapper browseTextMapper_mybatisPlus_mapper;

    @Resource
    BrowseImageMapper_MybatisPlus_Mapper browseImageMapper_mybatisPlus_mapper;

    @Resource
    BrowseAudioMapper_MybatisPlus_Mapper browseAudioMapper_mybatisPlus_mapper;

    @Resource
    BrowseVideoMapper_MybatisPlus_Mapper browseVideoMapper_mybatisPlus_mapper;

    @Resource
    BrowseMapper browseMapper;

    @Override
    public String getAllText(int page, int limit) {
        Page<textBean> pagesize = new Page<>(page, limit);

        List<textBean> res = browseTextMapper_mybatisPlus_mapper.selectPage(pagesize, null).getRecords();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ browseMapper.getTextNum() +",\"data\": ");
        ss.append(gson.toJson(res)+"}");
        return ss.toString();
    }

    @Override
    public void getTextById(String assetname, String asseturl) {
//        asposeUtil.doc2pdf(asseturl + assetname, "D:\\test.pdf");
    }

    @Override
    public String getAllImage(int page, int limit) {
        Page<imageBean> pagesize = new Page<>(page, limit);
        List<imageBean> res = browseImageMapper_mybatisPlus_mapper.selectPage(pagesize, null).getRecords();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ browseMapper.getImageNum() +",\"data\": ");
        ss.append(gson.toJson(res)+"}");
        return ss.toString();
    }

    @Override
    public String getAllAudio(int page, int limit) {
        Page<audioBean> pagesize = new Page<>(page, limit);
        List<audioBean> res = browseAudioMapper_mybatisPlus_mapper.selectPage(pagesize, null).getRecords();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ browseMapper.getAudioNum() +",\"data\": ");
        ss.append(gson.toJson(res)+"}");
        return ss.toString();
    }

    @Override
    public String getAllVideo(int page, int limit) {
        Page<videoBean> pagesize = new Page<>(page, limit);
        List<videoBean> res = browseVideoMapper_mybatisPlus_mapper.selectPage(pagesize, null).getRecords();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ browseMapper.getVideoNum() +",\"data\": ");
        ss.append(gson.toJson(res)+"}");
        return ss.toString();
    }

    @Override
    public String findText(String param1, long param2, String param3, String param4, int page, int limit) {
        List<textBean> res = browseMapper.findText(param1, param2, param3, param4, page, limit);
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ browseMapper.findTextNum(param1, param2, param3, param4) +",\"data\": ");
        ss.append(gson.toJson(res)+"}");
        return ss.toString();
    }

    @Override
    public String findImage(String param1, long param2, String param3, String param4, int page, int limit) {
        List<imageBean> res = browseMapper.findImage(param1, param2, param3, param4, page, limit);
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ browseMapper.findImageNum(param1, param2, param3, param4) +",\"data\": ");
        ss.append(gson.toJson(res)+"}");
        return ss.toString();
    }

    @Override
    public String findAudio(String param1, long param2, String param3, String param4, int page, int limit) {
        List<audioBean> res = browseMapper.findAudio(param1, param2, param3, param4, page, limit);
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ browseMapper.findAudioNum(param1, param2, param3, param4) +",\"data\": ");
        ss.append(gson.toJson(res)+"}");
        return ss.toString();
    }

    @Override
    public String findVideo(String param1, long param2, String param3, String param4, int page, int limit) {
        List<videoBean> res = browseMapper.findVideo(param1, param2, param3, param4, page, limit);
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ browseMapper.findVideoNum(param1, param2, param3, param4) +",\"data\": ");
        ss.append(gson.toJson(res)+"}");
        return ss.toString();
    }


}
