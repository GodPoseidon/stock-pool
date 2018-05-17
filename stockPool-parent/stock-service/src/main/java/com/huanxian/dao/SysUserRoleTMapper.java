package com.huanxian.dao;

import com.huanxian.entity.SysUserRoleT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 系统-系统管理-用户角色关联表 Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-20
 */
public interface SysUserRoleTMapper extends BaseMapper<SysUserRoleT> {

	Integer deleteByRoleId(Long roleId);
}
