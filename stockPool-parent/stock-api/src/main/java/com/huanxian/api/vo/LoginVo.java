package com.huanxian.api.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class LoginVo {
	
	@NotBlank(message = "手机号为空！！")
	@Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$", message = "手机号格式错误！！")
	private String phone;
	
	@NotBlank(message = "密码为空！！")
	@Length(min = 6, max = 20, message = "密码长度必须为{min}~{max}位！") 
	private String password;

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
	
	
}
