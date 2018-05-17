package com.huanxian.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpPreviewLiveT;

/**
 * <p>
 * 预约直播表 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-25
 */
public interface SpPreviewLiveTService {

	Integer insert(SpPreviewLiveT liveT);

	Integer delete(Long id);
	
	Integer batchDel(Long[] id);

	Integer update(SpPreviewLiveT liveT);

	SpPreviewLiveT get(Long id);

	PageVo<SpPreviewLiveT> getPage(EntityWrapper<SpPreviewLiveT> wrapper, Integer pageNum, Integer pageSize);
	
	Integer delByRoomId(Long roomId);
	
	Integer batchDelByRoomId(Long[] roomId);
}
