package com.ibm.common.utils;


/**
 * 
 * 〈一句话功能简述〉<br>
 * 会员系统常量类
 * 
 * @author jag
 */
/**
 * @author ibmshixianbing
 *
 */
/**
 * @author ibmshixianbing
 *
 */
public class MemberConstant {
	
	/**
	 * 省市区查询类型：省份
	 */
	public final static String AREAS_TYPE_PROVINCE = "1";	
	
	/**
	 * 省市区查询类型：市
	 */
	public final static String AREAS_TYPE_CITY = "2";
	
	
	/**
	 * 省市区查询类型：区
	 */
	public final static String AREAS_TYPE_AREA = "3";	
	
	/**
	 * 登陆类型-邮箱
	 */
	public final static String LOGIN_TYPE_EMAIL = "email";
	
	/**
	 * 登陆类型-手机
	 */
	public final static String LOGIN_TYPE_MOBILE = "mobile";
	
	/**
	 * 登陆类型-登陆账号
	 */
	public final static String LOGIN_TYPE_LOGINCODE = "loginCode";	
	
	/**
	 * 会员登录类型：账号登陆
	 */
	public final static int LOGINTYPE_CODE = 1;
	
	/**
	 * 会员登录类型：手机号登陆
	 */	
	public final static int LOGINTYPE_MOBILE = 2;
	
	/**
	 * 会员登录类型：email登陆
	 */		
	public final static int LOGINTYPE_EMAIL = 3;
	
	
	/**
	 * 会员登录类型：卡号登陆
	 */	
	public final static int LOGINTYPE_CARD = 4;
	
	/**
	 * 默认登陆超时时间
	 */
	public final static String DEFAULT_EXPIRE = "86400";
	
	
    /**
     * 分隔符
     */
	public final static String REDIS_SEPARATOR = "|";
	
	/**
	 * 登陆账号与密码 redis缓存前缀
	 */
	public final static String REDIS_PREFIX_LOGIN = "acc";

	/**
	 * 登陆账号与密码 redis缓存前缀
	 */
	public final static String REDIS_PREFIX_LOGIN_ERROR_TIMES = "let";

	/**
	 * 三网合一登陆账号与密码错误次数 redis缓存前缀
	 */
	public final static String REDIS_PREFIX_WEB_LOGIN_ERROR_TIMES = "wlet";
	
	/**
	 * 登陆后用户member_access标识与id对应 缓存前缀
	 */
	public final static String REDIS_PREFIX_TOKEN = "id";	 
	
	/**
	 * 第三方id与会员信息对应 缓存前缀
	 */
	public final static String REDIS_PREFIX_THIRD = "thirdPartyId";
	
	/**
	 * 用户基本信息 缓存前缀
	 */
	public final static String REDIS_PREFIX_BASEINFO = "mb";	
	
	/**
	 * 短信验证码登陆验证码信息 缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSCODE_LOGIN = "msglg";
	
	/**
	 * 短信验证码登陆验证码信息 缓存前缀
	 */
	public final static String REDIS_PREFIX_EMAIL_VALIDCODE = "emvcode";
	
	/**
	 * 短信验证码注册验证码信息 缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSCODE_REGISTER = "msgrg";
	
	
	/**
	 * 短信验证码注册验证码信息 缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSCODE_VERFITY = "msgVerfity";
	
	/**
	 * 短信验证码找回密码验证码信息 缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSCODE_FINDPWD = "msgfp";	
	
	
	/**
	 * 邮件找回密码，标识串与用户身份对应  缓存前缀
	 */
	public final static String REDIS_PREFIX_emall_FINDPWD = "emailfp";	
	
	
	/**
	 * 短信验证码绑定业态卡  缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSCODE_BINDCARD = "msgbk";		
	
	
	/**
	 * 手机号与业态卡号对应关系  缓存前缀
	 */
	public final static String REDIS_PREFIX_PHONE_CARD = "mpbk";	
	
	/**
	 * 业态门店id+业态卡号与卡基本信息对应  缓存前缀
	 */
	public final static String REDIS_PREFIX_STORE_CARD = "storecard";		
	
	/**
	 * 会员验证问题 缓存前缀
	 */
	public final static String REDIS_PREFIX_QUEST_QUERY = "questquery";
	
