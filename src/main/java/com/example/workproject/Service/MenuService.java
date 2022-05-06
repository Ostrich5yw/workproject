package com.example.workproject.Service;

public interface MenuService {
//    public String getMenu(String name);
//    public void changeMenu(String[] res, String name);
    public void updateMenu(String[] res, long znjgfzdm, int menubz);
    public String getMenu(long znjgfzdm, int menubz);
    public void insertMenu(String dwdm, long znjgdm, long znjgfzdm, int menubz, String[] res);

}
