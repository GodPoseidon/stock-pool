package com.huanxian.service;

import java.util.List;

import com.huanxian.entity.SysRoleResourceT;

/**
 * 角色-资源
 * @author zhuzhen
 *
 */
public interface SysRoleResourceTService {

	List<SysRoleResourceT> getRoleResourceByRoleId(Long roleId);
	
	Integer deleteByRoleId(Long roleId);
	
	Integer addRoleResource(SysRoleResourceT resourceT);
}
