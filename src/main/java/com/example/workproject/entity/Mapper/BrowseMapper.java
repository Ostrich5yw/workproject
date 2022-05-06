package com.example.workproject.entity.Mapper;

import com.example.workproject.entity.Mapper.sqlProvider.fileSqlProvider;
import com.example.workproject.entity.Mapper.sqlProvider.unitSqlProvider;
import com.example.workproject.entity.PoJo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.lang.NoSuchMethodError;
@Mapper
@Repository
public interface BrowseMapper {
    @Select("select count(*) from textstable")
    int getTextNum();

    @Select("select count(*) from imagestable")
    int getImageNum();

    @Select("select count(*) from audiostable")
    int getAudioNum();

    @Select("select count(*) from videostable")
    int getVideoNum();

    @SelectProvider(type = fileSqlProvider.class, method = "findText")
    List<textBean> findText(String param1, long param2, String param3, String param4, int page, int limit);
    @SelectProvider(type = fileSqlProvider.class, method = "findTextNum")
    int findTextNum(String param1, long param2, String param3, String param4);

    @SelectProvider(type = fileSqlProvider.class, method = "findImage")
    List<imageBean> findImage(String param1, long param2, String param3, String param4, int page, int limit);
    @SelectProvider(type = fileSqlProvider.class, method = "findImageNum")
    int findImageNum(String param1, long param2, String param3, String param4);

    @SelectProvider(type = fileSqlProvider.class, method = "findAudio")
    List<audioBean> findAudio(String param1, long param2, String param3, String param4, int page, int limit);
    @SelectProvider(type = fileSqlProvider.class, method = "findAudioNum")
    int findAudioNum(String param1, long param2, String param3, String param4);

    @SelectProvider(type = fileSqlProvider.class, method = "findVideo")
    List<videoBean> findVideo(String param1, long param2, String param3, String param4, int page, int limit);
    @SelectProvider(type = fileSqlProvider.class, method = "findVideoNum")
    int findVideoNum(String param1, long param2, String param3, String param4);


}
