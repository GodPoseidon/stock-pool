package com.aikxian.framework.common.TenYun.im.service;

import com.aikxian.framework.common.TenYun.im.IMConfig;
import com.aikxian.framework.common.TenYun.im.IMInterface;
import com.aikxian.framework.common.TenYun.im.model.AuthConfig;
import com.aikxian.framework.common.TenYun.im.req.ReqAddDirtyWords;
import com.aikxian.framework.common.TenYun.im.req.ReqDeleteDirtyWords;
import com.aikxian.framework.common.TenYun.im.res.ResAddDirtyWords;
import com.aikxian.framework.common.TenYun.im.res.ResDeleteDirtyWords;
import com.aikxian.framework.common.TenYun.im.res.ResGetDirtyWords;

/**
 * 自定义脏字服务接口
 * @author 张晓宇
 * @date 2017年6月13日 下午4:44:28
 */
public class DirtyWordsService extends BaseService{

	public DirtyWordsService(AuthConfig authConfig){
		this.authConfig = authConfig;
	}
	
	private AuthConfig authConfig;
	
	/**
	 * 获取自定义脏字
	 * @return
	 */
	public ResGetDirtyWords getDirtyWords(){
		String reqUrl = IMConfig.REQURL + IMInterface.DIRTY_WORDS_GET;
		return reqIMInterface(authConfig, reqUrl, null, ResGetDirtyWords.class);	
	}
	
	/**
	 * 添加脏字
	 * @param addDirtyWords
	 * @return
	 */
	public ResAddDirtyWords addDirtyWords(ReqAddDirtyWords addDirtyWords){
		String reqUrl = IMConfig.REQURL + IMInterface.DIRTY_WORDS_ADD;
		return reqIMInterface(authConfig, reqUrl, addDirtyWords, ResAddDirtyWords.class);	
	}
	
	/**
	 * 删除脏字
	 * @param deleteDirtyWords
	 * @return
	 */
	public ResDeleteDirtyWords deleteDirtyWords(ReqDeleteDirtyWords deleteDirtyWords){
		String reqUrl = IMConfig.REQURL + IMInterface.DIRTY_WORDS_DELETE;
		return reqIMInterface(authConfig, reqUrl, deleteDirtyWords, ResDeleteDirtyWords.class);	
	}
}
