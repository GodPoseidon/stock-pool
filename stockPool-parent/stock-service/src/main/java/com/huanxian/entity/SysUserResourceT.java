package com.huanxian.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户对应资源菜单
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
@TableName("sys_user_resource_t")
public class SysUserResourceT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;
    @TableField("user_id")
    private Integer userId;
    @TableField("resource_id")
    private Integer resourceId;
    @TableField("status")
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysUserResourceT{" +
        ", id=" + id +
        ", userId=" + userId +
        ", resourceId=" + resourceId +
        ", status=" + status +
        "}";
    }
}
