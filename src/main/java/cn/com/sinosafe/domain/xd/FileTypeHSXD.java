package cn.com.sinosafe.domain.xd;


import cn.com.sinosafe.common.annotation.Description;
import cn.com.sinosafe.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Project : Java EE 开发平台 <br>
 * Description : 车抵贷影像文件枚举  <br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2017-2-9<br>
 */
public enum FileTypeHSXD {
	
	/**
	 	1、奥马商户贷
		A身份证明	-						1		XFD_00201	身份证正反面	是	
		B申请资料	-						2		XFD_00101	营业执照原件照片	是	
		B申请资料	-						2		XFD_00101	商户经营场所门头LOGO 照片	是	
		B申请资料	-						2		XFD_00101	商户经营场所内部照片	如有	
		B申请资料	-						2		XFD_00101	钱包小贷经办经理与客户经营场所合影照片（经营场所内部）	如有
		C征信授权	征信授权书				3		XFD_00302	民泰银行征信授权书	是	
		D授信执行	贷款合同					4		XFD_T170201	民泰银行放款合同	是	
		E授信执行	代扣授权书				5		XFD_T170206	民泰银行支付授权委托书	是	
		F/V授信执行	投保单				   6/10		XFD_T170205	华安投保单	是	
		G授信执行	贷款权益转让通知确认函	7		XFD_T170207	华安权益转让确认通知函	是	
		H/N/M其他	-					 8/11/12	XFD_00801	其他资料	如有	
		J贷款用途材料	贷款用途材料-贷后	13		XFD_0001202	
		I征信报告	征信报告					9		XFD_00301
		客户手持三湘银行授权书和身份证面签拍照	15		XFD_00303	其他资料	如有	
		贷款用途合同							16		XFD_01201	
		三湘银行二类户截图					17		XFD_T170211
		三湘银行送达地址确认函				18		XFD_T170215
		三湘银行贷款申请书					19		XFD_T170214
		三湘银行借据							20		XFD_T170213
		婚姻状况（结婚证/离婚证/未婚声明三选一）21		XFD_T170210
		工作收入证明							22		XFD_00601
		营业执照+营业场地证明（租赁合同或产权证）23	XFD_00502
		企业工商查询信息						24		XFD_T170212
		资产证明文件：车、房、投资等			25		XFD_00701
	
		2、合和年现金贷
		借款人身份证明文件			是	1  XFD_00201
		投保单						是	6  XFD_T170205
		签署投保单照片				是	10 XFD_T170205
		借款人人行征信报告			是	9  XFD_00301
		签约银行卡复印件				是	8  XFD_00801
		借款合同						是	4  XFD_T170201
		合作方服务协议				是	11 XFD_00801
		借款人收入流水				否	12 XFD_00601
		审批结果						否	8  XFD_00801	
	
		1、三湘经营贷、消费贷
		A身份证明	-						1		XFD_00201	身份证正反面	是	
		B申请资料	-						2		XFD_00101	营业执照原件照片	是	
		B申请资料	-						2		XFD_00101	商户经营场所门头LOGO 照片	是	
		B申请资料	-						2		XFD_00101	商户经营场所内部照片	如有	
		B申请资料	-						2		XFD_00101	钱包小贷经办经理与客户经营场所合影照片（经营场所内部）	如有
		C征信授权	征信授权书				3		XFD_00302	银行征信授权书	是	
		D授信执行	贷款合同					4		XFD_T170201	银行放款合同	是	
		E授信执行	代扣授权书				5		XFD_T170206	银行支付授权委托书	是	
		F/V授信执行	投保单				   6/10		XFD_T170205	华安投保单	是	
		G授信执行	贷款权益转让通知确认函	7		XFD_T170207	华安权益转让确认通知函	是	
		
	
	
	 */
	
	@Description("00201")
	@Value("1")
	A,
	@Description("00101")
	@Value("2")
	B,
	@Description("00302")
	@Value("3")
	C,
	@Description("T170201")
	@Value("4")
	D,
	@Description("T170206")
	@Value("5")
	E,
	@Description("T170205")
	@Value("6")
	F,
	@Description("T170207")
	@Value("7")
	G,
	@Description("00801")
	@Value("8")
	H,
	@Description("00301")
	@Value("9")
	I,
	@Description("T170205")
	@Value("10")
	V,
	@Description("00801")
	@Value("11")
	N,
	@Description("00801")
	@Value("12")
	M,
	@Description("01202")
	@Value("13")
	J,
	@Description("00303")
	@Value("15")
	K,
	@Description("01201")
	@Value("16")
	L,
	@Description("T170211")
	@Value("17")
	O,
	@Description("T170215")
	@Value("18")
	P,
	@Description("T170214")
	@Value("19")
	Q,
	@Description("T170213")
	@Value("20")
	R,
	@Description("T170210")
	@Value("21")
	S,
	@Description("00601")
	@Value("22")
	T,
	@Description("00502")
	@Value("23")
	U,
	@Description("T170212")
	@Value("24")
	W,
	@Description("00701")
	@Value("25")
	X;
	
	public String getDesc() {
		return desc(this);
	}
	
	public String getValue() {
		return value(this);
	}
	
	
	/**
	 * 获取描述注解的值
	 * 
	 * @param e
	 * @return
	 * @throws Exception
	 */
	private String desc(Enum<?> e) {
		try {
			return e.getClass().getField(e.name()).getAnnotation(Description.class).value();
		} catch (Exception exp) {
			return e.name();
		}
	}
	
	/**
	 * 获取描述注解的值
	 * 
	 * @param e
	 * @return
	 * @throws Exception
	 */
	private String value(Enum<?> e) {
		try {
			return e.getClass().getField(e.name()).getAnnotation(Value.class).value();
		} catch (Exception exp) {
			return e.name();
		}
	}
	
	public static String getPrdCode(String biz_mode){
		String prdCode="";
	    if (StringUtils.isNotEmpty(biz_mode)) {
	        if (biz_mode.equals("1")) { // 微贷业务类产品 WDCP
	            prdCode = "WDCP";
	        } else if (biz_mode.equals("2")) {// 抵押增信业务类-个人 DYZX
	            prdCode = "DYZX";
	        } else if (biz_mode.equals("3")) {// 抵押增信业务类-企业 DYZX
	            prdCode = "DYZX";
	        } else if (biz_mode.equals("4")) {// 保贷通业务类 BDT
	            prdCode = "BDT";
	        } else if (biz_mode.equals("5") || biz_mode.equals("22")  || biz_mode.equals("23")) {// 消费贷
	            prdCode = "XFD";
	        } else if (biz_mode.equals("6")){ //个分险
	        	prdCode = "GFX";
	        } else if(biz_mode.equals("8")){
				 prdCode = "SHD";
			} else if(biz_mode.equals("9")){
				prdCode = "BDT";  //同业金融的，暂时和保贷通产品保持一致
			} else if(biz_mode.equals("11") || biz_mode.equals("15")){
				prdCode = "HTBH";  //合同保函
			} else if(biz_mode.equals("13")){
				prdCode = "SLDK";  //赎楼贷
			} else if(biz_mode.equals("14")){
				prdCode = "CDDK";  //车抵贷
			}
	    }
	    return prdCode;
	}

}
