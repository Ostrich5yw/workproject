package com.example.workproject.entity.PoJo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class institutionBean {
    private String dwdm;                    //单位代码  （不显示）
    private int znjgdm;                  //机构代码（不显示，系统生成）
    private String znjgmc;                  //机构名称
    private String cjrq;                    //创建日期
    private String lxrxm;                   //联系人
    private String lxryddh;                 //联系人移动电话
    private String lxrgddh;                 //联系人固定电话
    private String lxrmail;                 // 联系人邮箱
}
