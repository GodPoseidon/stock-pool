package com.huanxian.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户-产品表
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-08
 */
@TableName("sp_account_pro_t")
public class SpAccountProT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("accountId")
    private Long accountId;
    /**
     * 产品id
     */
    @TableField("productId")
    private Long productId;
    /**
     * 产品生效时间
     */
    @TableField("startTime")
    private Date startTime;
    /**
     * 产品结束时间
     */
    @TableField("endTime")
    private Date endTime;
    @TableField("status")
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SpAccountProT{" +
        ", id=" + id +
        ", accountId=" + accountId +
        ", productId=" + productId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", status=" + status +
        "}";
    }
}
