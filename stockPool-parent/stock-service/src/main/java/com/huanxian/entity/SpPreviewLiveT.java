package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 预约直播表
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-25
 */
@TableName("sp_preview_live_t")
public class SpPreviewLiveT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 链接
     */
    @TableField("url")
    private String url;
    /**
     * 直播间id
     */
    @TableField("room_id")
    private Long roomId;
    /**
     * 封面
     */
    @TableField("pic")
    private String pic;
    /**
     * 预约时间
     */
    @TableField("preview_time")
    private Date previewTime;
    
    /**
     * 预约直播结束时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 状态（1：启用；2：禁用；3：删除）
     */
    @TableField("status")
    private Integer status;
    @TableField("modify_time")
    private Date modifyTime;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getPreviewTime() {
        return previewTime;
    }

    public void setPreviewTime(Date previewTime) {
        this.previewTime = previewTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "SpPreviewLiveT [id=" + id + ", title=" + title + ", url=" + url + ", roomId=" + roomId + ", pic=" + pic
				+ ", previewTime=" + previewTime + ", endTime=" + endTime + ", status=" + status + ", modifyTime="
				+ modifyTime + ", modifyUser=" + modifyUser + "]";
	}
	
}
