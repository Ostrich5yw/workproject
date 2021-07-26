package com.example.workproject.entity.Mapper;

import com.example.workproject.entity.PoJo.institutionBean;
import com.example.workproject.entity.PoJo.institutionTreeBean;
import com.example.workproject.entity.PoJo.unitBean_Name_ID;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Mapper
@Repository
public interface InstitutionMapper {
    @Select("select MAX(znjgfzb.znjgfzdm) from znjgfzb")                     //查询目前最大分组机构编号
    int getMaxIndexInstitution_fz();

    @Select("select MAX(znjgxxb.znjgdm) from znjgxxb")                     //查询目前最大分组机构编号
    int getMaxIndexInstitution();

    @Select("select menuconfigdir from xtcsb")                     //查询分组树存放目录
    String getPath();

//    @Select("select * from znjgtree where dwdm=#{dwdm}")                         //查询视图，生成机构树---二级
//    @Select("select `dwxxb`.`dwdm` AS `dwdm`,`znjgxxb`.`znjgdm` AS `znjgdm`,`znjgxxb`.`znjgmc` AS `znjgmc`,`xtcsb`.`znjgfzdm` AS `znjgfzdm`,`znjgfzb`.`znjgfzmc` AS `znjgfzmc` from (((`dwxxb` join `znjgxxb`) join `xtcsb`) join `znjgfzb`) where ((`znjgxxb`.`dwdm` = `dwxxb`.`dwdm`) and (`znjgxxb`.`znjgdm` = `xtcsb`.`znjgdm`) and (`xtcsb`.`znjgfzdm` = `znjgfzb`.`znjgfzdm`) and (`dwxxb`.`dwdm` = #{dwdm}))")
//    LinkedList<institutionTreeBean> getInstitutionTree(String dwdm);

    @Select("select `dwxxb`.`dwdm` AS `dwdm`,`znjgxxb`.`znjgdm` AS `znjgdm`,`znjgxxb`.`znjgmc` AS `znjgmc`,`znjgfzb`.`znjgfzdm` AS `znjgfzdm`,`znjgfzb`.`znjgfzmc` AS `znjgfzmc` from ((`dwxxb` join `znjgxxb`) join `znjgfzb`) where ((`znjgxxb`.`dwdm` = `dwxxb`.`dwdm`) and (`znjgxxb`.`znjgdm` = `znjgfzb`.`znjgdm`) and (`dwxxb`.`dwdm` = #{dwdm}))")
    LinkedList<institutionTreeBean> getInstitutionTree(String dwdm);

    @Select("select * from znjgxxb where dwdm=#{dwdm}")                          //查询所有职能机构---一级
    List<institutionBean> getAllInstitution(String dwdm);

    @Select("select dwxxb.dwmc as title, dwxxb.dwdm as id from dwxxb")           //查询所有单位的名称和代码
    List<unitBean_Name_ID> getUnit_Name_ID();

//    @Insert("INSERT INTO `xtcsb`(`znjgdm`, `znjgfzdm`, `klcs`) VALUES (#{znjgdm}, #{znjgfzdm}, #{klcs})")
//    public void insertInstitution(int znjgdm, int znjgfzdm, int klcs);    //插入新的分支机构
    @Insert("INSERT INTO `znjgxxb`(`dwdm`, `znjgdm`, `znjgmc`, `cjrq`, `lxrxm`, `lxryddh`, `lxrgddh`, `lxrmail`) VALUES (#{dwdm}, #{znjgdm}, #{znjgmc}, #{cjrq}, #{lxrxm}, #{lxryddh}, #{lxrgddh}, #{lxrmail})")
    public void insertInstitution(String dwdm, int znjgdm, String znjgmc ,String cjrq, String lxrxm, String lxryddh, String lxrgddh, String lxrmail);    //插入新的分支机构
}
