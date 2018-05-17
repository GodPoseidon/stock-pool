package com.huanxian.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户消息表
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-05
 */
@TableName("sys_message_t")
public class SysMessageT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 目标用户ID
     */
    @TableField("account_id")
    private Long accountId;
    /**
     * 消息标题
     */
    @TableField("title")
    private String title;
    /**
     * 消息内容
     */
    @TableField("content")
    private String content;
    /**
     * 消息类型
     */
    @TableField("msg_type")
    private String msgType;
    /**
     * 消息链接
     */
    @TableField("link")
    private String link;
    /**
     * 是否已读(0：未读、1：已读)
     */
    @TableField("msread")
    private Integer msread;
    @TableField("create_time")
    private Date createTime;
    @TableField("create_user")
    private String createUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getMsread() {
        return msread;
    }

    public void setMsread(Integer msread) {
        this.msread = msread;
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
        return "SysMessageT{" +
        ", id=" + id +
        ", accountId=" + accountId +
        ", title=" + title +
        ", content=" + content +
        ", msgType=" + msgType +
        ", link=" + link +
        ", msread=" + msread +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        "}";
    }
}
