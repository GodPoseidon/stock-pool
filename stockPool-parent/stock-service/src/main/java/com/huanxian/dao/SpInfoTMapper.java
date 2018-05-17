package com.huanxian.dao;

import com.huanxian.entity.SpInfoT;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 资讯表 Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
public interface SpInfoTMapper extends BaseMapper<SpInfoT> {
	
	/*
	 * 批量删除资讯
	 */
	void delInfoByIds(@Param("ids") List<Long> ids);
}
