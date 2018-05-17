package com.huanxian.service;

import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpAdT;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 广告表 服务类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
public interface SpAdTService {
	
	/*
	 * 广告列表
	 */
	PageVo<SpAdT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpAdT> wrapper);
	
	Integer insert(SpAdT spAdT);
	
	Integer updateById(SpAdT spAdT);
	
	SpAdT get(Long id);
	/*
	 * 批量启用/禁用
	 */
	void enbAdtByIds(Map<String,Object> map);
	
	/*
	 * 批量删除
	 */
	void delAdtByIds (List<Long> ids);


}
