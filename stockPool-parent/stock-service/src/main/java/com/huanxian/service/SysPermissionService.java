package com.huanxian.service;

import java.util.Set;

public interface SysPermissionService {

	/**
	 * 获取用户所有权限路径
	 * @param id
	 * @return
	 */
	Set<String> getAllPermissionByUserId(Long id);
}
