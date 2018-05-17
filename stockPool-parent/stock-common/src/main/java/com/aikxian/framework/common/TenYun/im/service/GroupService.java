package com.aikxian.framework.common.TenYun.im.service;

import com.aikxian.framework.common.TenYun.im.IMConfig;
import com.aikxian.framework.common.TenYun.im.IMInterface;
import com.aikxian.framework.common.TenYun.im.model.AuthConfig;
import com.aikxian.framework.common.TenYun.im.req.ReqAddGroupMember;
import com.aikxian.framework.common.TenYun.im.req.ReqChangeGroupOwner;
import com.aikxian.framework.common.TenYun.im.req.ReqCreateGroup;
import com.aikxian.framework.common.TenYun.im.req.ReqDeleteGroupMember;
import com.aikxian.framework.common.TenYun.im.req.ReqDeleteGroupMsgBySender;
import com.aikxian.framework.common.TenYun.im.req.ReqDestroyGroup;
import com.aikxian.framework.common.TenYun.im.req.ReqForbidSendMsg;
import com.aikxian.framework.common.TenYun.im.req.ReqGetGroupInfo;
import com.aikxian.framework.common.TenYun.im.req.ReqGetGroupList;
import com.aikxian.framework.common.TenYun.im.req.ReqGetGroupMemberInfo;
import com.aikxian.framework.common.TenYun.im.req.ReqGetGroupShuttedUin;
import com.aikxian.framework.common.TenYun.im.req.ReqGetJoinedGroupList;
import com.aikxian.framework.common.TenYun.im.req.ReqGetRoleInGroup;
import com.aikxian.framework.common.TenYun.im.req.ReqGroupMsgGetSimple;
import com.aikxian.framework.common.TenYun.im.req.ReqImportGroup;
import com.aikxian.framework.common.TenYun.im.req.ReqImportGroupMember;
import com.aikxian.framework.common.TenYun.im.req.ReqImportGroupMsg;
import com.aikxian.framework.common.TenYun.im.req.ReqModifyGroupBaseInfo;
import com.aikxian.framework.common.TenYun.im.req.ReqModifyGroupMemberInfo;
import com.aikxian.framework.common.TenYun.im.req.ReqSearchGroup;
import com.aikxian.framework.common.TenYun.im.req.ReqSendGroupMsg;
import com.aikxian.framework.common.TenYun.im.req.ReqSendGroupSystemNotification;
import com.aikxian.framework.common.TenYun.im.req.ReqSetUnreadMsgNum;
import com.aikxian.framework.common.TenYun.im.res.ResAddGroupMember;
import com.aikxian.framework.common.TenYun.im.res.ResChangeGroupOwner;
import com.aikxian.framework.common.TenYun.im.res.ResCreateGroup;
import com.aikxian.framework.common.TenYun.im.res.ResDeleteGroupMember;
import com.aikxian.framework.common.TenYun.im.res.ResDeleteGroupMsgBySender;
import com.aikxian.framework.common.TenYun.im.res.ResDestroyGroup;
import com.aikxian.framework.common.TenYun.im.res.ResForbidSendMsg;
import com.aikxian.framework.common.TenYun.im.res.ResGetGroupInfo;
import com.aikxian.framework.common.TenYun.im.res.ResGetGroupList;
import com.aikxian.framework.common.TenYun.im.res.ResGetGroupMemberInfo;
import com.aikxian.framework.common.TenYun.im.res.ResGetGroupShuttedUin;
import com.aikxian.framework.common.TenYun.im.res.ResGetJoinedGroupList;
import com.aikxian.framework.common.TenYun.im.res.ResGetRoleInGroup;
import com.aikxian.framework.common.TenYun.im.res.ResGroupMsgGetSimple;
import com.aikxian.framework.common.TenYun.im.res.ResImportGroup;
import com.aikxian.framework.common.TenYun.im.res.ResImportGroupMember;
import com.aikxian.framework.common.TenYun.im.res.ResImportGroupMsg;
import com.aikxian.framework.common.TenYun.im.res.ResModifyGroupBaseInfo;
import com.aikxian.framework.common.TenYun.im.res.ResModifyGroupMemberInfo;
import com.aikxian.framework.common.TenYun.im.res.ResSearchGroup;
import com.aikxian.framework.common.TenYun.im.res.ResSendGroupMsg;
import com.aikxian.framework.common.TenYun.im.res.ResSendGroupSystemNotification;
import com.aikxian.framework.common.TenYun.im.res.ResSetUnreadMsgNum;

/**
 * 群组服务接口
 * 
 * @author 张晓宇
 *
 */
public class GroupService extends BaseService {

	public GroupService(AuthConfig authConfig) {
		this.authConfig = authConfig;
	}

	private AuthConfig authConfig;

	/**
	 * 获取群组列表
	 * 
	 * @param groupList
	 * @return
	 */
	public ResGetGroupList getGroupList(ReqGetGroupList groupList) {
		String reqUrl = IMConfig.REQURL + IMInterface.GET_APPID_GROUP_LIST;
		return reqIMInterface(authConfig, reqUrl, groupList, ResGetGroupList.class);
	}

