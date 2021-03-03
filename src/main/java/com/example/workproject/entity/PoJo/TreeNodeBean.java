package com.example.workproject.entity.PoJo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNodeBean {
     private int authorityId;
     private String authorityName;
     private int orderNumber;
     private String menuUrl;
     private String menuIcon;
     private String createTime;
     private String authority;
     private int checked;
     private String updateTime;
     private int isMenu;
     private int parentId;
}
