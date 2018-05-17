package com.huanxian.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 视频学院-名师战法-课程
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
@TableName("sp_course_t")
public class SpCourseT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value ="id", type = IdType.AUTO)
    private Long id;
    /**
     * 课程包id
     */
    @TableField("package_id")
    private Long packageId;
    /**
     * 课程标题
     */
    @TableField("title")
    private String title;
    /**
     * 课程简介
     */
    @TableField("intro")
    private String intro;
    /**
     * 视频封面
     */
    @TableField("pic")
    private String pic;
    /**
     * 视频地址
     */
    @TableField("url")
    private String url;
    /**
     * 排序序号
     */
    @TableField("sort")
    private Integer sort;
    /**
     * 视频时长
     */
    @TableField("video_time")
    private String videoTime;
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

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
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

    @Override
    public String toString() {
        return "SpCourseT{" +
        ", id=" + id +
        ", packageId=" + packageId +
        ", title=" + title +
        ", intro=" + intro +
        ", pic=" + pic +
        ", url=" + url +
        ", sort=" + sort +
        ", videoTime=" + videoTime +
        ", status=" + status +
        ", modifyTime=" + modifyTime +
        ", modifyUser=" + modifyUser +
        "}";
    }
}
