package cn.com.sinosafe.common.util;

import org.springframework.util.StringUtils;



/**
 * 工保网常量
 *
 */
public class GBCNConstant {
	//投保
	public static final String INSURE_REQUEST = "insureRequest";
	//理赔
	public static final String CLAIMl_REQUEST = "claimRequest";
	//批改
	public static final String CORRECT_REQUEST = "correctRequest";
	//发票申请
	public static final String INVOICE_REQUEST = "invoiceRequest";
	//退保
	public static final String SURREND_REQUEST = "surrendRequest";
	//支付回调接口
	public static final String PAY_CALLBACK = "payCallBack";
	//电子保单回调接口
	public static final String INSURANCE_CALLBACK = "insuranceCallBack";
	//批改保函回调
	public static final String CORRECT_CALLBACK = "correctCallBack";
	//发送快递接口
    public static final String SEND_INVOICE = "sendInvoice";
    //发送退保回执接口
    public static final String SEND_SURREND = "sendSurrend";
	//发票申请定时任务
//	public static final String INVOICE_RECEIPT_JOB = "invoiceReceiptJob";
	//退保定时任务
//	public static final String SURREND_RECEIPT_JOB = "surrendReceiptJob";
	//调用核心出单key
	public static final String CENTRE_KEY = "bcacfbdb-1fbc-4757-87ed-3f8719e1d2da";
	//系统名称
	//public static final String SYSTEM_NAME = "HAXB-Rest-Partner";
	//客户经理
//	public static final String CUST_MANAGER_CODE = "101068678";
//	//客户经理姓名
//	public static final String CUST_MANAGER_NAME = "余相斌";
//	//客户经理电话
//	public static final String CUST_MANAGER_PHONE = "17722692539";
//	//客户经理所属机构
//	public static final String CUST_MANAGER_ORG = "01680003";
//	
//	//客户经理
//	public static final String CUST_MANAGER_CODE1 = "104095127";
//	//客户经理姓名
//	public static final String CUST_MANAGER_NAME1 = "陈晶晶";
//	//客户经理电话
//	public static final String CUST_MANAGER_PHONE1 = "18950462022";
//	//客户经理所属机构
//	public static final String CUST_MANAGER_ORG1 = "04010007";
//	
	//客户归属条限
	public static final String CUST_BELONG = "BL_ALL";
	//产品名称
	public static final String PRODUCT_NAME = "自营投标A";
	//产品编号
	public static final String PRODUCT_ID = "05270304";
	//证件类型 30    统一社会信用证代码
	public static final String CRET_TYPE = "30";
	//币种
	public static final String CURRENCY_TYPE = "CNY";
	//电子保单id
	//public static final String POLICY_CODE = "GCTBBH201909100921";
	//合同名
	public static final String POLICY_NAME = "建设工程施工合同履约保证保险单（A款）";
	//保函签章配置ID
	//public static final String CERTIFICATE_CODE = "GCTBBH201909181124";
	//莆田中支
	public static final String PT_ORG = "04060000";
	//地址
//	public static final String PT_ADDRESS = "福建省莆田市荔城区荔园路与东园路交叉路口西南侧凯天国际一期2#303";//"";
//	//邮编
//	public static final String PT_POSTALCODE = "351100";
//	//电话
//	public static final String PT_PHONE = "0594-2635313";
//    //莆田法定代表人
//	public static final String PT_LEGAL_PERSON = "朱清鸿";
	
	private static String localIpPort;

	public static String getLocalIpPort(){
		if(!StringUtils.hasText(localIpPort)){
			localIpPort = "http://"+IpAddressUtils.getLocalIP()+":18088/gbcn/";
		}
		return localIpPort;
	};
	
}
