package cn.com.sinosafe.common.config.constant;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 响应信息定义
 * @Author	: hesong
 * @Date	: 2018年12月29日 上午11:28:20
 * @Version	: 1.0
 */
public class RspMsgConstant {

	/**
	 * 失败
	 */
	public static final int FAIL = 0;
	
	/**
	 * 操作失败消息
	 */
	public static final String FAIL_MSG = "操作异常！";
	
	/**
	 * 成功
	 */
	public static final int SUCCESS = 1;
	
	/**
	 * 操作成功消息
	 */
	public static final String SUCCESS_MSG = "操作成功！";
	
	/**
     * 参数错误: 一般是缺少或参数值不符合要求
     */
    public static final int ARGUMENT_ERROR = 2;
    
    /**
     * 参数错误提示: 参数异常
     */
    public static final String ARGUMENT_ERRORMSG = "参数异常！";
    
    /**
     * 参数错误提示: 文件大小不一致
     */
    public static final String FILESIZE_ERROR = "文件大小不一致！";
    
    /**
     * 参数错误提示: 文件名称不合法
     */
    public static final String FILENAME_ERROR = "文件名称不合法！";
    
    /**
     * 参数错误提示: 手机号码格式有误
     */
    public static final String MOBILE_ILLEGAL = "手机号码格式有误！";
    
    /**
     * 参数错误提示: 身份证号码格式有误
     */
    public static final String IDNUM_ILLEGAL = "身份证号码格式有误！";
    
    /**
     * 操作失败提示: 文件上传失败
     */
    public static final String UPLOAD_FAIL = "文件上传失败！";
    
    /**
     * 系统错误提示: OSS下载文件失败
     */
    public static final String OSSDOWN_ERROR = "文件下载失败，请稍后重试！";
    
    /**
     * 系统错误提示: 影像系统上传文件失败
     */
    public static final String FILEUP_ERROR = "文件上传失败，请稍后重试！";
    
    
}
