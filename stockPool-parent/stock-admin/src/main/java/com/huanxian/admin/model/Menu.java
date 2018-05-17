package com.huanxian.admin.model;

import java.util.List;

public class Menu {

	private String id;
	private String name;
	private String url;
	private String icon;
	private Integer num;
	
	private List<Menu> sons;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu> getSons() {
		return sons;
	}

	public void setSons(List<Menu> sons) {
		this.sons = sons;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", url=" + url + ", icon=" + icon + ", num=" + num + ", sons="
				+ sons + "]";
	}
	
}
