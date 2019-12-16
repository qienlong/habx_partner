package com.sinosafe.app.pbc.bean;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/***
 * 人行征信返回结果bean
 * @author 隆美华
 *
 */
@SuppressWarnings("serial")
public class ResultPbcBean implements Serializable {
	private String MSG="";//返回结果
	private String CODE="";//返回结果代码  0- 查询成功 1-失败
	private String ERR="";//返回异常信息
	private String REQUESTPBC="";//  1- 是在线查询  2- 缓存查询
	private String OPERID="";//登录人行查询查询工号
	private String HTML="";//返回网页
	private HtmlBean htmlBean=null;
	private Map<Object, Object> fcio=new HashMap<Object, Object>();
	
	public String getMSG() {
		return MSG;
	}
	public void setMSG(String msg) {
		MSG = msg;
	}
	public String getCODE() {
		return CODE;
	}
	public void setCODE(String code) {
		CODE = code;
	}
	public String getERR() {
		return ERR;
	}
	public void setERR(String err) {
		ERR = err;
	}
	public String getREQUESTPBC() {
		return REQUESTPBC;
	}
	public void setREQUESTPBC(String requestpbc) {
		REQUESTPBC = requestpbc;
	}
	public String getOPERID() {
		return OPERID;
	}
	public void setOPERID(String queryUser) {
		this.OPERID = queryUser;
	}
	public String getHTML() {
		return HTML;
	}
	public void setHTML(String html) {
		HTML = html;
	}
	public HtmlBean getHtmlBean() {
		return htmlBean;
	}
	public void setHtmlBean(HtmlBean htmlBean) {
		this.htmlBean = htmlBean;
	}
	public Map<Object, Object> getFcio() {
		return fcio;
	}
	public void setFcio(Map<Object, Object> fcio) {
		this.fcio = fcio;
	}
 
}
