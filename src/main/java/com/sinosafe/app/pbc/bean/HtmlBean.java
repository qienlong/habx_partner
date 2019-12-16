package com.sinosafe.app.pbc.bean;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/***
 * 人行征信返回 html 结果bean
 * @author 隆美华
 *
 */
@SuppressWarnings("serial")
public class HtmlBean implements Serializable {
	
	private String path=""; //存放路径
	private String html=""; //string 报告网页
	private String errorHtml=""; //返回错误显示html
	private byte[] byteIo=null; //字节流
	private byte[] resultByte=null;//返回人行数据,json格式,转换为 btye返回
	@SuppressWarnings("rawtypes")
	private Map resultMap=new HashMap();//返回人行数据,为 Map 返回
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public byte[] getByteIo() {
		return byteIo;
	}
	public void setByteIo(byte[] byteIo) {
		this.byteIo = byteIo;
	}
	public String getErrorHtml() {
		return errorHtml;
	}
	public void setErrorHtml(String errorHtml) {
		this.errorHtml = errorHtml;
	}
	public byte[] getResultByte() {
		return resultByte;
	}
	public void setResultByte(byte[] resultByte) {
		this.resultByte = resultByte;
	}
	@SuppressWarnings("rawtypes")
	public Map getResultMap() {
		return resultMap;
	}
	@SuppressWarnings("rawtypes")
	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}
	
}
