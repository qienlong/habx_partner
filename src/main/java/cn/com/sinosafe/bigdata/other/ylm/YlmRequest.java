package cn.com.sinosafe.bigdata.other.ylm;

/**
 * 
 * 亚联接口请求参数 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年4月1日<br>
 */
public class YlmRequest {
	
	private String type;
	private String serno;
	private String name;
	private String idcard;
	private String mobile;
	private String bankcard;
	
	// 指定查询第三方  ylm py
	private String creditType;
	
	// 公积金参数
	private String area_code;
	private String request_id;
	private String phase_img;
	private String password;
	private String account;
	private String login_type;
	
	// 学籍参数
	private String college;
	private String starttime;
	
	// 车评估
	private String modelId;
	
	public YlmRequest() {
	}
	
	public YlmRequest(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSerno() {
		return serno;
	}
	public void setSerno(String serno) {
		this.serno = serno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBankcard() {
		return bankcard;
	}
	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public String getPhase_img() {
		return phase_img;
	}
	public void setPhase_img(String phase_img) {
		this.phase_img = phase_img;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getLogin_type() {
		return login_type;
	}
	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

}
