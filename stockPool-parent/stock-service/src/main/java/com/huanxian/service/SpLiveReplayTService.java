package com.huanxian.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpLiveReplayT;

/**
 * <p>
 * 直播间回放表 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
public interface SpLiveReplayTService {

	Integer insert(SpLiveReplayT replayT);

	Integer delete(Long id);
	
	Integer batchDel(Long[] ids);

	Integer update(SpLiveReplayT liveReplayT);

	SpLiveReplayT get(Long id);

	PageVo<SpLiveReplayT> getPage(EntityWrapper<SpLiveReplayT> wrapper, Integer pageSize, Integer pageNum);
	
	List<SpLiveReplayT> getList(Integer pageSize,Integer pageNum);
}
