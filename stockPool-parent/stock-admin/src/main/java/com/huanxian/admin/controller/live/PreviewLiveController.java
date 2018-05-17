package com.huanxian.admin.controller.live;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpPreviewLiveT;
import com.huanxian.service.SpLiveRoomTService;
import com.huanxian.service.SpPreviewLiveTService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 预约直播 前端控制器
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/live/preview")
public class PreviewLiveController extends BaseController {

	@Autowired
	SpPreviewLiveTService spPreviewLiveTService;

	@Autowired
	SpLiveRoomTService spLiveRoomTService;

	@GetMapping("/list")
	public String list() {
		return "live/preview/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpPreviewLiveT> listData(String title, Integer status, Integer length, Integer start) {
		EntityWrapper<SpPreviewLiveT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (status != null) {
			wrapper.eq("status", status);
		} else {
			wrapper.ne("status", 3);
		}
		wrapper.orderBy("modify_time", false);
		PageVo<SpPreviewLiveT> page = spPreviewLiveTService.getPage(wrapper, start / length + 1, length);
		return page;
	}

	@GetMapping("/view")
	public String view(Long id, Model model) {
		SpPreviewLiveT liveT = spPreviewLiveTService.get(id);
		model.addAttribute("preview", liveT);
		return "live/preview/view";
	}

	@GetMapping("/edit")
	public String edit(Long id, Model model) {
		SpPreviewLiveT liveT = spPreviewLiveTService.get(id);
		model.addAttribute("preview", liveT);
		List<Map<Long, String>> liveInfoList = spLiveRoomTService.getLiveInfoList();
		model.addAttribute("liveList", liveInfoList);
		return "live/preview/edit";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpPreviewLiveT previewLiveT, String startDate, String endDate) {
		try {
			previewLiveT.setEndTime(DateUtil.parse(endDate, "yyyy-MM-dd HH:mm:ss"));
			previewLiveT.setPreviewTime(DateUtil.parse(startDate, "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			return errorResult("500", "日期格式不正确！", null);
		}
		previewLiveT.setModifyTime(new Date());
		previewLiveT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (previewLiveT.getId() == null) {
			spPreviewLiveTService.insert(previewLiveT);
		} else {
			spPreviewLiveTService.update(previewLiveT);
		}
		return successResult();
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		spPreviewLiveTService.delete(id);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records) {
		spPreviewLiveTService.batchDel(table_records);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		SpPreviewLiveT previewLiveT = new SpPreviewLiveT();
		previewLiveT.setId(id);
		previewLiveT.setStatus(1);
		previewLiveT.setModifyTime(new Date());
		spPreviewLiveTService.update(previewLiveT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		SpPreviewLiveT previewLiveT = new SpPreviewLiveT();
		previewLiveT.setId(id);
		previewLiveT.setStatus(2);
		spPreviewLiveTService.update(previewLiveT);
		return successResult();
	}
}