	/**
	 * 创建群组
	 * 
	 * @param createGroup
	 * @return
	 */
	public ResCreateGroup createGroup(ReqCreateGroup createGroup) {
		String reqUrl = IMConfig.REQURL + IMInterface.CREAT_GROUP;
		return reqIMInterface(authConfig, reqUrl, createGroup, ResCreateGroup.class);
	}

	/**
	 * 获取群组信息
	 * 
	 * @param getGroupInfo
	 * @return
	 */
	public ResGetGroupInfo getGroupInfo(ReqGetGroupInfo getGroupInfo) {
		String reqUrl = IMConfig.REQURL + IMInterface.GET_GROUP_INFO;
		return reqIMInterface(authConfig, reqUrl, getGroupInfo, ResGetGroupInfo.class);
	}

	/**
	 * 获取群组成员信息
	 * 
	 * @param getGroupMemberInfo
	 * @return
	 */
	public ResGetGroupMemberInfo getGroupMemberInfo(ReqGetGroupMemberInfo getGroupMemberInfo) {
		String reqUrl = IMConfig.REQURL + IMInterface.GET_GROUP_MEMBER_INFO;
		return reqIMInterface(authConfig, reqUrl, getGroupMemberInfo, ResGetGroupMemberInfo.class);
	}

	/**
	 * 修改群组基本信息
	 * 
	 * @param groupBaseInfo
	 * @return
	 */
	public ResModifyGroupBaseInfo getModifyGroupBaseInfo(ReqModifyGroupBaseInfo groupBaseInfo) {
		String reqUrl = IMConfig.REQURL + IMInterface.MODIFY_GROUP_BASE_INFO;
		return reqIMInterface(authConfig, reqUrl, groupBaseInfo, ResModifyGroupBaseInfo.class);
	}

	/**
	 * 增加群组成员接口
	 * 
	 * @param addGroupMember
	 * @return
	 */
	public ResAddGroupMember addGroupMember(ReqAddGroupMember addGroupMember) {
		String reqUrl = IMConfig.REQURL + IMInterface.ADD_GROUP_MEMBER;
		return reqIMInterface(authConfig, reqUrl, addGroupMember, ResAddGroupMember.class);
	}

	/**
	 * 删除群组成员接口
	 * 
	 * @param deleteGroupMember
	 * @return
	 */
	public ResDeleteGroupMember deleteGroupMember(ReqDeleteGroupMember deleteGroupMember) {
		String reqUrl = IMConfig.REQURL + IMInterface.DELETE_GROUP_MEMBER;
		return reqIMInterface(authConfig, reqUrl, deleteGroupMember, ResDeleteGroupMember.class);
	}

	/**
	 * 修改群组成员信息
	 * 
	 * @param groupMember
	 * @return
	 */
	public ResModifyGroupMemberInfo modifyGroupMember(ReqModifyGroupMemberInfo groupMember) {
		String reqUrl = IMConfig.REQURL + IMInterface.MODIFY_GROUP_MEMBER_INFO;
		return reqIMInterface(authConfig, reqUrl, groupMember, ResModifyGroupMemberInfo.class);
	}

	/**
	 * 解散群组
	 * 
	 * @param destroyGroup
	 * @return
	 */
	public ResDestroyGroup destroyGroup(ReqDestroyGroup destroyGroup) {
		String reqUrl = IMConfig.REQURL + IMInterface.DESTROY_GROUP;
		return reqIMInterface(authConfig, reqUrl, destroyGroup, ResDestroyGroup.class);
	}

	/**
	 * 获取用户所加入的群组
	 * 
	 * @param groupList
	 * @return
	 */
	public ResGetJoinedGroupList getJoinedGroupList(ReqGetJoinedGroupList groupList) {
		String reqUrl = IMConfig.REQURL + IMInterface.GET_JOINED_GROUP_LIST;
		return reqIMInterface(authConfig, reqUrl, groupList, ResGetJoinedGroupList.class);
	}

	/**
	 * 查询用户在群组中的身份
	 * 
	 * @param group
	 * @return
	 */
	public ResGetRoleInGroup getRoleInGroup(ReqGetRoleInGroup group) {
		String reqUrl = IMConfig.REQURL + IMInterface.GET_ROLE_IN_GROUP;
		return reqIMInterface(authConfig, reqUrl, group, ResGetRoleInGroup.class);
	}

	/**
	 * 批量禁言和取消禁言
	 * 
	 * @param forbidSendMsg
	 * @return
	 */
	public ResForbidSendMsg forbidSendMsg(ReqForbidSendMsg forbidSendMsg) {
		String reqUrl = IMConfig.REQURL + IMInterface.FORBID_SEND_MSG;
		return reqIMInterface(authConfig, reqUrl, forbidSendMsg, ResForbidSendMsg.class);
	}

