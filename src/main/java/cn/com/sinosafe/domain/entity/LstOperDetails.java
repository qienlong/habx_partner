package cn.com.sinosafe.domain.entity;

public class LstOperDetails {
    /**
     * null
     */
    private String pkId;

    /**
     * null
     */
    private String serno;

    /**
     * null
     */
    private String iqpSerno;

    /**
     * null
     */
    private String operId;

    /**
     * null
     */
    private String operOrgid;

    /**
     * null
     */
    private String status;

    /**
     * null
     */
    private String operTime;

    /**
     * null
     */
    private String taskBeginTime;

    /**
     * null
     */
    private String taskEndTime;

    /**
     * 说明
     */
    private String nodename;

    /**
     * 第二说明
     */
    private String nodenameTwo;

    /**
     * 备注
     */
    private String remark;

    /**
     * null
     * @return PK_ID null
     */
    public String getPkId() {
        return pkId;
    }

    /**
     * null
     * @param pkId null
     */
    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    /**
     * null
     * @return SERNO null
     */
    public String getSerno() {
        return serno;
    }

    /**
     * null
     * @param serno null
     */
    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    /**
     * null
     * @return IQP_SERNO null
     */
    public String getIqpSerno() {
        return iqpSerno;
    }

    /**
     * null
     * @param iqpSerno null
     */
    public void setIqpSerno(String iqpSerno) {
        this.iqpSerno = iqpSerno == null ? null : iqpSerno.trim();
    }

    /**
     * null
     * @return OPER_ID null
     */
    public String getOperId() {
        return operId;
    }

    /**
     * null
     * @param operId null
     */
    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }

    /**
     * null
     * @return OPER_ORGID null
     */
    public String getOperOrgid() {
        return operOrgid;
    }

    /**
     * null
     * @param operOrgid null
     */
    public void setOperOrgid(String operOrgid) {
        this.operOrgid = operOrgid == null ? null : operOrgid.trim();
    }

    /**
     * null
     * @return STATUS null
     */
    public String getStatus() {
        return status;
    }

    /**
     * null
     * @param status null
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * null
     * @return OPER_TIME null
     */
    public String getOperTime() {
        return operTime;
    }

    /**
     * null
     * @param operTime null
     */
    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }

    /**
     * null
     * @return TASK_BEGIN_TIME null
     */
    public String getTaskBeginTime() {
        return taskBeginTime;
    }

    /**
     * null
     * @param taskBeginTime null
     */
    public void setTaskBeginTime(String taskBeginTime) {
        this.taskBeginTime = taskBeginTime == null ? null : taskBeginTime.trim();
    }

    /**
     * null
     * @return TASK_END_TIME null
     */
    public String getTaskEndTime() {
        return taskEndTime;
    }

    /**
     * null
     * @param taskEndTime null
     */
    public void setTaskEndTime(String taskEndTime) {
        this.taskEndTime = taskEndTime == null ? null : taskEndTime.trim();
    }

    /**
     * 说明
     * @return NODENAME 说明
     */
    public String getNodename() {
        return nodename;
    }

    /**
     * 说明
     * @param nodename 说明
     */
    public void setNodename(String nodename) {
        this.nodename = nodename == null ? null : nodename.trim();
    }

    /**
     * 第二说明
     * @return NODENAME_TWO 第二说明
     */
    public String getNodenameTwo() {
        return nodenameTwo;
    }

    /**
     * 第二说明
     * @param nodenameTwo 第二说明
     */
    public void setNodenameTwo(String nodenameTwo) {
        this.nodenameTwo = nodenameTwo == null ? null : nodenameTwo.trim();
    }

    /**
     * 备注
     * @return REMARK 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}