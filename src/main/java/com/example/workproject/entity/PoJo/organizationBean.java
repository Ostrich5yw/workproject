package com.example.workproject.entity.PoJo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class organizationBean {
    @Expose
    @TableField(value = "organizationId",exist = true)
    private int organizationId;
    @Expose
    @TableField(value = "parentId",exist = true)
    private int parentId;
    @Expose
    @TableField(value = "organizationName",exist = true)
    private String organizationName;
    @Expose
    @TableField(value = "organizationFullName",exist = true)
    private String organizationFullName;
    @Expose
    @TableField(value = "organizationType",exist = true)
    private String organizationType;
    @Expose
    @TableField(value = "sortNumber",exist = true)
    private int sortNumber;
    @Expose
    @TableField(value = "comments",exist = true)
    private String comments;
    @Expose
    @TableField(value = "createTime",exist = true)
    private String createTime;
    @Expose
    @TableField(value = "updateTime",exist = true)
    private String updateTime;
}
