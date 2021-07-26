package com.example.workproject.entity.Mapper.sqlProvider;

import org.apache.ibatis.annotations.Select;

public class unitSqlProvider {
    public String findUnit(String dwmc, String dwdm, int page, int limit){
        dwmc = dwmc=="" ?  "" : " and dwxxb.dwmc = '" + dwmc + "'";
        dwdm = dwdm=="" ?  "" : " and dwxxb.dwdm = '" + dwdm + "'";
        return "select dwxxb.*, dwxzxxb.dwxzmc from dwxxb JOIN dwxzxxb where dwxxb.dwxzid=dwxzxxb.dwxzid" + dwmc + dwdm + " limit "+ limit +" offset "+ page;
    }

    public String getConditionUnitNum(String dwmc, String dwdm){
        dwmc = dwmc ==" " ?  "" : "dwxxb.dwmc = '" + dwmc + "'";
        if (dwmc == ""){
            dwdm = dwdm =="" ?  "" : "dwxxb.dwdm = '" + dwdm + "'";
        } else
            dwdm = dwdm =="" ?  "" : "and dwxxb.dwdm = '" + dwdm + "'";
        return "select count(*) from dwxxb where " + dwmc + dwdm;
    }
}
