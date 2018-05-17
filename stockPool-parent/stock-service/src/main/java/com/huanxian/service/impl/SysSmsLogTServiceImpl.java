package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SysSmsLogTMapper;
import com.huanxian.entity.SysSmsLogT;
import com.huanxian.service.SysSmsLogTService;

/**
 * <p>
 * 短信日志表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-07
 */
@Service
public class SysSmsLogTServiceImpl implements SysSmsLogTService {

	@Autowired
	private SysSmsLogTMapper sysSmsLogTMapper;
	
	@Override
	public PageVo<SysSmsLogT> getPage(EntityWrapper<SysSmsLogT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysSmsLogT> selectList = sysSmsLogTMapper.selectList(wrapper);
		PageVo<SysSmsLogT> vo = new PageVo<>();
		vo.setData(selectList);
		vo.setPageNumber(pageNum);
		vo.setPageSize(pageSize);
		vo.setRecordsTotal(Integer.valueOf(PageHelper.freeTotal()+""));
		return vo;
	}

}
