package com.example.workproject.entity.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workproject.entity.PoJo.UserBean;

public interface MybatisPlusMapper extends BaseMapper<UserBean> {
    IPage<UserBean> selectPageVo(Page<?> page, Integer state);
}
