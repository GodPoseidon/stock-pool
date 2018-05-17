package com.huanxian.service;

import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpAccountT;
import com.huanxian.entity.SpAdClassifyT;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 广告位表 服务类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
public interface SpAdClassifyTService extends IService<SpAdClassifyT> {
	/*
	 * 广告位列表
	 */
	PageVo<SpAdClassifyT> getPage(Integer pageSize, Integer pageNumber,EntityWrapper<SpAdClassifyT> wrapper);
	
	/*
	 * 根据id查广告位
	 */
	SpAdClassifyT queryAdClassify( Long id);
	
	/*
	 * 修改广告位
	 */
	void updateSpAdCById(SpAdClassifyT spAdClassifyT);
	
	/*
	 * 添加广告位
	 */
	void addAdClassify(SpAdClassifyT spAdClassifyT);
	
	/*
	 * 批量删除
	 */
	void deleteByIds(List<Long> list);

	List<SpAdClassifyT> getList(EntityWrapper<SpAdClassifyT> wrapper);

}
