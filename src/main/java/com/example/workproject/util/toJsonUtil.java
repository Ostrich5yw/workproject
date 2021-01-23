package com.example.workproject.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class toJsonUtil {
    private static String filePath = "E:\\test.txt";
    public static void saveAsFileWriter(String content ,String path) {
        filePath = path;
        FileWriter fwriter = null;
//        File file = file = new File(filePath);
//        System.out.println(file.delete());
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath, false);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
