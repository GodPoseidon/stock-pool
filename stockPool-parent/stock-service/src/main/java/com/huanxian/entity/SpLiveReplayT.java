package com.huanxian.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 直播间回放表
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
@TableName("sp_live_replay_t")
public class SpLiveReplayT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="id",type=IdType.AUTO)
    private Long id;
    /**
     * 直播间ID
     */
    @TableField("room_id")
    private Long roomId;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 背景图
     */
    @TableField("cover")
    private String cover;
    /**
     * 视频地址
     */
    @TableField("url")
    private String url;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "SpLiveReplayT [id=" + id + ", roomId=" + roomId + ", title=" + title + ", cover=" + cover + ", url="
				+ url + ", status=" + status + ", createTime=" + createTime + ", createUser=" + createUser
				+ ", modifyTime=" + modifyTime + ", modifyUser=" + modifyUser + "]";
	}
}