	/**
	 * 二维码 缓存前缀
	 */
	public final static String REDIS_PREFIX_DIM_CODE = "dimcode";

	
	/**
	 * 可绑定卡列表  缓存前缀
	 */
	public final static String REDIS_ABLE_BIND_CARD_LIST = "ablebindcardlist";
	
	
	/**
	 * 手机绑定 短信验证码 缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSCODE_MOBILEBING = "mobilebing";	
	
	/**
	 * 更新车牌号短信验证码 缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSCODE_UPDATECARLC = "carlicense";		
	
	/**
	 * 短信邮件模板 缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSEMAIL_TEMPLATE = "smsemailtemplate";	
	
	
	/**
	 * 邮寄地址 缓存前缀
	 */
	public final static String REDIS_PREFIX_MAILADDRESS = "mailaddress";		
	
	/**
	 * 短信验证码登陆验证码信息 缓存前缀
	 */
	public final static String REDIS_PREFIX_SMSCODE_COMMON = "common";	
	/**
	 * 设置支付密码token
	 */
	public final static String REDIS_PREFIX_SET_PAYPASS_MSG="paypass_msg";
	/**
	 *  门店法人关系
	 */
	public final static String REDIS_PREFIX_STORE_ORG = "cache_member_store_org";
	/**
	 * 会员有效期和年费规则
	 */
	public final static String REDIS_PREFIX_VALID_FEE_RULE = "cache_member_valid_fee_rule";
	/**
	 * 会员积分规则
	 */
	public final static String REDIS_PREFIX_INTEGRAL_RULE = "cache_member_integral_rule";
	/**
	 * 会员等级规则
	 */
	public final static String REDIS_PREFIX_LEVEL_RULE = "cache_member_level_rule";
	/**
	 * 会员预制积分规则
	 */
	public final static String REDIS_PREFIX_DELIVERY_INTEGRAL_RULE = "cache_member_delivery_integral_rule";
	/**
	 * 法人规则
	 */
	public final static String REDIS_PREFIX_SYS_INSTITUION = "cache_sys_institution";
	/**
	 *会员ip地址
	 */
	public final static String REDIS_PREFIX_MEMBER_IP = "cache_member_ip";
	/**
	 *会员注册
	 */
	public final static String REDIS_PREFIX_MEMBER_REGIST = "cache_member_regist";
	
	/**
	 * 邮箱绑定状态-未验证
	 */
	public final static Integer EMAILBINDFLAG_UNVERIFIED = 0;
	
	/**
	 * 邮箱绑定状态-已验证
	 */
	public final static Integer EMAILBINDFLAG_VERIFIED = 1;	
	
	public final static String WEIXIN_THIRD__LOGINTYPE_CODE = "code";	
	
	public final static String WEIXIN_THIRD__LOGINTYPE_PWD = "pwd";		
	
	
	/**
	 * 短信发送接口 url
	 */
	public final static String SMS_SEND_URL= "http://mapi.blemall.com";
	
	/**
	 * 短信发送接口 context method
	 */
	public final static String SMS_SEND_METHOD= "mreg/sendMessage";
	
	/**
	 * 邮件发送接口 context method
	 */
	public final static String EMAIL_SEND_METHOD= "mail/sendemail";	
	
	/**
	 * 邮件模板code
	 */
	public final static String TEMPLATE_EMAIL_CODE= "mbemail";	
	
	/**
	 * 短信模板code
	 */
	public final static String TEMPLATE_SMS_CODE= "smscode";
	
	public final static String TEMPLATE_GAME_NEWLUCK= "luckyNewMember";
	public final static String  TEMPLATE_GAME_OLDLUCK = "luckyOldMember";
	public final static String TEMPLATE_GAME_NEWUNLUCK= "notLuckyNewMember";
	public final static String TEMPLATE_GAME_OLDUNLUCK= "notLuckyOldMember";
	
	/**
	 * member_token与access_token redis缓存前缀
	 */
	public final static String REDIS_PREFIX_ACCESS_TOKEN = "accesstoken";	
	
	/**
	 * redis缓存前缀
	 */
	public final static String REDIS_PREFIX_PWD_VALIDATE = "changepwdflag";		
	
	/**
	 * 分发给客户端应用的ID号
	 */
	public final static String SMS_SEND_CLIENTID ="11125";// 测试id: "10000"; // 正式id："11125";
	
