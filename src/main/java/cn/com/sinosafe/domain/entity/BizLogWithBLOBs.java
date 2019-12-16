package cn.com.sinosafe.domain.entity;

public class BizLogWithBLOBs extends BizLog {
    /**
     * 入口报文
     */
    private String inputReport;

    /**
     * 出口报文
     */
    private String outputReport;

    /**
     * 请求服务化报文
     */
    private String requestReport;

    /**
     * 入口报文
     * @return INPUT_REPORT 入口报文
     */
    public String getInputReport() {
        return inputReport;
    }

    /**
     * 入口报文
     * @param inputReport 入口报文
     */
    public void setInputReport(String inputReport) {
        this.inputReport = inputReport == null ? null : inputReport.trim();
    }

    /**
     * 出口报文
     * @return OUTPUT_REPORT 出口报文
     */
    public String getOutputReport() {
        return outputReport;
    }

    /**
     * 出口报文
     * @param outputReport 出口报文
     */
    public void setOutputReport(String outputReport) {
        this.outputReport = outputReport == null ? null : outputReport.trim();
    }

    /**
     * 请求服务化报文
     * @return REQUEST_REPORT 请求服务化报文
     */
    public String getRequestReport() {
        return requestReport;
    }

    /**
     * 请求服务化报文
     * @param requestReport 请求服务化报文
     */
    public void setRequestReport(String requestReport) {
        this.requestReport = requestReport == null ? null : requestReport.trim();
    }
}