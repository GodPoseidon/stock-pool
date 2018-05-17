package com.huanxian.api.controller.account;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.api.ApiContsant;
import com.huanxian.api.controller.BaseController;
import com.huanxian.common.web.SMSUtil;
import com.huanxian.core.annotation.LoginValidate;
import com.huanxian.core.em.BasePropertyPropGroupEnum;
import com.huanxian.core.model.LoginUserInfo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.core.util.SecurityUtil;
import com.huanxian.entity.SpAccountT;
import com.huanxian.entity.SysMessageT;
import com.huanxian.service.SpAccountProTService;
import com.huanxian.service.SpAccountTService;
import com.huanxian.service.SysBasePropertyTService;
import com.huanxian.service.SysMessageTService;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class AccountController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private SpAccountTService spAccountTService;
	
	@Autowired
	private RedissonClient redissonClient;
	
	@Autowired
	private SysMessageTService messageTService;
	
	
	@Autowired
	private SpAccountProTService spAccountProTService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private SysBasePropertyTService sysBasePropertyTService;
	
	@ApiOperation(value = "用户通过手机验证码更改密码")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "password", value = "新密码", dataType = "String", required = true, paramType = "form"),
		@ApiImplicitParam(name = "code", value = "手机验证码", dataType = "String", required = true, paramType = "form"),
		@ApiImplicitParam(name = "auth_token", value = "用户token", dataType = "String", required = true, paramType = "header")
	})
	@LoginValidate
	@PostMapping("/updatePasswordByPhoneCode")
	public ResultModel updatePasswordByPhoneCode(String password, String code) {
		ResultModel model = new ResultModel();
		if(StrUtil.isBlank(code)) {
			model.setCode("100");
			model.setMessage("验证码为空！！");
			model.setSuccess(false);
			return model;
		}		
		if(StrUtil.isBlank(password)) {
			model.setCode("100");
			model.setMessage("新密码为空！！");
			model.setSuccess(false);
			return model;
		}
		LoginUserInfo info = getCurrentUser();
		SpAccountT accountT = spAccountTService.get(info.getId());
		String key = ApiContsant.PHONE_CODE_UPDATE_PASSWORE + ":" + accountT.getPhone();
		String vailCode = redisTemplate.boundValueOps(key).get();
		if(!code.equals(vailCode)) {
			model.setCode("2001");
			model.setMessage("手机验证码校验错误!!");
			model.setSuccess(false);
			return model;
		}
		SpAccountT a = new SpAccountT();
		a.setId(accountT.getId());
		a.setPassword(SecurityUtil.encryptPassword(password));
		spAccountTService.update(a);
		return successResult(null);
	}
	
	
	@ApiOperation(value = "用户发送修改密码的手机验证码")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "auth_token", value = "用户token", dataType = "String", required = true, paramType = "header")
	})
	@LoginValidate
	@PostMapping("/sendUpdatePasswordCode")
	public ResultModel sendUpdatePasswordCode() {
		LoginUserInfo info = getCurrentUser();
		ResultModel model = new ResultModel();
		SpAccountT accountT = spAccountTService.get(info.getId());
		RLock rLock = redissonClient.getLock(ApiContsant.PHONE_CODE_STOP + ":" + accountT.getPhone());	
		if(rLock.isLocked()) {
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
		flag = SMSUtil.sendSMS(accountT.getPhone(), map, parms);
//		flag = UPYunSMSUtil.sendMessage(accountT.getPhone(), "1636", parms, "dEQ5xivdLVUSAsGP8tjz0TgqXJG9GX");
		if(flag) {
			String key = ApiContsant.PHONE_CODE_UPDATE_PASSWORE + ":" + accountT.getPhone();
			redisTemplate.boundValueOps(key).set(randomCode, 5L, TimeUnit.MINUTES);
			rLock.lock(60, TimeUnit.SECONDS);
		}else {
			model.setCode("101");
			model.setMessage("手机验证码发送失败！！");
			model.setSuccess(false);
			return model;
		}
		return successResult(null);
	}
	
	
	@ApiOperation(value = "个人中心信息页")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "auth_token", value = "用户token", dataType = "String", required = true, paramType = "header")
	})
	@LoginValidate
	@PostMapping("/myInfoMain")
	public ResultModel myInfoMain(){
		SpAccountT account = spAccountTService.get(getCurrentUser().getId());
		EntityWrapper<SysMessageT> wrapper = new EntityWrapper<SysMessageT>();
		wrapper.eq("account_id", account.getId());
		wrapper.eq("msread",0);
		return successResult(messageTService.getPage(10000, 1, wrapper).getRecordsTotal());
	}

	
	@ApiOperation(value = "个人中心产品页")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "auth_token", value = "用户token", dataType = "String", required = true, paramType = "header")
	})
	@PostMapping("/myProMain")
	@LoginValidate
	public ResultModel myProMain(){
		return successResult(spAccountProTService.queryPro(getCurrentUser().getId()));
	}

	@ApiOperation(value = "个人中心消息页")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Integer", required = true, paramType = "form"),
		@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true, paramType = "form") ,
	})
	@LoginValidate
	@PostMapping("/myMSMain")
	public ResultModel myMSMain(Integer pageSize,Integer pageNum){
		SpAccountT account = spAccountTService.get(getCurrentUser().getId());
		EntityWrapper<SysMessageT> wrapper = new EntityWrapper<SysMessageT>();
		wrapper.eq("account_id", account.getId());
		wrapper.orderBy("create_time", false);
		return successResult(messageTService.getPage(pageSize, pageNum, wrapper));
	}
	
	@ApiOperation(value = "修改未读为已读")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "分页大小", dataType = "Long", required = true, paramType = "form"),
		@ApiImplicitParam(name = "auth_token", value = "用户token", dataType = "String", required = true, paramType = "header")
	})
	@LoginValidate
	@PostMapping("/readMs")
	public ResultModel readMs(Long id){
		SysMessageT sysMessageT  = messageTService.get(id);
		sysMessageT.setMsread(1);
		messageTService.updateById(sysMessageT);
		return successResult(sysMessageT.getLink());
	}
	
	@ApiOperation(value = "修改推送时间")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "time", value = "时间状态，0:关闭 ，1:开启，2: 21点-8点", dataType = "int", required = true, paramType = "form"),
		@ApiImplicitParam(name = "auth_token", value = "用户token", dataType = "String", required = true, paramType = "header")
	})
	@LoginValidate
	@PostMapping("/updatePushTime")
	public ResultModel updatePushTime(Integer time){
		if(time != 1 && time != 2 && time != 0) {
			return result("100", "时间状态错误！！", false, null);
		}
		SpAccountT accountT = new SpAccountT();
		accountT.setId(getCurrentUser().getId());
		accountT.setPushStatus(time);
		spAccountTService.update(accountT);
		return successResult(null);
	}
	
	@ApiOperation(value = "获取推送状态")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "auth_token", value = "用户token", dataType = "String", required = true, paramType = "header")
	})
	@LoginValidate
	@PostMapping("/myPushStatus")
	public ResultModel getMyPushStatus() {
		SpAccountT accountT = spAccountTService.get(getCurrentUser().getId());
		Map<String, Object> data = new HashMap<>();
		data.put("pushStatus", accountT.getPushStatus());
		return successResult(data);
	}
}
