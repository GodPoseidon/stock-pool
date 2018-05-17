package com.huanxian.core.jwt;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
/**
 * JWT工具类
 * @author 张晓宇
 * @date 2018年3月28日 上午10:18:45
 */
@Component
@EnableConfigurationProperties({JWTConfig.class})
public class JWTUtil {
	
    private JWTConfig jWTConfig;

    public JWTUtil(JWTConfig jWTConfig) {
        this.jWTConfig = jWTConfig;
    }
	
	public String createToken(String userId, String username, String md5Password) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(jWTConfig.getSaltValue());
			Date date = new Date();
			Calendar nowTime = Calendar.getInstance();
			nowTime.add(jWTConfig.getTimeField(), jWTConfig.getTokenExpires());
			Date expiresAt = nowTime.getTime();
			String token = JWT.create().withClaim("username", username).withClaim("password", md5Password)
					.withClaim("userId", userId).withIssuedAt(date).withExpiresAt(expiresAt).sign(algorithm);
			return token;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Map<String, Claim> verifyToke(String token) {
		Algorithm algorithm;
		try {
			algorithm = Algorithm.HMAC256(jWTConfig.getSaltValue());
			JWTVerifier jwtVerifier = JWT.require(algorithm).build();
			DecodedJWT decodedJWT = null;
			decodedJWT = jwtVerifier.verify(token);
			return decodedJWT.getClaims();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (JWTDecodeException e) {

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;

	}
}
