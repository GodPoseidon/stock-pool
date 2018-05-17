package com.huanxian.service;

import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpInfoClassifyT;
import com.huanxian.entity.SpInfoT;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 资讯表 服务类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
public interface SpInfoTService {
	
	PageVo<SpInfoT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpInfoT> wrapper);
	
	Integer insert(SpInfoT spInfoT);
	
	Integer updateById(SpInfoT spInfoT);
	
	SpInfoT get(Long id);
	
	/*
	 * 批量删除资讯
	 */
	void delInfoByIds(List<Long> ids);
	/**
	 * 通过类型获取基础（不包含内容和相关状态）内容
	 * @param pageSize
	 * @param pageNumber
	 * @param type
	 * @return
	 */
	List<Map<String, Object>> listBaseByType(Integer pageNumber, Integer pageSize, Long type);
	
}
