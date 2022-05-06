package com.example.workproject.entity.Mapper;

import com.example.workproject.entity.PoJo.operatorBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OperatorMapper {
    @Select("select * from czyxxb")
    public operatorBean[] getAllOperator();



    @Select("select xtcsb.czydm from xtcsb")                     //查询目前最大人员编号
    long getOperatorDm_MAX();

    @Update("update xtcsb set czydm = czydm + 1")
    void updateMaxOperatorDm();

    @Select("select * from czyxxb where czydm = #{czydm}")
    public operatorBean getOperator(String czydm);

    @Select("select count(*) from czyxxb where znjgfzdm=#{institutionId}")
    public int getOperatorNum(long institutionId);

    @Select("select * from czyxxb where znjgfzdm=#{institutionId} limit #{limit} offset #{page}")
    public List<operatorBean> getOperatorByInstitutionDM(long institutionId, int page, int limit);

    @Update("update czyxxb set zt = #{zt} where czydm = #{czydm}")
    public void updateOperator(String czydm, String zt);
}
