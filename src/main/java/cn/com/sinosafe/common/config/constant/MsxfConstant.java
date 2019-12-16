package cn.com.sinosafe.common.config.constant;

/**
 * 
 * 马上消费常量类 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月2日<br>
 */
public class MsxfConstant {
	
	/**马上消费模块**/
	public final static String MSXF = "MSXF";
	
	/**核保申请接口**/
	public final static String MSXF_PL1001 = "MSPL1001";
	
	/**放款结果通知（承保申请）*/
	public static final String MSXF_PL2001 = "MSPL2001";
	
	/**承保申请结果查询*/
	public static final String MSXF_PL2002 = "MSPL2002";
	
	/**影像上传接口**/
	public final static String MSXF_PL3001 = "MSPL3001";
	
	/**对账：贷款借据信息**/
	public final static String MSXF_AL6001 = "MSAL6001";
	
	/**对账：保费明细**/
	public final static String MSXF_AL6002 = "MSAL6002";

	/**默认系统操作人**/
	public static final String MSXF_SYSTEM = "xwadmin";
	
	/**默认系统操作人机构**/
	public static final String MSXF_ORG = "cmis";

	/**核保申请结果查询接口**/
	public final static String MSXF_PL1002 = "MSPL1002";

	/**保费明细对账接口**/
	public final static String MSXF_AL1003 = "MSAL1003";
	
	/**贷后文件存储接口**/
	public final static String MSXF_AL1001 = "MSAL1001";
	
	public static final String MSXF_AL100101 = "MSAL100101";
	
	/**贷后数据处理接口**/
	public final static String MSXF_AL1002 = "MSAL1002";
	
	/**贷后文件上传接口**/
	public final static String MSXF_AL1004 = "MSAL1004";

	/**贷后核赔反馈文件处理**/
	public final static String MSXF_AL100401 = "MSAL100401";

	/**贷后退保结果文件处理**/
	public final static String MSXF_AL100402 = "MSAL100402";

	/**贷后正常还款数据处理接口**/
	public final static String MSXF_AL100201= "MSAL100201";

	/**贷后提前结清还款数据处理接口**/
	public final static String MSXF_AL100202= "MSAL100202";

	/**贷后逾期还款数据处理接口**/
	public final static String MSXF_AL100204= "MSAL100204";

	/**贷后延期还款数据处理接口**/
	public final static String MSXF_AL100203= "MSAL100203";

	/**贷后延期还款数据处理接口**/
	public final static String MSXF_AL100206= "MSAL100206";


	/**贷后结清还款数据处理接口**/
	public final static String MSXF_AL100205= "MSAL100205";


	/**贷款借据信息接口**/
	public final static String MSXF_AL1001_LOANFILE = "MSXFSinosafeLoanFile";
	
	/**保费明细接口**/
	public final static String MSXF_AL1001_INFOFILE = "MSXFSinosafePremiumInfoFile";

	/**还款计划文件存储接口**/
	public final static String MSXF_AL1001_PLAN_FILE = "MSXFSinosafeRepayPlanFile";

	/**还款明细文件存储接口**/
	public final static String MSXF_AL1001_REPAY_FILE = "MSXFSinosafeRepayFile";
	
	/**核赔反馈文件名称**/
	public final static String MSXF_AL100401_FILENAME = "SinosafeCompensationFile.txt";
	/**核赔反馈数据数目文件名称**/
	public final static String MSXF_AL100401_FILENAME_OK = "SinosafeCompensationFile.ctrl";
	/**退保结果清单文件名称**/
	public final static String MSXF_AL100402_FILENAME = "SinosafeCancellationFile.txt";
	/**退保结果清单数据数目文件名称**/
	public final static String MSXF_AL100402_FILENAME_OK = "SinosafeCancellationFile.ctrl";
	
	/**贷后文件存储接口txt数据分隔符**/
	public final static String MSXF_SPLIT = "\\|";

	/**贷后文件上传完成标记**/
	public final static String MSXF_AL100101_FILENAME = "-filelist.ok";

	/**影像文件上传完成标记**/
	public final static String MSXF_PL3001_FILENAME = "_imgfiles.ctrl";


	/**申请状态  通过**/
	public final static String PASS = "997";
	/**申请状态  拒绝**/
	public final static String NO_PASS = "998";
	/**申请状态  审批中**/
	public final static String DEAING = "111";
	/**还款计划文件参数个数 **/
	public final static Integer ACC_MTD_PLAN_PARAMCOUNT = 20;
	/**还款明细文件参数个数**/
	public final static Integer ACC_MTD_PS_NOTE_PARAMCOUNT = 15;
	
	/**消息队列**/
	public final static String MQ_XB_EXCHANGE = "ex_xb";
	public final static String MQ_XB_ACT_ROUTINGKEY = "rk_order_xb_partner_msxf";
	public final static String MQ_MSXF_QUEUE = "ha.queue_order_xb_partner_msxf";

	/**银行名称**/
	public final static String MSXF_HMBANK = "HMBANK";
	public final static String MSXF_CQBANK = "CQBANK";
	public final static String MSXF_NJBANK = "NJBANK";
}
