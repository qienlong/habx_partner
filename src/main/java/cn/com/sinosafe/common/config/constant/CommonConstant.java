package cn.com.sinosafe.common.config.constant;
/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 全局常量配置
 * @Author	: hesong
 * @Date	: 2018年12月26日 上午9:15:03
 * @Version	: 1.0
 */
public class CommonConstant {

	/**
	 * 成功：SUCCESS
	 */
	public static final String SUCCESS = "SUCCESS";
	
	/**
	 * 缺失：DELETION
	 */
	public static final String DELETION = "DELETION";
	
	/**
	 * 失败：FAIL
	 */
	public static final String FAIL = "FAIL";
	
	/**
	 * 文件路径分隔符：/
	 */
	public static final String PATH_SEPARATOR = "/";
	
	/**
	 * 参数校验提示语：不能为空
	 */
	public static final String CHECK_PARAM = "不能为空";
	
	/**
     * 基本数据，包括token缓存时间：7天
     */
    public static final long CACHE_BASE_TIME = 7 * 24 * 60 * 60;
    
    /**
     * 失败重试次数：2
     */
    public static final int FAILURECOUNT_2 = 2;
    
    
    /**
     * 华安核对三要素成功
     */
    public static final String HUAAN_APPROVE = "00";
    
    /**
     * 核保通过
     */
    public static final String CHECK_SUCCESS = "0000";
    
    /**
     * 核保拒绝
     */
    public static final String CHECK_REJECT = "9999";

    /**
     * 审批通过
     */
    public static final String APPROVAL_SUCCESS = "997";

    /**
     * 审批拒绝
     */
    public static final String APPROVAL_REJECT = "998";

    /**
     * 华安核保通过
     */
    public static final String NEW_APPROVAL_SUCCESS = "06";

    /**
     * 华安核保拒绝
     */
    public static final String NEW_APPROVAL_REJECT = "07";

    /**
     * 保费校验通过
     */
    public static final String NEW_RATE_SUCCESS = "08";

    /**
     * 保费校验拒绝
     */
    public static final String NEW_RATE_REJECT = "09";

    /**
     * 审批中
     */
    public static final String APPROVEING = "111";
    
    /**
     * 担保最高金额
     */
    public static final String LimitAmt = "1000000"; 
    
    /**
     * 字符编码：UTF-8
     */
    public static final String CHARSET_UTF8 = "UTF-8";
    
    /**
     * 字符编码：GBK
     */
    public static final String CHARSET_GBK = "GBK";
}
