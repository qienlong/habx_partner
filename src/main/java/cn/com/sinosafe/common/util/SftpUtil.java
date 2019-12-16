package cn.com.sinosafe.common.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import org.apache.log4j.Logger;

/**
 * SFTP操作
 * 
 * @author liuyicong
 *
 */
public class SftpUtil {
    private Logger logger = Logger.getLogger(getClass());
	/** Sftp */
	ChannelSftp sftp = null;
	/** 主机 */
	private String host = "";
	/** 端口 */
	private int port = 0;
	/** 用户名 */
	private String username = "";
	/** 密码 */
	private String password = "";

	/**
	 * 构造函数
	 * 
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 * 
	 */
	public SftpUtil(String host, int port, String username, String password) {

		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	/**
	 * 连接sftp服务器
	 * 
	 * @throws Exception
	 */
	public void connect() throws Exception {

		JSch jsch = new JSch();
		Session sshSession = jsch.getSession(this.username, this.host, this.port);
		// EMPLog.log("SftpUtil", EMPLog.INFO, 0, "Session created.");

		sshSession.setPassword(password);
		Properties sshConfig = new Properties();
		sshConfig.put("StrictHostKeyChecking", "no");
		sshSession.setConfig(sshConfig);
		sshSession.connect(20000);
		// EMPLog.log("SftpUtil", EMPLog.INFO, 0, "Session connected.");
		// EMPLog.log("SftpUtil", EMPLog.INFO, 0, " Opening Channel.");
		Channel channel = sshSession.openChannel("sftp");
		channel.connect();
		this.sftp = (ChannelSftp) channel;
		// EMPLog.log("SftpUtil", EMPLog.INFO, 0, " Connected to " + this.host+
		// ".");
	}

	/**
	 * Disconnect with server
	 * 
	 * @throws Exception
	 */
	public void disconnect() throws Exception {
		if (this.sftp != null) {
			if (this.sftp.isConnected()) {
				this.sftp.disconnect();
			} else if (this.sftp.isClosed()) {
				// EMPLog.log("SftpUtil", EMPLog.INFO, 0," sftp is closed
				// already");
			}
		}
	}

	/**
	 * create Directory
	 * 
	 * @param filepath
	 * @param sftp
	 * @throws SftpException
	 */
	public void createDir(String filepath) throws SftpException {

		String[] remotepath = filepath.substring(1, filepath.lastIndexOf("/")).split("/");

		String path = "";
		for (String dir : remotepath) {
			path = path + "/" + dir;
			try {
				this.sftp.cd(path);
			} catch (Exception e) {
				this.sftp.mkdir(path);
				this.sftp.cd(path);
			}
		}
	}

	/**
	 * 上传单个文件
	 * 
	 * @param directory
	 *            上传的目录
	 * @param uploadFile
	 *            要上传的文件
	 * 
	 * @throws Exception
	 */
	public void upload(String directory, String uploadFile) throws Exception {
		try {
			this.sftp.cd(directory);
		}catch (Exception e){
			this.createDir(directory);
		}
		File file = new File(uploadFile);
		this.sftp.put(new FileInputStream(file), file.getName());
	}

	/**
	 * 上传目录下全部文件
	 * 
	 * @param directory
	 *            上传的目录
	 * 
	 * @throws Exception
	 */
	public void uploadByDirectory(String localDirectory, String remoteDirectory) throws Exception {
		this.createDir(remoteDirectory);
		String uploadFile = "";
		File folder = new File(localDirectory);
		if (folder.exists() && folder.isDirectory()) {
			File[] files = folder.listFiles();
			for (File fileIndex : files) {
				String src = fileIndex.toString();
				System.out.println("src:" + src);
				if (fileIndex.isDirectory()) {
					// this.upload(remoteDirectory, src);
					uploadByDirectory(src, remoteDirectory + src.substring(src.lastIndexOf("/") + 1) + "/");
				} else {
					this.upload(remoteDirectory, src);
				}
			}
		}
	}

	/**
	 * 下载单个文件
	 * 
	 * @param directory
	 *            下载目录
	 * @param downloadFile
	 *            下载的文件
	 * @param saveDirectory
	 *            存在本地的路径
	 * 
	 * @throws Exception
	 */
	public void download(String directory, String downloadFile, String saveDirectory) throws Exception {
		this.sftp.cd(directory);
		String saveFile = saveDirectory + "/" + downloadFile;
		File file = new File(saveFile);
		file.getParentFile().mkdirs();// 创建目录
		//  modify by xiechong 2018/09/27
		//this.sftp.get(downloadFile, new FileOutputStream(file));
		OutputStream out = new FileOutputStream(file);
		this.sftp.get(downloadFile, out);
		out.flush();
		out.close();
	}

	/**
	 * 下载目录下全部文件
	 * 
	 * @param directory
	 *            下载目录
	 * 
	 * @param saveDirectory
	 *            存在本地的路径
	 * 
	 * @throws Exception
	 */
	public void downloadByDirectory(String directory, String saveDirectory) throws Exception {
		String downloadFile = "";
		List<String> downloadFileList = this.listFiles(directory);
		Iterator<String> it = downloadFileList.iterator();

		while (it.hasNext()) {
			downloadFile = it.next().toString();
			if (downloadFile.toString().indexOf(".") < 0) {
				continue;
			}
			this.download(directory, downloadFile, saveDirectory);
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param directory
	 *            要删除文件所在目录
	 * @param deleteFile
	 *            要删除的文件
	 * 
	 * @throws Exception
	 */
	public void delete(String directory, String deleteFile) throws Exception {
		this.sftp.cd(directory);
		this.sftp.rm(deleteFile);
	}

	/**
	 * 列出目录下的文件
	 * 
	 * @param directory
	 *            要列出的目录
	 * 
	 * @return list 文件名列表
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<String> listFiles(String directory) throws Exception {

		Vector fileList;
		List<String> fileNameList = new ArrayList<String>();

		fileList = this.sftp.ls(directory);
		Iterator it = fileList.iterator();

		while (it.hasNext()) {
			String fileName = ((LsEntry) it.next()).getFilename();
			if (".".equals(fileName) || "..".equals(fileName)) {
				continue;
			}
			fileNameList.add(fileName);

		}

		return fileNameList;
	}

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 * 
	 * @param dir
	 *            将要删除的文件目录
	 * @return boolean Returns "true" if all deletions were successful. If a
	 *         deletion fails, the method stops attempting to delete and returns
	 *         "false".
	 */
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

	/**
	 * 更改文件名
	 * 
	 * @param directory
	 *            文件所在目录
	 * @param oldFileNm
	 *            原文件名
	 * @param newFileNm
	 *            新文件名
	 * 
	 * @throws Exception
	 */
	public void rename(String directory, String oldFileNm, String newFileNm) throws Exception {
		this.sftp.cd(directory);
		this.sftp.rename(oldFileNm, newFileNm);
	}

	public void cd(String directory) throws Exception {
		this.sftp.cd(directory);
	}

	/**
	 * @description:从服务器上读取指定的文件名，读取内容并以List<String>形式返回：第一行对应list[0]，第二行对应list[1]，……
	 */
	public List<String> get(String directory) throws Exception {
		InputStream ins = null;
		try {
			ins = this.sftp.get(directory);
		} catch (Exception e) {
		}
		List<String> list = new ArrayList<String>();
		try {
			// 从服务器上读取指定的文件
			if (ins == null) {
				//throw new RuntimeException("读取文件：" + directory + "失败！");
				return list;
			}
//			BufferedReader reader = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(ins, "GBK"));
			String lineTxt = "";  
			while ((lineTxt = reader.readLine()) != null) {
				lineTxt+='\n';  
				list.add(lineTxt);
			}
			reader.close();
			if (ins != null) {
				ins.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

    /**
     * <p>删除文件夹<p>
     * @param dirName
     * @return
     * <p>xiechong 2018/09/28</p>
     */
    @SuppressWarnings("unchecked")
    public boolean delDir(String dirName){
        if(!changeDir(dirName)){
            return false;
        }

        Vector<LsEntry> list = null;
        try {
            list = sftp.ls(sftp.pwd());
        } catch (SftpException e) {
            logger.error("can not list directory",e);
            return false;
        }

        for(LsEntry entry : list){
            String fileName = entry.getFilename();
            if(!fileName.equals(".") && !fileName.equals("..")){
                if(entry.getAttrs().isDir()){
                    delDir(fileName);
                } else {
                    delFile(fileName);
                }
            }
        }

        if(!changeToParentDir()){
            return false;
        }

        try {
            sftp.rmdir(dirName);
            logger.debug("directory " + dirName + " successfully deleted");
            return true;
        } catch (SftpException e) {
            logger.error("failed to delete directory " + dirName,e);
            return false;
        }
    }

    /**
     * <p>删除文件</p>
     * @param fileName 文件名
     * @return boolean
     * <p>xiechong 2018/09/28</p>
     */
    public boolean delFile(String fileName){
        if(fileName == null || fileName.trim().equals("")){
            logger.debug("invalid filename");
            return false;
        }

        try {
            sftp.rm(fileName);
            logger.debug("file " + fileName + " successfully deleted");
            return true;
        } catch (SftpException e) {
            logger.error("failed to delete file " + fileName,e);
            return false;
        }
    }

    /**
     * <p>切换工作目录</p>
     * <p>使用示例，SFTP服务器上的目录结构如下：/testA/testA_B/</p>
     * <p>
     * <table border="1">
     * <tr><td>当前目录</td><td>方法</td><td>参数(绝对路径/相对路径)</td><td>切换后的目录</td></tr>
     * <tr><td>/</td><td>changeDir("testA")</td><td>相对路径</td><td>/testA/</td></tr>
     * <tr><td>/</td><td>changeDir("testA/testA_B")</td><td>相对路径</td><td>/testA/testA_B/</td></tr>
     * <tr><td>/</td><td>changeDir("/testA")</td><td>绝对路径</td><td>/testA/</td></tr>
     * <tr><td>/testA/testA_B/</td><td>changeDir("/testA")</td><td>绝对路径</td><td>/testA/</td></tr>
     * </table>
     * </p>
     * @param pathName 路径
     * @return boolean
     *
     * <p>xiechong 2018/09/28</p>
     */
    public boolean changeDir(String pathName){
        if(pathName == null || pathName.trim().equals("")){
            logger.debug("invalid pathName");
            return false;
        }

        try {
            sftp.cd(pathName.replaceAll("\\\\", "/"));
            logger.debug("directory successfully changed,current dir=" + sftp.pwd());
            return true;
        } catch (SftpException e) {
            logger.error("failed to change directory",e);
            return false;
        }
    }


    /**
     *<p> 切换到上一级目录</p>
     * <p>
     * <p>使用示例，SFTP服务器上的目录结构如下：/testA/testA_B/</p>
     * <table border="1">
     * <tr><td>当前目录</td><td>方法</td><td>切换后的目录</td></tr>
     * <tr><td>/testA/</td><td>changeToParentDir()</td><td>/</td></tr>
     * <tr><td>/testA/testA_B/</td><td>changeToParentDir()</td><td>/testA/</td></tr>
     * </table>
     * </p>
     * @return boolean
     *
     * <p>xiechong 2018/09/28</p>
     */
    public boolean changeToParentDir(){
        return changeDir("..");
    }

	/**
	 * <p>列出目录下的文件</p>
	 * @param directory 要列出的目录
	 * @return
	 * xiechong
	 */
	@SuppressWarnings("unchecked")
	public List<String> listAllFilesPath(String directory, List<String> FilesPathLists) throws Exception{

		//List<String> FilesPathLists = new ArrayList<String>();
		if(!changeDir(directory)){
			return null;
		}

		Vector<LsEntry> list = null;
		try {
			list = sftp.ls(sftp.pwd());
		} catch (SftpException e) {
			logger.error("can not list directory",e);
			return null;
		}

		for(LsEntry entry : list){
			String fileName = entry.getFilename();
			if(!fileName.equals(".") && !fileName.equals("..")){
				if(entry.getAttrs().isDir()){
					listAllFilesPath(sftp.pwd()+ "/" + fileName, FilesPathLists);
				} else {
					FilesPathLists.add(sftp.pwd()+ "/" + fileName);
				}
			}
		}

		if(!changeToParentDir()){
			return null;
		}

		return FilesPathLists;

	}

	/*public static void main(String[] args) throws Exception {

		SftpUtil sftpUtil2 = new SftpUtil("10.1.102.26", 10226, "crbcsftp", "crbcsftp2015");
		sftpUtil2.connect();
		// sftpUtil2.createDir("/upload/sinosafe/lmh/");
		// sftpUtil2.uploadByDirectory("E:\\test\\","/upload/sinosafe/20170830/");

		sftpUtil2.upload("/upload/cqrcbank/test/image/", "E:\\test\\LSTI20160811033228.zip");
		sftpUtil2.disconnect();

	}*/

}