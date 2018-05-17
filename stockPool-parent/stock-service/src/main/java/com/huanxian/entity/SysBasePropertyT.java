package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 系统管理-系统参数配置表
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-21
 */
@TableName("sys_base_property_t")
public class SysBasePropertyT implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 参数分组：SYSTEM,系统参数;QCLOUDAV,腾讯视频互动直播;SMS,短信;IM,IM消息;JPUSH,极光推送;COS,腾讯云对象存储服务
     */
    @TableField("prop_group")
    private String propGroup;
    /**
     * 参数集合(name:value,name:value)
     */
    @TableField("value_set")
    private String valueSet;
    /**
     * 参数类型 ：text,文本框;checkbox,复选框;select,下拉列表;radio,单选;switch,开关;
     */
    @TableField("prop_type")
    private String propType;
    /**
     * 参数名
     */
    @TableField("prop_name")
    private String propName;
    /**
     * 参数编码
     */
    @TableField("prop_code")
    private String propCode;
    /**
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;
    /**
     * 参数值
     */
    @TableField("prop_value")
    private String propValue;
    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
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

    public String getPropGroup() {
        return propGroup;
    }

    public void setPropGroup(String propGroup) {
        this.propGroup = propGroup;
    }

    public String getValueSet() {
        return valueSet;
    }

    public void setValueSet(String valueSet) {
        this.valueSet = valueSet;
    }

    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropCode() {
        return propCode;
    }

    public void setPropCode(String propCode) {
        this.propCode = propCode;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        return "SysBasePropertyT{" +
        ", id=" + id +
        ", propGroup=" + propGroup +
        ", valueSet=" + valueSet +
        ", propType=" + propType +
        ", propName=" + propName +
        ", propCode=" + propCode +
        ", orderNum=" + orderNum +
        ", propValue=" + propValue +
        ", createUser=" + createUser +
        ", createTime=" + createTime +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
