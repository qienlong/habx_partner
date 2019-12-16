package cn.com.sinosafe.common.config.properties;

import org.springframework.boot.ApplicationHome;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 安心签配置类
 * @Project	: Rest_HAXB_Service
 * @Desc	: 安心签配置类
 * @Author	: hesong
 * @Date	: 2019年1月11日 上午10:03:08
 * @Version	: 1.0
 */
@Component
@Order(1)
@ConfigurationProperties(prefix = "axsign")
public class AxsignProperties {
	public String platId; 
	public String jksPath;
	public String jksPwd;
	public String jksAlias;
	public String jksUrl;
	public String smsTemplateId;
	
	public String getPlatId() {
		return platId;
	}
	public void setPlatId(String platId) {
		this.platId = platId;
	}
	public String getJksPath() {
		return jksPath;
	}
	public void setJksPath(String jksPath) {
//		this.jksPath = jksPath;
//		this.jksPath = AxsignProperties.class.getClassLoader().getResource("").getPath();
		this.jksPath = new ApplicationHome(getClass()).getSource().getParent() + "/" + jksPath;
		System.out.println("安心签秘钥文件路径为："+ this.jksPath);
	}
	public String getJksPwd() {
		return jksPwd;
	}
	public void setJksPwd(String jksPwd) {
		this.jksPwd = jksPwd;
	}
	public String getJksAlias() {
		return jksAlias;
	}
	public void setJksAlias(String jksAlias) {
		this.jksAlias = jksAlias;
	}
	public String getJksUrl() {
		return jksUrl;
	}
	public void setJksUrl(String jksUrl) {
		this.jksUrl = jksUrl;
	}
	public String getSmsTemplateId() {
		return smsTemplateId;
	}
	public void setSmsTemplateId(String smsTemplateId) {
		this.smsTemplateId = smsTemplateId;
	}
	
}
