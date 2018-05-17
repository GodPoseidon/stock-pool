package com.huanxian.api.vo;

import java.util.Date;

public class ThirdPartyAccountVo {

	    /**
	     * 第三方用户id
	     */
	    private Integer accountId;
	    /**
	     * 账号
	     */
	    private String account;
	    /**
	     * 密码
	     */
	    private String password;
	    /**
	     * 积分
	     */
	    private Integer integral;
	    /**
	     * 状态0,删除1正常，2冻结，3黑名单,4照片审核不通过
	     */
	    private Integer states;
	    /**
	     * 客户类型
	     */
	    private Integer types;
	    /**
	     * 客户等级
	     */
	    private Integer leave;
	    /**
	     * 备注
	     */
	    private String rember;

	    private String addPerson;
	    /**
	     * 真名
	     */
	    private String trueName;
	    /**
	     * 昵称
	     */
	    private String niceName;
	    /**
	     * 手机号码--当前字段已改为客户编号
	     */
	    private String mobile;
	    
	    private String idNumber;
	    /**
	     * 微信OpenId
	     */
	    private String openId;
	    /**
	     * 性别
	     */
	    private Integer sex;
	    /**
	     * 年龄
	     */
	    private Integer age;
	    /**
	     * 受益人
	     */
	    private String remit;

	    private String province;

	    private String city;
	    /**
	     * 区
	     */
	    private String area;
	    /**
	     * 详细地址
	     */
	    private String address;
	    /**
	     * 工资
	     */
	    private String inComeRange;
	    /**
	     * 职业
	     */
	    private String career;
	    /**
	     * 身份证正面
	     */
	    private String idImage1;
	    /**
	     * 身份证反面
	     */
	    private String idImage2;
	    /**
	     * 用户验证码
	     */
	    private String code;
	    /**
	     * 简化编号
	     */
	    private String simpleNo;

	    private Date createTime;


	    public Integer getAccountId() {
	        return accountId;
	    }

	    public void setAccountId(Integer accountId) {
	        this.accountId = accountId;
	    }

	    public String getAccount() {
	        return account;
	    }

	    public void setAccount(String account) {
	        this.account = account;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Integer getIntegral() {
	        return integral;
	    }

	    public void setIntegral(Integer integral) {
	        this.integral = integral;
	    }

	    public Integer getStates() {
	        return states;
	    }

	    public void setStates(Integer states) {
	        this.states = states;
	    }

	    public Integer getTypes() {
	        return types;
	    }

	    public void setTypes(Integer types) {
	        this.types = types;
	    }

	    public Integer getLeave() {
	        return leave;
	    }

	    public void setLeave(Integer leave) {
	        this.leave = leave;
	    }

	    public String getRember() {
	        return rember;
	    }

	    public void setRember(String rember) {
	        this.rember = rember;
	    }

	    public String getAddPerson() {
	        return addPerson;
	    }

	    public void setAddPerson(String addPerson) {
	        this.addPerson = addPerson;
	    }

	    public String getTrueName() {
	        return trueName;
	    }

	    public void setTrueName(String trueName) {
	        this.trueName = trueName;
	    }

	    public String getNiceName() {
	        return niceName;
	    }

	    public void setNiceName(String niceName) {
	        this.niceName = niceName;
	    }

	    public String getMobile() {
	        return mobile;
	    }

	    public void setMobile(String mobile) {
	        this.mobile = mobile;
	    }

	    public String getIdNumber() {
	        return idNumber;
	    }

	    public void setIdNumber(String idNumber) {
	        this.idNumber = idNumber;
	    }

	    public String getOpenId() {
	        return openId;
	    }

	    public void setOpenId(String openId) {
	        this.openId = openId;
	    }

	    public Integer getSex() {
	        return sex;
	    }

	    public void setSex(Integer sex) {
	        this.sex = sex;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }

	    public String getRemit() {
	        return remit;
	    }

	    public void setRemit(String remit) {
	        this.remit = remit;
	    }

	    public String getProvince() {
	        return province;
	    }

	    public void setProvince(String province) {
	        this.province = province;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getArea() {
	        return area;
	    }

	    public void setArea(String area) {
	        this.area = area;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getInComeRange() {
	        return inComeRange;
	    }

	    public void setInComeRange(String inComeRange) {
	        this.inComeRange = inComeRange;
	    }

	    public String getCareer() {
	        return career;
	    }

	    public void setCareer(String career) {
	        this.career = career;
	    }

	    public String getIdImage1() {
	        return idImage1;
	    }

	    public void setIdImage1(String idImage1) {
	        this.idImage1 = idImage1;
	    }

	    public String getIdImage2() {
	        return idImage2;
	    }

	    public void setIdImage2(String idImage2) {
	        this.idImage2 = idImage2;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getSimpleNo() {
	        return simpleNo;
	    }

	    public void setSimpleNo(String simpleNo) {
	        this.simpleNo = simpleNo;
	    }

	    public Date getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Date createTime) {
	        this.createTime = createTime;
	    }
}
