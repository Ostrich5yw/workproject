package com.example.workproject.entity.Mapper;

import com.example.workproject.entity.PoJo.organizationBean;
import com.example.workproject.entity.PoJo.userBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MysqlMapper {
    //MenuData
    @Select("select data from menu where name = #{name}")
    String getMenu(String name);


    @Update("update menu set data = #{data} where name = #{name}")
    void changeMenu(String data, String name);

    //userData
    @Select("select * from userData where username = #{username}")          //shiro登录
    userBean getUser(String username);

    @Select("select * from userData")
    List<userBean> getData();

    @Select("select count(*) from userData")
    int getDataNum();

    @Update("update userData set username = #{username} where userId = #{userId}")
    void updateData(String username, int userId);

    @Select("call upd_when_del(#{userId})")
    void deleteData(int userId);

    @Insert("insert into userData (userId, username, nickName, phone, sex, password, state, roleId, roleName, roles, createTime, updateTime) values (#{userId}, #{username}, #{nickName}, #{phone}, #{sex}, #{password}, #{state}, #{roleId}, #{roleName}, #{roles}, #{createTime}, #{updateTime})")
    void insertData(int userId, String username, String nickName, String phone, String sex, String password, int state, int roleId, String roleName, String roles, String createTime, String updateTime);

    //organizationData
    @Select("select * from organizationData")
    List<organizationBean> getOrganizationdata();

    @Update("update organizationData set organizationName = #{organizationName} where organizationId = #{organizationId}")
    void updateOrganizationdata(String organizationName, int organizationId);

    @Delete("call upd_when_del_org(#{start}, #{end})")
    void deleteOrganizationdata(int start, int end);

    @Insert("call upd_when_ins_org(#{organizationId}, #{organizationName}, #{createTime})")
    void insertOrganizationdata(String organizationName, int organizationId, String createTime);

}
