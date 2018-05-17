package com.huanxian.admin.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisSessionDao extends AbstractSessionDAO {
	
	private static final int EXPIRE_TIME = 600;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void delete(Serializable sessionId) {
		if (sessionId != null) {
			String sessionKey = buildRedisSessionKey(sessionId);
			redisTemplate.delete(sessionKey);
		}
	}

	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		saveSession(session);
		return sessionId;
	}

	protected Session doReadSession(Serializable sessionId) {
		String sessionKey = buildRedisSessionKey(sessionId);
		Object value = redisTemplate.boundValueOps(sessionKey).get();
		if (value == null) {
			return null;
		}
		Session session = (Session) value;
		return session;
	}

	public void update(Session session) throws UnknownSessionException {
		saveSession(session);
	}

	public void delete(Session session) {
		if (session != null) {
			Serializable id = session.getId();
			if (id != null) {
				redisTemplate.delete(buildRedisSessionKey(id));
			}
		}
	}

	public Collection<Session> getActiveSessions() {
		List<Session> list = new ArrayList<>();
		Set<String> set = redisTemplate.keys("shiro:redis:*");
		for (String key : set) {
			list.add((Session) redisTemplate.boundValueOps(key).get());
		}
		return list;
	}

	private void saveSession(Session session) {
		if (session == null || session.getId() == null)
			throw new UnknownSessionException("session is empty");
		String sessionKey = buildRedisSessionKey(session.getId());
		int sessionTimeOut = EXPIRE_TIME;
		redisTemplate.boundValueOps(sessionKey).set(session, sessionTimeOut, TimeUnit.SECONDS);
	}

	private String buildRedisSessionKey(Serializable sessionId) {
		return "shiro:redis:" + sessionId;
	}
}
