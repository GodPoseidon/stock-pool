package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 删除自定义脏字
 * @author 张晓宇
 * @date 2017年6月13日 下午4:49:44
 */
public class ReqDeleteDirtyWords {
	
	private List<String> DirtyWordsList;

	@JSONField(name = "DirtyWordsList")
	public List<String> getDirtyWordsList() {
		return DirtyWordsList;
	}

	public void setDirtyWordsList(List<String> dirtyWordsList) {
		DirtyWordsList = dirtyWordsList;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}

}
