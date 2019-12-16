package cn.com.sinosafe.service.msxf.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.MsxfAccLoanInfoMapper;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.CopFiledate;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.msxf.MsxfMqMsg;
import cn.com.sinosafe.service.common.MqService;
import cn.com.sinosafe.service.msxf.MsxfBaseService;

/**
 * 
 * 马上消费--贷后数据处理接口 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月17日<br>
 */
@Service(MsxfConstant.MSXF_AL1002)
public class MsxfAL1002Service extends MsxfBaseService {
	
	@Autowired
	private MqService mqService;
	@Autowired
	private MsxfAccLoanInfoMapper msxfAccLoanInfoMapper;

	/**
	 * 
	 * 用消息队列解决数据量问题
	 * 1、正常：有还款就插入还款明细，有保费还款就插入保费明细<br>
	 * 2、逾期：更新还款计划（更新罚息），有还款就插入还款明细，有保费还款就插入保费明细<br>
	 * 3、提前结清：华安需删除未到期本息还款计划、保费还款计划。批改保单保费、保费计划、保单止期。在日终时，华安生成当天提前结清、异常终止的处理结果清单【退保结果清单】上传到sftp。<br>
	 * 4、理赔结清：理赔时处理<br>
	 * 4、正常终止或者逾期终止：华安需删除未到期本息还款计划，冲销对应的应收客户。之后当客户还款，马上传输对应的还款明细，华安校验本息还清后，华安同步对保单进行提前结清，批改保单保费、保费计划、保单止期。在日终时，华安生成当天提前结清、异常终止的处理结果清单【退保结果清单】上传到sftp。<br>
	 * 5、延期：华安需删除未到期的本息还款计划，保费还款计划，冲销对应的应收科目。批改保单保费、保费计划、保单止期。在日终时，华安生成当天提前结清、异常终止的处理结果清单【退保结果清单】上传到sftp。<br>
	 */
	@Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		
		try {
			// 获取业务时间
			CopFiledate copFiledate = copFiledateMapper.selectByPrimaryKey(MsxfConstant.MSXF + "-DATA");
			// 根据业务时间查询借据中间表待处理数据
			List<MsxfAccLoanInfo> accLoanInfos = msxfAccLoanInfoMapper.selectByStatusAndBusiDate("0",copFiledate.getFiledate());
			
			if(StringUtils.isNotEmpty(accLoanInfos)) {
				// 发送MQ
				for (MsxfAccLoanInfo msxfAccLoanInfo : accLoanInfos) {
					MsxfMqMsg mqMsg = new MsxfMqMsg();
					mqMsg.setType("data");
					mqMsg.setDate(copFiledate.getFiledate());
					mqMsg.setData(JSON.toJSONString(msxfAccLoanInfo));
					mqService.noticeMsxfPostLoanData(JSON.toJSONString(mqMsg));
				}
				
				// 更新状态
				msxfAccLoanInfoMapper.updateStatusByBusiDate(copFiledate.getFiledate());
				
				logger.info("{}已处理{}笔借据",MsxfConstant.MSXF_AL1002,accLoanInfos.size());
			}else {
				logger.info("{}无数据需要处理",MsxfConstant.MSXF_AL1002);
			}
			
			// 更新日期
			copFiledate.setFiledate(DateUtils.getAddDate1(copFiledate.getFiledate(), 1));
			copFiledateMapper.updateByPrimaryKeySelective(copFiledate);
		} catch (Exception e) {
			logger.info(MsxfConstant.MSXF_AL1002,e);
			msxfAsynDealService.pushEmail(MsxfConstant.MSXF_AL1002, param, e);
		}
		return MsxfResponse.CODE_0000;
	}
	

}
