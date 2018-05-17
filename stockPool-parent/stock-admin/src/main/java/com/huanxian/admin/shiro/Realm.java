package com.huanxian.admin.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.huanxian.core.exception.LoginFailException;
import com.huanxian.core.model.LoginUserInfo;
import com.huanxian.core.util.SecurityUtil;
import com.huanxian.entity.SysUserT;
import com.huanxian.service.SysPermissionService;
import com.huanxian.service.SysUserService;

public class Realm extends AuthorizingRealm{

	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private SysPermissionService sysPermissionService;

	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		LoginUserInfo user = (LoginUserInfo) ShiroUtil.getCurrentUser();
		Set<String> url = sysPermissionService.getAllPermissionByUserId(user.getId());
		info.addStringPermissions(url);
		// 添加用户权限
		info.addStringPermission("user");
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
		String username = authcToken.getUsername();
		SysUserT sysUser = sysUserService.getByUserName(username);
		if(sysUser == null) {
			throw new DisabledAccountException();
		}
		StringBuilder sb = new StringBuilder(100);
		for (int i = 0; i < authcToken.getPassword().length; i++) {
			sb.append(authcToken.getPassword()[i]);
		}
		if(sysUser.getPassword().equals(SecurityUtil.encryptPassword(sb.toString()))) {
			LoginUserInfo info = new LoginUserInfo();
			info.setId(sysUser.getId());
			info.setAccount(sysUser.getAccount());
			info.setName(sysUser.getName());
			ShiroUtil.saveCurrentUser(info);
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(sysUser.getAccount(), sb.toString(), sysUser.getName());
			return authcInfo;
		}else {
			throw new LoginFailException("1001", "密码或账号错误！");
		}
	}

}
