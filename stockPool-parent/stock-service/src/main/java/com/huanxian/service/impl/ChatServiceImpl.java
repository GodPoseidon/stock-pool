package com.huanxian.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.aikxian.framework.common.TenYun.im.model.AuthConfig;
import com.aikxian.framework.common.TenYun.im.model.MessageType;
import com.aikxian.framework.common.TenYun.im.model.MsgBody;
import com.aikxian.framework.common.TenYun.im.model.TextContent;
import com.aikxian.framework.common.TenYun.im.req.ReqAccount;
import com.aikxian.framework.common.TenYun.im.req.ReqSendGroupMsg;
import com.aikxian.framework.common.TenYun.im.res.ResAccount;
import com.aikxian.framework.common.TenYun.im.res.ResSendGroupMsg;
import com.aikxian.framework.common.TenYun.im.service.AccountService;
import com.aikxian.framework.common.TenYun.im.service.GroupService;
import com.aikxian.framework.common.TenYun.im.uitl.Tls_sigature;
import com.aikxian.framework.common.TenYun.im.uitl.Tls_sigature.GenTLSSignatureResult;
import com.alibaba.fastjson.JSON;
import com.huanxian.dao.SpAccountTMapper;
import com.huanxian.entity.SpAccountT;
import com.huanxian.service.ChatService;
import com.huanxian.service.SysBasePropertyTService;
import com.huanxian.vo.CustomIMBody;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

@Service
public class ChatServiceImpl implements ChatService {

	private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

	@Autowired
	private SysBasePropertyTService sysBasePropertyTService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private SpAccountTMapper spAccountTMapper;

	@Override
	@Async
	public Boolean asynSendChat(Long userId, String groupId, String message) {
		AuthConfig authConfig = new AuthConfig();
		Map<String, String> map = sysBasePropertyTService.getGroupMap("IM");
		String identifier = map.get("IM_MANAGER");
		String sdkAppId = map.get("IMSDKAPPID");
		authConfig.setIdentifier(identifier);
		authConfig.setSdkappid(sdkAppId);
		String sign = getUserSig(identifier, 60L * 60L * 24L * 30L);
		if(StrUtil.isBlank(sign)) {
			return false;
		}
		authConfig.setUsersig(sign);
		GroupService groupService = new GroupService(authConfig);
		ReqSendGroupMsg groupMsg = new ReqSendGroupMsg();
		groupMsg.setGroupId(groupId);
		groupMsg.setRandom((int) (System.currentTimeMillis() / RandomUtil.randomLong(10000, 99999)));
		groupMsg.setFrom_Account(userId.toString());
		List<String> list = new ArrayList<>();
		groupMsg.setForbidCallbackControl(list);
		MsgBody msgBody = new MsgBody();
		msgBody.setMsgType(MessageType.TIMTextElem);
		SpAccountT accountT = spAccountTMapper.selectById(userId);
		CustomIMBody imBody = new CustomIMBody();
		imBody.setUserId(accountT.getId());
		imBody.setAvatar(accountT.getAvatar());
		imBody.setNickname(accountT.getNick());
		imBody.setMessageType(1);
		imBody.setMessage(message);
		TextContent content = new TextContent();
		content.setText(JSON.toJSONString(imBody));
		msgBody.setMsgContent(content);
		List<MsgBody> mb = new ArrayList<>();
		mb.add(msgBody);
		groupMsg.setMsgBody(mb);
		ResSendGroupMsg sendResult = groupService.sendGroupMsg(groupMsg);
		if (!"OK".equals(sendResult.getActionStatus())) {
			Integer time = sendResult.getMsgTime();
			logger.error("群聊信息发送失败！发送用户id:{},发送群组id:{},发送时间:{},错误码:{},错误消息:{},消息格式:{}", userId, groupId, time,
					sendResult.getErrorCode(), sendResult.getErrorInfo(), groupMsg.toString());
			return false;
		}
		return true;
	}
	
	/**
	 * 获取用户的im签名
	 * @return
	 */
	public String getUserSig(String userId, Long time) {
		String sign = stringRedisTemplate.boundValueOps("IM_GenTLSSignature:" + userId).get();
		if (StrUtil.isBlank(sign)) {
			GenTLSSignatureResult result;
			Map<String, String> map = sysBasePropertyTService.getGroupMap("IM");
			String imPrivate = map.get("IM_PRIVATE");
			String sdkAppId = map.get("IMSDKAPPID");
			try {
				result = Tls_sigature.GenTLSSignatureEx(Long.valueOf(sdkAppId),
						userId, imPrivate, time);
				if (0 == result.urlSig.length()) {
					logger.error("腾讯云通讯获取签名失败！失败消息:{}", result.errMessage);
					return null;
				}
				sign = result.urlSig;
				stringRedisTemplate.boundValueOps("IM_GenTLSSignature:" + userId).set(result.urlSig, time, TimeUnit.SECONDS);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}
	
	@Async
	public Future<Boolean> asyncAddIMUser(String userId, String nick, String faceUrl, Integer type) {
		return new AsyncResult<Boolean>(addIMUser(userId, nick, faceUrl, type));
	}
	
	public Boolean addIMUser(String userId, String nick, String faceUrl, Integer type) {
		Map<String, String> map = sysBasePropertyTService.getGroupMap("IM");
		String sdkAppid = map.get("IMSDKAPPID");
		String imManager = map.get("IM_MANAGER");
		AuthConfig authConfig = new AuthConfig();
		authConfig.setSdkappid(sdkAppid);
		authConfig.setIdentifier(imManager);
		authConfig.setUsersig(getUserSig(imManager, 60L * 60L * 24L * 30L));
		authConfig.setRandom((int) (System.currentTimeMillis() / RandomUtil.randomLong(10000, 99999)));
		AccountService accountService = new AccountService(authConfig);
		ReqAccount reqAccount = new ReqAccount();
		reqAccount.setIdentifier(userId);
		reqAccount.setNick(nick);
		reqAccount.setFaceUrl(faceUrl);
		reqAccount.setType(type);
		ResAccount account = accountService.accountImport(reqAccount);
		if(account.getActionStatus().equals("OK")) {
			return true;
		}else {
			logger.error("添加用户到腾讯云im中发生错！！code:{},errorMessage:{}", account.getErrorCode(), account.getErrorInfo());
		}
		return false;		
	}

}
