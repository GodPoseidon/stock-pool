package com.huanxian.core.annotation.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.huanxian.core.annotation.LoginValidate;
import com.huanxian.core.constant.Constant;
import com.huanxian.core.exception.LoginFailException;
import com.huanxian.core.exception.LogonExpiresException;
import com.huanxian.core.jwt.JWTUtil;
/**
 * {@link LoginValidate}
 * 处理登录验证
 * @author 张晓宇
 * @date 2018年4月19日 下午7:55:46
 */
@Configuration
@ConditionalOnProperty(name = "jwt.login-vaildate", havingValue = "true")
@Aspect
public class LoginVaildateHandler {

	@Autowired
	private JWTUtil jwtUtil;

	@Pointcut("@annotation(com.huanxian.core.annotation.LoginValidate)")
	public void pointcut() {

	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String token = request.getHeader(Constant.AUTH_TOKEN) != null ? request.getHeader(Constant.AUTH_TOKEN) : request.getParameter(Constant.AUTH_TOKEN);
		if (StringUtils.isEmpty(token)) {
			throw new LoginFailException("100", "未登录！");
		}
		Map<String, Claim> userInfo = null;
		try {
			userInfo = jwtUtil.verifyToke(token);
		}catch (TokenExpiredException e) {
			throw new LogonExpiresException();
		}
		if (userInfo == null) {
			throw new LoginFailException();
		}
		request.setAttribute(Constant.CURRENT_USER_INFO, userInfo);
		try {
			return joinPoint.proceed();
		} catch (Throwable e) {
			throw e;
		}
	}
}
