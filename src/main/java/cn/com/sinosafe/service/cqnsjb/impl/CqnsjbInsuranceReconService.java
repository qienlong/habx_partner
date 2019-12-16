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
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.constant.CqnsjbConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.CqnsjbBfAccountInfoMapper;
import cn.com.sinosafe.dao.CqnsjbBfDetailInfoMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.entity.CqnsjbBfAccountInfo;
import cn.com.sinosafe.domain.entity.CqnsjbBfCorrectInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.cqnsjb.CqnsjbService;


/**
 * 
 * 重庆农商借呗 保费对账逻辑 <br>
 * @Author : fengxiaoyu <br>
 * @Date : 2019年9月26日<br>
 */
@Service("insuranceRecon")
public class CqnsjbInsuranceReconService extends CqnsjbService{

	@Autowired
	private CqnsjbBfDetailInfoMapper cqnsjbBfDetailInfoMapper;
	@Autowired
	private CqnsjbBfAccountInfoMapper cqnsjbBfAccountInfoMapper;
	
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	
	@Override
	public String busiDeal(String param) throws Exception {
		logger.info("=============重庆农商借呗    保费对账逻辑开始");
		JSONObject json = JSONObject.parseObject(param);
		String accDate =json.getString("accountMonth");
		String inputDate = json.getString("inputDate");
		//上月应收保费 A
		BigDecimal reviceAmont = json.getBigDecimal("coverage");
		
		Map<String,String> mapRes = new HashMap<String,String>();
		mapRes.put("code", "0");
		mapRes.put("message", "");
		
		logger.debug("1、获取业务日期和日切日期");
		copFiledate = copFiledateMapper.selectByPrimaryKey(CqnsjbConstant.CQRCBJB_RECON);
		
		String currentDate = copFiledate.getFiledate();
		logger.info("=========重庆农商借呗批改逻辑，当前业务处理日期为："+currentDate);
		
		//查询当月所有保单的明细数据
		List<String> cqnsjbBfDetailInfosList = cqnsjbBfDetailInfoMapper.queryDetailInfo(accDate);
		if(null !=cqnsjbBfDetailInfosList && cqnsjbBfDetailInfosList.size() > 0){
			logger.info("====借呗保费对账，当月所有的保单总数为："+cqnsjbBfDetailInfosList.size());
			//查询业务归属部门代码(10位出单机构代码)
			String coreOrganno = cqnsjbBfDetailInfoMapper.querySOrgInfo(CqnsjbConstant.CQRCBJB);
			boolean flag = true;
			List<CqnsjbBfAccountInfo> cqnsjbBfAccountInfos = new ArrayList<CqnsjbBfAccountInfo>();  //存放对账信息记录
			List<CqnsjbBfCorrectInfo> correctInfoList = new ArrayList<CqnsjbBfCorrectInfo>();  //存放批改信息记录
			
			for(String listSerno:cqnsjbBfDetailInfosList){
				//根据保单号查询保单信息
				LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(listSerno);
				
				//已发送总对账金额
				BigDecimal alreadyAmount = getAlreadyAmount(lstIqpInfo); 
				logger.info("====借呗保费对账,当前保单"+listSerno+"已发送总对账金额为："+alreadyAmount);
				//待对账金额 B = 保单保费 - 已发送总对账金额
				BigDecimal needAmount = Convert.toBigDecimal(lstIqpInfo.getCoverageFee(), new BigDecimal("0.00"))
										.subtract(Convert.toBigDecimal(alreadyAmount,new BigDecimal("0.00")));
				logger.info("====借呗保费对账,当前保单"+listSerno+"待对账金额为："+needAmount);
				BigDecimal amountDz = null;
				
				// 上月应收保费A > 待对账金额 B时，需要批改保单保费，费率同步批改，本次对账金额为上月应收保费A
				if(reviceAmont.compareTo(needAmount) == 1){
					logger.info("====借呗保费对账,当前保单"+listSerno+"上月应收保费大于待对账金额，需要批改保单保费");
					//批改保单保费，批改费率,保费= 已对账金额 +上月应收保费A
					BigDecimal accrAmount = alreadyAmount.add(Convert.toBigDecimal(reviceAmont));//保费= 已对账金额 +上月应收保费A
					boolean resu = sendInsuranceInfo(lstIqpInfo,accrAmount);
					if(resu){
						logger.info("====借呗保费对账,当前保单"+listSerno+"上月应收保费大于待对账金额，批改保单保费成功");
						amountDz = reviceAmont; 
						
					}else{
						logger.info("====借呗保费对账,当前保单"+listSerno+"上月应收保费大于待对账金额，批改保单保费失败");
						mapRes.put("code", "1");
						mapRes.put("message", "批改保单保费，批改费率失败");
						return JSON.toJSONString(mapRes);
					}
					//记录批改信息
					correctInfoList.add(buildParams(lstIqpInfo,accrAmount,resu?"1":"0",currentDate));
					
				}else{
					logger.info("====借呗保费对账,当前保单"+listSerno+"上月应收保费小于等于待对账金额，本次对账金额为上月应收保费");
					//上月应收保费A <= 待对账金额 B，本	次对账金额 = 上月应收保费A
					amountDz = reviceAmont; 
				}
				if(null != amountDz){
					logger.info("======重庆农商行借呗保费对账，当前保单"+lstIqpInfo.getListSerno()+"上报业务数据的金额为："+amountDz);
					//上报业务数据
					String resultB = sendReconInfo(lstIqpInfo,inputDate,coreOrganno,amountDz);
					if("0".equals(resultB)){
						logger.info("======重庆农商行借呗保费对账，当前保单"+lstIqpInfo.getListSerno()+"上报业务数据成功");
						
						cqnsjbBfAccountInfos.add(buildAccountInfo(amountDz,lstIqpInfo.getListSerno(),inputDate));
					}
					if("1".equals(resultB)){
						logger.info("======重庆农商行借呗保费对账，当前保单"+lstIqpInfo.getListSerno()+"上报业务数据失败");
						flag = false;
						mapRes.put("code", "3");
						mapRes.put("message", "上报业务数据失败");
						return JSON.toJSONString(mapRes);
					}
				}
			}
			
			//批量记录对账成功的信息
			if(!StringUtils.isEmpty(cqnsjbBfAccountInfos)){
				cqnsjbBfAccountInfoMapper.insertBfAccountInfoBatch(cqnsjbBfAccountInfos);
				logger.info("======重庆农商行借呗保费对账，批量记录对账成功信息成功");
			}
			//批量记录批改信息
			if(!StringUtils.isEmpty(correctInfoList)){
				cqnsjbBfCorrectInfoMapper.insertBatch(correctInfoList);
				logger.info("======批量添加批改记录成功");
			}
			
			// 业务数据不是时实的，业务数据推送成功后立马调对账单会失败，需要手工调对账单接口，（业务数据推送成功，对账单接口一定会返回成功，实际是否需要到企联）
//			if(flag){
//				//发送对账单
//				boolean res = sendAccountInfo(inputDate);
//				if(!res){
//					mapRes.put("code", "2");
//					mapRes.put("message", "发送对账单，对账失败");
//					return JSON.toJSONString(mapRes);
//				}
//				//批量记录对账成功的信息
//				if(null !=cqnsjbBfAccountInfos && cqnsjbBfAccountInfos.size() >0){
//					cqnsjbBfAccountInfoMapper.insertBfAccountInfoBatch(cqnsjbBfAccountInfos);
//				}
//			}
			
		}
		//切日
		changeDate(CqnsjbConstant.CQRCBJB_RECON,currentDate);
		logger.info("重庆农商借呗 保费对账切日成功");
		
		logger.info("=============重庆农商借呗    保费对账逻辑结束");
		return JSON.toJSONString(mapRes);
	}
	
	
	/**
	 * 获取已发送总对账金额
	 * @Description
	 * @date 2019年10月16日  
	 * @param lstIqpInfo
	 * @return
	 */
	private BigDecimal getAlreadyAmount(LstIqpInfo lstIqpInfo){
		//根据保单号查询已发送对账金额
		List<CqnsjbBfAccountInfo> cqnsjbBfAccountInfos = cqnsjbBfAccountInfoMapper.queryBfAccountInfoByListSerno(lstIqpInfo.getListSerno());
		//已发送总对账金额
		BigDecimal alreadyAmount = new BigDecimal("0.00"); 
		if(null != cqnsjbBfAccountInfos && cqnsjbBfAccountInfos.size() >0){
			for (CqnsjbBfAccountInfo cqnsjbBfAccountInfo : cqnsjbBfAccountInfos) {
				alreadyAmount.add(cqnsjbBfAccountInfo.getAmount());
			}
		}
		return alreadyAmount;
	}
	

