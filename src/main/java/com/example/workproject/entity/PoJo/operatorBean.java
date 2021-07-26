package com.example.workproject.entity.PoJo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("czyxxb")
public class operatorBean implements Serializable {
    private String dwdm    ;     //单位代码
    private int znjgdm  ;        //职能机构代码
    private int znjgfzdm;        //职能机构分支代码
    private String czyxm   ;     //操作员姓名
    private String czysfzh ;     //操作员身份证号
    private String czyyddh ;     //操作员移动电话
    public long czydm   ;        //操作员代码
    private String czymail ;     //操作员邮箱
    private String czygddh ;     //操作员固定电话
    private String czyjs   ;    //操作员角色【1：普通用户  2：分支部门管理员  3：职能部门管理员   4：单位管理员】
    private String zt      ;    //操作员状态【1：正常  0：停用】
    private String cjrq    ;    //创建日期
    private String czykl;       //操作员口令
}
