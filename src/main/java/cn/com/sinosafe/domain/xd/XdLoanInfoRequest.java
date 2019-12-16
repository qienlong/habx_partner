package cn.com.sinosafe.domain.xd;

import java.util.List;

/**
 * 
 * 小贷申请进件请求参数 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
public class XdLoanInfoRequest {

    //唯一编号
    private String contNO;

    //客户姓名
    private String cusName;

    //证件类型
    private String certType;

    //证件号码
    private String certNo;

    //行政区划编号
    private String rsdRelId;

    //居住地址
    private String rsdAddress;

    //行政区划编号
    private String regRelId;

    //户籍地址
    private String registerAddress;

    //客户卡号
    private String cusBankCardNo;

    //手机号码
    private String phone;

    //还款账户开户行
    private String bankName;

    //还款账户开户行号
    private String bankNo;

    //还款账户
    private String bankCardNo;

    //婚姻状况
    private String marryStatus;

    //配偶姓名
    private String spouseName;

    //配偶证件类型 默认 10 居民身份证
    private String spouseCertType;

    //配偶证件号码
    private String spouseCertNo;

    //配偶手机号
    private String spousePhone;

    //单位名称
    private String comName;

    //行政区划编号
    private String comRelId;

    //单位地址
    private String comAddr;

    //单位电话
    private String comPhone;

    //教育程度
    private String education;

    //申请金额（元）
    private String applyAmt;

    //期限类型 01天 02月
    private String termType;

    //申请期限
    private String term;

    //还款方式
    private String repayModel;

    //收款账户户名
    private String payeeBankCusName;

    //收款账户
    private String payeeBankCardNo;

    //借款用途
    private String loanUse;

    //文件在ftp的路径
    private List<XdFileInfo> filePaths;

    //业务类型 05210305-消费贷 05210304-经营贷
    private String busiType;

    //资金方编号
    private String partnerNo;

    //居住状况
    private String liveStatus;

    //客户类型
    private String cusType;

    //营业执照统一社会信用代码
    private String comCertNo;

    //经营主体所属行业编码
    private String comFld;

    //是否受托支付
    private String payType;

    //行业投向编码
    private String industry;

    //行业投向名称
    private String industryName;

    // 职业，参考字典表，传4位数字 对应 iqp_me_cus_app表 indiv_occ 字段
    private String occupation;

    // 证件有效期，yyyy-MM-dd  对应 iqp_me_cus_app表 indiv_id_long 字段
    private String validation;

    // 缴费账号，客户一类卡号
    private String paymentAccount;

    // 证件号起期
    private String idStartDate;

    //月收入
    private String loanPurpose;

    private String type;
    // 合作方唯一标识
    private String accid;

    //另加字段
    private String serno;
    private String cusId;

    //放款通知接口字段
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public String getContNO() {
        return contNO;
    }

    public void setContNO(String contNO) {
        this.contNO = contNO;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getRsdRelId() {
        return rsdRelId;
    }

    public void setRsdRelId(String rsdRelId) {
        this.rsdRelId = rsdRelId;
    }

    public String getRsdAddress() {
        return rsdAddress;
    }

    public void setRsdAddress(String rsdAddress) {
        this.rsdAddress = rsdAddress;
    }

    public String getRegRelId() {
        return regRelId;
    }

    public void setRegRelId(String regRelId) {
        this.regRelId = regRelId;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getCusBankCardNo() {
        return cusBankCardNo;
    }

    public void setCusBankCardNo(String cusBankCardNo) {
        this.cusBankCardNo = cusBankCardNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseCertType() {
        return spouseCertType;
    }

    public void setSpouseCertType(String spouseCertType) {
        this.spouseCertType = spouseCertType;
    }

    public String getSpouseCertNo() {
        return spouseCertNo;
    }

    public void setSpouseCertNo(String spouseCertNo) {
        this.spouseCertNo = spouseCertNo;
    }

    public String getSpousePhone() {
        return spousePhone;
    }

    public void setSpousePhone(String spousePhone) {
        this.spousePhone = spousePhone;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComRelId() {
        return comRelId;
    }

    public void setComRelId(String comRelId) {
        this.comRelId = comRelId;
    }

    public String getComAddr() {
        return comAddr;
    }

    public void setComAddr(String comAddr) {
        this.comAddr = comAddr;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getApplyAmt() {
        return applyAmt;
    }

    public void setApplyAmt(String applyAmt) {
        this.applyAmt = applyAmt;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getRepayModel() {
        return repayModel;
    }

    public void setRepayModel(String repayModel) {
        this.repayModel = repayModel;
    }

    public String getPayeeBankCusName() {
        return payeeBankCusName;
    }

    public void setPayeeBankCusName(String payeeBankCusName) {
        this.payeeBankCusName = payeeBankCusName;
    }

    public String getPayeeBankCardNo() {
        return payeeBankCardNo;
    }

    public void setPayeeBankCardNo(String payeeBankCardNo) {
        this.payeeBankCardNo = payeeBankCardNo;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse;
    }

    public List<XdFileInfo> getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(List<XdFileInfo> filePaths) {
        this.filePaths = filePaths;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getPartnerNo() {
        return partnerNo;
    }

    public void setPartnerNo(String partnerNo) {
        this.partnerNo = partnerNo;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    public String getComCertNo() {
        return comCertNo;
    }

    public void setComCertNo(String comCertNo) {
        this.comCertNo = comCertNo;
    }

    public String getComFld() {
        return comFld;
    }

    public void setComFld(String comFld) {
        this.comFld = comFld;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public String getIdStartDate() {
        return idStartDate;
    }

    public void setIdStartDate(String idStartDate) {
        this.idStartDate = idStartDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
}