	/**
	 * 短信发送接口分配的密钥
	 */
	public final static String SMS_SEND_CLIENT_SECRET ="dda26438a3ae4177ba765ee41433a0b0";// 测试秘钥： "405d3579f69ea2361bf5e51bf4b65276";//正式的秘钥： "dda26438a3ae4177ba765ee41433a0b0";
	
	public final static String SMS_SEND_STATUS_SUCCESS= "200";
	
	
	/**
	 * 三网合一：华润股份
	 */
	public final static String channelType_JT= "1";
	
	/**
	 * 三网合一：华润电商
	 */
	public final static String channelType_BE= "2";
	
	/**
	 * 三网合一：联华易购
	 */	
	public final static String channelType_LH= "3";
	
	/**
	 * 第三方账号包括 1微信，2微博，3qq，4支付宝  ，5人人网，6ecp账号， 7华润e城， 8联华易购 9魔都生活卡,10平安万里通,11上汽安悦商城
	 */
	public final static String THIRD_PART_TYPE_WEIXIN = "1";
	
	public final static String THIRD_PART_TYPE_WEIBO = "2";
	
	public final static String THIRD_PART_TYPE_QQ = "3";	
	
	public final static String THIRD_PART_TYPE_ALIPAY = "4";
	
	public final static String THIRD_PART_TYPE_RENREN = "5";
	
	public final static String THIRD_PART_TYPE_ECP = "6";
	
	public final static String THIRD_PART_TYPE_BLEC = "7";
	
	public final static String THIRD_PART_TYPE_LHEG = "8";
	
	public final static String THIRD_PART_TYPE_MODU = "9";
	
	public final static String THIRD_PART_TYPE_WANLITONG = "10";
	
	public final static String THIRD_PART_TYPE_ANYUE = "11";
	/**
	 * 客户性质:01为内部用户
	 */
	public final static String CUST_TYPE_INNER= "01";
	
	/**
	 * 客户性质:02为外部用户
	 */
	public final static String CUST_TYPE_OUTNER= "02";
	
	
	/**
	 * 状态：可用
	 */
	public final static String STATUS_AVAIABLE  = "0";
	

	/**
	 * 状态：不可用
	 */
	public final static String STATUS_NOT_AVAIABLE = "1";	
	

	/**
	 * 状态：不可用
	 */
	public final static String STATUS_NOT_CANCEL = "2";	
	
	/**
	 * 门店预约状态：到店状态
	 */
	public final static String STATUS_ARRIVED = "2";
	
	/**
	 * 注册渠道：APP
	 */	
	public final static String CHANEL_APP = "1";
	
	/**
	 * 注册渠道：微信
	 */		
	public final static String CHANEL_WEIXIN = "2";		
	
	/**
	 * 注册渠道：PC电商
	 */
	public final static String CHANEL_EMALL = "3";

	/**
	 * 注册渠道：电子屏(大屏)
	 */	
	public final static String CHANEL_DIANZIPIN = "4";
	
	/**
	 * 注册渠道：社区(时趣)
	 */		
	public final static String CHANEL_SHIQU = "5";	
	
	
	/**
	 * 线下pos
	 */
	public final static String CHANEL_OFFLINE = "6";
	/**
	 * 名品
	 */
	public final static String CHANEL_MINGPIN = "7";	
		
	/**
	 * 注册渠道：合作伙伴
	 */	
	public final static String CHANEL_PARTNER = "20";
	/**
	 * social
	 */
	public final static String CHANEL_SOCIAL = "8";
	
	
	public final static String CREATOR_CUSTOMER = "customer";
	
	/**
	 * 中台：赢促销系统
	 */
	public final static String  SYSID_MID_PROMOTION= "1000";	
	
	/**
	 * 社区系统标识
	 */
	public final static String  SYSID_SHIQU= "1101";
	
	/**
	 * 电商系统标识
	 */
	public final static String  SYSID_PC= "1102";
	
	/**
	 * app系统标识
	 */
	public final static String  SYSID_APP= "1103";
	
	/**
	 * 微信系统标识
	 */
	public final static String  SYSID_WEIXIN= "1104";
	
	/**
	 * 电子屏
	 */
	public final static String  SYSID_DZP= "1105";	
	
