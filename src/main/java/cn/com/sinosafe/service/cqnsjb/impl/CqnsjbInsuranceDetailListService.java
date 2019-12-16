/**
 * 
 */
package cn.com.sinosafe.service.cqnsjb.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.CqnsjbConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.CqnsjbBfCorrectInfoMapper;
import cn.com.sinosafe.dao.CqnsjbBfDetailInfoMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.entity.CqnsjbBfCorrectInfo;
import cn.com.sinosafe.domain.entity.CqnsjbBfDetailInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.service.cqnsjb.CqnsjbService;

/**
 * 
 * 重庆农商借呗--保费清单明细，应计利息 <br>
 * @Author : fengxiaoyu <br>
 * @Date : 2019年9月26日<br>
 */
@Service("insuranceDetailList")
public class CqnsjbInsuranceDetailListService extends CqnsjbService{
	
	@Autowired
	private CqnsjbBfCorrectInfoMapper cqnsjbBfCorrectInfoMapper;
	
	@Autowired
	private CqnsjbBfDetailInfoMapper cqnsjbBfDetailInfoMapper;
	
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;

	@Async
	@Override
	public String busiDeal(String param) throws Exception {
		logger.info("=============重庆农商借呗    保费清单明细，应计利息开始" );
		
		logger.debug("1、获取业务日期和日切日期");
		copFiledate = copFiledateMapper.selectByPrimaryKey(CqnsjbConstant.CQRCBJB_DETAIL);
		
		String currentDate = copFiledate.getFiledate();
		logger.info("=========重庆农商借呗--保费清单明细，应计利息,当前业务处理日期为："+currentDate);
		
		//查询当月总的实还利息
		String currentMonth = currentDate.substring(0, 7);
		List<Map<String, Object>> currentMontRealIntAmtList = cqnsjbBfCorrectInfoMapper.queryCurrentMontRealIntAmt(currentMonth);
		if(StringUtils.isNotEmpty(currentMontRealIntAmtList)){
			//插入之前先删除当月明细数据
			cqnsjbBfDetailInfoMapper.deleteDetailInfoByMonth(currentMonth);
			
			String monthLastDay = DateUtils.getLastDayOfCurrentDay(currentDate);//结算当月月末
			String monthFirstDay = DateUtils.getFirstDayOfCurrentDay(currentDate);//结算当月1日
			
			//构造明细数据
			List<CqnsjbBfDetailInfo> cqnsjbBfDetailInfos = new ArrayList<>();
			
			for(Map<String, Object> currentMontRealIntAmt:currentMontRealIntAmtList){
				String listSerno = Convert.toStr(currentMontRealIntAmt.get("LIST_SERNO"));//保单号
				LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(listSerno);
				//T = 保险止期-1
				String coverEndDate = DateUtils.getAddDate1(lstIqpInfo.getCoverEndDate(),-1);
				
				//查询最新的批改日期
				CqnsjbBfCorrectInfo correctInfo = queryCorrectDate(lstIqpInfo.getSerno(),listSerno, null);
				// 批改日期
				String correctDate = StringUtils.isNotNull(correctInfo) && StringUtils.equals("1", correctInfo.getStatus())
											?correctInfo.getCorrectDate():null;
											
				logger.info("=================重庆农商借呗，当前保单：{}，保险止期为：{}，批改成功日期：{}",listSerno,coverEndDate,correctDate);
				
				String calculateDate = null; //计算日期 
				//比较日期
				//T <= 今天
				if(DateUtils.getItDifferenceDate(coverEndDate, currentDate) >= 0){
					logger.info("{}=================重庆农商借呗，保险止期 -1 小于等于今天",listSerno);
					//计算日期, T -1 与结算当月月末比较，取小值
					if(StringUtils.isNotNull(correctInfo) && StringUtils.equals("0", correctInfo.getStatus())){
						logger.info("{}==============重庆农商借呗,批改失败，计算日期 = 上次批改日期 -1 和月末 比较，取小值",listSerno);
						//计算日期 = 上次批改日期 -1 和月末 比较，取小值,如果上一批改日为空，就默认为月末
						//获取上一次批改日(查询批改成功的)
						CqnsjbBfCorrectInfo correctInfo1 = queryCorrectDate(lstIqpInfo.getSerno(),listSerno, "1");
						if(StringUtils.isNotNull(correctInfo1) && StringUtils.isNotEmpty(correctInfo1.getCorrectDate())){
							logger.info("==============重庆农商借呗,当前保单"+lstIqpInfo.getListSerno()+"批改失败，并且上一批改日为"+correctInfo1.getCorrectDate());
							calculateDate = DateUtils.comparamDay(monthLastDay,DateUtils.getAddDate1(correctInfo1.getCorrectDate(),-1));
						}else{
							//如果上一批改日为空，就默认为月末
							logger.info("==============重庆农商借呗,当前保单"+lstIqpInfo.getListSerno()+"批改失败，并且上一批改日为空，计算日期默认为当月月末");
							calculateDate = monthLastDay;
						}
					}else{
						logger.info("{}==============重庆农商借呗,上一次批改成功，计算日期 = T-1和月末比较，取小值",listSerno);
						//上次批改成功，计算日期 = T-1和月末比较，取小值
						calculateDate = DateUtils.comparamDay(monthLastDay,DateUtils.getAddDate1(coverEndDate,-1));
					}
				}else{
					// T > 今天,应计利息=有效利息，有效利息为：实还日期在结算月份1日至月末最后一天或(保险止期-2天)（取二者较前的日期）的利息，记为有效实还利息
					logger.info("{}=================重庆农商借呗，保险止期 -1 大于今天",listSerno);
					//保险止期-2天
					calculateDate =  DateUtils.comparamDay(monthLastDay,DateUtils.getAddDate1(coverEndDate,-1));
				}
				
				//构造明细数据
				cqnsjbBfDetailInfos.add(bulidDetailInfoList(monthFirstDay,calculateDate,coverEndDate,correctDate,currentMontRealIntAmt,currentDate));
			}
			
			//批量插入明细数据
			if(StringUtils.isNotEmpty(cqnsjbBfDetailInfos)){
				cqnsjbBfDetailInfoMapper.insertBatchDetailInfo(cqnsjbBfDetailInfos);
			}
			
		}
		
		//切日
		changeDate(CqnsjbConstant.CQRCBJB_DETAIL,currentDate);
		logger.info("重庆农商借呗保费清单明细，应计利息切日成功");
		
		logger.info("=============重庆农商借呗    保费清单明细，应计利息结束");
		return null;
	}
	/**
	 * 计算保单应计利息，构造明细数据
	 * @param monthFirstDay
	 * @param calculateDate
	 * @param coverEndDate
	 * @param correctDate
	 * @param currentMontRealIntAmt
	 * @param currentDate 
	 * @return
	 */
	private CqnsjbBfDetailInfo bulidDetailInfoList(String monthFirstDay, String calculateDate,String coverEndDate, String correctDate, Map<String, Object> currentMontRealIntAmt, String currentDate){
		// 根据保单查询所有借据 的 利息
		Map<String,String> mapParams = new HashMap<String, String>();
		mapParams.put("monthFirstDay", monthFirstDay);
		mapParams.put("calculateDate", calculateDate);
		mapParams.put("listSerno", Convert.toStr(currentMontRealIntAmt.get("LIST_SERNO")));
		//查询保单应计利息，日期范围是当月1号到计算日期
		Map<String, Object> acctIntList = cqnsjbBfCorrectInfoMapper.queryBillAccruedInterestByListSerno(mapParams);
		
		CqnsjbBfDetailInfo cqnsjbBfDetailInfo = buildDetailInfo(currentMontRealIntAmt,acctIntList,correctDate,coverEndDate,currentDate);
		
		return cqnsjbBfDetailInfo;
	}

