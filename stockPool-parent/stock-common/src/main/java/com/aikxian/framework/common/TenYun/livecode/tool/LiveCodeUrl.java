package com.aikxian.framework.common.TenYun.livecode.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LiveCodeUrl {

	public static void main(String[] args) {
		System.out.println(getPushUrl("2388", "123", "txrtmp", 1469762325L));
		System.out.println(getPlayUrl("2388", "123"));
	}

	private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	/*
	 * KEY+ stream_id + txTime
	 */
	private static String getSafeUrl(String key, String streamId, long txTime) {
		String input = new StringBuilder().append(key).append(streamId).append(Long.toHexString(txTime).toUpperCase())
				.toString();

		String txSecret = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			txSecret = byteArrayToHexString(messageDigest.digest(input.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return txSecret == null ? ""
				: new StringBuilder().append("txSecret=").append(txSecret).append("&").append("txTime=")
						.append(Long.toHexString(txTime).toUpperCase()).toString();
	}

	private static String byteArrayToHexString(byte[] data) {
		char[] out = new char[data.length << 1];

		for (int i = 0, j = 0; i < data.length; i++) {
			out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS_LOWER[0x0F & data[i]];
		}
		return new String(out);
	}

	/**
	 * 获取完整直播推流地址
	 * 
	 * @param bizid
	 *            业务码
	 * @param liveid
	 *            直播id
	 * @param key
	 *            直播流秘钥
	 * @param txTime
	 *            有效时间戳，单位：秒
	 * @return
	 */
	public static String getPushUrl(String bizid, String liveid, String key, long txTime) {
		String streamId = bizid + "_" + liveid;
		String safeUrl = getSafeUrl(key, streamId, txTime);
		String pushStream = "rtmp://" + bizid + ".livepush.myqcloud.com/live/" + streamId + "?bizid=" + bizid + "&"
				+ safeUrl;
		return pushStream;
	}

	/**
	 * 获取播放地址
	 * 
	 * @param bizid
	 * @param liveid
	 * @return
	 */
	public static Map<String, String> getPlayUrl(String bizid, String liveid) {
		String streamId = bizid + "_" + liveid;
		Map<String, String> playUrl = new HashMap<>();
		playUrl.put("rtmp", "rtmp://" + bizid + ".liveplay.myqcloud.com/live/" + streamId);
		playUrl.put("flv", "http://" + bizid + ".liveplay.myqcloud.com/live/" + streamId + ".flv");
		playUrl.put("hls", "http://" + bizid + ".liveplay.myqcloud.com/live/" + streamId + ".m3u8");
		return playUrl;
	}

}
