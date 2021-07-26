package com.example.workproject.Service;

public interface UserService {
    public String getData(int page, int limit);
    public String getData2(int page, int limit);
    public void updateData(String username, int userId);
    public void deleteData(int userId);
    public void insertData(int userId, String username, String nickName, String phone, String sex);
}
