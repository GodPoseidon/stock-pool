package com.huanxian.api.controller.login;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aikxian.framework.common.TenYun.im.uitl.Tls_sigature;
import com.aikxian.framework.common.TenYun.im.uitl.Tls_sigature.GenTLSSignatureResult;
import com.huanxian.api.ApiContsant;
import com.huanxian.api.controller.BaseController;
import com.huanxian.api.vo.LoginVo;
import com.huanxian.common.web.SMSUtil;
import com.huanxian.common.web.UPYunSMSUtil;
import com.huanxian.core.em.BasePropertyPropGroupEnum;
import com.huanxian.core.jwt.JWTUtil;
import com.huanxian.core.model.LoginUserInfo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.core.util.SecurityUtil;
import com.huanxian.entity.SpAccountT;
import com.huanxian.service.ChatService;
import com.huanxian.service.SpAccountTService;
import com.huanxian.service.SysBasePropertyTService;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * app登录方式
 * 
 * @author 张晓宇
 * @date 2018年4月24日 下午5:35:47
 */
@RestController
@RequestMapping("/app")
public class AppLoginController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(AppLoginController.class);
	@Autowired
	private SpAccountTService spAccountTService;

	@Autowired
	private JWTUtil jWTUtil;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	private SysBasePropertyTService sysBasePropertyTService;

	@Autowired
	private RedissonClient redissonClient;

	@Autowired
	private ChatService chatService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@ApiOperation(value = "app用户登录接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "form", dataTypeClass = String.class),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form", dataTypeClass = String.class),
			@ApiImplicitParam(name = "os", value = "设备系统,ios或android", required = true, paramType = "form", dataTypeClass = String.class),
			@ApiImplicitParam(name = "registrationId", value = "极光推送的注册id", required = true, paramType = "form", dataTypeClass = String.class) })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResultModel Login(@Validated LoginVo loginVo, String os, String registrationId)
			throws NumberFormatException, IOException {
		ResultModel model = new ResultModel();
		String device = null;
		if (StrUtil.isBlank(registrationId)) {
			model.setCode("100");
			model.setMessage("推送设备id不存在！！");
			model.setSuccess(false);
			return model;
		}
		if (os.equalsIgnoreCase("ios")) {
			device = "ios";
		}
		if (os.equalsIgnoreCase("android")) {
			device = "android";
		}
		if (StrUtil.isBlank(device)) {
			model.setCode("100");
			model.setMessage("设备不存在！！");
			model.setSuccess(false);
			return model;
		}
		SpAccountT account = spAccountTService.getByPhone(loginVo.getPhone(), 1);
		if (account == null) {
			model.setCode("1004");
			model.setMessage("账号不存在！！");
			model.setSuccess(false);
			return model;
		}
		if (!account.getPassword().equals(SecurityUtil.encryptPassword(loginVo.getPassword()))) {
			model.setCode("1001");
			model.setMessage("账号登录失败！请检查密码！！");
			model.setSuccess(false);
			return model;
		}
		LoginUserInfo userInfo = new LoginUserInfo();
		userInfo.setAccount(account.getPhone());
		userInfo.setName(account.getNick());
		userInfo.setId(account.getId());
		String token = jWTUtil.createToken(account.getId().toString(), account.getNick(),
				SecurityUtil.encryptPassword(loginVo.getPassword()));
		Map<String, Object> data = new HashMap<>();
		Map<String, String> map = sysBasePropertyTService.getGroupMap("IM");
		GenTLSSignatureResult result = Tls_sigature.GenTLSSignatureEx(Long.valueOf(map.get("IMSDKAPPID")),
				account.getId().toString(), map.get("IM_PRIVATE"));
		if (0 == result.urlSig.length()) {
			logger.error("腾讯云通讯获取签名失败！失败消息:{}", result.errMessage);
		} else {
			stringRedisTemplate.boundValueOps("IM_GenTLSSignature:" + account.getId().toString()).set(result.urlSig, 29,
					TimeUnit.DAYS);
		}
		SpAccountT a = new SpAccountT();
		a.setId(account.getId());
		a.setLastDevice(device);
		a.setJpushRegistrationId(registrationId);
		a.setModifyTime(new Date());
		spAccountTService.update(a);
		data.put("imUserSig", result.urlSig);
		data.put("authToken", token);
		data.put("userInfo", userInfo);
		model.setCode("0");
		model.setMessage("成功！！");
		model.setSuccess(true);
		model.setData(data);
		return model;
	}

	@ApiOperation(value = "app用户注册接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "form", dataTypeClass = String.class),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form", dataTypeClass = String.class),
			@ApiImplicitParam(name = "registerCode", value = "注册验证码", required = true, paramType = "form", dataTypeClass = String.class),
			@ApiImplicitParam(name = "sessionUUID", value = "会话ID", required = true, paramType = "form", dataTypeClass = String.class),
			@ApiImplicitParam(name = "os", value = "设备系统,ios或android", required = true, paramType = "form", dataTypeClass = String.class),
			@ApiImplicitParam(name = "registrationId", value = "极光推送的注册id", required = true, paramType = "form", dataTypeClass = String.class) })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResultModel register(@Validated LoginVo loginVo, String registerCode, String sessionUUID, String os,
			String registrationId) throws NumberFormatException, IOException {
		ResultModel model = new ResultModel();
		if (StrUtil.isEmpty(registerCode)) {
			model.setCode("100");
			model.setMessage("验证码为空!!");
			model.setSuccess(false);
			return model;
		}
		String key = ApiContsant.PHONE_CODE_REGISTER + ":" + sessionUUID + loginVo.getPhone();
		String code = redisTemplate.boundValueOps(key).get();
		if (StrUtil.isEmpty(code)) {
			model.setCode("100");
			model.setMessage("请发送验证码!!");
			model.setSuccess(false);
			return model;
		}
		if (!registerCode.equals(code)) {
			model.setCode("2001");
			model.setMessage("手机注册验证码错误!!");
			model.setSuccess(false);
			return model;
		}
		SpAccountT account = spAccountTService.getByPhone(loginVo.getPhone(), null);
		if (account != null) {
			model.setCode("1005");
			model.setMessage("账户已存在!!");
			model.setSuccess(false);
			return model;
		}
		String device = null;
		if (os.equalsIgnoreCase("ios")) {
			device = "ios";
		}
		if (os.equalsIgnoreCase("android")) {
			device = "android";
		}
		if (StrUtil.isBlank(device)) {
			model.setCode("100");
			model.setMessage("设备不存在！！");
			model.setSuccess(false);
			return model;
		}
		SpAccountT accountT = new SpAccountT();
		accountT.setPhone(loginVo.getPhone());
		accountT.setPassword(SecurityUtil.encryptPassword(loginVo.getPassword()));
		Date date = new Date();
		accountT.setModifyTime(date);
		accountT.setCreateTime(date);
		accountT.setNick("stock_" + RandomUtil.randomString(loginVo.getPhone(), 6));
		accountT.setLastDevice(device);
		accountT.setJpushRegistrationId(registrationId);
		spAccountTService.insert(accountT);
		redisTemplate.delete(key);
		LoginUserInfo userInfo = new LoginUserInfo();
		userInfo.setAccount(accountT.getPhone());
		userInfo.setName(accountT.getNick());
		userInfo.setId(accountT.getId());
		String token = jWTUtil.createToken(accountT.getId().toString(), accountT.getNick(),
				SecurityUtil.encryptPassword(accountT.getPassword()));
		chatService.addIMUser(accountT.getId().toString(), accountT.getNick(), null, 0);
		Map<String, Object> data = new HashMap<>();
		data.put("imUserSig", chatService.getUserSig(accountT.getId().toString(), 60L * 60L * 24L * 30L));
		data.put("authToken", token);
		data.put("userInfo", userInfo);

		return successResult(data);
	}

	@ApiOperation(value = "app发送注册验证码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "form", dataTypeClass = String.class) })
	@ApiModelProperty()
	@RequestMapping(value = "/sendRegisterCode", method = RequestMethod.POST)
	public ResultModel register(String phone) {
		ResultModel model = new ResultModel();
		if (StrUtil.isEmpty(phone)) {
			model.setCode("100");
			model.setMessage("手机号为空!!");
			model.setSuccess(false);
			return model;
		}
		RLock rLock = redissonClient.getLock(ApiContsant.PHONE_CODE_STOP + ":" + phone);
		if (rLock.isLocked()) {
			model.setCode("2002");
			model.setMessage("在指定时间内请勿重复发送!!");
			model.setSuccess(false);
			return model;
		}
		String randomCode = RandomUtil.randomString("0123456789", 6);
		Map<String, String> map = new HashMap<>();
		map = sysBasePropertyTService.getGroupMap(BasePropertyPropGroupEnum.SMS.getEname());
		String[] parms = new String[2];
		parms[0] = randomCode;
		parms[1] = "5分钟";
		Boolean flag = false;
		flag = SMSUtil.sendSMS(phone, map, parms);
//		flag = UPYunSMSUtil.sendMessage(phone, "1636", parms, "dEQ5xivdLVUSAsGP8tjz0TgqXJG9GX");
		String sessionUUID = RandomUtil.simpleUUID();
		if (flag) {
			String key = ApiContsant.PHONE_CODE_REGISTER + ":" + sessionUUID + phone;
			// redisTemplate.boundSetOps(ApiContsant.PHONE_CODE_STOP + ":" +
			// phone).expire(60L, TimeUnit.SECONDS);
			rLock.lock(60, TimeUnit.SECONDS);
			redisTemplate.boundValueOps(key).set(randomCode, 5L, TimeUnit.MINUTES);
		} else {
			model.setCode("101");
			model.setMessage("手机验证码发送失败！！");
			model.setSuccess(false);
			return model;
		}
		model.setCode("0");
		model.setMessage("发送成功！！");
		model.setSuccess(true);
		Map<String, Object> data = new HashMap<>();
		data.put("sessionUUID", sessionUUID);
		model.setData(data);
		return model;
	}

}
