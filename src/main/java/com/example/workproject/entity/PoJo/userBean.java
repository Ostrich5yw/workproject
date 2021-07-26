package com.example.workproject.entity.PoJo;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userData")
public class userBean implements Serializable {
    @Expose
    @TableId(value = "userId")
//    @TableField(value = "userId",exist = true)
    private long userId;
    @Expose
    @TableField(value = "username",exist = true)
    private String username;
    @Expose
    @TableField(value = "password",exist = true)
    private String password;
    @Expose
    @TableField(value = "nickName",exist = true)
    private String nickName;
    @Expose
    @TableField(value = "avatar",exist = true)
    private String avatar;
    @Expose
    @TableField(value = "phone",exist = true)
    private String phone;
    @Expose
    @TableField(value = "state",exist = true)
    private int state;
    @Expose
    @TableField(value = "createTime",exist = true)
    private String createTime;
    @Expose
    @TableField(value = "updateTime",exist = true)
    private String updateTime;
    @Expose
    @TableField(value = "roleId",exist = true)
    private int roleId;
    @Expose
    @TableField(value = "roleName",exist = true)
    private String roleName;
    @Expose(serialize=false,deserialize=false)
    @TableField(value = "roles",exist = true)
    private String roles;
    @Expose
    @TableField(value = "sex",exist = true)
    private String sex;
}
