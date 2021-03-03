package com.example.workproject.entity.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.example.workproject.entity.PoJo.UserBean;

import java.util.List;

@Mapper
@Repository
public interface testMapper {
    @Select("select * from userData")
    List<UserBean> getData();

    @Select("select count(*) from userData")
    int getDataNum();

    @Select("update userData set username = #{username} where userId = #{userId}")
    void changeData(String username, int userId);
}
