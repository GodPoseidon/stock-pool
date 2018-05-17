package com.huanxian.dao;

import com.huanxian.entity.SpLiveReplayT;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 直播间回放表 Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
public interface SpLiveReplayTMapper extends BaseMapper<SpLiveReplayT> {

	List<SpLiveReplayT> getList(@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
	Integer batchDel(@Param("ids") Long[] ids);
}
