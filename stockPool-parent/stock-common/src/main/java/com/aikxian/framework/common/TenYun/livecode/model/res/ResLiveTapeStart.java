package com.aikxian.framework.common.TenYun.livecode.model.res;

import java.util.Map;

import com.aikxian.framework.common.TenYun.livecode.model.BaseResData;

/**
 * 创建录制任务 响应数据
 * @author 张晓宇
 *
 */
public class ResLiveTapeStart extends BaseResData{
	
	
	private Map<String, Integer> output;


	public Map<String, Integer> getOutput() {
		return output;
	}

	public void setOutput(Map<String, Integer> output) {
		this.output = output;
	}
	

}
