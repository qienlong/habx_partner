package cn.com.sinosafe.domain.gbcn.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "responseHead", "responseBody" })
public class BaseResponse {

	private ResponseHead responseHead;

	private ResponseBody responseBody;

	public ResponseHead getResponseHead() {
		return responseHead;
	}

	public void setResponseHead(ResponseHead responseHead) {
		this.responseHead = responseHead;
	}

	public ResponseBody getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(ResponseBody responseBody) {
		this.responseBody = responseBody;
	}

	public BaseResponse() {
		this.responseHead = new ResponseHead();
		this.responseBody = new ResponseBody();
	}

	public BaseResponse(ResponseHead responseHead, ResponseBody responseBody) {
		this.responseHead = responseHead;
		this.responseBody = responseBody;
	}

	/**
	 * 返回头
	 */
	@XmlRootElement(name = "responseHead")
	@XmlType(name = "responseHead", propOrder = { "requestUUID", "sign" })
	public static class ResponseHead {
		private String requestUUID;
		private String sign;
		public ResponseHead(String requestUUID, String sign) {
			this.requestUUID = requestUUID;
			this.sign = sign;
		}
		public ResponseHead() {

		}
		public String getRequestUUID() {
			return requestUUID;
		}
		public void setRequestUUID(String requestUUID) {
			this.requestUUID = requestUUID;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
	}

	/**
	 * 返回体
	 */
	@XmlRootElement(name = "responseBody")
	@XmlType(name = "responseBody",propOrder = {"responseTime","resultFlag","resultMessage","proposalNo","yeepayurl","insurancePhone","downLoadUrl","guaranteeUrl","insuranceTime"})
	public static class ResponseBody {
	    private boolean resultFlag; //处理状态 true成功 false失败
	    private String resultMessage;// 处理结果 受理申请/受理失败
	    private String responseTime;//处理成功后返回
	    private String proposalNo;//投保单号 处理成功后返回
	    private String yeepayurl;//支付链接
	    private String insurancePhone;//保险公司联系方式
	    private String downLoadUrl;//电子保单下载地址
	    private String guaranteeUrl;//电子保函下载地址
	    private String insuranceTime;//保单起期和止期
	    public ResponseBody() {
	    }
	    public ResponseBody(String responseTime,boolean resultFlag,String resultMessage) {
	        this.resultFlag = resultFlag;
	        this.resultMessage = resultMessage;
	        this.responseTime = responseTime;
	    }
	    public ResponseBody(String responseTime,boolean resultFlag,String resultMessage, String proposalNo, String yeepayurl) {
	        this.resultFlag = resultFlag;
	        this.resultMessage = resultMessage;
	        this.responseTime = responseTime;
	        this.proposalNo = proposalNo;
	        this.yeepayurl = yeepayurl;
	    }
	    public ResponseBody(String responseTime,boolean resultFlag,String resultMessage, String downLoadUrl, String guaranteeUrl, String insuranceTime,String insurancePhone) {
	        this.resultFlag = resultFlag;
	        this.resultMessage = resultMessage;
	        this.responseTime = responseTime;
	        this.insurancePhone = insurancePhone;
	        this.downLoadUrl = downLoadUrl;
	        this.guaranteeUrl = guaranteeUrl;
	        this.insuranceTime = insuranceTime;
	    }
		public boolean isResultFlag() {
			return resultFlag;
		}
		public void setResultFlag(boolean resultFlag) {
			this.resultFlag = resultFlag;
		}
		public String getResultMessage() {
			return resultMessage;
		}
		public void setResultMessage(String resultMessage) {
			this.resultMessage = resultMessage;
		}
		public String getResponseTime() {
			return responseTime;
		}
		public void setResponseTime(String responseTime) {
			this.responseTime = responseTime;
		}
		public String getProposalNo() {
			return proposalNo;
		}
		public void setProposalNo(String proposalNo) {
			this.proposalNo = proposalNo;
		}
		public String getYeepayurl() {
			return yeepayurl;
		}
		public void setYeepayurl(String yeepayurl) {
			this.yeepayurl = yeepayurl;
		}
		public String getInsurancePhone() {
			return insurancePhone;
		}
		@XmlElement(name = "InsurancePhone")
		public void setInsurancePhone(String insurancePhone) {
			this.insurancePhone = insurancePhone;
		}
		public String getDownLoadUrl() {
			return downLoadUrl;
		}
		public void setDownLoadUrl(String downLoadUrl) {
			this.downLoadUrl = downLoadUrl;
		}
		public String getGuaranteeUrl() {
			return guaranteeUrl;
		}
		public void setGuaranteeUrl(String guaranteeUrl) {
			this.guaranteeUrl = guaranteeUrl;
		}
		public String getInsuranceTime() {
			return insuranceTime;
		}
		@XmlElement(name = "InsuranceTime")
		public void setInsuranceTime(String insuranceTime) {
			this.insuranceTime = insuranceTime;
		}
	}
}
