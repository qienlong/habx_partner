/**   
* @Title:：IssueInfoSyncProperties.java 
* @Package ：cn.com.sinosafe.common.config.properties 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月5日 下午6:05:45 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** 
 * @ClassName:：IssueInfoSyncProperties 
 * @Description： sftp属性配置类
 * @author ：xiewei
 * @date ：2019年6月5日 下午6:05:45  
 */
@Component
@ConfigurationProperties(prefix = "sftpProperties")
public class SftpProperties {
	/**
	 * 目标
	 */
	public String host;
	/**
	 * 端口号
	 */
	public int port;
	/**
	 * 账号
	 */
	public String account;
	/**
	 * 密码
	 */
	public String pwd;
	/**
	 * 上传地址
	 */
	public String uploadSftpLocation;
	/**
	 * 下载地址
	 */
	public String dowloadSftpLoacation;
	
	/**
	 * 本地文件地址
	 */
	public String localFileLocation;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getAccount() {
		return account;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUploadSftpLocation() {
		return uploadSftpLocation;
	}
	public void setUploadSftpLocation(String uploadSftpLocation) {
		this.uploadSftpLocation = uploadSftpLocation;
	}
	public String getDowloadSftpLoacation() {
		return dowloadSftpLoacation;
	}
	public void setDowloadSftpLoacation(String dowloadSftpLoacation) {
		this.dowloadSftpLoacation = dowloadSftpLoacation;
	}
	public String getLocalFileLocation() {
		return localFileLocation;
	}
	public void setLocalFileLocation(String localFileLocation) {
		this.localFileLocation = localFileLocation;
	}
	@Override
	public String toString() {
		return "SftpProperties [host=" + host + ", port=" + port + ", account="
				+ account + ", pwd=" + pwd + ", uploadSftpLocation="
				+ uploadSftpLocation + ", dowloadSftpLoacation="
				+ dowloadSftpLoacation + "]";
	}
	
	
}
