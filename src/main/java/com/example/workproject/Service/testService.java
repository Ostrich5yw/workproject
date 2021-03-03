package com.example.workproject.Service;

import com.example.workproject.entity.PoJo.UserBean;

public interface testService {
    public String getData(int page, int limit);
    public void changeData(String username, int userId);

}
