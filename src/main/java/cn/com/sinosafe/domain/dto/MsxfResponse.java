package cn.com.sinosafe.domain.dto;

/**
 * 
 * 马上消费接口响应 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年8月30日<br>
 */
public class MsxfResponse {
	
	/** 业务返回码 **/
	public static final MsxfResponse CODE_0000 = new MsxfResponse("0000", "Success");
    public static final MsxfResponse CODE_9001 = new MsxfResponse("9001", "请求重复");
    public static final MsxfResponse CODE_9002 = new MsxfResponse("9002", "业务重复");
    public static final MsxfResponse CODE_9003 = new MsxfResponse("9003", "核保请求不存在");
    public static final MsxfResponse CODE_9005 = new MsxfResponse("9005", "核保数据异常");
    public static final MsxfResponse CODE_9006 = new MsxfResponse("9006", "产品信息不存在");
    public static final MsxfResponse CODE_9007 = new MsxfResponse("9007", "投保失败");
    public static final MsxfResponse CODE_9008 = new MsxfResponse("9008", "承保失败");
    public static final MsxfResponse CODE_9011 = new MsxfResponse("9011", "字段不能为空");
    public static final MsxfResponse CODE_9016 = new MsxfResponse("9016", "业务参数有误");
    public static final MsxfResponse CODE_9500 = new MsxfResponse("9500", "服务器异常");




	// 响应码
	private String retCode;
	
	// 响应消息
	private String retMsg;
	
	// 交易状态
	private String status;
	
	// 业务流水号
	private String preInsuranceNo;
	
	// 交易结果信息
	private String msg;
	
	// 保单号
	private String policyNo;
	
	// 电子保单url
	private String policyURL;

	public MsxfResponse() {
		
	}

	public MsxfResponse(String retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPreInsuranceNo() {
		return preInsuranceNo;
	}

	public void setPreInsuranceNo(String preInsuranceNo) {
		this.preInsuranceNo = preInsuranceNo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyURL() {
		return policyURL;
	}

	public void setPolicyURL(String policyURL) {
		this.policyURL = policyURL;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MsxfResponse [retCode=");
		builder.append(retCode);
		builder.append(", retMsg=");
		builder.append(retMsg);
		builder.append(", status=");
		builder.append(status);
		builder.append(", preInsuranceNo=");
		builder.append(preInsuranceNo);
		builder.append(", msg=");
		builder.append(msg);
		builder.append(", policyNo=");
		builder.append(policyNo);
		builder.append(", policyURL=");
		builder.append(policyURL);
		builder.append("]");
		return builder.toString();
	}

}
