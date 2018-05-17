package com.huanxian.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SysRoleT;

/**
 * <p>
 * 系统-系统管理-角色 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-05
 */
public interface SysRoleTService{

	Integer add(SysRoleT roleT);
	
	Integer update(SysRoleT roleT);
	
	SysRoleT get(Long id);
	
	PageVo<SysRoleT> getPage(EntityWrapper<SysRoleT> wrapper,Integer pageSize,Integer pageNum);
}
