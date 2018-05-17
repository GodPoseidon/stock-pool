package com.huanxian.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SysBasePropertyT;

/**
 * <p>
 * 系统管理-系统参数配置表 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-21
 */
public interface SysBasePropertyTService{
	
	List<SysBasePropertyT> getAll();
	

	/**
	 * 新增BaseProperty
	 * 
	 * @param basePropertyT
	 * @return
	 */
	Integer insertBaseProperty(SysBasePropertyT basePropertyT);

	/**
	 * 修改BaseProperty
	 * 
	 * @param basePropertyT
	 * @return
	 */
	Integer updateBaseProperty(SysBasePropertyT basePropertyT);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteBaseProperty(Long id);

	/***
	 * 根据参数查询配置信息表中所对应的值
	 * 
	 * @param group
	 *            组名，比如：IM，支付宝，微信等
	 * @param key
	 *            键，属性键
	 * @return
	 */
	public String getValue(String group, String key);

	/**
	 * 根据参数组枚举，查询参数表中参数列表
	 * 
	 * @param group
	 * @return
	 */
	List<SysBasePropertyT> getBasePropertyVoByGroup(String group);

	/**根据参数组枚举，查询参数表中参数列表
     * @param group
     * @return
     */
    public Map<String, String> getGroupMap(String group);
	
	/**
	 * 保存全部参数
	 * 
	 * @param paramMap
	 * @param modifyUser
	 * @return
	 */
	Integer updateValueAll(SysBasePropertyT propertyT);
	
	PageVo<SysBasePropertyT> getPage(EntityWrapper<SysBasePropertyT> wrapper,Integer pageSize,Integer pageNum);

	SysBasePropertyT get(Long id);
}
