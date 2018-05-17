package com.huanxian.admin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huanxian.core.constant.Constant;
import com.huanxian.core.model.LoginUserInfo;

public final class ShiroUtil {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroUtil.class);

	/** 保存当前用户 */
	public static final void saveCurrentUser(LoginUserInfo user) {
		setSession(Constant.CURRENT_USER_INFO, user);
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	public static final void setSession(Object key, LoginUserInfo value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	/** 获取当前用户 */
	public static final LoginUserInfo getCurrentUser() {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			try {
				Session session = currentUser.getSession();
				if (null != session) {
					return (LoginUserInfo) session.getAttribute(Constant.CURRENT_USER_INFO);
				}
			} catch (InvalidSessionException e) {
				logger.error("", e);
			}
		}
		return null;
	}

	/**
	 * 退出登录
	 */
	public static final void logout() {
		SecurityUtils.getSubject().logout();
	}

}
