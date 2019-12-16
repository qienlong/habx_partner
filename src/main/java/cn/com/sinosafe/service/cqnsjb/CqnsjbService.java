package cn.com.sinosafe.service.cqnsjb;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.alibaba.fastjson.JSON;
import com.yzj.util.UUID32;

import cn.com.sinosafe.api.CommonService;
import cn.com.sinosafe.api.PayService;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.dao.CopFiledateMapper;
import cn.com.sinosafe.dao.CqnsjbBfCorrectInfoMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.entity.CopFiledate;
import cn.com.sinosafe.domain.entity.CqnsjbBfCorrectInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.common.EmailPushService;

/**
 * 
 * 重庆农商借呗服务 <br>
 * @Author : fengxiaoyu <br>
 * @Date : 2019年9月26日<br>
 */
public abstract class  CqnsjbService implements CqnsjbBaseService{

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected SystemConfig systemConfig;
	
	@Autowired
	private EmailPushService emailPushService;
	
	@Autowired
	protected LstIqpInfoMapper lstIqpInfoMapper;
	
	@Autowired
	protected CqnsjbBfCorrectInfoMapper cqnsjbBfCorrectInfoMapper;
	
	@Autowired
	protected CopFiledateMapper copFiledateMapper;
	
	@Resource
	protected CommonService commonService;
	
	@Resource
	protected PayService payService;
	
	protected CopFiledate copFiledate;
	
	
	/**
	 * 批改保费
	 * @Description
	 * @date 2019年9月26日  
	 * @param lstIqpInfo
	 * @param amountCurr
	 * @return
	 * @throws Exception 
	 */
	protected boolean sendInsuranceInfo(LstIqpInfo lstIqpInfo,BigDecimal amountCurr) throws Exception{
		boolean result = true;
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("policyNo", lstIqpInfo.getListSerno());
		params.put("modifyType", "07");//批改类型，07：批改费率、金额
		
		Map<String,Object> paramsInfo= new HashMap<String,Object>();
		paramsInfo.put("rateOrig", lstIqpInfo.getRate());//原费率
		//如果是对账时批改费率，批改后费率 = 批改后保费/批改后保额
		BigDecimal rateCurr = amountCurr.divide(Convert.toBigDecimal(lstIqpInfo.getCoverAmount()),5,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("1000"));
		paramsInfo.put("rateCurr", rateCurr);//批改后费率
		
		paramsInfo.put("amountOrig", lstIqpInfo.getCoverAmount());//原保额
		paramsInfo.put("amountCurr", lstIqpInfo.getCoverAmount());//批改后保额
		paramsInfo.put("feeOrig", lstIqpInfo.getCoverageFee());//原保费
		paramsInfo.put("feeCurr", amountCurr);//批改后保费
		
		//借呗没有退费，暂时写死
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("accountName", "预付借呗联合贷保险费");
		map.put("accountNo", "3401010101800010051");
		map.put("payeeBankCityCode", "6530");
		map.put("payeeBankCity", "重庆市_重庆市");
		map.put("payeeBankCode", "50014");
		map.put("payeeBankName", "重庆农村商业银行股份有限公司");
		map.put("bankCode", "314667300017");
		map.put("bankBranchName", "重庆农村商业银行股份有限公司开县支行");
		paramsInfo.put("bankInfo", map);
		
		params.put("modifyRateAmountInfo", paramsInfo);
		
		JsonProtocol jsonProtocol = commonService.policyModify(JSON.parseObject(JSON.toJSONString(params)));
		logger.info("重庆农商借呗，保单编号"+lstIqpInfo.getListSerno()+"调用批改保费接口返回参数为："+jsonProtocol.toString());
		
		if(jsonProtocol.getCode() != 0) {
			result = false;
			logger.info("重庆农商借呗--调用批改保费接口失败，失败原因为："+jsonProtocol.getMessage());
			// 批改失败需发送邮件至陈亮、林伟涛；若在工作日批改失败需人工处理，节假日批改失败则无需处理
			pushEmail("cqnsjbInsuranceCorrect", lstIqpInfo.getListSerno(), new Exception("重庆农商借呗"+lstIqpInfo.getListSerno()+"保单批改失败！,失败原因为："+jsonProtocol.getMessage()));
		}
		
		return result;
	}
	
	/**
	 * 构造批改记录数据
	 * @Description
	 * @date 2019年10月17日  
	 * @param lstIqpInfo
	 * @param amountCurr
	 * @param flag
	 * @param currentDate 
	 * @return
	 */
	protected CqnsjbBfCorrectInfo  buildParams(LstIqpInfo lstIqpInfo,BigDecimal amountCurr, String flag, String currentDate){
		CqnsjbBfCorrectInfo correctInfo = new CqnsjbBfCorrectInfo();
		correctInfo.setPkId(UUID32.getUUID());
		correctInfo.setSerno(lstIqpInfo.getSerno());
		correctInfo.setListSerno(lstIqpInfo.getListSerno());
		correctInfo.setAmountOrig(lstIqpInfo.getCoverageFee());
		correctInfo.setAmountCurr(amountCurr);
		correctInfo.setStatus(flag);
		correctInfo.setCreateDate(DateUtils.getDate());//DateUtils.getDate()
		correctInfo.setUpdateDate(DateUtils.getDate());//
		correctInfo.setCorrectDate(currentDate);//DateUtils.getDate1()
		return correctInfo;
	}
	
	/**
	 * 切日
	 * @param copName
	 */
	protected void changeDate(String copName,String currentDay){
		CopFiledate cf = new CopFiledate();
		cf.setCopname(copName);
		cf.setFiledate(DateUtils.getAddDate1(currentDay,1));
		copFiledateMapper.updateByPrimaryKeySelective(cf);
	}
	
	/**
	 * 发送异常邮件
	 */
	@Async
	protected void pushEmail(String title, String remark, Exception e) {
		StringBuffer content = new StringBuffer();
        content.append("============>接口:")
        	   .append("\n")
        	   .append(title)
        	   .append("\n")
        	   .append("============>业务数据:")
               .append("\n")
               .append(remark)
               .append("\n")
               .append("============>异常信息:")
               .append("\n")
               .append(ExceptionUtils.getStackTrace(e));
        emailPushService.pushMessage("重庆农商借呗", 
											content.toString(), 
											systemConfig.getValue("Error_Notice_Emails") , 
											null, 
											null);
	}
}
