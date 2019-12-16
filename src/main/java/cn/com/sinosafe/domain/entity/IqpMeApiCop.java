package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Project : Java EE 开发平台 <br>
 * Description : 渠道对接接口配置参数 <br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2018年4月27日<br>
 */
public class IqpMeApiCop {
	 /** 接口合作方定义的编号 */
    private String accid;
    
    /** 系统合作方编号 */
    private String copNo;
    
    /** 合作方密钥 */
    private String key;
    
    /** 允许访问的接口 */
    private String intefaces;
    
    /** 默认业务机构 */
    private String brId;
    
    /** 默认录入人 */
    private String inputId;
    
    /** 默认客户经理编号 */
    private String cusMgr;
    
    /** 默认客户经理 */
    private String mgrName;
    
    /** 默认客户经理手机号 */
    private String mgrPhone;
    
    /** 默认ftp */
    private String ftpType;
    
    /** 默认ftpIp */
    private String ftpHost;
    
    /** 默认ftp端口 */
    private String ftpPort;
    
    /** 默认ftp帐号 */
    private String ftpAcc;
    
    /** 默认ftp密码 */
    private String ftpPwd;
    
    /** 默认出单员 */
    private String insurInputId;
    
    /**  */
    private String copDesc;
    
    /** 执行年利率 */
    private BigDecimal grossRate;
    
    /** 默认产品编号 */
    private String prdId;
    
    /** 默认产品名称 */
    private String prdName;
    
    /** 默认自动投保单类型  loan 进件接口 file 文件接口 */
    private String insurType;
    
    /** 默认是否预审  0否1是 */
    private String preRule;
    
    /** 默认是否自动审批  0否1是 */
    private String autoRule;
    
    /** 默认是否查询征信  0否1是 */
    private String queryCredit;
    
    /** 默认ftp需定时删除的文件目录 逗号分割 */
    private String ftpDeletePath;
    
    /** 默认渠道两位编号 */
    private String copSerno;
    
    /** 默认默认通知url */
    private String noticeUrl;
    
    /**
     * 默认还款日方式  1固定日还款 2 对日还款

     */
    private String withHoldKind;
    
    public IqpMeApiCop() {
    	
    }
    
    public IqpMeApiCop(String ftpHost,String ftpPort,String ftpAcc,String ftpPwd,String ftpType) {
    	this.ftpHost = ftpHost;
    	this.ftpPort = ftpPort;
    	this.ftpAcc = ftpAcc;
    	this.ftpPwd = ftpPwd;
    	this.ftpType = ftpType;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid == null ? null : accid.trim();
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo == null ? null : copNo.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getIntefaces() {
        return intefaces;
    }

    public void setIntefaces(String intefaces) {
        this.intefaces = intefaces == null ? null : intefaces.trim();
    }

    public String getBrId() {
        return brId;
    }

    public void setBrId(String brId) {
        this.brId = brId == null ? null : brId.trim();
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId == null ? null : inputId.trim();
    }

    public String getCusMgr() {
        return cusMgr;
    }

    public void setCusMgr(String cusMgr) {
        this.cusMgr = cusMgr == null ? null : cusMgr.trim();
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName == null ? null : mgrName.trim();
    }

    public String getMgrPhone() {
        return mgrPhone;
    }

    public void setMgrPhone(String mgrPhone) {
        this.mgrPhone = mgrPhone == null ? null : mgrPhone.trim();
    }

    public String getFtpAcc() {
        return ftpAcc;
    }

    public void setFtpAcc(String ftpAcc) {
        this.ftpAcc = ftpAcc == null ? null : ftpAcc.trim();
    }

    public String getFtpPwd() {
        return ftpPwd;
    }

    public void setFtpPwd(String ftpPwd) {
        this.ftpPwd = ftpPwd == null ? null : ftpPwd.trim();
    }

    public String getInsurInputId() {
        return insurInputId;
    }

    public void setInsurInputId(String insurInputId) {
        this.insurInputId = insurInputId == null ? null : insurInputId.trim();
    }

    public String getCopDesc() {
        return copDesc;
    }

    public void setCopDesc(String copDesc) {
        this.copDesc = copDesc == null ? null : copDesc.trim();
    }

    public BigDecimal getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId == null ? null : prdId.trim();
    }

    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost == null ? null : ftpHost.trim();
    }

    public String getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(String ftpPort) {
        this.ftpPort = ftpPort == null ? null : ftpPort.trim();
    }

    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl == null ? null : noticeUrl.trim();
    }

    public String getFtpType() {
        return ftpType;
    }

    public void setFtpType(String ftpType) {
        this.ftpType = ftpType == null ? null : ftpType.trim();
    }

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getInsurType() {
		return insurType;
	}

	public void setInsurType(String insurType) {
		this.insurType = insurType;
	}

	public String getPreRule() {
		return preRule;
	}

	public void setPreRule(String preRule) {
		this.preRule = preRule;
	}

	public String getAutoRule() {
		return autoRule;
	}

	public void setAutoRule(String autoRule) {
		this.autoRule = autoRule;
	}

	public String getQueryCredit() {
		return queryCredit;
	}

	public void setQueryCredit(String queryCredit) {
		this.queryCredit = queryCredit;
	}

	public String getFtpDeletePath() {
		return ftpDeletePath;
	}

	public void setFtpDeletePath(String ftpDeletePath) {
		this.ftpDeletePath = ftpDeletePath;
	}

	public String getCopSerno() {
		return copSerno;
	}

	public void setCopSerno(String copSerno) {
		this.copSerno = copSerno;
	}

	public String getWithHoldKind() {
		return withHoldKind;
	}

	public void setWithHoldKind(String withHoldKind) {
		this.withHoldKind = withHoldKind;
	}
    
}