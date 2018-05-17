package com.huanxian.dao;

import com.huanxian.entity.SysRoleResourceT;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-20
 */
public interface SysRoleResourceTMapper extends BaseMapper<SysRoleResourceT> {

	List<SysRoleResourceT> getRoleResourceByRoleId(@Param("roleId") Long roleId);
	
	Integer deleteByRoleId(@Param("roleId") Long roleId);
}
