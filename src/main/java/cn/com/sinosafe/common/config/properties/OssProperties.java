package cn.com.sinosafe.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 阿里云OSS相关配置
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Component
@ConfigurationProperties(prefix = "OSS")
public class OssProperties {

	private String endpoint;
	
	private String accessKeyId;
	
	private String accessKeySecret;
	
	private String bucket;
	
	private String proxyHost;
	
	private String proxyPort;
	
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getBucket() {
		return bucket;
	}
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
	public String getProxyHost() {
		return proxyHost;
	}
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}
	public String getProxyPort() {
		return proxyPort;
	}
	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}
	
}
