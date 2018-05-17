package com.huanxian.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.dao.SysResourceTMapper;
import com.huanxian.dao.SysUserRoleTMapper;
import com.huanxian.entity.SysResourceT;
import com.huanxian.entity.SysUserRoleT;
import com.huanxian.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	private SysUserRoleTMapper sysUserRoleTMapper;

	@Autowired
	private SysResourceTMapper sysResourceTMapper;
	

	public Set<String> getAllPermissionByUserId(Long id) {
		SysUserRoleT p = new SysUserRoleT();
		p.setUserId(id);
		EntityWrapper<SysUserRoleT> wrapper = new EntityWrapper<>(p);
		List<SysUserRoleT> roles = sysUserRoleTMapper.selectList(wrapper);
		Set<String> url = new HashSet<String>();
		for (SysUserRoleT r : roles) {
			List<SysResourceT> rr = sysResourceTMapper.listRoleResourceByUserId(r.getRoleId());
			for (SysResourceT sr : rr) {
				url.add(sr.getUrl());
			}
		}
		List<SysResourceT> ur = sysResourceTMapper.listResourceByUserId(id);
		for (SysResourceT u : ur) {
			url.add(u.getUrl());
		}
		return url;
	}
}
