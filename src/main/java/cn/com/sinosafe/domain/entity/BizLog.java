package cn.com.sinosafe.domain.entity;

public class BizLog {
    /**
     * 主键ID
     */
    private String pkId;

    /**
     * 行业企业编码
     */
    private String extEnterpriseCode;

    /**
     * 产品编号
     */
    private String prodNo;

    /**
     * 交易类型
     */
    private String transType;

    /**
     * 交易流水号
     */
    private String transSerialNo;

    /**
     * 流程编号
     */
    private String processNo;

    /**
     * 调用类型
     */
    private String invokeType;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private String createdDate;

    /**
     * 修改人
     */
    private String updatedBy;

    /**
     * 修改时间
     */
    private String updatedDate;

    /**
     * 主键ID
     * @return PK_ID 主键ID
     */
    public String getPkId() {
        return pkId;
    }

    /**
     * 主键ID
     * @param pkId 主键ID
     */
    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    /**
     * 行业企业编码
     * @return EXT_ENTERPRISE_CODE 行业企业编码
     */
    public String getExtEnterpriseCode() {
        return extEnterpriseCode;
    }

    /**
     * 行业企业编码
     * @param extEnterpriseCode 行业企业编码
     */
    public void setExtEnterpriseCode(String extEnterpriseCode) {
        this.extEnterpriseCode = extEnterpriseCode == null ? null : extEnterpriseCode.trim();
    }

    /**
     * 产品编号
     * @return PROD_NO 产品编号
     */
    public String getProdNo() {
        return prodNo;
    }

    /**
     * 产品编号
     * @param prodNo 产品编号
     */
    public void setProdNo(String prodNo) {
        this.prodNo = prodNo == null ? null : prodNo.trim();
    }

    /**
     * 交易类型
     * @return TRANS_TYPE 交易类型
     */
    public String getTransType() {
        return transType;
    }

    /**
     * 交易类型
     * @param transType 交易类型
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * 交易流水号
     * @return TRANS_SERIAL_NO 交易流水号
     */
    public String getTransSerialNo() {
        return transSerialNo;
    }

    /**
     * 交易流水号
     * @param transSerialNo 交易流水号
     */
    public void setTransSerialNo(String transSerialNo) {
        this.transSerialNo = transSerialNo == null ? null : transSerialNo.trim();
    }

    /**
     * 流程编号
     * @return PROCESS_NO 流程编号
     */
    public String getProcessNo() {
        return processNo;
    }

    /**
     * 流程编号
     * @param processNo 流程编号
     */
    public void setProcessNo(String processNo) {
        this.processNo = processNo == null ? null : processNo.trim();
    }

    /**
     * 调用类型
     * @return INVOKE_TYPE 调用类型
     */
    public String getInvokeType() {
        return invokeType;
    }

    /**
     * 调用类型
     * @param invokeType 调用类型
     */
    public void setInvokeType(String invokeType) {
        this.invokeType = invokeType == null ? null : invokeType.trim();
    }

    /**
     * 创建人
     * @return CREATED_BY 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 创建人
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 创建时间
     * @return CREATED_DATE 创建时间
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * 创建时间
     * @param createdDate 创建时间
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate == null ? null : createdDate.trim();
    }

    /**
     * 修改人
     * @return UPDATED_BY 修改人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 修改人
     * @param updatedBy 修改人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 修改时间
     * @return UPDATED_DATE 修改时间
     */
    public String getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 修改时间
     * @param updatedDate 修改时间
     */
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate == null ? null : updatedDate.trim();
    }
}