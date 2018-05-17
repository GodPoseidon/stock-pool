package com.huanxian.dao;

import com.huanxian.entity.SpPreviewLiveT;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 预约直播表 Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-25
 */
public interface SpPreviewLiveTMapper extends BaseMapper<SpPreviewLiveT> {

	Integer batchDel(@Param("ids") Long[] id);
	
	Integer delByRoomId(@Param("roomId") Long roomId);
	
	Integer batchDelByRoomId(@Param("roomIds") Long[] roomId);
}
