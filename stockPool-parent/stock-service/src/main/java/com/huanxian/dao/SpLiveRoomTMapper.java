package com.huanxian.dao;

import com.huanxian.entity.SpLiveRoomT;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 直播间表 Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
public interface SpLiveRoomTMapper extends BaseMapper<SpLiveRoomT> {

	Integer batchDel(@Param("ids") Long[] ids);
	
	 List<Map<Long, String>> getLiveInfoList();
}