	/**
	 * 构造明细数据
	 * @Description
	 * @date 2019年10月16日  
	 * @param lstIqpInfo
	 * @param map
	 * @param correctDate 
	 * @param currentDate 
	 * @return
	 */
	private CqnsjbBfDetailInfo buildDetailInfo(Map<String, Object> currentMontRealIntAmt,Map<String, Object> acctIntList, String correctDate,String coverEndDate, String currentDate) {
		CqnsjbBfDetailInfo detailInfo = new CqnsjbBfDetailInfo();
		detailInfo.setListSerno(Convert.toStr(currentMontRealIntAmt.get("LIST_SERNO")));
		detailInfo.setPsRealIntAmt(Convert.toBigDecimal(currentMontRealIntAmt.get("REAL_INT_AMOUNT")));//实还利息
		if(null !=acctIntList){
			detailInfo.setAccruedIntAmt(Convert.toBigDecimal(acctIntList.get("ACCR_INT_AMOUNT")));//应计利息
		}else{
			detailInfo.setAccruedIntAmt(new BigDecimal("0.00"));//应计利息
		}
		detailInfo.setInputDate(DateUtils.getDate());
		detailInfo.setAccountMonth(currentDate.substring(0, 7));
		detailInfo.setListDueDate(coverEndDate);
		detailInfo.setCorrectDate(correctDate);
		return detailInfo;
	}
	
	
	/**
	 * 查询批改日期
	 * @Description
	 * @date 2019年11月7日  
	 * @param lstIqpInfo
	 * @param status
	 * @return
	 */
	private CqnsjbBfCorrectInfo queryCorrectDate(String serno, String listSerno,String status){
		//查询批改日期
		CqnsjbBfCorrectInfo cqnsjbBfCorrectInfo = new CqnsjbBfCorrectInfo();
		cqnsjbBfCorrectInfo.setListSerno(listSerno);
		cqnsjbBfCorrectInfo.setSerno(serno);
		cqnsjbBfCorrectInfo.setStatus(status);
		return cqnsjbBfCorrectInfoMapper.selectByListserno(cqnsjbBfCorrectInfo);
	}
}
