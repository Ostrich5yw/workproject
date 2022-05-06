package com.example.workproject.Service;

import com.example.workproject.entity.PoJo.textBean;

import java.util.List;

public interface BrowseService {
    public String getAllText(int page, int limit);
    public void getTextById(String assetname, String asseturl);
    public String getAllImage(int page, int limit);
    public String getAllAudio(int page, int limit);
    public String getAllVideo(int page, int limit);


    public String findText(String param1, long param2, String param3, String param4, int page, int limit);
    public String findImage(String param1, long param2, String param3, String param4, int page, int limit);
    public String findAudio(String param1, long param2, String param3, String param4, int page, int limit);
    public String findVideo(String param1, long param2, String param3, String param4, int page, int limit);

//    public String getAllVideo(int page, int limit);
//    public String getAllAudio(int page, int limit);
//    public String getAllImage(int page, int limit);
}
