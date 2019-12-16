package cn.com.sinosafe.domain.entity;

public class IqpMeAuditOpinionKey {
    /**
     * 主键	界面隐藏
     */
    private String pkId;

    /**
     * 客户编码
     */
    private String cusId;

    /**
     * 主键	界面隐藏
     * @return PK_ID 主键	界面隐藏
     */
    public String getPkId() {
        return pkId;
    }

    /**
     * 主键	界面隐藏
     * @param pkId 主键	界面隐藏
     */
    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    /**
     * 客户编码
     * @return CUS_ID 客户编码
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * 客户编码
     * @param cusId 客户编码
     */
    public void setCusId(String cusId) {
        this.cusId = cusId == null ? null : cusId.trim();
    }
}