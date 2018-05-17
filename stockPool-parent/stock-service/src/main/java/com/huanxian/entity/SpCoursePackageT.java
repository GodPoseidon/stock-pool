package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 视频学院-名师战法课程包
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
@TableName("sp_course_package_t")
public class SpCoursePackageT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
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
     * 简介
     */
    @TableField("intro")
    private String intro;
    /**
     * 封面
     */
    @TableField("pic")
    private String pic;
    /**
     * 排序序号
     */
    @TableField("sort")
    private Integer sort;
    /**
     * 状态（1：启用；2：禁用；3：删除）
     */
    @TableField("status")
    private Integer status;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        return "SpCoursePackageT{" +
        ", id=" + id +
        ", title=" + title +
        ", teacherId=" + teacherId +
        ", teacherName=" + teacherName +
        ", intro=" + intro +
        ", pic=" + pic +
        ", sort=" + sort +
        ", status=" + status +
        ", modifyTime=" + modifyTime +
        ", modifyUser=" + modifyUser +
        "}";
    }
}
