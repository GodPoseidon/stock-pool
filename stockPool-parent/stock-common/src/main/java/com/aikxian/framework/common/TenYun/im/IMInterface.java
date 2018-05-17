package com.aikxian.framework.common.TenYun.im;
/**
 * v4版本云通讯接口
 * @author 张晓宇
 *
 */
public class IMInterface {

	/**
	 * 独立模式帐号导入
	 */
	public static final String ACCOUNT_IMPORT = "v4/im_open_login_svc/account_import";
	
	/**
	 * 独立模式帐号批量导入
	 */
	public static final String MULTI_ACCOUNT_IMPORT = "v4/im_open_login_svc/multiaccount_import";
	
	/**
	 * 托管模式帐号导入
	 */
	public static final String REGISTER_ACCOUNT = "v4/registration_service/register_account_v1";
	
	/**
	 * 失效帐号登录态
	 */
	public static final String KICK_ACCOUNT = "v4/im_open_login_svc/kick";
	
	
	/**
	 * 单发单聊消息
	 */
	public static final String SEND_MSG = "v4/openim/sendmsg";
	
	/**
	 * 批量发单聊消息
	 */
	public static final String BATCH_SEND_MSG = "v4/openim/batchsendmsg";
	
	/**
	 * 导入单聊消息
	 */
	public static final String IMPORT_MSG = "v4/openim/importmsg";
	
	/**
	 * 推送
	 */
	public static final String IM_PUSH = "v4/openim/im_push";
		
	/**
	 * 获取推送报告
	 */
	public static final String IM_GET_PUSH_REPORT = "v4/openim/im_get_push_report";
	
	/**
	 * 设置应用属性名称
	 */
	public static final String IM_SET_ATTR_NAME = "v4/openim/im_set_attr_name";
	
	/**
	 * 获取应用属性名称
	 */
	public static final String IM_GET_ATTR_NAME = "v4/openim/im_get_attr_name";
	
	/**
	 * 设置用户属性
	 */
	public static final String IM_SET_ATTR = "v4/openim/im_set_attr";
	
	/**
	 * 删除用户属性
	 */
	public static final String IM_REMOVE_ATTR = "v4/openim/im_remove_attr";
	
	/**
	 * 获取用户属性
	 */
	public static final String IM_GET_ATTR = "v4/openim/im_get_attr";
	
	/**
	 * 添加用户标签
	 */
	public static final String IM_ADD_TAG = "v4/openim/im_add_tag";
	
	/**
	 * 删除用户标签
	 */
	public static final String IM_REMOVE_TAG = "v4/openim/im_remove_tag";
	
	/**
	 * 删除用户所有标签
	 */
	public static final String IM_REMOVE_ALL_TAG = "v4/openim/im_remove_all_tags";
	
	/**
	 * 获取APP中的所有群组
	 */
	public static final String GET_APPID_GROUP_LIST = "v4/group_open_http_svc/get_appid_group_list";
	
	/**
	 * 创建群组
	 */
	public static final String CREAT_GROUP = "v4/group_open_http_svc/create_group";
	
	/**
	 * 获取群组详细资料
	 */
	public static final String GET_GROUP_INFO = "v4/group_open_http_svc/get_group_info";
	
	/**
	 * 获取群成员详细资料
	 */
	public static final String GET_GROUP_MEMBER_INFO = "v4/group_open_http_svc/get_group_member_info";
	
	/**
	 * 修改群组基础资料
	 */
	public static final String MODIFY_GROUP_BASE_INFO = "v4/group_open_http_svc/modify_group_base_info";
	
	/**
	 * 增加群组成员
	 */
	public static final String ADD_GROUP_MEMBER = "v4/group_open_http_svc/add_group_member";
	
	/**
	 * 删除群组成员
	 */
	public static final String DELETE_GROUP_MEMBER = "v4/group_open_http_svc/delete_group_member";
	
	/**
	 * 修改群组成员资料
	 */
	public static final String MODIFY_GROUP_MEMBER_INFO = "v4/group_open_http_svc/modify_group_member_info";
	
	/**
	 * 解散群组
	 */
	public static final String DESTROY_GROUP = "v4/group_open_http_svc/destroy_group";
	
