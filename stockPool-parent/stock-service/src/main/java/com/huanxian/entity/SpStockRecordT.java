package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 牛股战绩
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
@TableName("sp_stock_record_t")
public class SpStockRecordT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 股票名称
     */
    @TableField("name")
    private String name;
    /**
     * 股票代码
     */
    @TableField("code")
    private String code;
    /**
     * 最大涨幅
     */
    @TableField("max_rise")
    private String maxRise;
    /**
     * 买入时间
     */
    @TableField("timing")
    private String timing;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMaxRise() {
        return maxRise;
    }

    public void setMaxRise(String maxRise) {
        this.maxRise = maxRise;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
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
        return "SpStockRecordT{" +
        ", id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", maxRise=" + maxRise +
        ", timing=" + timing +
        ", status=" + status +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
