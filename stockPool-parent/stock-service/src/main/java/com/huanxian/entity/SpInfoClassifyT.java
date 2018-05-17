package com.huanxian.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 资讯分类表
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@TableName("sp_info_classify_t")
public class SpInfoClassifyT implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 分类名称
     */
    @TableField("name")
    private String name;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @TableField("founder")
    private String founder;
    /**
     * 是否启用（0：启用 1：禁用）
     */
    @TableField("infc_enable")
    private Integer infcEnable;
    /**
     * 是否删除（0：未删除 1 删除）
     */
    @TableField("infc_delete")
    private Integer infcDelete;


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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Integer getInfcEnable() {
        return infcEnable;
    }

    public void setInfcEnable(Integer infcEnable) {
        this.infcEnable = infcEnable;
    }

    public Integer getInfcDelete() {
        return infcDelete;
    }

    public void setInfcDelete(Integer infcDelete) {
        this.infcDelete = infcDelete;
    }

    @Override
    public String toString() {
        return "SpInfoClassifyT{" +
        ", id=" + id +
        ", name=" + name +
        ", createTime=" + createTime +
        ", founder=" + founder +
        ", infcEnable=" + infcEnable +
        ", infcDelete=" + infcDelete +
        "}";
    }
}

