package com.example.workproject.entity.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MenuMapper {
    @Select("select menujson from menujsontab where znjgfzdm = #{znjgfzdm} and menubz = #{menubz}")
    public String getMenu(long znjgfzdm, int menubz);

    @Update("update menujsontab set menujson = #{menujson} where znjgfzdm = #{znjgfzdm} and menubz = #{menubz}")
    public void updateMenu(String menujson, long znjgfzdm, int menubz);

    @Insert("INSERT INTO `menujsontab`(`dwdm`, `znjgdm`, `znjgfzdm`, `menubz`, `menujson`) VALUES (#{dwdm}, #{znjgdm}, #{znjgfzdm}, #{menubz}, #{menujson})")
    public void insertMenu(String dwdm, long znjgdm, long znjgfzdm, int menubz, String menujson);
}
