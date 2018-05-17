package com.huanxian.api.vo;

import com.baomidou.mybatisplus.annotations.TableField;

public class ProdInfoVo {

	private Long prodId;
	/**
	 * 产品名称
	 */
	private String prodName;
	/**
	 * 产品子项目id
	 */
	private Long classifyId;
	/**
	 * 产品子项目名称
	 */
	private String classifyName;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 封面
	 */
	private String pic;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 内容
	 */
	private String content;
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
	public Long getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(Long classifyId) {
		this.classifyId = classifyId;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