	/**
	 * 业务数据上报
	 * @Description
	 * @date 2019年10月16日  
	 * @param lstIqpInfo
	 * @param inputDate
	 * @param coreOrganno
	 * @throws Exception 
	 */
	private String sendReconInfo(LstIqpInfo lstIqpInfo,String inputDate,String coreOrganno,BigDecimal reviceAmont) throws Exception{
		//客户刷卡卡号 
		String bankCode = systemConfig.getValue("cqnshjb_insurance_bank_code");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("app_id", "00201902");//统一分配的对账接入鉴权id
		params.put("app_key", "recon_2019");//统一分配的对账接入鉴权key
		params.put("recon_bus_type", "2");//对账业务类型
		params.put("app_base_pay_app_no",lstIqpInfo.getSerno()+DateUtils.getDateStr());//从外部收款通道获取的唯一支付申请号  ,保单号+年月日
		params.put("app_base_inpayment_date", inputDate.replaceAll("-", ""));//完成缴费的交易日期格式YYYYMMDD
		params.put("app_base_inpayment_time", "000000");//完成缴费的交易时间格式HHMMSS
		params.put("app_base_insu_mid_no", "DZ00201902");//商户号(由统一对账平台配置）
		params.put("app_base_remark", "保费结算单对账"); //备注
		params.put("app_base_policy_start_date", lstIqpInfo.getCoverStartDate());//起保时间
		params.put("app_base_sub_company",  coreOrganno.substring(0, 4)); //分公司
		params.put("app_base_currency_type", "CNY");//币种传CNY
		params.put("app_base_insured_name", "");//缴款人名称
		params.put("app_base_department_code", coreOrganno);//业务归属部门
		params.put("app_base_mobile_number", lstIqpInfo.getMobile()); //客户手机号
		params.put("app_base_certificate_type", "1");//1：身份证，2：组织机构代码 3：其他证件
		params.put("app_base_certificate_no", lstIqpInfo.getCertCode());//证件号
		params.put("app_base_terminal_no", "CQNSJB0000000000");//终端编号
		params.put("app_base_bank_flow_no", "CQNSJB0000000000");//银行流水号
		params.put("app_base_cus_bank_card_no", bankCode);//客户刷卡卡号 
		params.put("app_base_total_no", "");//分批传送总数
		params.put("app_base_serial_no", "");//分批批次号
		
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("app_info_cust_seq", lstIqpInfo.getSerno());//流水号
		map.put("app_info_applicant_no", lstIqpInfo.getListSerno());//投保单/保单，代表业务单号（结合datatype看，0-投保单、2-保单，1-批改申请单号）
		map.put("app_info_policy_no", lstIqpInfo.getListSerno());//保单号
		map.put("app_info_currency_type", "CNY");//币种CNY
		map.put("app_info_amount",reviceAmont.multiply(new BigDecimal("100")));//金额单位分
		map.put("app_info_transactor_name", "");//业务经办人
		map.put("app_info_applicant_name", lstIqpInfo.getCusName());//投保人名称
		map.put("app_info_applicant_code", lstIqpInfo.getCusId());//投保人代码
		map.put("app_info_insured_name", lstIqpInfo.getReceiveCusName());//被保险人名称
		map.put("app_info_insured_code", lstIqpInfo.getReceiverCusId());//被保险人代码
		map.put("app_info_start_date", lstIqpInfo.getCoverStartDate().replaceAll("-", ""));//起保生效日期 20190711145023
		map.put("app_info_data_type", "2");//0-见费出单、2-非见费，1-见费批改申请
		map.put("app_info_department_code", coreOrganno);//业务归属部门代码(10位出单机构代码)
		map.put("app_info_installments_times", "1");//分期缴费期次
		map.put("app_info_apply_type", "0");//“保费/赔款”标识，0--保费，1-赔款
		
		params.put("app_info_list", listMap);
		params.put("app_base_amount",reviceAmont.multiply(new BigDecimal("100")));//交易金额，以分为单位
		
		JsonProtocol jsonProtocol = payService.sendReconInfo(JSON.parseObject(JSON.toJSONString(params)));
		
		logger.info("重庆农商借呗，保单编号"+lstIqpInfo.getListSerno()+"业务数据上报接口返回参数为："+jsonProtocol.toString());
		
		if(jsonProtocol.getCode() == 0){
			logger.info("重庆农商借呗，保单编号"+lstIqpInfo.getListSerno()+"业务数据上报接口成功");
			return "0";
		}else if(jsonProtocol.getCode() == 903){
			logger.info("重庆农商借呗，保单编号"+lstIqpInfo.getListSerno()+"业务数据上报接口返回"+jsonProtocol.getMessage());
			return "903";
		}else if(jsonProtocol.getCode() == 902){
			logger.info("重庆农商借呗，保单编号"+lstIqpInfo.getListSerno()+"业务数据上报接口返回"+jsonProtocol.getMessage());
			return "902";
		}else{
			logger.info("重庆农商借呗，保单编号"+lstIqpInfo.getListSerno()+"业务数据上报接口返回"+jsonProtocol.getMessage());
			return "1";
		}
	}
	
