/**
 * projectName: haxb_partner
 * fileName: PublicRepayment.java
 * packageName: cn.com.sinosafe.domain.entity
 * date: 2019-09-10 11:13
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.domain.entity;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: PublicRepayment
 * @packageName: cn.com.sinosafe.domain.entity
 * @description: 对公还款
 * @data: 2019-09-10 11:13
 **/
public class PublicRepayment {
    /**
     * 主键
     */
    private String id;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 核账流水号
     */
    private String serNo;
    /**
     * 保单号
     */
    private String policyNo;
    /**
     * 申请号
     */
    private String applNo;
    /**
     * 客户姓名
     */
    private String custName;
    /**
     * 对公还款金额
     */
    private String reBurAmt;
    /**
     * 对公还款存入日期
     */
    private String reBurDate;
    /**
     * 存款者姓名
     */
    private String reBurFromName;
    /**
     * 保险公司合作方
     */
    private String insuCompany;
    /**
     * 核实状态
     */
    private String reBurStatus;
    /**
     * 核实还款结果通知
     */
    private String noticeResult;
    /**
     * 借据总笔数
     */
    private String batchCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSerNo() {
        return serNo;
    }

    public void setSerNo(String serNo) {
        this.serNo = serNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getApplNo() {
        return applNo;
    }

    public void setApplNo(String applNo) {
        this.applNo = applNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getReBurAmt() {
        return reBurAmt;
    }

    public void setReBurAmt(String reBurAmt) {
        this.reBurAmt = reBurAmt;
    }

    public String getReBurDate() {
        return reBurDate;
    }

    public void setReBurDate(String reBurDate) {
        this.reBurDate = reBurDate;
    }

    public String getReBurFromName() {
        return reBurFromName;
    }

    public void setReBurFromName(String reBurFromName) {
        this.reBurFromName = reBurFromName;
    }

    public String getInsuCompany() {
        return insuCompany;
    }

    public void setInsuCompany(String insuCompany) {
        this.insuCompany = insuCompany;
    }

    public String getReBurStatus() {
        return reBurStatus;
    }

    public void setReBurStatus(String reBurStatus) {
        this.reBurStatus = reBurStatus;
    }
    public String getNoticeResult() {
        return noticeResult;
    }

    public void setNoticeResult(String noticeResult) {
        this.noticeResult = noticeResult;
    }

    public String getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(String batchCount) {
        this.batchCount = batchCount;
    }
}
