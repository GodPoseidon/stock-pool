package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 广告表
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@TableName("sp_ad_t")
public class SpAdT implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 所属广告位
     */
    @TableField("type")
    private Long type;
    /**
     * 所属广告位名称
     */
    @TableField("type_name")
    private String typeName;
    /**
     * 广告位标题
     */
    @TableField("name")
    private String name;
    /**
     * 广告内容
     */
    @TableField("content")
    private String content;
    /**
     * 广告图片
     */
    @TableField("picture")
    private String picture;
    /**
     * 链接
     */
    @TableField("url")
    private String url;
    /**
     * 是否启用（0：启用 1：禁用）
     */
    @TableField("ad_enable")
    private Integer adEnable;
    /**
     * 创建人
     */
    @TableField("founder")
    private String founder;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 是否删除（0：未删除 1 删除）
     */
    @TableField("ad_delete")
    private Integer adDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAdEnable() {
        return adEnable;
    }

    public void setAdEnable(Integer adEnable) {
        this.adEnable = adEnable;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAdDelete() {
        return adDelete;
    }

    public void setAdDelete(Integer adDelete) {
        this.adDelete = adDelete;
    }
    
    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
    public String toString() {
        return "SpAdT{" +
        ", id=" + id +
        ", type=" + type +
        ", typeName=" + typeName +
        ", name=" + name +
        ", content=" + content +
        ", picture=" + picture +
        ", url=" + url +
        ", adEnable=" + adEnable +
        ", founder=" + founder +
        ", creatTime=" + createTime +
        ", adDelete=" + adDelete +
        "}";
    }
}
