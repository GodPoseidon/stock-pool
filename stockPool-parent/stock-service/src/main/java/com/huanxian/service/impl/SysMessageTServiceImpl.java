package com.huanxian.service.impl;

import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SysMessageTMapper;
import com.huanxian.entity.SysMessageT;
import com.huanxian.service.SysMessageTService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户消息表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-05
 */
@Service
public class SysMessageTServiceImpl implements SysMessageTService {

	@Autowired
	private SysMessageTMapper sysMessageTMapper;
	
	@Override
	public PageVo<SysMessageT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SysMessageT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		List<SysMessageT> spInfoClassifyTList = sysMessageTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SysMessageT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spInfoClassifyTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public Integer insert(SysMessageT sysMessageT) {
		// TODO Auto-generated method stub
		return sysMessageTMapper.insert(sysMessageT);
	}

	@Override
	public Integer updateById(SysMessageT sysMessageT) {
		// TODO Auto-generated method stub
		return sysMessageTMapper.updateById(sysMessageT);
	}

	@Override
	public SysMessageT get(Long id) {
		// TODO Auto-generated method stub
		return sysMessageTMapper.selectById(id);
	}

	@Override
	public void delInfoClassifyByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}



}
