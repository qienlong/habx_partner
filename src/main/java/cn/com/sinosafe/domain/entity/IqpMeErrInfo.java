package cn.com.sinosafe.domain.entity;

/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Project : Java EE 开发平台 <br>
 * Description : 贷后处理异常信息 <br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2018年8月1日<br>
 */
public class IqpMeErrInfo {
	
	private String pkId;
	private String module;
	private String type;
	private String msgType;
	private String msg;
	private String info;
	private Integer idx;
	private String msgDate;
	private String status;
	
	public String getPkId() {
		return pkId;
	}
	public void setPkId(String pkId) {
		this.pkId = pkId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IqpMeErrInfo [pkId=").append(pkId).append(", module=").append(module).append(", type=")
				.append(type).append(", msgType=").append(msgType).append(", msg=").append(msg).append(", info=")
				.append(info).append(", idx=").append(idx).append(", msgDate=").append(msgDate).append(", status=")
				.append(status).append("]");
		return builder.toString();
	}
	
	

}
