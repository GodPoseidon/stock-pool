package com.huanxian.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpLiveRoomT;

/**
 * <p>
 * 直播间表 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
public interface SpLiveRoomTService {

	Integer insert(SpLiveRoomT liveRoomT);

	Integer delete(Long id);
	
	Integer batchDel(Long[] ids);

	Integer update(SpLiveRoomT liveRoomT);

	SpLiveRoomT get(Long id);

	PageVo<SpLiveRoomT> getPage(EntityWrapper<SpLiveRoomT> wrapper, Integer pageSize, Integer pageNum);
	/**
	 * 获取平台直播间列表
	 * @return
	 */
	List<SpLiveRoomT> listPlatformLiveRoom();
	
	String getPushUrl(Long id);
	
	boolean forbidStream(Long id);
	
	/**
	 * 只获取直播间id、标题
	 * @return
	 */
	List<Map<Long, String>> getLiveInfoList();
}
