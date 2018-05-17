package com.huanxian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-21
 */
@TableName("sp_account_t")
public class SpAccountT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 昵称
     */
    @TableField("nick")
    private String nick;
    /**
     * 性别（1：男、2：女）
     */
    @TableField("sex")
    private Integer sex;
    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;
    /**
     * 讲师简介(会员为空）
     */
    @TableField("intro")
    private String intro;
    /**
     * 我的产品id
     */
    @TableField("prod_id")
    private Long prodId;
    /**
     * 我的产品名称
     */
    @TableField("prod_name")
    private String prodName;
    /**
     * 推送状态：（0：完全关闭、1：开启、2：21点-8点）
     */
    @TableField("push_status")
    private Integer pushStatus;
    /**
     * 是否是会员(0：不是、1：是)
     */
    @TableField("member")
    private Integer member;
    /**
     * 是否是讲师(0：不是、1：是)
     */
    @TableField("teacher")
    private Integer teacher;
    /**
     * 最后登录设备
     */
    @TableField("last_device")
    private String lastDevice;
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
    
    @TableField("create_user")
    private String createUser;
    
	@TableField("create_time")
    private Date createTime;
    
    @TableField("jpush_registration_id")
    private String jpushRegistrationId;
    
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public String getLastDevice() {
        return lastDevice;
    }

    public void setLastDevice(String lastDevice) {
        this.lastDevice = lastDevice;
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

	public String getJpushRegistrationId() {
		return jpushRegistrationId;
	}

	public void setJpushRegistrationId(String jpushRegistrationId) {
		this.jpushRegistrationId = jpushRegistrationId;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "SpAccountT [id=" + id + ", phone=" + phone + ", password=" + password + ", nick=" + nick + ", sex="
				+ sex + ", avatar=" + avatar + ", intro=" + intro + ", prodId=" + prodId + ", prodName=" + prodName
				+ ", pushStatus=" + pushStatus + ", member=" + member + ", teacher=" + teacher + ", lastDevice="
				+ lastDevice + ", status=" + status + ", modifyUser=" + modifyUser + ", modifyTime=" + modifyTime
				+ ", createUser=" + createUser + ", createTime=" + createTime + ", jpushRegistrationId="
				+ jpushRegistrationId + "]";
	}
}
