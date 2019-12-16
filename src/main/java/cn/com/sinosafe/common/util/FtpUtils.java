package cn.com.sinosafe.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ftp连接工具 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
public class FtpUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(FtpUtils.class);

	/**
     * 下载单个文件
     * @param filePath zip路径
     * @param serno 业务流水号
     * @param ftpType ftp类型
     * @param host 主机
     * @param port 端口
     * @param ftpName 帐号
     * @param ftpPws 密码
     * @param localPath 本地目录
     * @return
     * @throws Exception
     */
    public static File downloadFile(String filePath, String serno,String ftpType,String host,int port,String ftpName,String ftpPws,String localPath) throws Exception{
        String fileDirPath = filePath.substring(0, filePath.lastIndexOf("/"));
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);

        // 判断ftp类型
        if("sftp".equalsIgnoreCase(ftpType)){
            SftpUtil ftp = new SftpUtil(host, port, ftpName, ftpPws);
            ftp.connect();
            File localDir = new File(localPath);
            if (!localDir.exists()) {
                localDir.mkdir();
            }
            ftp.cd(fileDirPath);

            ftp.download(fileDirPath, fileName, localPath + File.separator + serno);
            ftp.disconnect();
        }else{
            boolean flag = getFile(host, port, ftpName, ftpPws, fileDirPath, localPath + File.separator + serno, fileName);
            if(!flag){
                throw new Exception("从ftp上下载文件失败");
            }
        }
        return new File(localPath + File.separator + serno + File.separator + fileName);//返回所有文件的
    }

    /**
     * 从FTP服务器下载文件
     * @param server FTP服务器IP
     * @param port FTP服务器端口
     * @param username 登录用户名
     * @param password 密码
     * @param ftpFolder FTP服务器文件夹路径
     * @param localFolder 本地存储文件夹路径
     * @param fileName 文件名
     * @return
     * @throws Exception
     */
    public static boolean getFile(String server,int port, String username, String password,
                           String ftpFolder, String localFolder, String fileName) throws Exception
    {
        boolean rtnFlag = false;
        FTPClient ftp = new FTPClient();
        FileOutputStream fos = null;

        try {
            logger.info(" connecting FTP server " + server + " : " + port + " ...");
            // 连接FTP服务器
            ftp.connect(server, port);
            logger.info(" connected -------- " + server + " : " + port);

            // 登陆FTP服务器
            if (!ftp.login(username, password)) {
                throw new Exception("登录FTP服务器失败");
            }
            logger.info(" user login ------- " + username + " : " + password);

            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();

            // 设置下载目录
            if (!ftp.changeWorkingDirectory(ftpFolder)) {
                throw new Exception("FTP服务器上不存在文件夹 " + ftpFolder);
            }

            // 创建文件夹
            File fileFold = new File(localFolder);
            if (!fileFold.exists()) {
                fileFold.mkdirs();
            }
            File file = new File(localFolder, fileName);
            fos = new FileOutputStream(file);

            // 下载文件
            if (!ftp.retrieveFile(fileName, fos)) {
                fos.close();
                file.delete();
                return false;
            }
            ftp.logout();
            logger.info(" recv file -------- " + localFolder + "/" + fileName);

            rtnFlag = true;
        } catch (Exception e) {
            throw new Exception("与FTP服务器通讯出错：" + e.getMessage());
        } finally {
        	FileUtils.closeQuietly(fos);
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException f) {
                    throw new Exception("关闭FTP连接发生异常");
                }
            }
        }
        return rtnFlag;
    }

    /**
     * 上传文件至FTP服务器
     * @param server FTP服务器IP
     * @param port FTP服务器端口
     * @param username 登录用户名
     * @param password 密码
     * @param ftpFolder FTP服务器上传文件夹路径
     * @param localFolder 本地存储文件夹路径
     * @param fileName 文件名
     * @return
     * @throws Exception
     */
    public static boolean sendFile(String server, int port, String username, String password,
                            String ftpFolder, String localFolder, String fileName) throws Exception
    {
        boolean rtnFlag = false;
        FTPClient ftp = new FTPClient();
        FileInputStream fis = null;

        try {
            logger.info(" connecting FTP server " + server + " : " + port + " ...");
            // 连接FTP服务器
            ftp.connect(server,port);
            logger.info(" connected -------- " + server + " : " + port);

            // 登陆FTP服务器
            if (!ftp.login(username, password)) {
                throw new Exception("登录FTP服务器" + server + "失败");
            }
            logger.info(" user login ------- " + username + " : " + password);

            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();

            File srcFile = new File(localFolder, fileName);
            fis = new FileInputStream(srcFile);

            // 设置上传目录
            if (null != ftpFolder && 0 < ftpFolder.trim().length())
            {
                //如果不存在目录，则创建目录
                if (!ftp.changeWorkingDirectory(ftpFolder)) {
                    ftp.makeDirectory(ftpFolder);
                }
                ftp.changeWorkingDirectory(ftpFolder);

            } else {
                throw new Exception("FTP服务器上传文件夹不能为空");
            }

            // 上传文件
            if (!ftp.storeFile(fileName, fis)) {
                return false;
            }
            ftp.logout();
            logger.info(" store file ------- " + ftpFolder + "/" + fileName);

            rtnFlag = true;
        } catch (Exception e) {
            throw new Exception("与FTP服务器通讯出错：" + e.getMessage());
        } finally {
            FileUtils.closeQuietly(fis);
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException f) {
                    throw new Exception("关闭FTP连接发生异常");
                }
            }
        }
        return rtnFlag;
    }
}
