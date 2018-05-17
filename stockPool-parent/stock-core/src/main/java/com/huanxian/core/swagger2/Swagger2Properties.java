package com.huanxian.core.swagger2;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = Swagger2Properties.SWAGGER2_PREFIX)
public class Swagger2Properties implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static final String SWAGGER2_PREFIX = "swagger2";
	
	/**
	 * 是否开启swagger2,默认为false
	 */
	private Boolean enabled = false;
	
	/**
	 * 标题
	 */
	private String title = "Swagger2";
	
	/**
	 * 介绍
	 */
	private String desc = "Swagger2接口测试页面";
	
	/**
	 * 版本
	 */
	private String version = "1.0";
	
	/**
	 * 扫描的包,可配置多个
	 */
	private List<String> scanBasePackage;
	
	/**
	 * 扫描的类上的注解,可配置多个
	 */
	private List<Class<? extends Annotation>> classAnnotation;
	
	/**
	 * 扫描方法上的注解,可配置多个
	 */
	private List<Class<? extends Annotation>> methodAnnotation;
	
	/**
	 * 组名称
	 */
	private String groupName = "default";
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<String> getScanBasePackage() {
		return scanBasePackage;
	}

	public void setScanBasePackage(List<String> scanBasePackage) {
		this.scanBasePackage = scanBasePackage;
	}

	public List<Class<? extends Annotation>> getClassAnnotation() {
		return classAnnotation;
	}

	public void setClassAnnotation(List<Class<? extends Annotation>> classAnnotation) {
		this.classAnnotation = classAnnotation;
	}

	public List<Class<? extends Annotation>> getMethodAnnotation() {
		return methodAnnotation;
	}

	public void setMethodAnnotation(List<Class<? extends Annotation>> methodAnnotation) {
		this.methodAnnotation = methodAnnotation;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	

}
