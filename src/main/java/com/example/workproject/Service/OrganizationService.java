package com.example.workproject.Service;

import com.example.workproject.entity.PoJo.organizationBean;

import java.util.List;

public interface OrganizationService {
    public List<organizationBean> getOrganizationdata();
    public void updateOrganizationdata(String organizationName, int organizationId);
    public void deleteOrganizationdata(int start, int end);
    public void insertOrganizationdata(String organizationName, int organizationId);
}
