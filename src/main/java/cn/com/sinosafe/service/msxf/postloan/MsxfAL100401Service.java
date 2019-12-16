package cn.com.sinosafe.service.msxf.postloan;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.FileUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.bean.MsxfBankType;
import cn.com.sinosafe.domain.entity.MsxfCompensationFile;
import cn.com.sinosafe.service.common.ImageOperaService;

/**
 * 核赔反馈文件处理 <br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年9月25日<br>
 */
@Service(MsxfConstant.MSXF_AL100401)
public class MsxfAL100401Service{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected ImageOperaService imageOperaService;
	
	public List<String> getCompensationTxtPath(String filedate) throws Exception {
		
		logger.info("{}查询所有核赔反馈数据开始",MsxfConstant.MSXF_AL100401);
		//存放文件路径
		List<String> resultList = new ArrayList<>();
		for (MsxfBankType e : MsxfBankType.values()) {
			//存放文件数据
			List<String> content = new ArrayList<>();
			String bank = e.getBank();
			List<MsxfCompensationFile> importData = new ArrayList<>();
			if(StringUtils.isNotEmpty(importData)) {
				for (MsxfCompensationFile msxfCompensationFile : importData) {
					//组装数据
					String data =getData(msxfCompensationFile);
					content.add(data);
				}
			}
			// 本地目录 
			String localBasePath = imageOperaService.getLocalPath(MsxfConstant.MSXF);
			//创建各个银行文件夹
			String newFilePath = localBasePath + File.separator + bank;
			FileUtils.initFiles(newFilePath);
			String fullFilePath= newFilePath + File.separator + MsxfConstant.MSXF_AL100401_FILENAME;
			FileUtils.write(content, fullFilePath);
			resultList.add(fullFilePath);
			//写.OK文件
			String okFilePath= newFilePath + File.separator + MsxfConstant.MSXF_AL100401_FILENAME_OK;
			FileUtils.writeOne(Convert.toStr(content.size()) + "|" + new File(fullFilePath).length(), okFilePath);
			resultList.add(okFilePath);
		}
		logger.info("{}查询核赔反馈数据结果结束,txt文档本地路径:{}",MsxfConstant.MSXF_AL100401,resultList);
		return resultList;
	}
	
	private String getData(MsxfCompensationFile msxfCompensationFile) {
		StringBuffer buffer = new StringBuffer();
		String data = buffer.append(msxfCompensationFile.getPkId()).append("|")
				.append(msxfCompensationFile.getBatchNo()).append("|")
				.append(msxfCompensationFile.getPerdNo()).append("|")
				.append(msxfCompensationFile.getPremDate()).append("|")
				.append(msxfCompensationFile.getPrinAmt()).append("|")
				.append(msxfCompensationFile.getIntAmt()).append("|")
				.append(msxfCompensationFile.getClaimAmt()).append("|")
				.append(msxfCompensationFile.getLcAmt()).append("|")
				.append(msxfCompensationFile.getApproveStatus()).append("|")
				.append(msxfCompensationFile.getCheckResult()).append("|")
				.append(msxfCompensationFile.getFailReasons())
				.toString();
		return data;
	}
}
