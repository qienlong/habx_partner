package cn.com.sinosafe.domain.entity;

public class AccMtdPlanKey {
    /**
     * 借据号
     */
    private String billNo;

    /**
     * 期号
     */
    private Short psPerdNo;

    /**
     * 借据号
     * @return BILL_NO 借据号
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * 借据号
     * @param billNo 借据号
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    /**
     * 期号
     * @return PS_PERD_NO 期号
     */
    public Short getPsPerdNo() {
        return psPerdNo;
    }

    /**
     * 期号
     * @param psPerdNo 期号
     */
    public void setPsPerdNo(Short psPerdNo) {
        this.psPerdNo = psPerdNo;
    }
}