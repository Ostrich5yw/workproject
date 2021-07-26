package com.example.workproject.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class mkDirUtil {
    static public void mkJsonFile(String rec, String name, String path)  {
        try {
//            System.out.println(path + "\\" + name + ".json");
            File file = new File(path + "\\" + name + ".json");
            if (!file.exists())
                file.createNewFile();
            BufferedWriter bf = new BufferedWriter(new FileWriter(path + "\\" + name + ".json"));
            bf.write(rec);
            bf.close();
        }catch (IOException a){
            a.printStackTrace();
        }
    }
    static public void mkDirFile(String name, String path) {
        String filePath = path + "\\" + name;
        //生成文件夹
        File file = new File(filePath);
        if (!file.exists()) {    //如果_test2文件夹不存在
            file.mkdir();        //创建文件夹
        }
    }
}
