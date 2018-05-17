package com.huanxian.dao;

import com.huanxian.entity.SpAdT;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 广告表 Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
public interface SpAdTMapper extends BaseMapper<SpAdT> {
	/*
	 * 批量启用/禁用
	 */
	void enbAdtByIds(Map<String,Object> map);
	
	/*
	 * 批量删除
	 */
	void delAdtByIds (@Param("ids")List<Long> ids);
}
