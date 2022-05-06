package com.example.workproject.entity.Mapper.sqlProvider;

public class fileSqlProvider {
    public String findText(String param1, long param2, String param3, String param4, int page,int limit){
        page = page - 1;
        String p1 = " assetshbz = " + param2;
        String p2 = param1 == "" ? "" : " and assetname = '" + param1 + "'";
        String p3 = param3 == "" ? "" : " and assetcjsj >= '" + param3 + "'";
        String p4 = param4 == "" ? "" : " and assetcjsj <= '" + param4 + "'";
        return "select * from textstable where" + p1 + p2 + p3 + p4 + " limit "+ limit +" offset "+ page;
    }
    public String findTextNum(String param1, long param2, String param3, String param4){
        String p1 = " assetshbz = " + param2;
        String p2 = param1 == "" ? "" : " and assetname = '" + param1 + "'";
        String p3 = param3 == "" ? "" : " and assetcjsj >= '" + param3 + "'";
        String p4 = param4 == "" ? "" : " and assetcjsj <= '" + param4 + "'";
        return "select count(*) from textstable where" + p1 + p2 + p3 + p4;
    }

    public String findImage(String param1, long param2, String param3, String param4, int page,int limit){
        page = page - 1;
        String p1 = " assetshbz = " + param2;
        String p2 = param1 == "" ? "" : " and assetname = '" + param1 + "'";
        String p3 = param3 == "" ? "" : " and assetcjsj >= '" + param3 + "'";
        String p4 = param4 == "" ? "" : " and assetcjsj <= '" + param4 + "'";
        return "select * from imagestable where" + p1 + p2 + p3 + p4 + " limit "+ limit +" offset "+ page;
    }
    public String findImageNum(String param1, long param2, String param3, String param4){
        String p1 = " assetshbz = " + param2;
        String p2 = param1 == "" ? "" : " and assetname = '" + param1 + "'";
        String p3 = param3 == "" ? "" : " and assetcjsj >= '" + param3 + "'";
        String p4 = param4 == "" ? "" : " and assetcjsj <= '" + param4 + "'";
        return "select count(*) from imagestable where"+ p1 + p2 + p3 + p4;
    }

    public String findAudio(String param1, long param2, String param3, String param4, int page,int limit){
        page = page - 1;
        String p1 = " assetshbz = " + param2;
        String p2 = param1 == "" ? "" : " and assetname = '" + param1 + "'";
        String p3 = param3 == "" ? "" : " and assetcjsj >= '" + param3 + "'";
        String p4 = param4 == "" ? "" : " and assetcjsj <= '" + param4 + "'";
        return "select * from audiostable where"+ p1 + p2 + p3 + p4+" limit "+ limit +" offset "+ page;
    }
    public String findAudioNum(String param1, long param2, String param3, String param4){
        String p1 = " assetshbz = " + param2;
        String p2 = param1 == "" ? "" : " and assetname = '" + param1 + "'";
        String p3 = param3 == "" ? "" : " and assetcjsj >= '" + param3 + "'";
        String p4 = param4 == "" ? "" : " and assetcjsj <= '" + param4 + "'";
        return "select count(*) from audiostable where"+ p1 + p2 + p3 + p4;
    }

    public String findVideo(String param1, long param2, String param3, String param4, int page,int limit){
        page = page - 1;
        String p1 = " assetshbz = " + param2;
        String p2 = param1 == "" ? "" : " and assetname = '" + param1 + "'";
        String p3 = param3 == "" ? "" : " and assetcjsj >= '" + param3 + "'";
        String p4 = param4 == "" ? "" : " and assetcjsj <= '" + param4 + "'";
        return "select * from videostable where" + p1 + p2 + p3 + p4+ " limit "+ limit +" offset "+ page;
    }
    public String findVideoNum(String param1, long param2, String param3, String param4){
        String p1 = " assetshbz = " + param2;
        String p2 = param1 == "" ? "" : " and assetname = '" + param1 + "'";
        String p3 = param3 == "" ? "" : " and assetcjsj >= '" + param3 + "'";
        String p4 = param4 == "" ? "" : " and assetcjsj <= '" + param4 + "'";
        return "select count(*) from videostable where"+ p1 + p2 + p3 + p4;
    }
}
