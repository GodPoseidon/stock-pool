package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 短信日志表
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-07
 */
@TableName("sys_sms_log_t")
public class SysSmsLogT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;
    /**
     * 消息内容
     */
    @TableField("content")
    private String content;
    /**
     * 发送时间
     */
    @TableField("send_time")
    private Date sendTime;
    /**
     * 用户类型（teacher,讲师;member,会员;operation,运营;admin,管理员;）
     */
    @TableField("type")
    private String type;
    /**
     * 发送状态(0：失败、1：成功)
     */
    @TableField("state")
    private Integer state;
    /**
     * 保留字段
     */
    @TableField("version")
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SysSmsLogT{" +
        ", id=" + id +
        ", phone=" + phone +
        ", content=" + content +
        ", sendTime=" + sendTime +
        ", type=" + type +
        ", state=" + state +
        ", version=" + version +
        "}";
    }
}
