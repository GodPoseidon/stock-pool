package com.huanxian.core.exception;

public class LoginFailException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginFailException() {
		super();
	}
	
	public LoginFailException(String code, String message) {
		super(code, message);
	}
}
