/**   
* @Title:：IssueMsgProperties.java 
* @Package ：cn.com.sinosafe.common.config.properties 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月4日 上午9:18:36 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** 
 * @ClassName:：IssueMsgProperties 
 * @Description： 保单生成通知参数属性配置
 * @author ：xiewei
 * @date ：2019年6月4日 上午9:18:36  
 */
@Component
@ConfigurationProperties(prefix = "issueMsg")
public class IssueMsgProperties {
	/**
	 * 保单审批状态
	 */
	private String status;
	
	/**
	 * 出单请求地址
	 */
	private String addr;
	
	/**
	 * 报文格式
	 */
	private String pattern;
	/**
	 * 授权书模板
	 */
	private String writtenboard;
	/**
	 * 投保单模板
	 */
	private String lstboard;
	
	

	/**
	 * @return the writtenboard
	 */
	public String getWrittenboard() {
		return writtenboard;
	}

	/**
	 * @param writtenboard the writtenboard to set
	 */
	public void setWrittenboard(String writtenboard) {
		this.writtenboard = writtenboard;
	}

	/**
	 * @return the lstboard
	 */
	public String getLstboard() {
		return lstboard;
	}

	/**
	 * @param lstboard the lstboard to set
	 */
	public void setLstboard(String lstboard) {
		this.lstboard = lstboard;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	
}
