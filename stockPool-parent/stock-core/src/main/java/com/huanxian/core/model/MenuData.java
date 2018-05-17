package com.huanxian.core.model;

public class MenuData {

	private Long id;

	private String name;

	private Long pId;

	private boolean isResource;

	private boolean checked;

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

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public boolean getIsResource() {
		return isResource;
	}

	public void setIsResource(boolean isResource) {
		this.isResource = isResource;
	}

	public MenuData(Long id, String name, Long pId, boolean isResource) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
		this.isResource = isResource;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public MenuData(Long id, String name, Long pId, boolean isResource, boolean checked) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
		this.isResource = isResource;
		this.checked = checked;
	}
}
