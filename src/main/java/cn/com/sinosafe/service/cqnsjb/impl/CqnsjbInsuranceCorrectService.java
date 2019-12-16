/**
 * 
 */
package cn.com.sinosafe.service.cqnsjb.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.api.CommonService;
import cn.com.sinosafe.common.config.constant.CqnsjbConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.entity.CqnsjbBfCorrectInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.cqnsjb.CqnsjbService;

/**
 * 
 * 重庆农商借呗--批改逻辑 <br>
 * @Author : fengxiaoyu <br>
 * @Date : 2019年9月26日<br>
 */
@Service("insuranceCorrect")
public class CqnsjbInsuranceCorrectService extends CqnsjbService{
	
	@Autowired
	private CommonService commonService;
	
	@Async
	@Override
	public String busiDeal(String param) throws Exception {
		logger.info("==============重庆农商借呗批改逻辑开始");
		
		logger.debug("1、获取业务日期和日切日期");
		copFiledate = copFiledateMapper.selectByPrimaryKey(CqnsjbConstant.CQRCBJB_CORRECT);
		
		String currentDate = copFiledate.getFiledate();
		logger.info("=========重庆农商借呗批改逻辑，当前业务处理日期为："+currentDate);
		
		//查询所有在保险止期之内的保单数据
		List<LstIqpInfo> LstIqpInfoList = lstIqpInfoMapper.selectLstIqpListByCqnsjb(currentDate);
		if(LstIqpInfoList != null && LstIqpInfoList.size() >0){
			List<CqnsjbBfCorrectInfo> correctInfoList = new ArrayList<CqnsjbBfCorrectInfo>(); //存储
			
			//截止至当天的每月应收保费之和=第1个月保单每笔借据实还利息之和*0.2+第2个月保单每笔借据实还利息之和*0.2+...+第i个月保单每笔借据实还利息之和*0.2，
			//其中第i个月保单每笔借据实还利息之和是保险止期所在月份1日至(当前系统时间-1天)(含)的实还利息之和，每月计算结果向下保留两位小数
			//计算出第1个月到i-1个月的每笔保单的保费
			String currentDay = currentDate.substring(0, 7);
			List<Map<String, Object>> coorrectAmt = cqnsjbBfCorrectInfoMapper.queryCorrectPremAmount(currentDay);
			
			//计算出i个月每笔保单的保费  ，保险止期所在月份1日至(当前系统时间-1天)(含)的实还利息之和          
			String monthFirstDay = DateUtils.getFirstDayOfCurrentDay(currentDate);//结算当月1日
			String monthlastDay = DateUtils.getAddDate1(currentDate,-1); //当前系统时间 -1
			List<Map<String, Object>> currentMonthAmt = cqnsjbBfCorrectInfoMapper.queryCurrentMonthPremAmount(monthFirstDay,monthlastDay);
			
			for(LstIqpInfo lstIqpInfo:LstIqpInfoList){
				//T = 保险止期 -1
				String coverEndDate = DateUtils.getAddDate1(lstIqpInfo.getCoverEndDate(),-1);
				logger.info("========保险止期 -1 为："+coverEndDate);
				
				CqnsjbBfCorrectInfo correctInfo = null;
				
				//比较日期, T = 当前日期  DateUtils.getDate1()
				if(StringUtils.equals(coverEndDate,currentDate)){
					
					logger.info("========保险止期 -1 等于 当前日期");
					correctInfo = lstUpdate(lstIqpInfo, correctInfo,coorrectAmt,currentMonthAmt,currentDate);
					
				} else {
					
					//判断T是节假日还是工作日
					JsonProtocol lsonProtocol = commonService.isWorkDay(coverEndDate);
					if(lsonProtocol.getCode() != 0) {
					    throw new Exception(coverEndDate + "判断是否为工作日失败：" + lsonProtocol.getMessage());
					}
					
					if(!Convert.toBool(lsonProtocol.getData())){
						
						logger.info("========保险止期 -1 为节假日");
						//节假日，获取T的上一工作日
						JsonProtocol resProtocol =commonService.getPreWorkDay(coverEndDate);
						if(resProtocol.getCode() != 0) {
						    throw new Exception(coverEndDate + "获取上一工作日失败：" + resProtocol.getMessage());
						}
						
						String workDay = Convert.toStr(resProtocol.getData());
						logger.info("========保险止期 -1 为节假日，重新获取上一工作日为："+workDay);
						
						//比较日期,T = 当前日期  DateUtils.getDate1()
						if(StringUtils.equals(workDay, currentDate)){
							logger.info("======保险止期 -1 为节假日，重新获取的上一工作日 等于 当前日期");
							correctInfo = lstUpdate(lstIqpInfo, correctInfo,coorrectAmt,currentMonthAmt,currentDate);
						}
					}else {
						logger.info("========保险止期 -1 为工作日且不是今天，则不做处理");
					}
				}
				
				if(correctInfo !=null){
					correctInfoList.add(correctInfo);
				}
			}
			
			if(correctInfoList != null && correctInfoList.size() > 0){
				//批量添加批改记录
				cqnsjbBfCorrectInfoMapper.insertBatch(correctInfoList);
				logger.info("======批量添加批改记录成功");
			}
		}
		//切日
		changeDate(CqnsjbConstant.CQRCBJB_CORRECT,currentDate);
		logger.info("重庆农商借呗批改切日成功");
		
		logger.info("==============重庆农商借呗批改逻辑结束");
		return null;
	}

