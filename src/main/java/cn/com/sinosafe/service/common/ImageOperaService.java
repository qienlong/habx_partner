package cn.com.sinosafe.service.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yzj.trans.FileBean;
import com.yzj.trans.FileUpload;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.httpclient.HttpUtil;



/**
 * 
 * 影像操作服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年7月30日<br>
 */
@Service
public class ImageOperaService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SystemConfig systemConfig;
	
	/**
	 * 上传文件到影像系统
	 * @param file 待上传文件
	 * @param serno 业务流水号
	 * @param prdCode 影像系统产品号
	 * @param dirCode 影像系统目录号
	 * @return 上传成功：true,上传失败：false
	 */
	public JSONObject uploadImgFirst(String file,String serno,String prdCodes,String dirCodes){
		String[] files = { file };
		String prdCode = prdCodes;// 影像系统产品号
		String[] desTypes = { dirCodes };// 影像系统目录号

		List<String> upfiles = Arrays.asList(files);
		List<String> desList = Arrays.asList(desTypes);
		log.info("【影像上传前】当前待上传文件为：" + upfiles);
		boolean flag = false;
		JSONObject result_json = uploadImg(upfiles, desList, prdCode, serno);
		String code = result_json.get("code").toString();
		if ("1".equals(code)) {
			flag = true;
		}
		log.info("【影像上传后】业务流水号为："+serno+"的影像上传结果为："+flag);
		
		//上传成功则删除下载的文件
		if (flag) {
			 File after_file = new File(file);
			 if (after_file.exists()) {
				 boolean delete = after_file.delete();
				 if (!delete) {
					 log.info(file+"删除失败，原因：其他原因");
				}else{
					log.info(file+"删除成功");
				}
			}else{
				log.info(file+"删除失败，原因：执行删除前判断到该文件不存在");
			}
		}
		return result_json;
	}
	
	/**
	 * 
	 * @param locList 上传文件的本地文件路径
	 * @param desList 影像系统文件路径
	 * @param serno  序列号
	 */
	public JSONObject uploadImg(List<String> locList,List<String> desList,String prdCode, String serno){
		JSONObject result_json = new JSONObject();//定义返回结果
		result_json.put("code", "0");
		result_json.put("message", "上传失败！");
		result_json.put("data", "");
		if(locList.size()!=desList.size()){
			//本地路径和目的路径的个数不对应
			log.info("【影像上传中】本地路径和目的路径的个数不对应");
			return result_json;
		}
		String separator = File.separator;
		FileUpload fileUpload = new FileUpload(systemConfig.getValue("PAGB_POLICY_IMAGE_MSGURL"), systemConfig.getValue("PAGB_POLICY_IMAGE_FILEURL"));
		
		//设置param参数
		Map<String, String> param = new HashMap<String, String>();
		param.put("BatchFlag", "0");// 批扫标识
		param.put("SysCode", "XBSYS");// 系统编号
		param.put("FunCode", prdCode);// 功能编号  GFX是否是变量？？？
		param.put("OrgCode", "15010100");// 机构编号
		param.put("OperCode", "xwadmin");// 操作人
		param.put("FlwCode", serno);// 业务流水号（唯一）
		param.put("MainDocument", serno);// 业务流水号（唯一）
		param.put("ScanTime", DateUtils.getDateTime());// 扫描日期，注意时间格式
		param.put("AttachedDocument", "0");
		param.put("BranchCode", "");// 分支机构号
		param.put("WdCode", "");// 网点号
		
		//设置fileList
		List<FileBean> fileList = new ArrayList<FileBean>();
		FileBean fileBean = null;
		for (int i = 0; i < locList.size(); i++) {
			fileBean = new FileBean();
			//文件路径
			String filePath =locList.get(i);
			//文件大小
			long length = new File(filePath).length();
			//原文件名
			String oldFileName=locList.get(i).substring(locList.get(i).lastIndexOf(separator)+1, locList.get(i).length());
			//同步到影像系统的新文件名
			String newFileName = UUID.randomUUID().toString().replace("-", "") .toUpperCase() + oldFileName.substring(oldFileName.lastIndexOf("."));
			//文件类型
			String fileType=desList.get(i);
			
			fileBean.setFileId(newFileName); // 这个是有UUID32生成加上【.文件类型】,这个在你数据表上应该保存下来
			fileBean.setFileName(oldFileName); // 原文件名称
			fileBean.setFilePath(filePath);// 文件路径
			fileBean.setFileType(fileType); // 这里需要换成红色选择框里面的值GFX_00101/GFX_00201/GFX_00301
			fileBean.setMainFlag("M");
			fileBean.setSideFlag("F");
			fileBean.setFileSize(String.valueOf(length));
			fileList.add(fileBean);
		}
		try {
			//调用文件上传
			String uplad_result = fileUpload.UpladFiles(fileList, param);//上传返回
			//返回上传结果
			if (!"Fail".equals(uplad_result)) {//上传成功
				String url = systemConfig.getValue("DOWNLOAN_URL") + "?SystemCode=XBSYS&BusinessCode=" + serno + "&FileId=" + fileBean.getFileId() + "&Type=1";
				result_json.put("code", "1");//上传成功
		        result_json.put("message", "上传成功！");
				result_json.put("data", url);
			}
			return result_json;
		} catch (Exception e) {
			log.info("【影像上传】影像上传发生异常......");
			e.printStackTrace();
		}
		return result_json;
	}
	
	/**
	 * 返回本地服务器临时目录
	 * @return
	 */
	public String getLocalPath(String dirName) {
		String localBasePath = systemConfig.getValue("ycxt_ha_file_save_path") + File.separator +dirName + File.separator + DateUtils.getDate1();
		File baseFile = new File(localBasePath);
		if(!baseFile.exists()) {
			baseFile.mkdirs();
		}
		return localBasePath;
	}
	/**
	 * 创建本地服务器临时目录
	 * @Description
	 * @date 2019年8月7日  
	 * @param dirName
	 * @return
	 */
	public String getLocalPathDir(String dirName) {
		String localBasePath = systemConfig.getValue("ycxt_ha_file_save_path") + File.separator +dirName + File.separator + DateUtils.getDate1().replaceAll("-", "");
		File baseFile = new File(localBasePath);
		if(!baseFile.exists()) {
			baseFile.mkdirs();
		}
		return localBasePath;
	}
	
	/**
	 * 获取影像系统单个目录下所有文件id
	 * @param serno
	 * @param dirTyoe
	 * @param transCode
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Node> getFileIds(String serno,String dirTyoe,String transCode) throws Exception{
		
		List<Node> nodels = new ArrayList<>();
		
		// 获取该目录下 所有文件  
		String xml = getXml(serno, dirTyoe, transCode);
		log.info("{}查询目录下文件列表，请求参数：{}" , serno,xml);
		String rtnXml = HttpUtil.sendPostWithXml(systemConfig.getValue("FILE_ID_URL"), xml);
		log.info("{}查询目录下文件列表，返回结果：{}" , serno,rtnXml);
		// 解析文件ids
		Document document = DocumentHelper.parseText(rtnXml);
		Node errorNode = document.selectSingleNode("/Packet//ErrorCode");//
		Node errorMessageNode = document.selectSingleNode("/Packet//ErrorMessage");//
		String errorCode = errorNode.getText();
		String errorMessage = errorMessageNode.getText();
		// 解析xml
		if ("0000000000".equals(errorCode)) {
			Node fileListNode = document.selectSingleNode("/Packet/Body/FileIdList");
			if (StringUtils.isNotNull(fileListNode)) {
				nodels = fileListNode.selectNodes("FileId");
			}
		}else {
			throw new Exception(serno + "["+transCode+"]" + errorMessage);
		}
		return nodels;
	}
	
	
	/**
	 * 组装获取文件id列表报文xml
	 * 
	 * @param serno
	 * @param fileType
	 * @param fileType
	 * @return
	 */
	public String getXml(String serno, String funcCode, String fileType) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<Packet type=\"REQUEST\" version=\"1.0\">");
		sb.append("<Head>");
		sb.append("<RequestType>null</RequestType>");
		sb.append("<RequestUser>null</RequestUser>");
		sb.append("<CipherText>null</CipherText>");
		sb.append("<PlainText>null</PlainText>");
		sb.append("<TransactionCode>null</TransactionCode>");
		sb.append("<TransDate>").append(DateUtils.getDate()).append("</TransDate>");
		sb.append("<TransTime>").append(DateUtils.getTime()).append("</TransTime>");
		sb.append("</Head>");
		sb.append("<Body>");
		sb.append("<SystemCode>XBSYS</SystemCode>");
		
		sb.append("<FunctionCode>").append(funcCode).append("</FunctionCode>");
		sb.append("<BusinessCode>").append(serno).append("</BusinessCode>");
		sb.append("<MainDocument></MainDocument>");
		sb.append("<AttachedDocument></AttachedDocument>");
		
		sb.append("<MsgId>0000000000</MsgId>");
		sb.append("<ImageType>").append(fileType).append("</ImageType>");
		sb.append("</Body>");
		sb.append("</Packet>");
		
		return sb.toString();
	}

	/**
	 * <p>判断影像系统中指定目录下是否存在影像文件</p>
	 * @param serno
	 * @param prdCode
	 * @param checkImg
	 * @param requestUrl
	 * @return
	 * @throws Exception
	 *
	 * fengxiaoyu  copy  2019/08/01
	 */
	public boolean checkImg(String serno,String prdCode,String checkImg){
		boolean isT = false;
		try {
			String xml = getXml(serno, prdCode, checkImg);
			log.info("{}，checkImg request: {}", serno, xml);
			String rtnXml = HttpUtil.sendPostWithXml(systemConfig.getValue("FILE_ID_URL"), xml);
			log.info("{}，checkImg response: {}", serno, rtnXml);
			Document document = DocumentHelper.parseText(rtnXml);
			Node responseNode = document.selectSingleNode("/Packet/Head/ResponseCode");
			@SuppressWarnings("unchecked")
			List<String> fileIdList = document.selectNodes("/Packet/Body/FileIdList");
			String responseCode = responseNode.getText();
			if (StringUtils.equals("1", responseCode) && (fileIdList.size() > 0)) {
				isT = true;
			}
		} catch (DocumentException e) {
			log.error("error:", e);
		}
		return isT;
	}
	
	/**
	 * txt文件下载
	 * @Description
	 * @date 2019年8月15日  
	 * @param batchDeal  配置sftp数据
	 * @param locatePath  本地地址
	 * @param sftpFilepath  sftp路径
	 * @param fileName  文件名
	 * @return
	 * @throws Exception
	 */
	/*public Boolean downlondTxt(CopFileBatchDeal batchDeal,String locatePath,String sftpFilepath,String fileName) throws Exception{
		try{
			// 下载文件
			SftpUtil ftp = new SftpUtil(batchDeal.getFtpHost(), batchDeal.getFtpPort(), batchDeal.getFtpUsername(), batchDeal.getFtpPwd());
			ftp.connect();
			File localDir = new File(locatePath);
			if (!localDir.exists()) {
				localDir.mkdir();
			}
			ftp.cd(batchDeal.getDownloadPath());
			
			ftp.download(sftpFilepath, fileName, locatePath);
			ftp.disconnect();
			return true;
		}catch (Exception e) {
			log.error("从sftp上下载文件["+sftpFilepath + "/" + fileName+"]失败", e);
			return false;
		}
		
	}*/
	
	/**
	 * @param locList 上传文件的本地文件路径
	 * @param desList 影像系统文件类型
	 * @param prdCode 功能编号
	 * @param serno 业务流水号
	 */
	public String uploadImgFile(String imageFileName, String funCode,String serno,String localPath,String fileType) {
		String upladFiles ="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date uploadDate = new Date();
		String uploadTime = sdf.format(uploadDate);
		String msgURL = systemConfig.getValue("PAHA_INDCRT_IMID_MSGURL");
		String fileURL = systemConfig.getValue("PAHA_INDCRT_IMID_FILEURL");
		FileUpload fileUpload = new FileUpload(msgURL, fileURL);
		// 设置param参数
		Map<String, String> param = new HashMap<String, String>();
		param.put("BatchFlag", "0");// 批扫标识
		param.put("SysCode", "XBSYS");// 系统编号
		param.put("FunCode", funCode);// 功能编号 GFX是否是变量？？？
		param.put("OrgCode", "15010100");// 机构编号
		param.put("OperCode", "xwadmin");// 操作人
		param.put("FlwCode", serno);// 业务流水号（唯一）
		param.put("MainDocument", serno);// 业务流水号（唯一）
		param.put("ScanTime", uploadTime);// 扫描日期，注意时间格式
		param.put("AttachedDocument", "0");
		param.put("BranchCode", "");// 分支机构号
		param.put("WdCode", "");// 网点号
		// 设置fileList
		List<FileBean> fileList = new ArrayList<FileBean>();
		
			String newFileName = UUID.randomUUID().toString().replace("-", "").toUpperCase()
					+ imageFileName.substring(imageFileName.lastIndexOf("."));
			
			FileBean fileBean = new FileBean();
			fileBean.setFileId(newFileName); // 这个是有UUID32生成加上【.文件类型】,这个在你数据表上应该保存下来
			fileBean.setFileName(imageFileName); // 原文件名称,例如：HUAAN_certFileA_821470020065930566_01.JPG
			fileBean.setFilePath(localPath+"/"+imageFileName);// 文件路径 例如：D:/zagb/imageFile
			fileBean.setFileType(fileType); // 这里需要换成红色选择框里面的值GFX_00101/GFX_00201/GFX_00301
			fileBean.setMainFlag("M");
			fileBean.setSideFlag("F");
			fileList.add(fileBean);
		try {
			// 调用文件上传
			upladFiles = fileUpload.UpladFiles(fileList, param);
			return upladFiles;
		} catch (Exception e) {
			log.info("上传影像失败 "+e.getMessage().toString());
		}
		return upladFiles;
	}
	
	/**
	 * 读取txt每行
	 * @param txtPath 文件路径
	 * @return
	 * @throws Exception
	 */
	public static List<String> read(String txtPath) throws Exception {
		String[] lines = readLines(new File(txtPath));
		return Arrays.asList(lines);
	}
	
	/**
	 * read lines.
	 * 
	 * @param file file.
	 * @return lines.
	 * @throws IOException
	 */
	private static String[] readLines(File file) throws IOException
	{
		if( file == null || !file.exists() || !file.canRead() )
	        return new String[0];

		return readLines(new FileInputStream(file));
	}
	
	/**
	 * read lines.
	 * 
	 * @param is input stream.
	 * @return lines.
	 * @throws IOException
	 */
	private static String[] readLines(InputStream is) throws IOException
	{
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try
		{
			String line;
			while( (line = reader.readLine()) != null )
				lines.add(line);
			return lines.toArray(new String[0]);
	    }
		finally
		{
			reader.close();
		}
	}

	
}
