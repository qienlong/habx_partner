package cn.com.sinosafe.domain.msxf;

/**
 * 
 * 马上消费消息体 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月20日<br>
 */
public class MsxfMqMsg {

	private String type;
	
	private String partner;
	
	private String filePath;
	
	private String date;
	
	private String data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
