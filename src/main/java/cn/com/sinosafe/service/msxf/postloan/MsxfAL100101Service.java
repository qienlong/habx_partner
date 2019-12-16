package cn.com.sinosafe.service.msxf.postloan;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.FileUtils;
import cn.com.sinosafe.common.util.SpringUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.msxf.MsxfMqMsg;
import cn.com.sinosafe.service.msxf.MsxfBaseService;
import cn.com.sinosafe.service.msxf.MsxfService;

/**
 * 
 * 贷后文件处理 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月20日<br>
 */
@Service(MsxfConstant.MSXF_AL100101)
public class MsxfAL100101Service extends MsxfBaseService {
	
	@Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		try {
			
			MsxfMqMsg msxfMqMsg = JSON.parseObject(param, MsxfMqMsg.class);
			
			// 获取贷后配置参数
			copFileBatchDeal = copFileBatchDealMapper.selectByPrimaryKey(MsxfConstant.MSXF);
			
			// 本地目录
			String localBasePath = imageOperaService.getLocalPath(MsxfConstant.MSXF);
			localBasePath += File.separator + msxfMqMsg.getPartner();
			FileUtils.initFiles(localBasePath);
			// zip包名称
			String fileName = FilenameUtils.getName(msxfMqMsg.getFilePath());
			String zipName = FilenameUtils.getBaseName(msxfMqMsg.getFilePath());
			// 下载zip
			String fullPath = FilenameUtils.getFullPathNoEndSeparator(msxfMqMsg.getFilePath());
			downloadZip(fullPath,fileName, localBasePath);
			
//			File file = new File(localBasePath + File.separator + fileName);
			// 创建目录
			String newDir = localBasePath + File.separator + DateUtils.getDate1() + File.separator;
			FileUtils.initFiles(newDir);
			// 解压
//			List<String> unpackFilePaths = unpackZip(file, newDir);
			List<String> unpackFilePaths = unZip(localBasePath + File.separator + fileName, zipName,newDir);
			// 读取文件
			String value = systemConfig.getValue("MSXF-FILE-LIST");
			List<String> fileNameList = Arrays.asList(value.split(","));
			for (String unpackFilePath : unpackFilePaths) {
				if(unpackFilePath.contains(".ctrl")){
					continue;
				}
				if(fileNameList.contains(unpackFilePath)) {
					String fullFilePath = newDir + zipName + File.separator + unpackFilePath;
					List<String> contents = FileUtils.readTxtFile(fullFilePath);
					
					if(StringUtils.isEmpty(contents)) {
						logger.info("{}资金方目录下文件{}内容为空",msxfMqMsg.getPartner(),fullFilePath);
					}else {
						String txtFileName = FilenameUtils.getBaseName(unpackFilePath);
						// 解析文件新增数据
						insertData(msxfMqMsg.getPartner(),msxfMqMsg.getDate(), txtFileName, contents);
					}
				}else {
					logger.info("{}资金方目录下文件{}不需要解析",msxfMqMsg.getPartner(),unpackFilePath);
				}
			}
			
			// 删除ftp文件
			//deleteFtpFile(FilenameUtils.getFullPathNoEndSeparator(msxfMqMsg.getFilePath()), fileName);
		} catch (Exception e) {
			logger.info(MsxfConstant.MSXF_AL100101, e);
			msxfAsynDealService.pushEmail(MsxfConstant.MSXF_AL100101, param, e);
		}
		return MsxfResponse.CODE_0000;
	}
	
	/**
	 * 解析文件插入数据
	 * @param partner
	 * @param fileName
	 * @param contents
	 * @throws Exception
	 */
	public void insertData(String partner,String date, String fileName, List<String> contents) throws Exception {
		// 判断条数
		int num = 1000;
//		if(contents.size() <= 1000){
//			callInterface(partner,date, fileName, contents);
//			return;
//		}
		
		List<List<String>> list = FileUtils.batchInfo(contents, num);
		for (List<String> temp : list) {
			callInterface(partner,date, fileName, temp);
		}
		
		// 设置保留位数
//		DecimalFormat df = new DecimalFormat("0.00");
//		String d = df.format((float)contents.size()/num);
//		int count = new Double(Math.ceil(new Double(d))).intValue();
//		for (int i = 0; i < count; i++) {
//			List<String> temp = null;
//			if(i == count-1) {
//				temp = contents.subList(i*num, contents.size());
//			}else {
//				temp = contents.subList(i*num, (i+1)*num);
//			}
//			callInterface(partner,date, fileName, temp);
//		}
	}
	private void callInterface(String partner,String date, String fileName, List<String> temp) throws Exception {
		JSONObject params = new JSONObject();
		// HMBANK：哈密城商行  CQBANK：重庆银行 NJBANK：南京银行
		params.put("partner", partner);
		// txt内容
		params.put("contents", temp);
		// 华安业务日期
		params.put("date", date);
		// 根据文件名去找对应服务处理
		MsxfService msxfService = (MsxfService) SpringUtils.getBean(MsxfConstant.MSXF + fileName);
		msxfService.busiDeal(params.toJSONString());
	}

}
