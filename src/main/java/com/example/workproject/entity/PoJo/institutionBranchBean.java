package com.example.workproject.entity.PoJo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("znjgfzb")
public class institutionBranchBean {
    private String dwdm;               //  单位代码 （不显示）
    private int znjgdm;             //职能机构代码  (不显示)
    private String znjgfzmc;           // 分支部门
    private int znjgfzdm;           // 职能分支机构代码  (不显示)
    private String cjrq;               //   创建日期
    private String lxrxm;              //  联系人
    private String lxryddh;            // 联系人移动电话
    private String lxrgddh;            //    联系人固定电话
    private String lxrmail;            //     联系人邮箱
}
