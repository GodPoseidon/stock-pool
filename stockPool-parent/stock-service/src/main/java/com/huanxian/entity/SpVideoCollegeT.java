package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 视频学院-视频表
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@TableName("sp_video_college_t")
public class SpVideoCollegeT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 视频标题
     */
    @TableField("title")
    private String title;
    /**
     * 视频封面
     */
    @TableField("cover")
    private String cover;
    /**
     * 视频时长
     */
    @TableField("video_time")
    private String videoTime;
    /**
     * 讲师id
     */
    @TableField("teacher_id")
    private Long teacherId;
    /**
     * 讲师名称
     */
    @TableField("teacher_name")
    private String teacherName;
    /**
     * 视频分类ID
     */
    @TableField("classify_id")
    private Long classifyId;
    /**
     * 视频分类名称
     */
    @TableField("classify_name")
    private String classifyName;
    /**
     * 视频地址
     */
    @TableField("url")
    private String url;
    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    @TableField("status")
    private Integer status;
    /**
     * 修改用户
     */
    @TableField("modify_user")
    private String modifyUser;
    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;


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

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
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

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
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

    @Override
    public String toString() {
        return "SpVideoCollegeT{" +
        ", id=" + id +
        ", title=" + title +
        ", cover=" + cover +
        ", videoTime=" + videoTime +
        ", teacherId=" + teacherId +
        ", teacherName=" + teacherName +
        ", classifyId=" + classifyId +
        ", classifyName=" + classifyName +
        ", url=" + url +
        ", status=" + status +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
