package com.example.workproject.Service.ServiceImpl;

import com.example.workproject.Service.InstitutionService;
import com.example.workproject.entity.Mapper.InstitutionBranch_MybatisPlus_Mapper;
import com.example.workproject.entity.Mapper.InstitutionMapper;
import com.example.workproject.entity.PoJo.*;
import com.example.workproject.util.mkDirUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InstitutionServiceImpl implements InstitutionService {
    @Resource
    InstitutionMapper institutionMapper;

    @Resource
    InstitutionBranch_MybatisPlus_Mapper institutionBranch_mybatisPlus_mapper;

    @Override
    public List<institutionTreeBean> getInstitutionTree(String dwdm){
        LinkedList<institutionTreeBean> treelist = institutionMapper.getInstitutionTree(dwdm);
        List<institutionBean> list = institutionMapper.getAllInstitution(dwdm);
        for(int i = 0;i < list.size(); i ++){
            institutionTreeBean temp = new institutionTreeBean();
            temp.setDwdm(list.get(0).getDwdm());
            temp.setZnjgdm(0);
            temp.setZnjgmc("根目录");
            temp.setZnjgfzdm(list.get(i).getZnjgdm());
            temp.setZnjgfzmc(list.get(i).getZnjgmc());
            treelist.addFirst(temp);
        }
//        System.out.println(treelist);
        return (List<institutionTreeBean>)treelist;
    }

    @Override
    public List<unitBean_Name_ID> getUnit_Name_ID(){
        return institutionMapper.getUnit_Name_ID();
    }

    @Override
    public List<institutionBean> getAllInstitution(String dwdm){
        return institutionMapper.getAllInstitution(dwdm);
    }

    @Override
    public void insertInstitution_fz(String dwdm, String znjgdm, String znjgfzmc, String lxrxm, String lxryddh, String lxrgddh, String lxrmail){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = simpleDateFormat.format(date);
        institutionBranchBean institutionBranchBean = new institutionBranchBean();
        institutionBranchBean.setCjrq(createTime);
        institutionBranchBean.setDwdm(dwdm);
        institutionBranchBean.setLxrgddh(lxrgddh);
        institutionBranchBean.setLxrmail(lxrmail);
        institutionBranchBean.setLxrxm(lxrxm);
        institutionBranchBean.setLxryddh(lxryddh);
        institutionBranchBean.setZnjgdm(Integer.parseInt(znjgdm));
        institutionBranchBean.setZnjgfzmc(znjgfzmc);
        int Id = institutionMapper.getMaxIndexInstitution_fz() + 1;
        institutionBranchBean.setZnjgfzdm(Id);
        institutionBranch_mybatisPlus_mapper.insert(institutionBranchBean);
//        institutionMapper.insertInstitution(Integer.parseInt(znjgdm), Id, 6);

        String path = institutionMapper.getPath();
        String json1 = "{\n" +
                "    \"msg\":\"\",\n" +
                "    \"code\":0,\n" +
                "    \"data\":[\n" +
                "        {\n" +
                "            \"open\":true,\n" +
                "            \"isMenu\":0,\n" +
                "            \"menuUrl\":\"根目录\",\n" +
                "            \"menuIcon\":null,\n" +
                "            \"parentId\":0,\n" +
                "            \"authority\":\"\",\n" +
                "            \"createTime\":\"" + createTime + "\",\n" +
                "            \"updateTime\":\"" + createTime + "\",\n" +
                "            \"authorityId\":1,\n" +
                "            \"orderNumber\":1,\n" +
                "            \"authorityName\":\"公有根目录\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"count\":1\n" +
                "}";
        String json2 = "{\n" +
                "    \"msg\":\"\",\n" +
                "    \"code\":0,\n" +
                "    \"data\":[\n" +
                "        {\n" +
                "            \"open\":true,\n" +
                "            \"isMenu\":0,\n" +
                "            \"menuUrl\":\"根目录\",\n" +
                "            \"menuIcon\":null,\n" +
                "            \"parentId\":0,\n" +
                "            \"authority\":\"\",\n" +
                "            \"createTime\":\"" + createTime + "\",\n" +
                "            \"updateTime\":\"" + createTime + "\",\n" +
                "            \"authorityId\":1,\n" +
                "            \"orderNumber\":1,\n" +
                "            \"authorityName\":\"私有根目录\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"count\":1\n" +
                "}";
        mkDirUtil.mkJsonFile(json1, "publicMenu" + String.valueOf(Id), path);
        mkDirUtil.mkJsonFile(json2, "privateMenu" + String.valueOf(Id), path);
    }

    @Override
    public void insertInstitution(String dwdm, String znjgmc, String lxrxm, String lxryddh, String lxrgddh, String lxrmail) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String cjrq = simpleDateFormat.format(date);
        int Id = institutionMapper.getMaxIndexInstitution() + 1;
        institutionMapper.insertInstitution(dwdm, Id, znjgmc, cjrq, lxrxm, lxryddh, lxrgddh, lxrmail);
    }
}
