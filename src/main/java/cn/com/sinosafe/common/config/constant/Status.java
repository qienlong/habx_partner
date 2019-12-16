package cn.com.sinosafe.common.config.constant;

/**
 * 
 *  返回状态<br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年09月05日<br>
 */
public enum Status {
	成功("SUCCESS"),
	失败("FAIL"),
	处理中("PROCESSING");

	private String responseStatus;

	private Status() {

	}
	private Status(String responseStatus) {
		this.setResponseStatus(responseStatus);
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
}
