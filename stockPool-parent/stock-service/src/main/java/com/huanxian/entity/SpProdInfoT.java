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
 * 产品-子项目内容表
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
@TableName("sp_prod_info_t")
public class SpProdInfoT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 产品ID
     */
    @TableField("prod_id")
    private Long prodId;
    /**
     * 产品名称
     */
    @TableField("prod_name")
    private String prodName;
    /**
     * 产品子项目id
     */
    @TableField("classify_id")
    private Long classifyId;
    /**
     * 产品子项目名称
     */
    @TableField("classify_name")
    private String classifyName;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 封面
     */
    @TableField("pic")
    private String pic;
    /**
     * 简介
     */
    @TableField("intro")
    private String intro;
    /**
     * 内容
     */
    @TableField("content")
    private String content;
    /**
     * 阅读数
     */
    @TableField("read_num")
    private Integer readNum;
    /**
     * 状态(1：已发布  2：未发布  3：删除）
     */
    @TableField("status")
    private Integer status;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
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
        return "SpProdInfoT{" +
        ", id=" + id +
        ", prodId=" + prodId +
        ", prodName=" + prodName +
        ", classifyId=" + classifyId +
        ", classifyName=" + classifyName +
        ", title=" + title +
        ", pic=" + pic +
        ", intro=" + intro +
        ", content=" + content +
        ", readNum=" + readNum +
        ", status=" + status +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
