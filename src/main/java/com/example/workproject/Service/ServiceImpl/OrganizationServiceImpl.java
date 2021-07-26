package com.example.workproject.Service.ServiceImpl;

import com.example.workproject.Service.OrganizationService;
import com.example.workproject.entity.Mapper.MysqlMapper;
import com.example.workproject.entity.PoJo.organizationBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    private MysqlMapper mysqlMapper;

    @Override
    public List<organizationBean> getOrganizationdata() {
        return mysqlMapper.getOrganizationdata();
    }

    @Override
    public void updateOrganizationdata(String organizationName, int organizationId) {
        mysqlMapper.updateOrganizationdata(organizationName, organizationId);
    }

    @Override
    public void deleteOrganizationdata(int start, int end) {
        mysqlMapper.deleteOrganizationdata(start, end);
    }

    @Override
    public void insertOrganizationdata(String organizationName, int organizationId) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createTime = simpleDateFormat.format(date);
        mysqlMapper.insertOrganizationdata(organizationName, organizationId, createTime);
    }
}
