package com.aikxian.framework.common.TenYun.im.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 文本类型数据格式
 * @author 张晓宇
 * @date 2017年6月13日 下午6:41:57
 */
public class TextContent {

	private String Text;

	@JSONField(name = "Text")
	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
}
