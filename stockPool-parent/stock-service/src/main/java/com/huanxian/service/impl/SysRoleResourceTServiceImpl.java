package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huanxian.dao.SysRoleResourceTMapper;
import com.huanxian.entity.SysRoleResourceT;
import com.huanxian.service.SysRoleResourceTService;

@Service
public class SysRoleResourceTServiceImpl implements SysRoleResourceTService {

	@Autowired
	private SysRoleResourceTMapper sysRoleResourceTMapper;
	
	@Override
	public List<SysRoleResourceT> getRoleResourceByRoleId(Long roleId) {
		return sysRoleResourceTMapper.getRoleResourceByRoleId(roleId);
	}

	@Override
	public Integer deleteByRoleId(Long roleId) {
		return sysRoleResourceTMapper.deleteByRoleId(roleId);
	}

	@Override
	public Integer addRoleResource(SysRoleResourceT resourceT) {
		return sysRoleResourceTMapper.insert(resourceT);
	}

}