	/**
	 * 获取群组被禁言用户列表
	 * 
	 * @param groupShuttedUin
	 * @return
	 */
	public ResGetGroupShuttedUin getGroupShuttedUin(ReqGetGroupShuttedUin groupShuttedUin) {
		String reqUrl = IMConfig.REQURL + IMInterface.FORBID_SEND_MSG;
		return reqIMInterface(authConfig, reqUrl, groupShuttedUin, ResGetGroupShuttedUin.class);
	}

	/**
	 * 在群组发送消息
	 * 
	 * @param groupMsg
	 * @return
	 */
	public ResSendGroupMsg sendGroupMsg(ReqSendGroupMsg groupMsg) {
		String reqUrl = IMConfig.REQURL + IMInterface.SEND_GROUP_MSG;
		return reqIMInterface(authConfig, reqUrl, groupMsg, ResSendGroupMsg.class);
	}

	/**
	 * 发送群组系统消息
	 * 
	 * @param groupSystemNotification
	 * @return
	 */
	public ResSendGroupSystemNotification sendGroupSystemNotification(
			ReqSendGroupSystemNotification groupSystemNotification) {
		String reqUrl = IMConfig.REQURL + IMInterface.SEND_GROUP_SYSTEM_NOTIFICATION;
		return reqIMInterface(authConfig, reqUrl, groupSystemNotification, ResSendGroupSystemNotification.class);
	}

	/**
	 * 转让群主
	 * 
	 * @param changeGroupOwner
	 * @return
	 */
	public ResChangeGroupOwner changeGroupOwner(ReqChangeGroupOwner changeGroupOwner) {
		String reqUrl = IMConfig.REQURL + IMInterface.CHANGE_GROUP_OWNER;
		return reqIMInterface(authConfig, reqUrl, changeGroupOwner, ResChangeGroupOwner.class);
	}

	/**
	 * 导入群基础资料
	 * 
	 * @param group
	 * @return
	 */
	public ResImportGroup importGroup(ReqImportGroup group) {
		String reqUrl = IMConfig.REQURL + IMInterface.IMPORT_GROUP;
		return reqIMInterface(authConfig, reqUrl, group, ResImportGroup.class);
	}

	/**
	 * 导入群消息
	 * 
	 * @param groupMsg
	 * @return
	 */
	public ResImportGroupMsg importGroupMsg(ReqImportGroupMsg groupMsg) {
		String reqUrl = IMConfig.REQURL + IMInterface.IMPORT_GROUP_MSG;
		return reqIMInterface(authConfig, reqUrl, groupMsg, ResImportGroupMsg.class);
	}

	/**
	 * 导入群成员
	 * 
	 * @param importGroupMember
	 * @return
	 */
	public ResImportGroupMember importGroupMember(ReqImportGroupMember importGroupMember) {
		String reqUrl = IMConfig.REQURL + IMInterface.IMPORT_GROUP_MEMEBR;
		return reqIMInterface(authConfig, reqUrl, importGroupMember, ResImportGroupMember.class);
	}

	/**
	 * 设置群成员未读消息数
	 * 
	 * @param unreadMsgNum
	 * @return
	 */
	public ResSetUnreadMsgNum setUnreadMsgNum(ReqSetUnreadMsgNum unreadMsgNum) {
		String reqUrl = IMConfig.REQURL + IMInterface.SET_UNREAD_MSG_NUM;
		return reqIMInterface(authConfig, reqUrl, unreadMsgNum, ResSetUnreadMsgNum.class);
	}

	/**
	 * 删除指定用户发送的消息
	 * 
	 * @param deleteGroupMsgBySender
	 * @return
	 */
	public ResDeleteGroupMsgBySender deleteGroupMsgBySender(ReqDeleteGroupMsgBySender deleteGroupMsgBySender) {
		String reqUrl = IMConfig.REQURL + IMInterface.DELETE_GROUP_MSG_BY_SENDER;
		return reqIMInterface(authConfig, reqUrl, deleteGroupMsgBySender, ResDeleteGroupMsgBySender.class);
	}

	/**
	 * 搜索群组
	 * 
	 * @param searchGroup
	 * @return
	 */
	public ResSearchGroup searchGroup(ReqSearchGroup searchGroup) {
		String reqUrl = IMConfig.REQURL + IMInterface.SEARCH_GROUP;
		return reqIMInterface(authConfig, reqUrl, searchGroup, ResSearchGroup.class);
	}

	/**
	 * 拉取群漫游消息
	 * 
	 * @param msgGetSimple
	 * @return
	 */
	public ResGroupMsgGetSimple groupMsgGetSimple(ReqGroupMsgGetSimple msgGetSimple) {
		String reqUrl = IMConfig.REQURL + IMInterface.GROUP_MSG_GET_SIMPLE;
		return reqIMInterface(authConfig, reqUrl, msgGetSimple, ResGroupMsgGetSimple.class);
	}
}
