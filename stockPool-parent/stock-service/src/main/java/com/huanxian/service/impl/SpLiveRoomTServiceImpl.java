package com.huanxian.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aikxian.framework.common.TenYun.livecode.model.req.LiveChannelSetStatus;
import com.aikxian.framework.common.TenYun.livecode.model.res.ResLiveChannelSetStatus;
import com.aikxian.framework.common.TenYun.livecode.service.LiveCodeService;
import com.aikxian.framework.common.TenYun.livecode.tool.LiveCodeUrl;
import com.aikxian.framework.common.TenYun.livecode.tool.LiveCodeUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpLiveRoomTMapper;
import com.huanxian.entity.SpLiveRoomT;
import com.huanxian.service.SpLiveRoomTService;

/**
 * <p>
 * 直播间表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
@Service
public class SpLiveRoomTServiceImpl implements SpLiveRoomTService {

	@Autowired
	private SpLiveRoomTMapper spLiveRoomTMapper;
	
	@Override
	public Integer insert(SpLiveRoomT liveRoomT) {
		return spLiveRoomTMapper.insert(liveRoomT);
	}

	@Override
	public Integer delete(Long id) {
		SpLiveRoomT entity = new SpLiveRoomT();
		entity.setId(id);
		entity.setStatus(3);
		return spLiveRoomTMapper.updateById(entity);
	}

	@Override
	public Integer update(SpLiveRoomT liveRoomT) {
		return spLiveRoomTMapper.updateById(liveRoomT);
	}

	@Override
	public SpLiveRoomT get(Long id) {
		return spLiveRoomTMapper.selectById(id);
	}

	@Override
	public PageVo<SpLiveRoomT> getPage(EntityWrapper<SpLiveRoomT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SpLiveRoomT> liveRoom = spLiveRoomTMapper.selectList(wrapper);
		PageVo<SpLiveRoomT> vo = new PageVo<>();
		Integer total = Integer.valueOf(PageHelper.freeTotal()+"");
		vo.setRecordsTotal(total);
		vo.setPageNumber(pageNum);
		vo.setData(liveRoom);
		vo.setPageSize(pageSize);
		return vo;
	}
	
	@Override
	public List<SpLiveRoomT> listPlatformLiveRoom() {
		SpLiveRoomT parm = new SpLiveRoomT();
		parm.setPlatform(1);
		parm.setStatus(1);
		EntityWrapper<SpLiveRoomT> wrapper = new EntityWrapper<>(parm);
		return spLiveRoomTMapper.selectList(wrapper);
	}

	@Override
	public Integer batchDel(Long[] ids) {
		return spLiveRoomTMapper.batchDel(ids);
	}

	@Override
	public List<Map<Long, String>> getLiveInfoList() {
		return spLiveRoomTMapper.getLiveInfoList();
	}

	
	/**
	 * 直播业务码
	 */
	private static final String bizid = "2388";
	
	/**
	 * 直播客户码
	 */
	private static final int appid = 1251995088;
	
	/**
	 * 直播推流key
	 */
	private static final String pushKey = "d06a3b7ba06e2ac92e780c5a54bb2d3e";
	
	/**
	 * 直播APIkey
	 */
	private static final String apiKey = "d06a3b7ba06e2ac92e780c5a54bb2d3e";
	
	@Override
	public String getPushUrl(Long id) {
		SpLiveRoomT room = spLiveRoomTMapper.selectById(id);
		if (room == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();// 取当前日期。
		cal.add(Calendar.MONTH, 1);
		String pushUrl = LiveCodeUrl.getPushUrl(bizid, "stock" + id.toString(), pushKey, cal.getTimeInMillis() / 1000);
		return pushUrl;
	}

	@Override
	public boolean forbidStream(Long id) {
		SpLiveRoomT room = spLiveRoomTMapper.selectById(id);
		if (room == null) {
			return false;
		}
		Calendar cal = Calendar.getInstance();// 取当前日期。
		cal.add(Calendar.MINUTE, 1);
		Integer exTime = (int) (cal.getTimeInMillis() / 1000);
		String channel_id = bizid + "_" + "stock" +id;
		String sign = LiveCodeUtil.safeSign(apiKey, exTime);
		LiveChannelSetStatus channelSetStatus = new LiveChannelSetStatus(appid, exTime, sign, channel_id, 2);
		ResLiveChannelSetStatus result =  LiveCodeService.liveChannelSetStatus(channelSetStatus);
		if(result.getCode() == 2) {
			return true;
		}
		return false;
	}

}