	/**
	 * 保费计算，批改
	 * @Description
	 * @date 2019年10月16日  
	 * @param lstIqpInfo
	 * @param correctInfo
	 * @param currentMonthAmt 
	 * @param coorrectAmt 
	 * @param currentDate 
	 * @return
	 * @throws Exception 
	 */
	public CqnsjbBfCorrectInfo lstUpdate(LstIqpInfo lstIqpInfo, CqnsjbBfCorrectInfo correctInfo, List<Map<String, Object>> coorrectAmt, List<Map<String, Object>> currentMonthAmt, String currentDate) throws Exception {
		//计算保费
		BigDecimal insuranceAmount = getCalculateInsurance(lstIqpInfo,coorrectAmt,currentMonthAmt);
		logger.info("======计算的批改保费为："+insuranceAmount);
		// 判断保单保费与计算保费是否相等，相等不等需批改  ，计算的保费为0也不需要去做批改
		if(insuranceAmount.compareTo(new BigDecimal("0.00")) != 0 && insuranceAmount.compareTo(lstIqpInfo.getCoverageFee()) != 0) {
			//批改保单
			boolean result = sendInsuranceInfo(lstIqpInfo,insuranceAmount);
			//记录表中
			correctInfo = buildParams(lstIqpInfo,insuranceAmount,result?"1":"0",currentDate);
		}
		return correctInfo;
	}
    
	/**
	 * 每日批改时计算的保费金额
	 * @param currentMonthAmt 
	 * @param coorrectAmt 
	 * @Description
	 * @date 2019年9月26日
	 */
	private BigDecimal getCalculateInsurance(LstIqpInfo lstIqpInfo, List<Map<String, Object>> coorrectAmt, List<Map<String, Object>> currentMonthAmt){
		BigDecimal insuranceAmount = new BigDecimal("0.00");
		if(StringUtils.isNotEmpty(coorrectAmt)){
			for(Map<String, Object> map:coorrectAmt){
				if(lstIqpInfo.getListSerno().equals(String.valueOf(map.get("LIST_SERNO")))){
					insuranceAmount = insuranceAmount.add(Convert.toBigDecimal(map.get("INSURE_AMOUNT")));
				}
			}
		}
		if(StringUtils.isNotEmpty(currentMonthAmt)){
			for(Map<String, Object> map:currentMonthAmt){
				if(lstIqpInfo.getListSerno().equals(String.valueOf(map.get("LIST_SERNO")))){
					insuranceAmount = insuranceAmount.add(Convert.toBigDecimal(map.get("LAST_MONTH_INT_AMT")));
				}
			}
		} 
		return insuranceAmount;
	}

}
