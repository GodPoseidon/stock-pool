package com.huanxian.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 资讯表
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@TableName("sp_info_t")
public class SpInfoT implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 所属分类
     */
    @TableField("classId")
    private Long classId;
    /**
     * 所属分类名称
     */
    @TableField("className")
    private String className;
    /**
     * 资讯标题
     */
    @TableField("title")
    private String title;
    /**
     * 简介
     */
    @TableField("outline")
    private String outline;
    /**
     * 资讯正文
     */
    @TableField("content")
    private String content;
    /**
     * 资讯封面
     */
    @TableField("cover")
    private String cover;
    /**
     * 上传时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 阅读量
     */
    @TableField("readsum")
    private Integer readsum;
    /**
     * 链接
     */
    @TableField("url")
    private String url;
    /**
     * 是否推荐（0：不推荐 1：推荐）
     */
    @TableField("inf_rec")
    private Integer infRec;
    /**
     * 是否推荐（0：启用 1：禁用）
     */
    @TableField("inf_enable")
    private Integer infEnable;
    /**
     * 是否发布（0:未发布 1：发布）
     */
    @TableField("inf_release")
    private Integer infRelease;
    /**
     * 是否删除（0：未删除 1：删除）
     */
    @TableField("inf_delete")
    private Integer infDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreatTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReadsum() {
        return readsum;
    }

    public void setReadsum(Integer readsum) {
        this.readsum = readsum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getInfRec() {
        return infRec;
    }

    public void setInfRec(Integer infRec) {
        this.infRec = infRec;
    }

    public Integer getInfEnable() {
        return infEnable;
    }

    public void setInfEnable(Integer infEnable) {
        this.infEnable = infEnable;
    }

    public Integer getInfRelease() {
        return infRelease;
    }

    public void setInfRelease(Integer infRelease) {
        this.infRelease = infRelease;
    }

    public Integer getInfDelete() {
        return infDelete;
    }

    public void setInfDelete(Integer infDelete) {
        this.infDelete = infDelete;
    }

    public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
    public String toString() {
        return "SpInfoT{" +
        ", id=" + id +
        ", classId=" + classId +
        ", className=" + className +
        ", title=" + title +
        ", outline=" + outline +
        ", content=" + content +
        ", cover=" + cover +
        ", createTime=" + createTime +
        ", readsum=" + readsum +
        ", url=" + url +
        ", infRec=" + infRec +
        ", infEnable=" + infEnable +
        ", infRelease=" + infRelease +
        ", infDelete=" + infDelete +
        "}";
    }
}

