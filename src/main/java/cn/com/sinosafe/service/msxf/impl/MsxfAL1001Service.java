package cn.com.sinosafe.service.msxf.impl;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.msxf.MsxfMqMsg;
import cn.com.sinosafe.service.common.MqService;
import cn.com.sinosafe.service.msxf.MsxfPostLoanService;

/**
 * 
 * 马上消费--贷后文件存储接口 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月17日<br>
 */
@Service(MsxfConstant.MSXF_AL1001)
public class MsxfAL1001Service extends MsxfPostLoanService {
	
//	public static String SinosafeClaimFile 			= "SinosafeClaimFile";
//	public static String SinosafeLoanFile 			= "SinosafeLoanFile";
//	public static String SinosafeRepayPlanFile 		= "SinosafeRepayPlanFile";
//	public static String SinosafeRepayFile 			= "SinosafeRepayFile";
//	public static String SinosafePremiumInfoFile 	= "SinosafePremiumInfoFile";
//	public static String SinosafeRecourseRepayFile 	= "SinosafeRecourseRepayFile";
//	public static String SinosafeSettleFile 		= "SinosafeSettleFile";
	
	@Autowired
	private MqService mqService;


	/**
	 *  根目录/upload/HuaAnBaoXianUnionPay/output/20190426/银行简称/日期-Filelist.zip（例如：20190910-Filelist.zip)<br>
	 *  索赔申请	 	SinosafeClaimFile.txt 			D+1日4:00出D日索赔文件（如有）<br>
		借据信息	 	SinosafeLoanFile.txt			D+1日4:00出D日文件<br>
		还款计划 		SinosafeRepayPlanFile.txt		D+1日4:00出D日文件<br>
		还款明细 		SinosafeRepayFile.txt			D+1日4:00出D日文件<br>
		保费明细 		SinosafePremiumInfoFile.txt		D+1日4:00出D日文件<br>
		还款明细（追偿）    SinosafeRecourseRepayFile.txt	D+1日4:00出D日文件<br>
		理赔还款明细	SinosafeSettleFile.txt			D+1日4:00出D日理赔入账结果<br>
	 */
	@Override
	public void dealData(List<String> filePaths) throws Exception {
		if(StringUtils.isEmpty(filePaths)) {
			logger.info("{}[]没有文件需要处理", MsxfConstant.MSXF, copFiledate.getFiledate());
			return;
		}
		//判断文件中是否包含yyyymmdd_imgfiles.ok yyyymmdd-filelist.ok  不存在抛异常
//        String filedate = copFiledate.getFiledate().replaceAll("-","");
//		checkFile(filePaths,filedate);

		for (String filePath : filePaths) {
			if (filePath.contains(".ok") || filePath.contains(".ctrl")){
				continue;
			}
			// 获取localBasePath + 银行简称
			String fullPath = FilenameUtils.getFullPathNoEndSeparator(filePath);
			// 银行简称
			String partner = FilenameUtils.getBaseName(fullPath);
			// 文件名
			String fileName = FilenameUtils.getName(filePath);
			// 根据文件名判断是 影像处理还是 贷后文件处理
			String type = fileName.contains("filelist") ? "file" : "image";
			
			MsxfMqMsg mqMsg = new MsxfMqMsg();
			mqMsg.setType(type);
			mqMsg.setFilePath(filePath);
			mqMsg.setPartner(partner);
			mqMsg.setDate(copFiledate.getFiledate());
			mqService.noticeMsxfPostLoanData(JSON.toJSONString(mqMsg));
		}
	}
	
    //校验文件是否上传完成
	/*private void checkFile(List<String> filePaths, String filedate)throws Exception {
		Set<String> bankPathSets = new HashSet<String>();
		//set  /upload/sinosafe/output/20191025/HMBANK/xxxxx.zip
		//   /upload/sinosafe/output/20191025/HMBANK/xxxxx.ctrl
		for (String filePath: filePaths) {
			// 获取localBasePath + 银行简称
			String fullPath = FilenameUtils.getFullPathNoEndSeparator(filePath);
			bankPathSets.add(fullPath);
		}
		int count = 0;
		for (String bankPath: bankPathSets) {
			if (filePaths.contains(bankPath + "/" + filedate + MsxfConstant.MSXF_AL100101_FILENAME) ||
					filePaths.contains(bankPath + "/" + filedate + MsxfConstant.MSXF_PL3001_FILENAME)){
				count++;
			}
		}
		if (count!=bankPathSets.size()){
			throw new  Exception("影像或贷后文件未全部上传完成");
		}
	}*/
}
