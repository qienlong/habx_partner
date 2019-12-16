package cn.com.sinosafe.common.config.constant;
/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 全局常量配置
 * @Author	: hesong
 * @Date	: 2018年12月26日 上午9:15:03
 * @Version	: 1.0
 */
public class PadbConstant {
    
    /**
     * 平安普惠行业企业编码
     */
    public static final String PAPH_ENTERPRISECODE = "PAPH";
    
    /**
     * 系统名称
     */
    public static final String PADB_SYSTEM = "haxb_partner";
    
    /**
	 * 平安保单信息同步http请求地址
	 */
	public static final String FCFPBX1005="http://172.18.243.147:44632/fcfpdmz/webservice/fcfpPolicyInfoSync.do";
	
	/**
	 * 平安投保通知信息http请求地址
	 */
	public static final String FCFPBX3006="";
	
	/**
	 * 平安下载通知http请求地址
	 */
	public static final String FCFPBX1004="http://172.18.243.147:44632/fcfpdmz/webservice/fcfpPolicyDownloadNotice.do";
	
	/**
	 * 对公费用确认
	 */
	public static final String FCFPBX2004="http://172.18.243.147:44632/fcfpdmz/webservice/fcfpCorporateFeeConfirm.do";
	
	/**
	 * 核保确认
	 */
	public static final String FCFPBX1001B="http://172.18.243.147:44632/fcfpdmz/webservice/fcfpUnderWritingConfirm.do";
	
	/**
	 * 保费率下发
	 */
	public static final String FCFPBX1000="http://172.18.243.147:44632/fcfpdmz/webservice/fcfpPremiumRatePush.do";

    
    
}
