package com.huanxian.service;

import java.util.List;

import com.huanxian.entity.SysUserRoleT;

public interface SysUserRoleTService {

	List<SysUserRoleT> getAll();
	
	List<SysUserRoleT> getUserRoleVoByRoleId(Long roleId);
	
	Integer deleteByRoleId(Long roleId);
	
	Integer add(SysUserRoleT roleT);
}
