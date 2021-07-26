package com.example.workproject.entity.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workproject.entity.PoJo.unitBean;
import org.apache.ibatis.annotations.Param;

public interface Unit_MybatisPlus_Mapper extends BaseMapper<unitBean> {
    IPage<unitBean> selectPageVo(Page<?> page, Integer state);
//    IPage<unitBean> findByPage(IPage<unitBean> page, @Param(Constants.WRAPPER) Wrapper<unitBean> wrapper);
}