	/**
	 * 上传对账单
	 * @Description
	 * @date 2019年10月16日  
	 * @param lstIqpInfo
	 * @param inputDate
	 * @throws Exception
	 */
	private boolean sendAccountInfo(String inputDate) throws Exception{
		Map<String, Object> params = new HashMap<>();
		params.put("accMerchant","DZ00201902");//商户号(由统一对账平台配置）
		params.put("inputDate", inputDate.replaceAll("-", ""));
		params.put("reconBusType", "2");
		params.put("settleDate", inputDate.replaceAll("-", ""));
		
		JsonProtocol jsonProtocol = payService.manualUploadStatement(JSON.parseObject(JSON.toJSONString(params)));
		
		logger.info("重庆农商借呗，上传对账单接口返回参数为："+jsonProtocol.toString());
		
		if(jsonProtocol.getCode() !=0){
			logger.info("重庆农商借呗,上传对账单失败，失败原因为{}"+jsonProtocol.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * 构建对账信息
	 * @param amountDz
	 * @param listSerno
	 * @param inputDate
	 * @return
	 */
	private CqnsjbBfAccountInfo buildAccountInfo(BigDecimal amountDz, String listSerno, String inputDate){
		//记录对账金额
		CqnsjbBfAccountInfo cqnsjbBfAccountInfo = new CqnsjbBfAccountInfo();
		cqnsjbBfAccountInfo.setListSerno(listSerno);
		cqnsjbBfAccountInfo.setAmount(amountDz);
		cqnsjbBfAccountInfo.setStatus("1");
		cqnsjbBfAccountInfo.setInputDate(inputDate);
		cqnsjbBfAccountInfo.setCreateDate(DateUtils.getDate());
		return cqnsjbBfAccountInfo;
	}
}
