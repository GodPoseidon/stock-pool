package com.huanxian.api.vo;

public class InformationVo {

    private Long classId;
    /**
     * 所属分类名称
     */
    private String className;
    /**
     * 资讯标题
     */

    private String title;
    /**
     * 简介
     */
    private String outline;
    /**
     * 资讯正文
     */
    private String content;
    /**
     * 资讯封面
     */
    private String cover;
    
    private String url;
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOutline() {
		return outline;
	}
	public void setOutline(String outline) {
		this.outline = outline;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	
}
