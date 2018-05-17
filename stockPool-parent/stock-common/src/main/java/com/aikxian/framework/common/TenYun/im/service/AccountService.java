package com.aikxian.framework.common.TenYun.im.service;

import com.aikxian.framework.common.TenYun.im.IMConfig;
import com.aikxian.framework.common.TenYun.im.IMInterface;
import com.aikxian.framework.common.TenYun.im.model.AuthConfig;
import com.aikxian.framework.common.TenYun.im.req.ReqAccount;
import com.aikxian.framework.common.TenYun.im.req.ReqKickAccount;
import com.aikxian.framework.common.TenYun.im.req.ReqMultiAccount;
import com.aikxian.framework.common.TenYun.im.req.ReqRegisterAccount;
import com.aikxian.framework.common.TenYun.im.res.ResAccount;
import com.aikxian.framework.common.TenYun.im.res.ResKickAccount;
import com.aikxian.framework.common.TenYun.im.res.ResMultiAccount;
import com.aikxian.framework.common.TenYun.im.res.ResRegisterAccount;

/**
 * 账号接口服务
 * 
 * @author 张晓宇
 *
 */
public class AccountService extends BaseService {

	public AccountService(AuthConfig authConfig) {
		this.authConfig = authConfig;
	}

	private AuthConfig authConfig;

	/**
	 * 独立模式账号导入接口
	 * 
	 * @param account
	 * @return
	 */
	public ResAccount accountImport(ReqAccount account) {
		String reqUrl = IMConfig.REQURL + IMInterface.ACCOUNT_IMPORT;
		return reqIMInterface(authConfig, reqUrl, account, ResAccount.class);
	}

	/**
	 * 独立模式账号批量导入接口
	 * 
	 * @param accounts
	 * @return
	 */
	public ResMultiAccount multiAccountImport(ReqMultiAccount accounts) {
		String reqUrl = IMConfig.REQURL + IMInterface.MULTI_ACCOUNT_IMPORT;
		return reqIMInterface(authConfig, reqUrl, accounts, ResMultiAccount.class);
	}
	
	/**
	 * 帐号登录态失效接口
	 * 
	 * @param account
	 * @return
	 */
	public ResKickAccount kickAccount(ReqKickAccount account) {
		String reqUrl = IMConfig.REQURL + IMInterface.KICK_ACCOUNT;
		return reqIMInterface(authConfig, reqUrl, account, ResKickAccount.class);
	}

	/**
	 * 托管模式存量账号导入
	 * 
	 * @param account
	 * @return
	 */
	public ResRegisterAccount registerAccount(ReqRegisterAccount account) {
		String reqUrl = IMConfig.REQURL + IMInterface.REGISTER_ACCOUNT;
		return reqIMInterface(authConfig, reqUrl, account, ResRegisterAccount.class);
	}

}
