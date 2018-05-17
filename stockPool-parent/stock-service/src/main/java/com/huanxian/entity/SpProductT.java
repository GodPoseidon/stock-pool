package com.huanxian.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-26
 */
@TableName("sp_product_t")
public class SpProductT implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品名称
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 产品标题
     */
    @TableField("title")
    private String title;
    /**
     * 价格
     */
    @TableField("price")
    private String price;
    /**
     * 图片
     */
    @TableField("pic")
    private String pic;
    /**
     * 简介
     */
    @TableField("intro")
    private String intro;
    /**
     * 链接
     */
    @TableField("url")
    private String url;
    /**
     * 时间时、分、秒组合
     */
    @TableField("time")
    private String time;
    /**
     * 状态(1：启用  2：冻结  3：删除）
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        return "SpProductT{" +
        ", id=" + id +
        ", title=" + title +
        ", price=" + price +
        ", pic=" + pic +
        ", intro=" + intro +
        ", url=" + url +
        ", time=" + time +
        ", status=" + status +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
