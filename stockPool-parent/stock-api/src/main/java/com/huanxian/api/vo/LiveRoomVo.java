package com.huanxian.api.vo;

import java.util.Date;

public class LiveRoomVo {

	    private Long id;
	    /**
	     * 标题
	     */
	    private String title;
	    /**
	     * 简介
	     */
	    private String intro;
	    /**
	     * 背景图
	     */
	    private String cover;
	    /**
	     * 直播间主人id
	     */
	    private Long teacherId;
	    /**
	     * 直播间主人名称
	     */
	    private String teacherName;
	    /**
	     * 群聊id
	     */
	    private String groupId;
	    /**
	     * 是否是平台直播间（0：不是；1：是）
	     */
	    private Integer platform;
	    /**
	     * 状态(1：空闲；2：正在直播)
	     */
	    private Integer liveStatus;
	    /**
	     * 状态（1：启用；2：禁用；3：删除）
	     */
	    private Integer status;
	    /**
	     * 创建时间
	     */
	    private Date createTime;
	    
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
}
