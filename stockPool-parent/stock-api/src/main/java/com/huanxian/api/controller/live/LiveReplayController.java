package com.huanxian.api.controller.live;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpLiveReplayT;
import com.huanxian.service.SpLiveReplayTService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "直播间回放接口")
@RestController
@RequestMapping("/live/replay")
public class LiveReplayController {

	@Autowired
	private SpLiveReplayTService spLiveReplayTService;

	@ApiOperation(value = "获取回放列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true) })
	@GetMapping("/list")
	public ResultModel list(Integer pageSize, Integer pageNum) {
		ResultModel model = new ResultModel();
		Integer size = 10, num = 1;
		if (pageSize <= 10 && pageSize > 0) {
			size = pageSize;
		}
		if (pageNum >= 1) {
			num = pageNum;
		}
		List<SpLiveReplayT> list = spLiveReplayTService.getList(size, num);
		model.setData(list);
		model.setSuccess(true);
		model.setCode("0");
		return model;
	}

}
