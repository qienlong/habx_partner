package cn.com.sinosafe.domain.gbcn.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="Packet")
@XmlType(name = "Packet",propOrder = {"head","body"})
public class Packet{

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
	
	@XmlType(propOrder = {"requestType","requestUser","transactionCode",
			"transDate","transTime","businessNo"})
	public static class Head{
		private String requestType;
		private String requestUser;
		private String transactionCode;
		private String transDate;
		private String transTime;
		private String businessNo;
		public String getRequestType() {
			return requestType;
		}
	    @XmlElement(name = "RequestType")
		public void setRequestType(String requestType) {
			this.requestType = requestType;
		}
		public String getRequestUser() {
			return requestUser;
		}
		 @XmlElement(name = "RequestUser")
		public void setRequestUser(String requestUser) {
			this.requestUser = requestUser;
		}
		public String getTransactionCode() {
			return transactionCode;
		}
		 @XmlElement(name = "TransactionCode")
		public void setTransactionCode(String transactionCode) {
			this.transactionCode = transactionCode;
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
		public String getBusinessNo() {
			return businessNo;
		}
		 @XmlElement(name = "BusinessNo")
		public void setBusinessNo(String businessNo) {
			this.businessNo = businessNo;
		}
	}
	
	public static class Body{
		private  String trans_no;
		private  String trans_time;
		private  String serno;
		private  String ins_amount;
		private  String send_type;
		public String getTrans_no() {
			return trans_no;
		}
		public void setTrans_no(String trans_no) {
			this.trans_no = trans_no;
		}
		public String getTrans_time() {
			return trans_time;
		}
		public void setTrans_time(String trans_time) {
			this.trans_time = trans_time;
		}
		public String getSerno() {
			return serno;
		}
		public void setSerno(String serno) {
			this.serno = serno;
		}
		public String getIns_amount() {
			return ins_amount;
		}
		public void setIns_amount(String ins_amount) {
			this.ins_amount = ins_amount;
		}
		public String getSend_type() {
			return send_type;
		}
		public void setSend_type(String send_type) {
			this.send_type = send_type;
		}
	}
	
}
