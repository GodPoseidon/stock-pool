package com.huanxian.service;

import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpInfoClassifyT;
import com.huanxian.entity.SysMessageT;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 用户消息表 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-05
 */
public interface SysMessageTService {

PageVo<SysMessageT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SysMessageT> wrapper);
	
	Integer insert(SysMessageT sysMessageT);
	
	Integer updateById(SysMessageT sysMessageT);
	
	SysMessageT get(Long id);
	
	/*
	 * 批量删除资讯分类
	 */
	void delInfoClassifyByIds (List<Long> ids);
	
}
