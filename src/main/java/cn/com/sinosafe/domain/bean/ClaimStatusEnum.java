/**
 * 
 */
package cn.com.sinosafe.domain.bean;


/**  
* <p>Title: ClaimStatusEnum</p>  
* <p>Description: </p>  
* @author longxiaoqiang  
* @date 2019年9月5日  
*/
public enum ClaimStatusEnum {
	
	claim_pay_msg1("5","支付失败"),
	claim_pay_msg2("6","支付成功"),
	claim_pay_msg3("7","入账成功"),
	claim_pay_msg4("8","退票"),
	claim_pay_msg5("9","提交资金系统失败"),
	claim_pay_status1("支付失败","20"),
	claim_pay_status2("支付成功","10"),
	claim_pay_status3("入账成功","10"),
	claim_pay_status4("退票","20"),
	claim_pay_status5("提交资金系统失败","20");
	
	private final String code;
	private final String msg;
	
	private ClaimStatusEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public String code() {
		return code;
	}
	
	public String msg() {
		return msg;
	}
	
	// 根据ID获取枚举
    public static String getMsg(String code){
        for(ClaimStatusEnum temp:ClaimStatusEnum.values()){
            if(temp.code().equals(code)){
                return temp.msg;
            }
        }
        return null;
    }
}
