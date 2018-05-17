package com.huanxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huanxian.entity.SysBasePropertyT;

/**
 * <p>
 * 系统管理-系统参数配置表 Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-21
 */
public interface SysBasePropertyTMapper extends BaseMapper<SysBasePropertyT> {

	/**
	 * 根据组枚举、关键组key查询配置信息表中所对应的值
	 * 
	 * @param group
	 * @param key
	 * @return
	 */
	String getValue(@Param("group") String group, @Param("key") String key);

	/**
	 * 根据参数组枚举，查询参数表中参数列表
	 * 
	 * @param group
	 * @return
	 */
	List<SysBasePropertyT> getBasePropertyVoByGroup(@Param("group") String group);

	/**
	 * 获取所有配置参数列表
	 * @return
	 */
	List<SysBasePropertyT> getAll();

}
