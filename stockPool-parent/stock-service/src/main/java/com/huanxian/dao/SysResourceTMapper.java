package com.huanxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huanxian.entity.SysResourceT;

/**
 * <p>
 * 系统菜单资源表 Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-20
 */
public interface SysResourceTMapper extends BaseMapper<SysResourceT> {

	List<SysResourceT> listResourceByUserId(@Param("userId") Long userId);

	List<SysResourceT> listRoleResourceByUserId(@Param("roleId") Long roleId);

	/**
	 * 获取所有父节点
	 * 
	 * @return
	 */
	List<Long> getGroupByParentId();

	/**
	 * 根据登录用户id获取用户菜单资源
	 * 
	 * @return
	 */
	List<SysResourceT> getResourcesMenuByLoginId(@Param("userId") Long userId, @Param("parentId") Long parentId);
	
	/**
	 * 获取所有资源列表
	 * @return
	 */
	List<SysResourceT> getResourceList();
	
}
