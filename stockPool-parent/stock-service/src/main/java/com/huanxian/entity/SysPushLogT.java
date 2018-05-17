package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 推送日志表
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
@TableName("sys_push_log_t")
public class SysPushLogT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 推送标题
     */
    @TableField("title")
    private String title;
    /**
     * 推送内容
     */
    @TableField("content")
    private String content;
    /**
     * 平台（IOS:苹果、ANDROID：安卓;ALL:全平台）
     */
    @TableField("platform")
    private String platform;
    /**
     * 推送状态(0：失败、1：成功)
     */
    @TableField("status")
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "SysPushLogT{" +
        ", id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", platform=" + platform +
        ", status=" + status +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        "}";
    }
}
