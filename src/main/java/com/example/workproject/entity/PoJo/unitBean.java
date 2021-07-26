package com.example.workproject.entity.PoJo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dwxxb")
public class unitBean {
    @TableId
    private String dwdm;                                         //单位代码
    private String dwmc;                                         //单位名称
    private int dwxzid;                                         //   单位性质
    private String dwszsf;                                      //  单位所在省份
    private String dwszcs;                                      //  单位所在城市
    private String dwszqx;                                      //  单位所在区县
    private String dwszdz;                                      //    单位所在地址
    private String dwfr;                                         // 单位法人
    private String dwlxr;                                       //  单位联系人
    private String lxryddh;                                      //   联系人移动电话
    private String lxrmail;                                      //    联系人电子邮件
    private String lxrgddh;                                      //   联系人电话
    private String dwyzbm;                                      //  单位邮政编码
    private String dwxzmc;                                //联和dwxzid查询dwxzxxb中的dwxzmc
}
