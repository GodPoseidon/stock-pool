package com.huanxian.dao;

import com.huanxian.entity.SpAccountT;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-21
 */
public interface SpAccountTMapper extends BaseMapper<SpAccountT> {

	Integer batchDel(@Param("ids") Long[] id);
	
	Integer delete(Long id);
	
	/**
	 * 极光推送 查询开启推送服务的RegistrationId
	 * @param device 设备号
	 * @return
	 */
	List<String> getRegistrationIdList(@Param("device") String device);
	
	/**
	 * 查询开启21点-8点推送服务的RegistrationId
	 * @param device 设备号
	 * @return
	 */
	List<String> getRegistrationIdListByPushStatus(@Param("device") String device);
	
	/**
	 * 只查询讲师id和昵称
	 * @return
	 */
	List<Map<Long, String>> getTeacherList();
}
