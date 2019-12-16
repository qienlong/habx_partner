package cn.com.sinosafe.domain.entity;

/**
 * @Author xiehanchun
 * @Time 2019/8/19 9:37
 * @Version 1.0
 */
public class IapsEntity {
    /**
     * 申请号 （主键）
     */
    private String merchantSeqNo;
    /**
     * 消息版本号
     */
    private String version;
    /**
     * 字符编码
     */
    private String charset;
    /**
     * 签名方法
     */
    private String signMethod;
    /**
     * 交易类型
     */
    private String transType;
    /**
     * 响应码
     */
    private String respCode;
    /**
     * 响应信息
     */
    private String respMsg;
    /**
     * 签名信息
     */
    private String signature;

    public String getMerchantSeqNo() {
        return merchantSeqNo;
    }

    public void setMerchantSeqNo(String merchantSeqNo) {
        this.merchantSeqNo = merchantSeqNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignMethod() {
        return signMethod;
    }

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
