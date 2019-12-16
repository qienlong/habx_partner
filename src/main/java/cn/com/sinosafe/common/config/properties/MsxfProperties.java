package cn.com.sinosafe.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * 马上消费配置参数 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月2日<br>
 */
@Component
@Order(1)
@ConfigurationProperties(prefix = "msxf")
public class MsxfProperties {
	
	// 默认邮件标题
	private String mailTitle;
	// 是否发送邮件
	private boolean mailSend;
	// 华安公钥
	private String haPublicKey;
	// 华安私钥
	private String haPrivateKey;
	// 压缩包密钥
	private String encryKey;
	
	public String getMailTitle() {
		return mailTitle;
	}
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	public boolean isMailSend() {
		return mailSend;
	}
	public void setMailSend(boolean mailSend) {
		this.mailSend = mailSend;
	}
	public String getHaPublicKey() {
		return haPublicKey;
	}
	public void setHaPublicKey(String haPublicKey) {
		this.haPublicKey = haPublicKey;
	}
	public String getHaPrivateKey() {
		return haPrivateKey;
	}
	public void setHaPrivateKey(String haPrivateKey) {
		this.haPrivateKey = haPrivateKey;
	}
	public String getEncryKey() {
		return encryKey;
	}
	public void setEncryKey(String encryKey) {
		this.encryKey = encryKey;
	}
	
}
