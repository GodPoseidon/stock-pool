package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SysRoleTMapper;
import com.huanxian.entity.SysRoleT;
import com.huanxian.service.SysRoleTService;

/**
 * <p>
 * 系统-系统管理-角色 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-05
 */
@Service
public class SysRoleTServiceImpl implements SysRoleTService {

	@Autowired
	private SysRoleTMapper sysRoleTMapper;
	
	@Override
	public Integer add(SysRoleT roleT) {
		return sysRoleTMapper.insert(roleT);
	}

	@Override
	public Integer update(SysRoleT roleT) {
		return sysRoleTMapper.updateById(roleT);
	}

	@Override
	public SysRoleT get(Long id) {
		return sysRoleTMapper.selectById(id);
	}

	@Override
	public PageVo<SysRoleT> getPage(EntityWrapper<SysRoleT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysRoleT> selectList = sysRoleTMapper.selectList(wrapper);
		PageVo<SysRoleT> vo = new PageVo<>();
		vo.setData(selectList);
		vo.setPageNumber(pageNum);
		vo.setPageSize(pageSize);
		vo.setRecordsTotal(Integer.valueOf(PageHelper.freeTotal()+""));
		return vo;
	}

}
