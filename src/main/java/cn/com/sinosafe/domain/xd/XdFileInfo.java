package cn.com.sinosafe.domain.xd;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-11-04
 */
public class XdFileInfo {

    //文件在ftp的路径
    private String filePath;

    //文件类型
    private String fileType;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
