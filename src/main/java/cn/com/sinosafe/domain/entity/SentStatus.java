/**   
* @Title:：SentStatus.java 
* @Package ：cn.com.sinosafe.domain.entity 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月6日 上午9:14:03 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.entity;

import java.util.Date;

/** 
 * @ClassName:：SentStatus 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月6日 上午9:14:03  
 */
public class SentStatus {
	/**
	 * 发送类型
	 */
	private String sentType;
	/**
	 * 发送流水号
	 */
	private String sentSerno;
	/**
	 * 发送状态
	 */
	private String sentStatus;
	/**
	 * 时间戳
	 */
	private String tmSmp;
	/**
	 * 运行时间
	 */
	private Date runTime;
	

	public SentStatus() {
		super();
	}
	
	public SentStatus(String sentType, String sentSerno, String sentStatus) {
		super();
		this.sentType = sentType;
		this.sentSerno = sentSerno;
		this.sentStatus = sentStatus;
	}
	
	public SentStatus(String sentType, String sentSerno, String sentStatus,
			String tmSmp, Date runTime) {
		super();
		this.sentType = sentType;
		this.sentSerno = sentSerno;
		this.sentStatus = sentStatus;
		this.tmSmp = tmSmp;
		this.runTime = runTime;
	}
	public String getSentType() {
		return sentType;
	}
	public void setSentType(String sentType) {
		this.sentType = sentType;
	}
	public String getSentSerno() {
		return sentSerno;
	}
	public void setSentSerno(String sentSerno) {
		this.sentSerno = sentSerno;
	}
	public String getSentStatus() {
		return sentStatus;
	}
	public void setSentStatus(String sentStatus) {
		this.sentStatus = sentStatus;
	}
	public String getTmSmp() {
		return tmSmp;
	}
	public void setTmSmp(String tmSmp) {
		this.tmSmp = tmSmp;
	}
	public Date getRunTime() {
		return runTime;
	}
	public void setRunTime(Date runTime) {
		this.runTime = runTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SentStatus [sentType=");
		builder.append(sentType);
		builder.append(", sentSerno=");
		builder.append(sentSerno);
		builder.append(", sentStatus=");
		builder.append(sentStatus);
		builder.append(", tmSmp=");
		builder.append(tmSmp);
		builder.append(", runTime=");
		builder.append(runTime);
		builder.append("]");
		return builder.toString();
	}
	
	
}
