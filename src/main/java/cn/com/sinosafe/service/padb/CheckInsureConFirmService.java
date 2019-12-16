package cn.com.sinosafe.service.padb;

import java.math.BigDecimal;
import java.util.Map;

/** 
 * @ClassName:：CheckInsureNoticeServiceImpl 
 * @Description： 平安核保确认
 * @author ：pengll
 * @date ：2019年6月3日 下午2:41:16  
 */
public interface CheckInsureConFirmService {

	/**
    *
    * 方法说明：根据校验规则进行核保确认
    * @author pengll
    * @param Amount 金额
    * @param certCode 身份证号
    * @param approveResult 平安审批结果
    * @return String类型
    * @time 2019-06-04
    */
	public String checkIqpInfo(BigDecimal amount,String certCode,String approveResult);
	
	
	
	/**
    *
    * 方法说明：发送核保确认信息
    * @author pengll
    * @param paramMap对象
    * @param 
    * @return String
    * @time 2019-06-04
    */
	public String sendInsureConfirmInfo(Map<String,Object> paramMap);

	/**
	 * 方法说明: 发送平安付信息
	 * @param hashmap
	 * @return
	 */
	String sendPaCheckCard4Param(Map<String, String> requestmap);
}
