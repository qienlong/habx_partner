package cn.com.sinosafe.common.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 影像系统及文件相关配置
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Component
//@ConfigurationProperties(prefix = "file")
public class FileProperties {

	@Value("${file.upload.savePath}")
	private String savePath;
	
	@Value("${file.upload.imageSystem.imgUrl}")
	private String imgUrl;
	
	@Value("${file.upload.imageSystem.fileUrl}")
	private String fileUrl;
	
	@Value("${file.upload.imageSystem.imgDomain}")
	private String imgDomain;
	
	@Value("${file.canvasPlugPrefix}")
	private String canvasPlugPrefix;
	
	@Value("${file.upload.imageSystem.imgDomainHttps}")
	private String imgDomainHttps;
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getImgDomain() {
		return imgDomain;
	}
	public void setImgDomain(String imgDomain) {
		this.imgDomain = imgDomain;
	}
	public String getCanvasPlugPrefix() {
		return canvasPlugPrefix;
	}
	public void setCanvasPlugPrefix(String canvasPlugPrefix) {
		this.canvasPlugPrefix = canvasPlugPrefix;
	}
	public String getImgDomainHttps() {
		return imgDomainHttps;
	}
	public void setImgDomainHttps(String imgDomainHttps) {
		this.imgDomainHttps = imgDomainHttps;
	}
	
}
