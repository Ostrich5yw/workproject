package com.example.workproject.Service;

import com.example.workproject.entity.PoJo.unitBean;

public interface UnitService {
    public String getAllUnit(int page, int limit);
    public void insertUnit(String param[]);
    public void updateUnit(String param[]);
    public void deleteUnit(String ID);
    public String findUnit(String param1, String param2, int page, int limit);
}
