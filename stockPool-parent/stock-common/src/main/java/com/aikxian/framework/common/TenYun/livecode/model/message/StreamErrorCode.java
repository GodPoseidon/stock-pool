package com.aikxian.framework.common.TenYun.livecode.model.message;

/**
 * 推流断流错误码
 * @author 张晓宇
 *
 */
public enum StreamErrorCode {

	DELTETESTREAM(1, "主播端主动断流"),
	CLOSESTREAM(2, "主播端主动断流"),
	CLOSETCP(3, "主播端主动断开TCP连接"),
	ERRORTCP(4, "主播端TCP连接异常"),
	EXCEPTIONSTREAM(7,"收到流数据异常"),
	AUTHERROR(18, "推流鉴权失败，服务端禁止推流"),
	THIRDAUTHERROR(19, "第三方鉴权失败，服务端禁止推流");
	
	private Integer code;
	
	private String errorMsg;
	
 	private StreamErrorCode(Integer code, String errorMsg){
 		this.code = code;
 		this.errorMsg = errorMsg;
 	}
 	
 	/**
 	 * 通过错误码获取错误信息
 	 * @param code
 	 * @return
 	 */
 	public static String getErrorMsg(Integer code) {
        for (StreamErrorCode c : StreamErrorCode.values()) {
            if (c.code.equals(code)) {
                return c.errorMsg;
            }
        }
		return "直播服务内部异常,请联系腾讯云！";
 	}
}
