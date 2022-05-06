package com.example.workproject.Service;

import com.example.workproject.entity.PoJo.operatorBean;

import java.util.List;

public interface OperatorService {
    public String getAllOperator();
    public String getOperatorByInstitutionDM(long institutionId, int page, int limit);
    public void insertOperator(String param[]);
    public void updateOperator(String czydm, String zt);
}
