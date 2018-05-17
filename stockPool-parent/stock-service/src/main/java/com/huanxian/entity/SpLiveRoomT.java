package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 直播间表
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
@TableName("sp_live_room_t")
public class SpLiveRoomT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 简介
     */
    @TableField("intro")
    private String intro;
    /**
     * 背景图
     */
    @TableField("cover")
    private String cover;
    /**
     * 直播间主人id
     */
    @TableField("teacher_id")
    private Long teacherId;
    /**
     * 直播间主人名称
     */
    @TableField("teacher_name")
    private String teacherName;
    /**
     * 群聊id
     */
    @TableField("group_id")
    private String groupId;
    /**
     * 是否是平台直播间（0：不是；1：是）
     */
    @TableField("platform")
    private Integer platform;
    /**
     * 状态(1：空闲；2：正在直播)
     */
    @TableField("live_status")
    private Integer liveStatus;
    /**
     * 状态（1：启用；2：禁用；3：删除）
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
    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;
    /**
     * 修改人
     */
    @TableField("modify_user")
    private String modifyUser;


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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Override
    public String toString() {
        return "SpLiveRoomT{" +
        ", id=" + id +
        ", title=" + title +
        ", intro=" + intro +
        ", cover=" + cover +
        ", teacherId=" + teacherId +
        ", teacherName=" + teacherName +
        ", groupId=" + groupId +
        ", platform=" + platform +
        ", liveStatus=" + liveStatus +
        ", status=" + status +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        ", modifyTime=" + modifyTime +
        ", modifyUser=" + modifyUser +
        "}";
    }
}
