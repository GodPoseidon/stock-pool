package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SysUserTMapper;
import com.huanxian.entity.SysUserT;
import com.huanxian.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
	
	@Autowired
	private SysUserTMapper sysUserTMapper;
	
	public SysUserT getByUserName(String username) {
		SysUserT p = new SysUserT();
		p.setAccount(username);
		return sysUserTMapper.selectOne(p);
	}

	@Override
	public List<SysUserT> getUserList() {
		EntityWrapper<SysUserT> wrapper = new EntityWrapper<>();
		wrapper.eq("status", 1);
		return sysUserTMapper.selectList(wrapper);
	}

	@Override
	public PageVo<SysUserT> getPage(EntityWrapper<SysUserT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysUserT> selectList = sysUserTMapper.selectList(wrapper);
		PageVo<SysUserT> vo = new PageVo<>();
		vo.setData(selectList);
		vo.setPageNumber(pageNum);
		vo.setPageSize(pageSize);
		vo.setRecordsTotal(Integer.valueOf(PageHelper.freeTotal()+""));
		return vo;
	}

	@Override
	public SysUserT get(Long id) {
		return sysUserTMapper.selectById(id);
	}

	@Override
	public Integer add(SysUserT userT) {
		return sysUserTMapper.insert(userT);
	}

	@Override
	public Integer update(SysUserT userT) {
		return sysUserTMapper.updateById(userT);
	}
}
