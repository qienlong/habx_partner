package cn.com.sinosafe.domain.entity;

public class CopFiledate {
    private String copname;

    private String filedate;

    private String copDescribe;

    private String cutDate;

    public String getCopname() {
        return copname;
    }

    public void setCopname(String copname) {
        this.copname = copname == null ? null : copname.trim();
    }

    public String getFiledate() {
        return filedate;
    }

    public void setFiledate(String filedate) {
        this.filedate = filedate == null ? null : filedate.trim();
    }

    public String getCopDescribe() {
        return copDescribe;
    }

    public void setCopDescribe(String copDescribe) {
        this.copDescribe = copDescribe == null ? null : copDescribe.trim();
    }

    public String getCutDate() {
        return cutDate;
    }

    public void setCutDate(String cutDate) {
        this.cutDate = cutDate == null ? null : cutDate.trim();
    }
}