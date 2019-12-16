package cn.com.sinosafe.service.msxf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.properties.MsxfProperties;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.MsxfUnzipUtil;
import cn.com.sinosafe.common.util.RSAUtils;
import cn.com.sinosafe.common.util.SftpUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.CopFileBatchDealMapper;
import cn.com.sinosafe.dao.CopFiledateMapper;
import cn.com.sinosafe.dao.IqpMeApiCopMapper;
import cn.com.sinosafe.domain.entity.CopFileBatchDeal;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.service.common.ImageOperaService;

/**
 * 
 * 马上消费抽象父类 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月2日<br>
 */
public abstract class MsxfBaseService implements MsxfService{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired(required =false )
    protected DataSource dataSource;
	@Autowired
	protected IqpMeApiCopMapper iqpMeApiCopMapper;
	@Autowired
	protected SystemConfig systemConfig;
	@Autowired
	protected MsxfProperties msxfProperties;
	@Autowired
	protected MsxfAsynDealService msxfAsynDealService;
	@Autowired
	protected CopFileBatchDealMapper copFileBatchDealMapper;
	@Autowired
	protected ImageOperaService imageOperaService;
	@Autowired
	protected CopFiledateMapper copFiledateMapper;
	
	protected CopFileBatchDeal copFileBatchDeal = null;
	// 渠道配置
	protected IqpMeApiCop iqpMeApiCop;
	
	private RSAUtils rsaUtils = null;
	//职业类型
    protected static Map<String,String> OccTypeMap = new HashMap<String,String>();
    static {
        OccTypeMap.put("01","5");
        OccTypeMap.put("02","4");
        OccTypeMap.put("03","X");
        OccTypeMap.put("04","1");
        OccTypeMap.put("05","Y");
        OccTypeMap.put("06","6");
        OccTypeMap.put("07","7");
        OccTypeMap.put("08","3");
        OccTypeMap.put("09","Z");
    }
    
    /**
	 * 初始化rsa工具类
	 * @return
	 */
	@PostConstruct
	public void getRsaUtils() {
		// 初始化rsa工具类
		if(StringUtils.isNull(rsaUtils)) {
			rsaUtils = new RSAUtils(msxfProperties.getHaPublicKey(), msxfProperties.getHaPrivateKey());
		}
	}
	
	/**
	 * 解密请求参数
	 * @param params 参数
	 * @return
	 */
	public String decrypt(String params) {
		// 解密
		return rsaUtils.decrypt(params);
	}
	
