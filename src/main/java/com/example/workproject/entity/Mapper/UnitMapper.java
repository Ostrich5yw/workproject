package com.example.workproject.entity.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.workproject.entity.Mapper.sqlProvider.unitSqlProvider;
import com.example.workproject.entity.PoJo.unitBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UnitMapper {
    @Select("select * from dwxxb")                          //查询所有单位信息
    unitBean[] getAllUnit();

    @Select("select mediadir from xtcsb")
    String getMediaDir();

    @Select("select dwxxb.*, dwxzxxb.dwxzmc from dwxxb JOIN dwxzxxb where dwxxb.dwxzid=dwxzxxb.dwxzid limit #{limit} offset #{page}")
    List<unitBean> unitPageInfo(int page, int limit);
//    @Select("select dwxxb.*, dwxzxxb.dwxzmc from dwxxb JOIN dwxzxxb where dwxxb.dwxzid=dwxzxxb.dwxzid ${ew.customSqlSegment}")
//    List<unitBean> findByPage(IPage<unitBean> page, @Param(Constants.WRAPPER) Wrapper<unitBean> wrapper);

    @SelectProvider(type = unitSqlProvider.class, method = "findUnit")
//    @ResultMap("unitBean")
    List<unitBean> findUnit(String dwmc, String dwdm, int page, int limit);

    @Select("select count(*) from dwxxb")
    int getUnitNum();                                        //查询单位总数

    @SelectProvider(type = unitSqlProvider.class, method = "getConditionUnitNum")
    int getConditionUnitNum(String dwmc, String dwdm);       //查询符合条件单位总数

    @Insert("insert into dwxxb (dwdm, dwmc, dwxzid, dwszsf, dwszcs, dwszqx, dwszdz, dwyzbm, dwfr, dwlxr, lxryddh, lxrgddh, lxrmail) values " +
            "(#{dwdm}, #{dwmc}, #{dwxzid}, #{dwszsf}, #{dwszcs}, #{dwszqx}, #{dwszdz},  #{dwyzbm}, #{dwfr}, #{dwlxr}, #{lxryddh}, #{lxrgddh}, #{lxrmail})")
    void insertUnit(String dwdm, String dwmc,int dwxzid, String dwszsf, String dwszcs, String dwszqx, String dwszdz, String dwyzbm, String dwfr, String dwlxr, String lxryddh, String lxrgddh, String lxrmail);

    @Delete("delete from dwxxb where dwdm=#{dwdm}")
    void deleteUnit(String dwxzid);

    @Update("update dwxxb set dwmc=#{dwmc}, dwxzid=#{dwxzid}, dwszsf=#{dwszsf}, dwszcs=#{dwszcs}, dwszqx=#{dwszqx}, dwszdz=#{dwszdz}, dwyzbm=#{dwyzbm}, dwfr=#{dwfr}, dwlxr=#{dwlxr}, lxryddh=#{lxryddh}, lxrmail=#{lxrmail} where dwdm=#{dwdm}")
    void updateUnit(String dwdm, String dwmc,int dwxzid, String dwszsf, String dwszcs, String dwszqx, String dwszdz, String dwyzbm, String dwfr, String dwlxr, String lxryddh, String lxrgddh, String lxrmail);

}
