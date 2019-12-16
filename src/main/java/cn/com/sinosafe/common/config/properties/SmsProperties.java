package cn.com.sinosafe.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 短信配置加载
 * 
 * @author ruoyi
 */
@Component
@ConfigurationProperties(prefix="sms")
public class SmsProperties
{
	private String url;
	private String user;
	private String pwd;
	private String t01;
	private String t02;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getT01() {
		return t01;
	}
	public void setT01(String t01) {
		this.t01 = t01;
	}
	public String getT02() {
		return t02;
	}
	public void setT02(String t02) {
		this.t02 = t02;
	}
	
}
