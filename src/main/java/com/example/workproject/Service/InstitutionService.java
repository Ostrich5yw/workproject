package com.example.workproject.Service;

import com.example.workproject.entity.PoJo.institutionBean;
import com.example.workproject.entity.PoJo.institutionTreeBean;
import com.example.workproject.entity.PoJo.unitBean_Name_ID;

import java.util.List;

public interface InstitutionService {
    public List<institutionTreeBean> getInstitutionTree(String dwdm);
    public List<unitBean_Name_ID> getUnit_Name_ID();
    public List<institutionBean> getAllInstitution(String dwdm);
    public void insertInstitution_fz(String dwdm, String znjgdm, String znjgfzmc, String lxrxm, String lxryddh, String lxrgddh, String lxrmail);
    public void insertInstitution(String dwdm, String znjgmc, String lxrxm, String lxryddh, String lxrgddh, String lxrmail);

}
