package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpPreviewLiveTMapper;
import com.huanxian.entity.SpPreviewLiveT;
import com.huanxian.service.SpPreviewLiveTService;

/**
 * <p>
 * 预约直播表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-25
 */
@Service
public class SpPreviewLiveTServiceImpl implements SpPreviewLiveTService {

	@Autowired
	private SpPreviewLiveTMapper spPreviewLiveTMapper;

	@Override
	public Integer insert(SpPreviewLiveT liveT) {
		return spPreviewLiveTMapper.insert(liveT);
	}

	@Override
	public Integer delete(Long id) {
		SpPreviewLiveT entity = new SpPreviewLiveT();
		entity.setId(id);
		entity.setStatus(3);
		return spPreviewLiveTMapper.updateById(entity);
	}

	@Override
	public Integer update(SpPreviewLiveT liveT) {
		return spPreviewLiveTMapper.updateById(liveT);
	}

	@Override
	public SpPreviewLiveT get(Long id) {
		return spPreviewLiveTMapper.selectById(id);
	}

	@Override
	public PageVo<SpPreviewLiveT> getPage(EntityWrapper<SpPreviewLiveT> wrapper, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SpPreviewLiveT> selectList = spPreviewLiveTMapper.selectList(wrapper);
		PageVo<SpPreviewLiveT> vo = new PageVo<SpPreviewLiveT>();
		Integer total = Integer.valueOf(PageHelper.freeTotal() + "");
		vo.setPageNumber(pageNum);
		vo.setData(selectList);
		vo.setPageSize(pageSize);
		vo.setRecordsTotal(total);
		return vo;
	}

	@Override
	public Integer batchDel(Long[] id) {
		return spPreviewLiveTMapper.batchDel(id);
	}

	@Override
	public Integer delByRoomId(Long roomId) {
		return spPreviewLiveTMapper.delByRoomId(roomId);
	}

	@Override
	public Integer batchDelByRoomId(Long[] roomId) {
		return spPreviewLiveTMapper.batchDelByRoomId(roomId);
	}

}