	/**
	 * APP的消息推送系统
	 */
	public final static String  SYSID_APPMESSEND= "1106";	
	
	/**
	 * 支付中台
	 */
	public final static String  SYSID_PAYCENTER= "1107";		
	
	/**
	 * 名品
	 */
	public final static String SYSID_MINGPIN = "1108";	
	/**
	 * 商户app
	 */
	public final static String  SYSID_SELLER_APP= "2101";	
	
	/**
	 * 导购APP
	 */
	public final static String  SYSID_guide_APP= "2102";

	/**
	 * 魔都生活卡
	 */
	public final static String  SYSID_MODU_CARD= "2103";
	
	/**
	 * 登陆验证失败锁定时长(30分钟)
	 */
	public final static int  redisExpireSeconds= 1800;	
	
	/**
	 * 重置秘密锁定时长(2分钟)
	 */
	public final static int  redisExpireSeconds_resetPassword= 120;		
	
	/**
	 * 重置秘密锁定时长(2分钟)
	 */
	public final static int  redisExpireSeconds_emallvalidateCode= 7200;	
	
	
	public final static String DELETEYTPE_ALL ="all";   
	
	public final static String DELETEYTPE_PART ="part";  	
	
	public final static String paymentType_cell = "06";
	
	
	public final static String businessId_ecomerce= "3000";
	
	/**
	 * 新会员注册
	 */
	public final static String eventTypeId_register= "2021";
	

	/**
	 * 会员登陆
	 */
	public final static String eventTypeId_login= "2022";
	
	/**
	 * 线下会员签到
	 */
	public final static String eventTypeId_checkIn= "2041";
	
	/**
	 * 线上会员签到
	 */
	public final static String eventTypeId_online_checkIn="2141";
	
	public final static String memberlevelCode_normal= "10";
	
	public final static String memberlevelName_SVIP= "SVIP";
	
	public static final  String BAR_CODE_PREFIX="uid:";
	
	public final static String BAR_CODE_SPLIT=";";
	
	/***
	 * 用户登陆方式
	 */
	public static final String LOGIN_MODEL_CELLPHONE="0";
	
	public static final String LOGIN_MODEL_EMAIL="1";
	
	public static final String LOGIN_MODEL_CARD="2";
	
	public static final String LOGIN_MODEL_CODE="3";
	public static final String CheckId = "checkId";

    /**
     * 手机号进行AES加密
     */
    public static final String PHONE_DESKEY = "cf9e8e17f6f4bc90079a218944b8fb28";
    
    
    public static final String MEMBER_REISSUE_CARD="reissue";//补发会员卡
    
    public final static String REDIS_MOBILE_UPDSATE = "mobileupd";//会员手机号码变更
    
    public final static String REDIS_NEW_MOBILE= "newmobile";//会员新手机号码

	public static final String REDIS_LOSECARD_MOBILE = "lose";//卡挂失
	
	public static final String REDIS_MEMBRE_MERGERA = "megerA";//会员合并

	public static final String REDIS_MEMBRE_MERGERB = "megerB";//会员合并
	
	
	
	/**
	 * 会员服务请求  服务类型 
	 * start
	 */
	//入会
	public static String SYS_SERVICE_TYPE_1="1";
	//会员到期
	public static String SYS_SERVICE_TYPE_2="2";
	//会员延期
	public static String SYS_SERVICE_TYPE_3="3";
	//会员信息变更
	public static String SYS_SERVICE_TYPE_4="4";
	//会员合并
	public static String SYS_SERVICE_TYPE_5="5";
	//挂失卡
	public static String SYS_SERVICE_TYPE_6="6";
	//补办卡
	public static String SYS_SERVICE_TYPE_7="7";
	//标记黑名单
	public static String SYS_SERVICE_TYPE_8="8";
	//黑名单解除
	public static String SYS_SERVICE_TYPE_9="9";
	//积分兑换
	public static String SYS_SERVICE_TYPE_10="10";
	//建议
	public static String SYS_SERVICE_TYPE_11="11";
	//投诉
	public static String SYS_SERVICE_TYPE_12="12";
	//消费加入黑名单
	public static String SYS_SERVICE_TYPE_13="13";
	//发卡
	public static String SYS_SERVICE_TYPE_14="14";
	
	//END
	
	
}
