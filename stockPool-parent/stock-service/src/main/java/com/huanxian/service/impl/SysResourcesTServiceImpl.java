package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SysResourceTMapper;
import com.huanxian.entity.SysResourceT;
import com.huanxian.service.SysResourcesTService;

@Service
public class SysResourcesTServiceImpl implements SysResourcesTService {

	@Autowired
	private SysResourceTMapper sysResourceTMapper;

	@Override
	public List<Long> getGroupByParentId() {
		return sysResourceTMapper.getGroupByParentId();
	}

	@Override
	public List<SysResourceT> getResourcesMenuByLoginId(Long userId, Long parentId) {
		return sysResourceTMapper.getResourcesMenuByLoginId(userId, parentId);
	}

	@Override
	public PageVo<SysResourceT> getPage(EntityWrapper<SysResourceT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysResourceT> selectList = sysResourceTMapper.selectList(wrapper);
		PageVo<SysResourceT> vo = new PageVo<>();
		Integer total = Integer.valueOf(PageHelper.freeTotal()+"");
		vo.setPageNumber(pageNum);
		vo.setData(selectList);
		vo.setPageSize(pageSize);
		vo.setRecordsTotal(total);
		return vo;
	}

	@Override
	public Integer add(SysResourceT resourceT) {
		return sysResourceTMapper.insert(resourceT);
	}

	@Override
	public Integer update(SysResourceT resourceT) {
		return sysResourceTMapper.updateById(resourceT);
	}

	@Override
	public SysResourceT get(Long id) {
		return sysResourceTMapper.selectById(id);
	}

	@Override
	public List<SysResourceT> getResourceList() {
		return sysResourceTMapper.getResourceList();
	}

	@Override
	public Integer delete(Long id) {
		return sysResourceTMapper.deleteById(id);
	}

}
