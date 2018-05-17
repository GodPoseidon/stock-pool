package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.dao.SysUserRoleTMapper;
import com.huanxian.entity.SysUserRoleT;
import com.huanxian.service.SysUserRoleTService;

@Service
public class SysUserRoleTServiceImpl implements SysUserRoleTService {

	@Autowired
	SysUserRoleTMapper SysUserRoleTMapper;
	
	@Override
	public List<SysUserRoleT> getAll() {
		EntityWrapper<SysUserRoleT> wrapper = new EntityWrapper<>();
		wrapper.eq("status", 1);
		return SysUserRoleTMapper.selectList(wrapper);
	}

	@Override
	public List<SysUserRoleT> getUserRoleVoByRoleId(Long roleId) {
		EntityWrapper<SysUserRoleT> wrapper = new EntityWrapper<>();
		wrapper.eq("status", 1);
		wrapper.eq("role_id", roleId);
		return SysUserRoleTMapper.selectList(wrapper);
	}

	@Override
	public Integer deleteByRoleId(Long roleId) {
		return SysUserRoleTMapper.deleteByRoleId(roleId);
	}

	@Override
	public Integer add(SysUserRoleT roleT) {
		return SysUserRoleTMapper.insert(roleT);
	}

}
