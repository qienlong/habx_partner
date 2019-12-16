package cn.com.sinosafe.service.msxf.postloan;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yzj.util.UUID32;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.MsxfAccMtdPlanMapper;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.MsxfAccMtdPlan;
import cn.com.sinosafe.service.msxf.MsxfService;

/**
 * 
 * 马上消费-还款计划文件处理 <br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年9月17日<br>
 */
@Service(MsxfConstant.MSXF_AL1001_PLAN_FILE)
public class MsxfRepayPlanFileService implements MsxfService{

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired(required = false)
	private MsxfAccMtdPlanMapper msxfAccMtdPlanMapper;

	@Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		logger.info("{}还款计划数据落地开始",MsxfConstant.MSXF_AL1001_PLAN_FILE);
		ArrayList<MsxfAccMtdPlan> accMtdPlanList = new ArrayList<>();
		try {
			JSONObject params = JSON.parseObject(param);
			String copNo = Convert.toStr(params.get("partner")); //资金方
			String businessDate = Convert.toStr(params.get("date"));//华安业务时间
			@SuppressWarnings("unchecked")
			List<String> contents =(List<String>)params.get("contents");
			if(StringUtils.isNotEmpty(contents)) {
				logger.info("解析还款计划txt文档共有{}条记录",contents.size());
				int count = 1;
				for (String content: contents) {
					MsxfAccMtdPlan msxfAccMtdPlan = coverToEntity(content,count);
					msxfAccMtdPlan.setMsxfAccMtdPlanId(UUID32.getUUID());
					msxfAccMtdPlan.setCopNo(copNo);
					msxfAccMtdPlan.setBusinessDate(businessDate);
					msxfAccMtdPlan.setSyncStatus("0");//同步状态 初始状态
					accMtdPlanList.add(msxfAccMtdPlan);
					count++;
				}
			}
			
			logger.info("{}批量插入还款计划开始,总记录数:{}",MsxfConstant.MSXF_AL1001_PLAN_FILE,accMtdPlanList.size());
			
			//批量插入
			if(StringUtils.isNotEmpty(accMtdPlanList)) msxfAccMtdPlanMapper.batchInsert(accMtdPlanList);
			
			logger.info("{}批量插入还款计划结束,总记录数:{}",MsxfConstant.MSXF_AL1001_PLAN_FILE,accMtdPlanList.size());
			
		} catch (Exception e){
			logger.error(MsxfConstant.MSXF_AL1001_PLAN_FILE + "批量插入还款计划失败!",e);
		} finally {
			logger.info("{}还款计划数据落地结束",MsxfConstant.MSXF_AL1001_PLAN_FILE);
		}
		return MsxfResponse.CODE_0000;
	}

	/**
	 * 读取文本内容并生成相应实体类
	 */
	private MsxfAccMtdPlan coverToEntity(String content,int count) throws Exception{
		MsxfAccMtdPlan msxfAccMtdPlan = new MsxfAccMtdPlan();
		int i=0;
		String[] contentArray = content.split(MsxfConstant.MSXF_SPLIT);
		if(contentArray.length!= MsxfConstant.ACC_MTD_PLAN_PARAMCOUNT){
			logger.info("还款计划txt文档中第{}行参数个数有误!",count);
			throw new IllegalArgumentException("还款计划txt文档中第"+count+"行参数个数有误!");
		}
		msxfAccMtdPlan.setBizDate(contentArray[i++]);
		msxfAccMtdPlan.setContrNbr(contentArray[i++]);
		msxfAccMtdPlan.setProductCd(contentArray[i++]);
		msxfAccMtdPlan.setRefNbr(contentArray[i++]);
		msxfAccMtdPlan.setTerm(contentArray[i++]);
		msxfAccMtdPlan.setBeginDate(contentArray[i++]);
		msxfAccMtdPlan.setStmtDate(contentArray[i++]);
		msxfAccMtdPlan.setGraceDate(contentArray[i++]);
		msxfAccMtdPlan.setStatus(contentArray[i++]);
		msxfAccMtdPlan.setPrincipal(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setPrincipalPaid(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setPrincipalDue(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setPrincipalDue91(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setInterest(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setInterestPaid(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setInterestDue(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setInterestDue91(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setPenaltyDue(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setPenaltyPaid(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPlan.setInitTerm(contentArray[i++]);
		return msxfAccMtdPlan;
	}

}
