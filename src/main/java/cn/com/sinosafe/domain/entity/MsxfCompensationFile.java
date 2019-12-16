package cn.com.sinosafe.domain.entity;


/**
 * @author Administrator
 *马上核赔数据存储类
 */
public class MsxfCompensationFile {

	private String pkId;//索赔申请号
    private String batchNo;//借据号
    private String perdNo;//索赔期次号
    private String premDate;//索赔日期
    private String prinAmt;//索赔本金
    private String intAmt;//索赔利息
    private String claimAmt;//索赔罚息
    private String lcAmt;//索赔复利
    private String approveStatus;//征信报送状态
    private String checkResult;//校验结果
    private String failReasons;//校验失败原因
    
    private String partner;//银行

	public String getPkId() {
		return pkId;
	}

	public void setPkId(String pkId) {
		this.pkId = pkId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPerdNo() {
		return perdNo;
	}

	public void setPerdNo(String perdNo) {
		this.perdNo = perdNo;
	}

	public String getPremDate() {
		return premDate;
	}

	public void setPremDate(String premDate) {
		this.premDate = premDate;
	}

	public String getPrinAmt() {
		return prinAmt;
	}

	public void setPrinAmt(String prinAmt) {
		this.prinAmt = prinAmt;
	}

	public String getIntAmt() {
		return intAmt;
	}

	public void setIntAmt(String intAmt) {
		this.intAmt = intAmt;
	}

	public String getClaimAmt() {
		return claimAmt;
	}

	public void setClaimAmt(String claimAmt) {
		this.claimAmt = claimAmt;
	}

	public String getLcAmt() {
		return lcAmt;
	}

	public void setLcAmt(String lcAmt) {
		this.lcAmt = lcAmt;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getFailReasons() {
		return failReasons;
	}

	public void setFailReasons(String failReasons) {
		this.failReasons = failReasons;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	
}
