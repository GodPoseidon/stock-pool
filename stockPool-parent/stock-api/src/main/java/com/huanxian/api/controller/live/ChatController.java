package com.huanxian.api.controller.live;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huanxian.api.controller.BaseController;
import com.huanxian.api.vo.ChatMessageVo;
import com.huanxian.core.annotation.LoginValidate;
import com.huanxian.core.model.LoginUserInfo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpLiveRoomT;
import com.huanxian.service.ChatService;
import com.huanxian.service.SpLiveRoomTService;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/chat")
public class ChatController extends BaseController {

	@Autowired
	private SpLiveRoomTService spLiveRoomTService;

	@Autowired
	private ChatService chatService;

	@ApiOperation(value = "发送直播间聊天信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "liveId", value = "直播间ID", dataType = "Integer", required = true, paramType = "form"),
			@ApiImplicitParam(name = "message", value = "消息", dataType = "String", required = true, paramType = "form"),
			@ApiImplicitParam(name = "auth_token", value = "用户token", dataType = "String", required = true, paramType = "header") })
	@LoginValidate
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResultModel send(@Validated ChatMessageVo messageVo) {
		SpLiveRoomT liveRoomT = spLiveRoomTService.get(messageVo.getLiveId());
		if (liveRoomT == null) {
			return result("100", "直播间不存在！", false, null);
		}
		if (StrUtil.isBlank(liveRoomT.getGroupId())) {
			return result("100", "直播间聊天组不存在！！", false, null);
		}
		LoginUserInfo user = getCurrentUser();
		chatService.asynSendChat(user.getId(), liveRoomT.getGroupId(), messageVo.getMessage());
		return successResult(null);
	}

	@ApiOperation(value = "聊天室游客登录")
	@RequestMapping(value = "/visitorLogin", method = RequestMethod.POST)
	public ResultModel visitorLogin() {
		String uid = RandomUtil.simpleUUID();
		chatService.asyncAddIMUser(uid, "游客_" + RandomUtil.randomString(7), null, 1);
		String sign = chatService.getUserSig(uid, 3600L);
		Map<String, Object> map = new HashMap<>();
		map.put("userSig", sign);
		map.put("visitorId", uid);
		return successResult(map);
	}

}
