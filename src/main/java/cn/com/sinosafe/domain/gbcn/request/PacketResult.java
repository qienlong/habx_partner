package cn.com.sinosafe.domain.gbcn.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="Packet")
@XmlType(name = "Packet",propOrder = {"head","body"})
public class PacketResult{

	private Head head;
	
	private Body body;
	
	private String type;
	
	private String version;

	public Head getHead() {
		return head;
	}

	@XmlElement(name="Head")
	public void setHead(Head head) {
		this.head = head;
	}

	public Body getBody() {
		return body;
	}

	@XmlElement(name="Body")
	public void setBody(Body body) {
		this.body = body;
	}

	public String getType() {
		return type;
	}

	@XmlAttribute
	public void setType(String type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	@XmlAttribute
	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlType(propOrder = {"requestType","responseCode","errorCode",
			"errorMessage","businessNo","transDate","transTime"})
	public static class Head{
		private String requestType;
		private String responseCode;
		private String errorCode;
		private String errorMessage;
		private String businessNo;
		private String transDate;
		private String transTime;

		public String getRequestType() {
			return requestType;
		}
	    @XmlElement(name = "RequestType")
		public void setRequestType(String requestType) {
			this.requestType = requestType;
		}
		public String getResponseCode() {
			return responseCode;
		}
	    @XmlElement(name = "ResponseCode")
		public void setResponseCode(String responseCode) {
			this.responseCode = responseCode;
		}
		public String getErrorCode() {
			return errorCode;
		}
		 @XmlElement(name = "ErrorCode")
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		 @XmlElement(name = "ErrorMessage")
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		public String getBusinessNo() {
			return businessNo;
		}
		 @XmlElement(name = "BusinessNo")
		public void setBusinessNo(String businessNo) {
			this.businessNo = businessNo;
		}
		public String getTransDate() {
			return transDate;
		}
		 @XmlElement(name = "TransDate")
		public void setTransDate(String transDate) {
			this.transDate = transDate;
		}
		public String getTransTime() {
			return transTime;
		}
		 @XmlElement(name = "TransTime")
		public void setTransTime(String transTime) {
			this.transTime = transTime;
		}
	    

	}
	
	public static class Body{
		
	}
	
}
