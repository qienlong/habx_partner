package com.sinosafe.app.pbc.bean;


import java.io.Serializable;

/***
 * 人行征信输入bean
 * @author 隆美华
 *
 */
@SuppressWarnings("serial")
public class ParamerBean implements Serializable {
 
 
	 private String name ;//姓名
	 private String idno ;//证件号
	 private String idtype ;//证件类型
	 private String queryReason ;//查询原因(贷后管理)
	 private String branch ;//机构号
	 private String serno ;//业务流水号
	 private String obligate ;//预留字段   可以用 | 分隔 并获取传入参数
	 
	 private String loanid ;//贷款卡编码
	 private String loanpwd ;//贷款卡密码
	 private String queryStyle ;//查询板式
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public String getQueryReason() {
		return queryReason;
	}
	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSerno() {
		return serno;
	}
	public void setSerno(String serno) {
		this.serno = serno;
	}
	public String getObligate() {
		return obligate;
	}
	public void setObligate(String obligate) {
		this.obligate = obligate;
	}
	public String getLoanid() {
		return loanid;
	}
	public void setLoanid(String loanid) {
		this.loanid = loanid;
	}
	public String getLoanpwd() {
		return loanpwd;
	}
	public void setLoanpwd(String loanpwd) {
		this.loanpwd = loanpwd;
	}
	public String getQueryStyle() {
		return queryStyle;
	}
	public void setQueryStyle(String queryStyle) {
		this.queryStyle = queryStyle;
	}
 
	 
}
