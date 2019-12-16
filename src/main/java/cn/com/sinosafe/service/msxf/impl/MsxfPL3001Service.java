package cn.com.sinosafe.service.msxf.impl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.FileUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.AccLoanMapper;
import cn.com.sinosafe.domain.bean.MsxfFileType;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.AccLoan;
import cn.com.sinosafe.domain.msxf.MsxfMqMsg;
import cn.com.sinosafe.service.msxf.MsxfBaseService;

/**
 * 
 * 马上消费--业务影像上传接口 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月2日<br>
 */
@Service(MsxfConstant.MSXF_PL3001)
public class MsxfPL3001Service extends MsxfBaseService{
	
	@Autowired
	private AccLoanMapper accLoanMapper;

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
			String path = FilenameUtils.getFullPathNoEndSeparator(msxfMqMsg.getFilePath());
			// 下载zip
			downloadZip(path,fileName, localBasePath);
			
			File file = new File(localBasePath + File.separator + fileName);
			// 创建目录
			String newDir = localBasePath + File.separator + DateUtils.getDate1();
			FileUtils.initFiles(newDir);
			// 解压
			List<String> unpackFilePaths = unpackZip(file, newDir);
			// 校验
			if(5 != unpackFilePaths.size()) {
				throw new Exception("马上消费文件个数不对：" + unpackFilePaths.size());
			}
			
			// 查询业务流水号
			String billNo = FilenameUtils.getBaseName(msxfMqMsg.getFilePath());
			AccLoan accLoan = accLoanMapper.selectByPrimaryKey(billNo);
			if(accLoan == null){
				throw new Exception("根据billNo:"+billNo+"查询台账信息为空！");
			}
			List<String> desList = new ArrayList<>();
			List<String> filePathList = new ArrayList<>();
			for (String unpackFilePath : unpackFilePaths) {
				// 01_证件号码_序号.jpg
				String[] temps = FilenameUtils.getBaseName(unpackFilePath).split("_");
				String type = temps[0];
				if(temps.length == 3) {
					type += temps[2];
				}
				String haType = MsxfFileType.getHaType(type);
				if(StringUtils.isEmpty(haType)) {
					throw new Exception(unpackFilePath + "没有找到对应华安影像目录");
				}
				desList.add(haType);
				unpackFilePath = newDir + File.separator + unpackFilePath;
				filePathList.add(unpackFilePath);
			}
			// 根据类型判断上传至影像系统目录
			imageOperaService.uploadImg(filePathList, desList, "XFD", accLoan.getIqpLoanSerno());
			
			// 删除ftp文件
			//deleteFtpFile(FilenameUtils.getFullPathNoEndSeparator(msxfMqMsg.getFilePath()), fileName);
			
		} catch (Exception e) {
			logger.info(MsxfConstant.MSXF_PL3001, e);
			msxfAsynDealService.pushEmail(MsxfConstant.MSXF_PL3001, "批量上传影像", e);
		}
		return MsxfResponse.CODE_0000;
	}

}