package cn.com.sinosafe.service.msxf;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.CopFiledate;

/**
 * 
 * 马上消费贷后文件抽象父类 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月16日<br>
 */
public abstract class MsxfPostLoanService extends MsxfBaseService {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected CopFiledate copFiledate;

	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		
		try {
			logger.debug("1、获取业务日期和日切日期");
			copFiledate = copFiledateMapper.selectByPrimaryKey(MsxfConstant.MSXF);
			
			// 获取当前时
			int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			//当参照时间和日切时间不相等时说明定时任务已处理
			if (hours > 20 && !StringUtils.equals(copFiledate.getFiledate(), copFiledate.getCutDate())) {
				logger.info("【{}】超过晚上八点不用处理",MsxfConstant.MSXF);
				changeDate();
				return MsxfResponse.CODE_0000;
			}
			
			if(hours > 20 || !StringUtils.equals(copFiledate.getFiledate(), copFiledate.getCutDate())) {
				logger.info("【{}】超过晚上八点不用处理",MsxfConstant.MSXF);
				return MsxfResponse.CODE_0000;
			}
			
			// 获取贷后配置参数
			copFileBatchDeal = copFileBatchDealMapper.selectByPrimaryKey(MsxfConstant.MSXF);
			
			List<String> filePaths = new ArrayList<>();
			// sftp目录
			//String ftpDir = copFileBatchDeal.getDownloadPath() + "/" + copFiledate.getFiledate().replace("-", "");
			// 获取当前目录下所有zip包全路径
			//filePaths = getRemoteDirectory(ftpDir,filePaths);

			// sftp贷后文件目录
			String ftpFileDir = copFileBatchDeal.getDownloadPath() + "/sinosafe/output/" + copFiledate.getFiledate().replace("-", "");
			// sftp影像目录
			String ftpImageDir = copFileBatchDeal.getDownloadPath() + "/receive/" + copFiledate.getFiledate().replace("-", "");
			//获取文件 影像目录下所有zip包全路径
			getRemoteDirectory(ftpFileDir,filePaths);
			getRemoteDirectory(ftpImageDir,filePaths);
			
			// 下载
//			List<String> filePaths = download();

			logger.debug("2、处理文件");
			if(StringUtils.isNotEmpty(filePaths)) {
				dealData(filePaths);
				// 处理完，切日
				copFiledate.setCutDate(DateUtils.getAddDate1(copFiledate.getFiledate(), 1));
				copFiledateMapper.updateByPrimaryKeySelective(copFiledate);
			}
			
			logger.debug("3、下午16点判断是否需要告警");
			if(hours >= 16) {
				isNeedWard();
			}
			
			logger.debug("4、晚上8点日切");
			if(hours >= 20) {
				changeDate();
				// 删除sftp文件
//				deleteFtpDir(ftpPath);
			}
		} catch (Exception e) {
			logger.error(MsxfConstant.MSXF,e);
			msxfAsynDealService.pushEmail(MsxfConstant.MSXF +"贷后中间表处理", copFiledate.getFiledate(), e);
		}
		return MsxfResponse.CODE_0000;
	}
	
	/**
	 * 数据处理
	 * @throws Exception 
	 */
	public abstract void dealData(List<String> filePaths) throws Exception;
	
	/**
	 * <p>Title: changeDate</p>  
	 * <p>Description: 日切</p>  
	 * @throws Exception 
	 */
	private void changeDate() throws Exception {
		CopFiledate cf = new CopFiledate();
		cf.setCopname(MsxfConstant.MSXF);
		if (StringUtils.equals(copFiledate.getFiledate(), copFiledate.getCutDate())) {
			cf.setFiledate(DateUtils.getAddDate1(copFiledate.getCutDate(),1));
			cf.setCutDate(DateUtils.getAddDate1(copFiledate.getCutDate(),1));
		} else {
			cf.setFiledate(DateUtils.getAddDate1(copFiledate.getFiledate(),1));
		}
		copFiledateMapper.updateByPrimaryKeySelective(cf);
	}
	
	/**  
	 * <p>Title: isNeedWard</p>  
	 * <p>Description: 判断是否需要发送警告</p>  
	 * @return  
	 * @throws Exception 
	 */
	private void isNeedWard() throws Exception {
    	if (StringUtils.equals(copFiledate.getFiledate(), copFiledate.getCutDate())) {
    		msxfAsynDealService.pushEmail(MsxfConstant.MSXF +"贷后中间表处理", copFiledate.getFiledate(), new Exception("贷后中间表处理==>没有完成任务，请注意"));
    	}
	}
}
