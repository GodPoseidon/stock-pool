package com.huanxian.api.controller.live;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aikxian.framework.common.TenYun.livecode.tool.LiveCodeUrl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.api.controller.BaseController;
import com.huanxian.api.vo.LiveRoomVo;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpLiveRoomT;
import com.huanxian.entity.SpPreviewLiveT;
import com.huanxian.service.SpLiveRoomTService;
import com.huanxian.service.SpPreviewLiveTService;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/live")
public class LiveController extends BaseController{

	@Autowired
	private SpLiveRoomTService liveRoomTService;
	
	@Autowired
	private SpPreviewLiveTService spPreviewLiveTService;
	
	@ApiOperation(value = "平台直播间信息")
	@GetMapping("/platformLive")
	public ResultModel platformLive() {
		List<SpLiveRoomT> room = liveRoomTService.listPlatformLiveRoom();
		List<LiveRoomVo> roomVos = new ArrayList<>();
		List<Map<String, Object>> data = new ArrayList<>();
		for (SpLiveRoomT r : room) {
			LiveRoomVo roomVo = new LiveRoomVo();
			BeanUtil.copyProperties(r, roomVo);
			roomVos.add(roomVo);
			Map<String, Object> d = new HashMap<>();
			d.put("liveRoom", roomVo);	
			SpPreviewLiveT p = new SpPreviewLiveT();
			p.setRoomId(r.getId());			
			p.setStatus(1);
			EntityWrapper<SpPreviewLiveT> wrapper = new EntityWrapper<>(p);
			wrapper.and("end_time>{0} ", new Date());
			wrapper.orderBy("preview_time", true);
			PageVo<SpPreviewLiveT> pageVo = spPreviewLiveTService.getPage(wrapper, 1, 2);
			d.put("preview", pageVo.getData());	
			data.add(d);
		}
		return successResult(data);
	}
	
	@ApiOperation(value = "获取直播间信息")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "直播间ID", dataType = "Long", required = true, paramType = "query")
	})
	@GetMapping("/get")
	public ResultModel getLiveRoom(Long id) {
		if(id == null) {
			return result("100", "直播间ID为空！！", false, null);
		}
		SpLiveRoomT room = liveRoomTService.get(id);

		if(room == null) {
			return result("2001", "直播间不存在！！", false, null);
		}
		LiveRoomVo liveRoomVo = new LiveRoomVo();
		BeanUtil.copyProperties(room, liveRoomVo);
		Map<String, Object> data = new HashMap<>();
		data.put("liveRoom", liveRoomVo);
		data.put("liveUrl", LiveCodeUrl.getPlayUrl("2388", "stock" + liveRoomVo.getId()));
		return successResult(data);
	}
}
