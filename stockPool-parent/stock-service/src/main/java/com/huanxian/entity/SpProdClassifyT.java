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
 * 产品-子项目分类表
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
@TableName("sp_prod_classify_t")
public class SpProdClassifyT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 子项目名称
     */
    @TableField("name")
    private String name;
    /**
     * 产品ID
     */
    @TableField("prodId")
    private Long prodId;
    /**
     * 直播间ID
     */
    @TableField("room_id")
    private Long roomId;
    /**
     * 修改人
     */
    @TableField("modify_user")
    private String modifyUser;
    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;
    /**
     * 状态(1：启用  2：禁用  3：删除）
     */
    @TableField("status")
    private int status;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	@Override
    public String toString() {
        return "SpProdClassifyT{" +
        ", id=" + id +
        ", prodId=" + prodId +
        ", name=" + name +
        ", roomId=" + roomId +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        ", status=" + status +
        "}";
    }
}
