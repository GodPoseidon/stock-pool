package com.huanxian.admin.shiro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableConfigurationProperties(ShiroProperties.class)
@ConditionalOnProperty(name = "shiro.enable", havingValue = "true")
public class ShiroConfig {

	private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
	
	static String filters = "/=anon;/app/**=anon;/resources/**=anon;/regin=anon;/login=anon;/*.ico=anon;/upload/*=anon;"
			+ "/unauthorized=anon;/forbidden=anon;/*/api-docs=anon;/callback*=anon;/swagger*=anon;"
			+ "/configuration/*=anon;/*/configuration/*=anon;/webjars/**=anon;" + "/**=authc,user";
	
	static {
		try {
			Resource res = new ClassPathResource("config/shiro.config");
			File f = res.getFile();
	        List<String> list = new ArrayList<String>();
	        BufferedReader reader = null;
	        FileInputStream fis = null;
            if (f.isFile() && f.exists()) {
                fis = new FileInputStream(f);
                reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!"".equals(line)) {
                        list.add(line);
                    }
                }
            }
			if (list != null && list.size() != 0) {
				StringBuilder sb = new StringBuilder();
				for (String url : list) {
					sb.append(url.trim());
					if (!url.trim().endsWith(";")) {
						sb.append(";");
					}
				}
				filters = sb.toString();
			}
		} catch (Exception e) {
			logger.error("读取shiro配置发生错误", e);
		}
	}


	
	
	@Bean
	public DefaultWebSecurityManager securityManager(AuthorizingRealm realm, SessionManager sessionManager,
			RememberMeManager rememberMeManager) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(realm);
		manager.setSessionManager(sessionManager);
		manager.setRememberMeManager(rememberMeManager);
		return manager;
	}
	
	@Bean
	public AuthorizingRealm realm() {
		return new Realm();
	}

	@Bean
	public RedisSessionDao RedisSessionDao() {
		return new RedisSessionDao();
	}
	
	@Bean
	public SessionManager sessionManager(Cookie cookie, SessionDAO sessionDAO) {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionDAO(sessionDAO);
		sessionManager.setSessionIdCookie(cookie);
		return sessionManager;
	}

	@Bean
	public Cookie cookie() {
		SimpleCookie cookie = new SimpleCookie("STOCKJSESSIONID");
		cookie.setSecure(false);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		return cookie;
	}

	@Bean
	public RememberMeManager rememberMeManager(ShiroProperties shiroProperties) {
		CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
		rememberMeManager.getCookie().setMaxAge(shiroProperties.getRememberTime() * 60 * 60 * 24);
		return rememberMeManager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager, ShiroProperties shiroProperties) {
		ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
		factory.setSecurityManager(securityManager);
		factory.setLoginUrl(shiroProperties.getLoginUrl());
		factory.setUnauthorizedUrl(shiroProperties.getUnauthorizedUrl());
		factory.setSuccessUrl(shiroProperties.getSuccessUrl());
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		for (String filter : filters.split(";")) {
			String[] keyValue = filter.split("=");
			if (keyValue != null && keyValue.length > 1) {
				filterMap.put(keyValue[0], keyValue[1]);
			}
		}
		factory.setFilterChainDefinitionMap(filterMap);
		return factory;
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAdvisor(
			org.apache.shiro.mgt.SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

}