	public void checkDatas(Object loanApply,String[] mustCheckFields) throws Exception {
		//利用反射获取PosLoanInfo的属性,根据属性获取对应的必输字段
		Field[] fields=loanApply.getClass().getDeclaredFields();
		for(Field field:fields){
			String name=field.getName();
			for (String fieldName : mustCheckFields) {
				if(fieldName.equalsIgnoreCase(name)){
					name = name.substring(0,1).toUpperCase()+name.substring(1);
					Method m = loanApply.getClass().getMethod("get" + name);
					Object value = (Object) m.invoke(loanApply, (Object[])null);
					String str = Objects.toString(value, "");
					if(StringUtils.isBlank(str)){
						throw new ParamException(name +"不能为空");
					}
					break;
				}
			}
		}
	}
    
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
//		ConnectionPool pool = dataSource.getConnection();
		return dataSource.getConnection();
	}
	
	/**
	 * 下载单个zip
	 * @param saveDirectory 保存到本地的目录
	 * @throws Exception
	 */
	public void downloadZip(String remotePath,String fileName,String saveDirectory) throws Exception {
		// 登录sftp，获取当日目录下的所有文件名，进行匹配
		SftpUtil sftpUtil = null;
		try {
//			copFileBatchDeal = getCopFileBatchDeal();
			// 链接sftp
			sftpUtil = new SftpUtil(copFileBatchDeal.getFtpHost(),copFileBatchDeal.getFtpPort(), copFileBatchDeal.getFtpUsername(), copFileBatchDeal.getFtpPwd());
			sftpUtil.connect();
			// 进入目录
			sftpUtil.download(remotePath, fileName, saveDirectory);
		} finally {
			if(StringUtils.isNotNull(sftpUtil)) {
				try {
					sftpUtil.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 下载目录下所有文件
	 * @param saveDirectory 保存到本地的目录
	 * @throws Exception
	 */
//	public void downloadZips(String remoteDirectory,String saveDirectory) throws Exception {
//		// 登录sftp，获取当日目录下的所有文件名，进行匹配
//		SftpUtil sftpUtil = null;
//		try {
//			copFileBatchDeal = getCopFileBatchDeal();
//			// 链接sftp
//			sftpUtil = new SftpUtil(copFileBatchDeal.getFtpHost(),copFileBatchDeal.getFtpPort(), copFileBatchDeal.getFtpUsername(), copFileBatchDeal.getFtpPwd());
//			sftpUtil.connect();
//			// 进入目录
//			sftpUtil.downloadByDirectory(remoteDirectory, saveDirectory);
//		} finally {
//			if(StringUtils.isNotNull(sftpUtil)) {
//				try {
//					sftpUtil.disconnect();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	/**
	 * 目录下所有文件名
	 * @param remoteDirectory
	 * @return
	 * @throws Exception
	 */
//	public List<String> getRemoteDirectory(String remoteDirectory) throws Exception {
//		// 登录sftp，获取当日目录下的所有文件名，进行匹配
//		SftpUtil sftpUtil = null;
//		try {
////			copFileBatchDeal = getCopFileBatchDeal();
//			// 链接sftp
//			sftpUtil = new SftpUtil(copFileBatchDeal.getFtpHost(),copFileBatchDeal.getFtpPort(), copFileBatchDeal.getFtpUsername(), copFileBatchDeal.getFtpPwd());
//			sftpUtil.connect();
//			
//			return sftpUtil.listFiles(remoteDirectory);
//			// sftp目录
//		} finally {
//			if(StringUtils.isNotNull(sftpUtil)) {
//				try {
//					sftpUtil.disconnect();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	/**
	 * 获取目录下所有文件全路径
	 * @param remoteDirectory
	 * @param filePahts
	 * @return
	 * @throws Exception
	 */
	public List<String> getRemoteDirectory(String remoteDirectory,List<String> filePahts) throws Exception {
		// 登录sftp，获取当日目录下的所有文件名，进行匹配
		SftpUtil sftpUtil = null;
		try {
//			copFileBatchDeal = getCopFileBatchDeal();
			// 链接sftp
			sftpUtil = new SftpUtil(copFileBatchDeal.getFtpHost(),copFileBatchDeal.getFtpPort(), copFileBatchDeal.getFtpUsername(), copFileBatchDeal.getFtpPwd());
			sftpUtil.connect();
			
			return sftpUtil.listAllFilesPath(remoteDirectory,filePahts);
			// sftp目录
		} finally {
			if(StringUtils.isNotNull(sftpUtil)) {
				try {
					sftpUtil.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 删除ftp目录
	 * @param ftpPath
	 * @return
	 * @throws Exception
	 */
	public boolean deleteFtpDir(String ftpPath) throws Exception {
		// 登录sftp，获取当日目录下的所有文件名，进行匹配
		SftpUtil sftpUtil = null;
		try {
//			copFileBatchDeal = getCopFileBatchDeal();
			// 链接sftp
			sftpUtil = new SftpUtil(copFileBatchDeal.getFtpHost(),copFileBatchDeal.getFtpPort(), copFileBatchDeal.getFtpUsername(), copFileBatchDeal.getFtpPwd());
			sftpUtil.connect();
			
			return  sftpUtil.delDir(ftpPath);
			// sftp目录
		} finally {
			if(StringUtils.isNotNull(sftpUtil)) {
				try {
					sftpUtil.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 删除ftp文件
	 * @param directory
	 * @param
	 * @return
	 * @throws Exception
	 */
	public void deleteFtpFile(String directory,String fileName) throws Exception {
		// 登录sftp，获取当日目录下的所有文件名，进行匹配
		SftpUtil sftpUtil = null;
		try {
//			copFileBatchDeal = getCopFileBatchDeal();
			// 链接sftp
			sftpUtil = new SftpUtil(copFileBatchDeal.getFtpHost(),copFileBatchDeal.getFtpPort(), copFileBatchDeal.getFtpUsername(), copFileBatchDeal.getFtpPwd());
			sftpUtil.connect();
			
			sftpUtil.delete(directory, fileName);
		} finally {
			if(StringUtils.isNotNull(sftpUtil)) {
				try {
					sftpUtil.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 上传文件到sftp
	 * @param remoteDirectory
	 * @param localFilePath
	 * @throws Exception
	 */
	public void uploadFile(String remoteDirectory,String localFilePath) throws Exception {
		// 登录sftp，获取当日目录下的所有文件名，进行匹配
		SftpUtil sftpUtil = null;
		try {
//			copFileBatchDeal = getCopFileBatchDeal();
			// 链接sftp
			sftpUtil = new SftpUtil(copFileBatchDeal.getFtpHost(),copFileBatchDeal.getFtpPort(), copFileBatchDeal.getFtpUsername(), copFileBatchDeal.getFtpPwd());
			sftpUtil.connect();
			
			sftpUtil.upload(remoteDirectory, localFilePath);
			// sftp目录
		} finally {
			if(StringUtils.isNotNull(sftpUtil)) {
				try {
					sftpUtil.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 贷后zip包解压
	 * @param zipPath
	 * @param outPath
	 * @return
	 */
	public List<String> unZip(String zipPath,String zipName,String outPath) {
		MsxfUnzipUtil.unzip(zipPath, outPath, msxfProperties.getEncryKey());
		File file = new File(outPath + File.separator + zipName);
		return Arrays.asList(file.list());
	}
	
	/**
	 * 影像zip包解压
	 * @param zipfile
	 * @param descDir
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public List<String> unpackZip(File zipfile,String descDir) throws Exception {
		List<String> fileNameList = new ArrayList<String>();
		ZipFile zf = new ZipFile(zipfile, "gbk");
		for(Enumeration<?> entries = zf.getEntries();entries.hasMoreElements();){
			ZipEntry entry = (ZipEntry)entries.nextElement();  
            String zipEntryName = entry.getName();  
            InputStream in = zf.getInputStream(entry);
            String outPath = (descDir + File.separator + zipEntryName).replaceAll("\\*", File.separator);
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
            if(!file.exists()){  
                file.mkdirs();  
            }  
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压  
            if(new File(outPath).isDirectory()){  
                continue;  
            }  
            
            OutputStream out = new FileOutputStream(outPath);
            IOUtils.copy(in, out);
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
           
            if(!fileNameList.contains(zipEntryName.split("\\/")[0])){
            	fileNameList.add(zipEntryName.split("\\/")[0]);
            }
		}
		
		return fileNameList;
	}
}
