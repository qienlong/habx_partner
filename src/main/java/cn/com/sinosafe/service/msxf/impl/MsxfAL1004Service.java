package cn.com.sinosafe.service.msxf.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.CopFiledate;
import cn.com.sinosafe.service.msxf.MsxfBaseService;
import cn.com.sinosafe.service.msxf.postloan.MsxfAL100401Service;
import cn.com.sinosafe.service.msxf.postloan.MsxfAL100402Service;

/**
 * 
 * 马上消费--贷后文件上传接口 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月17日<br>
 */
@Service(MsxfConstant.MSXF_AL1004)
public class MsxfAL1004Service extends MsxfBaseService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MsxfAL100401Service msxfAL100401Service;

	@Autowired
	private MsxfAL100402Service msxfAL100402Service;

	@Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		logger.info("{}贷后文件上传接口开始,param:{}",MsxfConstant.MSXF_AL1004,param);
		try {
			// 获取业务时间
			CopFiledate copFiledate = copFiledateMapper.selectByPrimaryKey(MsxfConstant.MSXF + "-UPLOAD");
            logger.info("获取业务时间:{}",copFiledate.getFiledate());
            
			//获取核赔反馈文件路径
			List<String> compensationTxtPath = msxfAL100401Service.getCompensationTxtPath(copFiledate.getFiledate());
			//获取退保结果清单文件路径
			List<String> cancellationTxtPath = msxfAL100402Service.getCancellationTxtPath(copFiledate.getFiledate());
            
            // 查询配置
            copFileBatchDeal = copFileBatchDealMapper.selectByPrimaryKey(MsxfConstant.MSXF);
            
			//上传ftp地址
			String uploadPath = copFileBatchDeal.getUploadPath()+"/" + DateUtils.getDate1().replaceAll("-","");
			//本地文件地址集合
			List<String> localFilePathList = new ArrayList<String>();
			if(StringUtils.isNotEmpty(cancellationTxtPath)) localFilePathList.addAll(cancellationTxtPath);
			if(StringUtils.isNotEmpty(compensationTxtPath)) localFilePathList.addAll(compensationTxtPath);
			//上传文件
			for (String path : localFilePathList) {
				// 获取localBasePath + 银行简称
				String fullPath = FilenameUtils.getFullPathNoEndSeparator(path);
				// 银行简称
				String bank = FilenameUtils.getBaseName(fullPath);
				//组装上传路径
				String remoteDirectory = uploadPath+"/"+bank+"/";
				logger.info("{}文件上传ftp路径:{}",path,remoteDirectory);
				//上传文件到ftp
				uploadFile(remoteDirectory, path); 
				//删除本地文件
//				FileUtils.delFile(path);
			}
			// 更新日期
			copFiledate.setFiledate(DateUtils.getAddDate1(copFiledate.getFiledate(), 1));
			copFiledateMapper.updateByPrimaryKeySelective(copFiledate);

		}catch (Exception e){
			logger.error(MsxfConstant.MSXF_AL1004 + "获取贷后文件上传失败！",e);
//			throw new Exception("获取贷后文件上传失败:"+e.getMessage());
			msxfAsynDealService.pushEmail(MsxfConstant.MSXF_AL1004, param, e);
		}
		return MsxfResponse.CODE_0000;
	}
}
