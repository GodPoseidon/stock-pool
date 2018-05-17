package com.huanxian.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SysUserT;

public interface SysUserService {

	public SysUserT getByUserName(String username);
	
	List<SysUserT> getUserList();
	
	PageVo<SysUserT> getPage(EntityWrapper<SysUserT> wrapper,Integer pageSize,Integer pageNum);
	
	SysUserT get(Long id);
	
	Integer add(SysUserT userT);
	
	Integer update(SysUserT userT);
}
