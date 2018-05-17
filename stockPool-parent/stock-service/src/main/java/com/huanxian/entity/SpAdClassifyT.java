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
 * 广告位表
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@TableName("sp_ad_classify_t")
public class SpAdClassifyT implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 广告位终端
     */
    @TableField("type")
    private String type;
    /**
     * 广告位名称
     */
    @TableField("name")
    private String name;
    /**
     * 广告位编码
     */
    @TableField("code")
    private String code;
    /**
     * 广告位描述
     */
    @TableField("describe")
    private String describe;
    /**
     * 创建人
     */
    @TableField("founder")
    private String founder;
    /**
     * 创建时间
     */
    @TableField("creat_time")
    private Date creatTime;
    /**
     * 是否删除（0：未删除 1 删除）
     */
    @TableField("adc_delete")
    private Integer adcDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getAdcDelete() {
        return adcDelete;
    }

    public void setAdcDelete(Integer adcDelete) {
        this.adcDelete = adcDelete;
    }

    @Override
    public String toString() {
        return "SpAdClassifyT{" +
        ", id=" + id +
        ", type=" + type +
        ", name=" + name +
        ", code=" + code +
        ", describe=" + describe +
        ", founder=" + founder +
        ", creatTime=" + creatTime +
        ", adcDelete=" + adcDelete +
        "}";
    }
}
