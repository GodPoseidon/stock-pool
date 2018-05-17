package com.huanxian.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpAccountT;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-21
 */
public interface SpAccountTService{

	PageVo<SpAccountT> getPage(Integer pageSize, Integer pageNumber,EntityWrapper<SpAccountT> wrapper);
	
	Integer insert(SpAccountT accountT);
	
	Integer delete(Long id);
	
	SpAccountT get(Long id);
	
	Integer update(SpAccountT accountT);
	
	Integer batchDel(Long[] id);
	
	SpAccountT getByPhone(String phone, Integer state);
	
	List<String> getRegistrationIdList(String device);
	
	List<String> getRegistrationIdListByPushStatus(String device);
	
	List<SpAccountT> getWrapper(EntityWrapper<SpAccountT> wrapper);
	
	/**
	 * 只查询讲师ID和昵称
	 * @return
	 */
	List<Map<Long, String>> getTeacherList();
}
