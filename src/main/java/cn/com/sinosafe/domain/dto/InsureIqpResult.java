package cn.com.sinosafe.domain.dto;

/** 
 * @ClassName:：InsureIqpResult 
 * @Description： 投保结果
 * @author ：pengll
 * @date ：2019年6月8日 下午3:58:24  
 */
public class InsureIqpResult {

	
	
	/**
	 * 申请号
	 */
	private String applNo;
	/**
	 * 保单对应贷款产品代码 默认值OD
	 */
	private String productCode;
	/**
	 * 投保人姓名
	 */
	private String custName;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 证件类型 默认值 1
	 */
	private String idType;
	/**
	 * 身份证号
	 */
	private String id;
	/**
	 * 投保单号
	 */
	private String coverNo;
	
	/**
	 * 投保完成日期（申请日期）
	 */
	private String applDate;
	/**
	 * 渠道标示 默认 06
	 */
	private String policyChannel;
	/**
	 * 投保结果标识
	 */
	private String isAuthorized;
	/**
	 * 是否完成投保(投保完成标识 Y完成投保 N没有)
	 */
	private String isCompleted;
	/**
	 * 异常原因
	 */
	private String falMsg;
	/**
	 * 成功页面H5链接
	 */
	private String successH5Url;
	
	/**
	 * 保险公司合作方
	 */
	private String insuCompany;
	/**
	 * 批单标示(投保N/保单批单Y)
	 */
	private String noticeType;
	/**
	 * 反洗钱结果 (0000:核保通过，9999：核保不通过
	 * 0000:投保通过，9999：投保不通过)
	 */
	private String antiMoneyLaunderingCode;
	/**
	 * 反洗钱结果描述 (反洗钱结果通过或不通过)
	 */
	private String antiMoneyLaunderingMsg;
	/**
	 * 返回保单状态标识(1投保完成，
	 *                  2投保拒绝
	 *                 3核保通过
	 *                 4核保拒绝
	 *                 5保单信息确认完成)
	 */
	private String policyStatus;
	/**
	 * 成功或者失败原因(成功：传空
	 * 					失败：传失败原因)
	 */
	private String reason;

	public String getApplNo() {
		return applNo;
	}

	public void setApplNo(String applNo) {
		this.applNo = applNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoverNo() {
		return coverNo;
	}

	public void setCoverNo(String coverNo) {
		this.coverNo = coverNo;
	}

	public String getIsAuthorized() {
		return isAuthorized;
	}

	public void setIsAuthorized(String isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	public String getFalMsg() {
		return falMsg;
	}

	public void setFalMsg(String falMsg) {
		this.falMsg = falMsg;
	}

	public String getSuccessH5Url() {
		return successH5Url;
	}

	public void setSuccessH5Url(String successH5Url) {
		this.successH5Url = successH5Url;
	}

	public String getInsuCompany() {
		return insuCompany;
	}

	public void setInsuCompany(String insuCompany) {
		this.insuCompany = insuCompany;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getApplDate() {
		return applDate;
	}

	public void setApplDate(String applDate) {
		this.applDate = applDate;
	}

	public String getPolicyChannel() {
		return policyChannel;
	}

	public void setPolicyChannel(String policyChannel) {
		this.policyChannel = policyChannel;
	}

	public String getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getAntiMoneyLaunderingCode() {
		return antiMoneyLaunderingCode;
	}

	public void setAntiMoneyLaunderingCode(String antiMoneyLaunderingCode) {
		this.antiMoneyLaunderingCode = antiMoneyLaunderingCode;
	}

	public String getAntiMoneyLaunderingMsg() {
		return antiMoneyLaunderingMsg;
	}

	public void setAntiMoneyLaunderingMsg(String antiMoneyLaunderingMsg) {
		this.antiMoneyLaunderingMsg = antiMoneyLaunderingMsg;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public InsureIqpResult() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InsureIqpResult [applNo=");
		builder.append(applNo);
		builder.append(", custName=");
		builder.append(custName);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", id=");
		builder.append(id);
		builder.append(", coverNo=");
		builder.append(coverNo);
		builder.append(", applDate=");
		builder.append(applDate);
		builder.append(", isAuthorized=");
		builder.append(isAuthorized);
		builder.append(", falMsg=");
		builder.append(falMsg);
		builder.append(", successH5Url=");
		builder.append(successH5Url);
		builder.append(", insuCompany=");
		builder.append(insuCompany);

		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", idType=");
		builder.append(idType);
		builder.append(", policyChannel=");
		builder.append(policyChannel);
		builder.append(", isCompleted=");
		builder.append(isCompleted);
		builder.append(", noticeType=");
		builder.append(noticeType);
		builder.append(", antiMoneyLaunderingCode=");
		builder.append(antiMoneyLaunderingCode);
		builder.append(", antiMoneyLaunderingMsg=");
		builder.append(antiMoneyLaunderingMsg);
		builder.append(", policyStatus=");
		builder.append(policyStatus);
		builder.append(", reason=");
		builder.append(reason);

		builder.append("]");
		return builder.toString();
	}

	public InsureIqpResult(String applNo, String custName, String mobile, String id, String coverNo, String applDate,
			String isAuthorized, String falMsg, String successH5Url, String insuCompany,String productCode,String idType,String  policyChannel,
						   String isCompleted,String noticeType,String antiMoneyLaunderingCode,String antiMoneyLaunderingMsg,String policyStatus,String reason) {
		super();
		this.applNo = applNo;
		this.custName = custName;
		this.mobile = mobile;
		this.id = id;
		this.coverNo = coverNo;
		this.applDate = applDate;
		this.isAuthorized = isAuthorized;
		this.falMsg = falMsg;
		this.successH5Url = successH5Url;
		this.insuCompany = insuCompany;

		this.productCode = productCode;
		this.idType = idType;
		this.policyChannel = policyChannel;
		this.isCompleted = isCompleted;
		this.noticeType = noticeType;
		this.antiMoneyLaunderingCode = antiMoneyLaunderingCode;
		this.antiMoneyLaunderingMsg = antiMoneyLaunderingMsg;
		this.policyStatus = policyStatus;
		this.reason = reason;
	}

	
}



