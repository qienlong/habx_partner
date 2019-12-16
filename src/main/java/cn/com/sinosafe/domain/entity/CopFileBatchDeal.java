package cn.com.sinosafe.domain.entity;

/**
 * 
 * ftp参数配置表 CopFileBatchDeal <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年7月30日<br>
 */
public class CopFileBatchDeal {
    private String copName;

    private String ftpType;

    private String ftpHost;

    private Integer ftpPort;

    private String ftpUsername;

    private String ftpPwd;

    private String downloadPath;

    private String uploadPath;

    private String locatePath;

    private String intefaces;

    private String memo;

    private String partnerNo;

    private String backupEffectFlag;

    public String getCopName() {
        return copName;
    }

    public void setCopName(String copName) {
        this.copName = copName == null ? null : copName.trim();
    }

    public String getFtpType() {
        return ftpType;
    }

    public void setFtpType(String ftpType) {
        this.ftpType = ftpType == null ? null : ftpType.trim();
    }

    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost == null ? null : ftpHost.trim();
    }

    public Integer getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(Integer ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUsername() {
        return ftpUsername;
    }

    public void setFtpUsername(String ftpUsername) {
        this.ftpUsername = ftpUsername == null ? null : ftpUsername.trim();
    }

    public String getFtpPwd() {
        return ftpPwd;
    }

    public void setFtpPwd(String ftpPwd) {
        this.ftpPwd = ftpPwd == null ? null : ftpPwd.trim();
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath == null ? null : downloadPath.trim();
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath == null ? null : uploadPath.trim();
    }

    public String getLocatePath() {
        return locatePath;
    }

    public void setLocatePath(String locatePath) {
        this.locatePath = locatePath == null ? null : locatePath.trim();
    }

    public String getIntefaces() {
        return intefaces;
    }

    public void setIntefaces(String intefaces) {
        this.intefaces = intefaces == null ? null : intefaces.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getPartnerNo() {
        return partnerNo;
    }

    public void setPartnerNo(String partnerNo) {
        this.partnerNo = partnerNo == null ? null : partnerNo.trim();
    }

    public String getBackupEffectFlag() {
        return backupEffectFlag;
    }

    public void setBackupEffectFlag(String backupEffectFlag) {
        this.backupEffectFlag = backupEffectFlag == null ? null : backupEffectFlag.trim();
    }
}