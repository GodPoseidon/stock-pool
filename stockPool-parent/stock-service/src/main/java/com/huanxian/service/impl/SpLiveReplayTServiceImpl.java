package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpLiveReplayTMapper;
import com.huanxian.entity.SpLiveReplayT;
import com.huanxian.service.SpLiveReplayTService;

/**
 * <p>
 * 直播间回放表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
@Service
public class SpLiveReplayTServiceImpl implements SpLiveReplayTService {

	@Autowired
	private SpLiveReplayTMapper spLiveReplayTMapper;

	@Override
	public Integer insert(SpLiveReplayT replayT) {
		return spLiveReplayTMapper.insert(replayT);
	}

	@Override
	public Integer delete(Long id) {
		SpLiveReplayT entity = new SpLiveReplayT();
		entity.setId(id);
		entity.setStatus(3);
		return spLiveReplayTMapper.updateById(entity);
	}

	@Override
	public Integer update(SpLiveReplayT liveReplayT) {
		return spLiveReplayTMapper.updateById(liveReplayT);
	}

	@Override
	public SpLiveReplayT get(Long id) {
		return spLiveReplayTMapper.selectById(id);
	}

	@Override
	public PageVo<SpLiveReplayT> getPage(EntityWrapper<SpLiveReplayT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SpLiveReplayT> selectList = spLiveReplayTMapper.selectList(wrapper);
		PageVo<SpLiveReplayT> vo = new PageVo<>();
		Integer total = Integer.valueOf(PageHelper.freeTotal() + "");
		vo.setRecordsTotal(total);
		vo.setPageNumber(pageNum);
		vo.setData(selectList);
		vo.setPageSize(pageSize);
		return vo;
	}

	@Override
	public List<SpLiveReplayT> getList(Integer pageSize, Integer pageNum) {
		return spLiveReplayTMapper.getList((pageSize * (pageNum - 1)), pageSize);
	}

	@Override
	public Integer batchDel(Long[] ids) {
		return spLiveReplayTMapper.batchDel(ids);
	}

}
