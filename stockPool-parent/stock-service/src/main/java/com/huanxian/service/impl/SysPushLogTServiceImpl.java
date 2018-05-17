package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SysPushLogTMapper;
import com.huanxian.entity.SysPushLogT;
import com.huanxian.service.SysPushLogTService;

/**
 * <p>
 * 推送日志表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
@Service
public class SysPushLogTServiceImpl implements SysPushLogTService {

	@Autowired
	private SysPushLogTMapper sysPushLogTMapper;

	@Override
	public PageVo<SysPushLogT> getPage(EntityWrapper<SysPushLogT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysPushLogT> pushLog = sysPushLogTMapper.selectList(wrapper);
		PageVo<SysPushLogT> pageVo = new PageVo<SysPushLogT>();
		pageVo.setPageNumber(pageNum);
		pageVo.setData(pushLog);
		pageVo.setPageSize(pageSize);
		Integer total = Integer.parseInt(PageHelper.freeTotal() + "");
		pageVo.setRecordsTotal(total);
		return pageVo;
	}

	@Override
	public Integer insert(SysPushLogT logT) {
		return sysPushLogTMapper.insert(logT);
	}

	@Override
	public SysPushLogT get(Long id) {
		return sysPushLogTMapper.selectById(id);
	}

	@Override
	public Integer update(SysPushLogT logT) {
		return sysPushLogTMapper.updateById(logT);
	}

}