	/**
	 * 获取用户所加入的群组
	 */
	public static final String GET_JOINED_GROUP_LIST = "v4/group_open_http_svc/get_joined_group_list";
	
	/**
	 * 查询用户在群组中的身份
	 */
	public static final String GET_ROLE_IN_GROUP = "v4/group_open_http_svc/get_role_in_group";
	
	/**
	 * 批量禁言和取消禁言
	 */
	public static final String FORBID_SEND_MSG = "v4/group_open_http_svc/forbid_send_msg";
	
	/**
	 * 获取群组被禁言用户列表
	 */
	public static final String GET_GROUP_SHUTTED_UIN = "v4/group_open_http_svc/get_group_shutted_uin";
	
	/**
	 * 在群组中发送普通消息
	 */
	public static final String SEND_GROUP_MSG = "v4/group_open_http_svc/send_group_msg";
	
	/**
	 * 在群组中发送系统通知
	 */
	public static final String SEND_GROUP_SYSTEM_NOTIFICATION = "v4/group_open_http_svc/send_group_system_notification";
	
	/**
	 * 转让群组
	 */
	public static final String CHANGE_GROUP_OWNER = "v4/group_open_http_svc/change_group_owner";
	
	/**
	 * 导入群基础资料
	 */
	public static final String IMPORT_GROUP = "v4/group_open_http_svc/import_group";
	
	/**
	 * 导入群消息
	 */
	public static final String IMPORT_GROUP_MSG = "v4/group_open_http_svc/import_group_msg ";
	
	/**
	 * 导入群成员
	 */
	public static final String IMPORT_GROUP_MEMEBR = "v4/group_open_http_svc/import_group_member";
	
	/**
	 * 设置成员未读消息计数
	 */
	public static final String SET_UNREAD_MSG_NUM = "v4/group_open_http_svc/set_unread_msg_num";
	
	/**
	 * 删除指定用户发送的消息
	 */
	public static final String DELETE_GROUP_MSG_BY_SENDER = "v4/group_open_http_svc/delete_group_msg_by_sender";
	
	/**
	 * 搜索群组
	 */
	public static final String SEARCH_GROUP = "v4/group_open_http_svc/search_group";
	
	/**
	 * 拉取群漫游消息
	 */
	public static final String GROUP_MSG_GET_SIMPLE = "v4/group_open_http_svc/group_msg_get_simple";
	
	/**
	 * 拉取资料
	 */
	public static final String PORTRAIT_GET = "v4/profile/portrait_get ";
	
	/**
	 * 设置资料
	 */
	public static final String PORTRAIT_SET = "v4/profile/portrait_set";
	
	/**
	 * 添加好友
	 */
	public static final String FRIEND_IMPORT = "v4/sns/friend_import";
	
	/**
	 * 删除好友
	 */
	public static final String FRIEND_DELETE = "v4/sns/friend_delete";
	
	/**
	 * 删除所有好友
	 */
	public static final String FRIEND_DELETE_ALL = "v4/sns/friend_delete_all";
	
	/**
	 * 校验好友
	 */
	public static final String FRIEND_CHECK = "v4/sns/friend_check";
	
	/**
	 * 拉取好友
	 */
	public static final String FRIEND_GET_ALL = "v4/sns/friend_get_all";
	/**
	 * 添加脏字
	 */
	public static final String DIRTY_WORDS_GET = "v4/openim_dirty_words/get";
	/**
	 * 删除脏字
	 */
	public static final String DIRTY_WORDS_ADD = "v4/openim_dirty_words/add";
	
	/**
	 * 删除所有脏字
	 */
	public static final String DIRTY_WORDS_DELETE = "v4/openim_dirty_words/delete";
	
	/**
	 * 消息记录下载
	 */
	public static final String GET_HISTORY = "v4/open_msg_svc/get_history";

	/**
	 * 获取用户在线状态
	 */
	public static final String QUERY_STATE = "v4/openim/querystate";
	
	/**
	 * 设置全局禁言
	 */
	public static final String SET_NO_SPEAK = "v4/openconfigsvr/setnospeaking";
	
	/**
	 * 查询全局禁言
	 */
	public static final String GET_NO_SPEAK = "v4/openconfigsvr/getnospeaking";
	
	
}
