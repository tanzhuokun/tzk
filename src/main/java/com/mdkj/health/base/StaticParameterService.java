package com.mdkj.health.base;

/**
 * 
 * 
 * 描述:静态参数
 *
 * @type_name 类名:StaticParameterService
 * @project_name 项目:HealthPlatform
 */
public interface StaticParameterService {

	static String MODULE_LABLE_REGEX = "\\{pa:model\\}([\\s\\S]*?)\\{/pa:model\\}";//提取模块标签正则
	
	static String SUBFFIX_HTML=".html";//系统访问
	static String SUBFFIX_SHTML=".shtml";//站点访问
	
	static String LOGIN_USER="login_user";
	static String LOGIN_MEMBER="login_member";
	static String LOGIN_COMPANY="login_company";
	static String LOGIN_SHOP="login_shop";
	static String LOGIN_SUPERVISION="login_supervision";
	static String LOGIN_ADMIN="login_admin";
	static String CUR_SITE="cur_site";
	static String RESULT_OK="ok";
	static String RESULT_FAILED="failed";
	static String INVEST_ID="investId";

	static String DATE_FORMAT1="yyyy-MM-dd HH:mm:ss";
	static String DATE_FORMAT2="yyyy年MM月dd日  HH时mm分ss秒";
	static String DATE_FORMAT3="yyyyMMddHHmmss";
	static String DATE_FORMAT4="yyyyMMdd";
	
	static int SHIRO_HASH_ITERATIONS=2;
	
	static int NEWS_BASE_ID=12012;
	
	/******************* 页面大小 *********************/
	static int DEFAULT_PAGE_SIZE=20;
	static int PAGE_SIZE_20=20;
	static int PAGE_SIZE_20_NEXT=21;
	static int PAGE_SIZE_15=15;
	static int PAGE_SIZE_15_NEXT=16;
	static int PAGE_SIZE_10=10;
	static int PAGE_SIZE_10_NEXT=11;
	static int PAGE_SIZE_MAX=100;

	/******************* 日志 *********************/
	static String LOG_TAG="syslog:";
	static String LOG_TOKEN="201509178080";
	
	/******************* 错误提示 *********************/
	static String MESSAGE_MEMBER_NO_ORG="您的会员身份尚未绑定任何组织单位！";
	static String MESSAGE_SERVER_ERROR="服务器开小差了，请稍后再试！";
	

	/**
	 * 用户登录
	 */
	static String LOG_TYPE_LOGIN="用户登录";
	/**
	 * 用户操作
	 */
	static String LOG_TYPE_OPTION="用户操作";
	/**
	 * 用户注册
	 */
	static String LOG_TYPE_REGISTER="用户注册";
	/**
	 * 找回密码
	 */
	static String LOG_TYPE_FINDPWD="找回密码";
	/**
	 * 设置交易密码
	 */
	static String LOG_TYPE_TRACEPWD="设置交易密码";
	/**
	 * 邮箱认证
	 */
	static String LOG_TYPE_EMAIL="邮箱认证";
	/**
	 * 短信发送
	 */
	static String LOG_TYPE_SMS_SEND="短信发送";
	/**
	 * 邮件发送
	 */
	static String LOG_TYPE_MAIL_SEND="邮件发送";
	/**
	 * 通知发送
	 */
	static String LOG_TYPE_NOTICE_SEND="通知发送";

	/**
	 * 页面不存在
	 */
	static String LOG_TYPE_NOTFOUND="页面不存在";

	/**
	 * 服务异常
	 */
	static String LOG_TYPE_EXCEPTION="服务异常";

	
	/**
	 * 日志类型
	 */
	static String[] LOG_OPT={LOG_TYPE_OPTION,LOG_TYPE_LOGIN,LOG_TYPE_REGISTER,LOG_TYPE_FINDPWD,LOG_TYPE_TRACEPWD,LOG_TYPE_EMAIL,LOG_TYPE_SMS_SEND,
			LOG_TYPE_MAIL_SEND,LOG_TYPE_NOTICE_SEND,LOG_TYPE_NOTFOUND,LOG_TYPE_EXCEPTION};
}
