package com.huanxian.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SysResourceT;

public interface SysResourcesTService {
	
	/**
	 * 获取所有父节点
	 * @return
	 */
	List<Long> getGroupByParentId();
	
	List<SysResourceT> getResourcesMenuByLoginId(Long userId,Long parentId);
	
	PageVo<SysResourceT> getPage(EntityWrapper<SysResourceT> wrapper,Integer pageSize,Integer pageNum);
	
	Integer add(SysResourceT resourceT);
	
	Integer update(SysResourceT resourceT);
	
	SysResourceT get(Long id);
	
	List<SysResourceT> getResourceList();
	
	Integer delete(Long id);
	
}
