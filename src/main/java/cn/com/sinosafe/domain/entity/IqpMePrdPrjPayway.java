package cn.com.sinosafe.domain.entity;

public class IqpMePrdPrjPayway {
    private String prdId;

    private String partnerNo;

    private String payWay;

    private String repayModel;

    private String termType;

    private String term;

    private String grossRate;

    private String memo;

    private String loanUseNo;

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId == null ? null : prdId.trim();
    }

    public String getPartnerNo() {
        return partnerNo;
    }

    public void setPartnerNo(String partnerNo) {
        this.partnerNo = partnerNo == null ? null : partnerNo.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getRepayModel() {
        return repayModel;
    }

    public void setRepayModel(String repayModel) {
        this.repayModel = repayModel == null ? null : repayModel.trim();
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType == null ? null : termType.trim();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public String getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(String grossRate) {
        this.grossRate = grossRate == null ? null : grossRate.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getLoanUseNo() {
        return loanUseNo;
    }

    public void setLoanUseNo(String loanUseNo) {
        this.loanUseNo = loanUseNo == null ? null : loanUseNo.trim();
    }
}