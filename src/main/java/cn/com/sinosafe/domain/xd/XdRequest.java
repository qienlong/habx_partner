package cn.com.sinosafe.domain.xd;

/**
 * 
 * 小贷请求参数 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
public class XdRequest {
	
	private String accid;
	private String type;
	private String params;
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	

}
