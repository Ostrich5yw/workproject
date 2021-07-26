package com.example.workproject.entity.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workproject.entity.PoJo.userBean;

public interface MybatisPlusMapper extends BaseMapper<userBean> {
    IPage<userBean> selectPageVo(Page<?> page, Integer state);
}
