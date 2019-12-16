/**   
* @Title:：CancelNoticeServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午8:10:47 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.dao.AccLoanMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.service.padb.PaCreditCancelService;

/** 
 * @ClassName:：PaCreditCancelServiceImpl 
 * @Description： 授信制回退服务			
 * @author ：longxiaoqiang
 * @date ：2019年6月8日 下午8:10:47  
 */
@Service
public class PaCreditCancelServiceImpl implements PaCreditCancelService{
	
	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	
	@Autowired
	private AsyncDealService asyncDealService;
	
	@Autowired
	private AccLoanMapper accLoanMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String creditCancel(Map<String, Object> paramMap) throws Exception{
		logger.info("*****************************授信制回退接口 start*****************************");
		logger.info("param={}",paramMap);
		String resultCode="";
		String resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
		Map<String, String> resultMap=new HashMap<String, String>();
		//字段校验
		if(LstIqpApplyConstant.checkFieldDefect(paramMap,new String[]{"credit","insuCompany","source","dateMsg"})){
			resultCode=PaResultCode.PA_FIELD_DELETION.code();
			resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
		}else{
			if (LstIqpApplyConstant.checkListFieldDefect(paramMap,new String[] {"applNo","status"})) {
				resultCode=PaResultCode.PA_FIELD_DELETION.code();
				resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
			} else {
				try {
					boolean flag = false;
					List<Map<String, Object>> extendList=(List<Map<String, Object>>)paramMap.get("credit");
					//判断授信制条件
					if (null!=extendList) {
						for(int i=0 ; i < extendList.size();i++){
							Map<String, Object> jsonObj = extendList.get(i);
							int count = iqpMeLoanAppMapper.getCountById(String.valueOf(jsonObj.get("applNo")));
							int num = accLoanMapper.checkIsLoan(String.valueOf(jsonObj.get("applNo")));
							if (count<1||num>0) {
								logger.info("申请号{}不满足条件：【申请号存在且未放款】",String.valueOf(jsonObj.get("applNo")));
								flag = true;
								break;
							}
						}
					} else {
						resultCode=PaResultCode.PA_FIELD_DELETION.code();
						resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
					}
					//校验通过后异步注销处理
					if (flag) {
						resultCode=PaResultCode.PA_FAIL.code();
						resultMsg=PaResultGenerator.DEFAULT_FAIL_MESSAGE;
					} else {
						asyncDealService.cancelIqpInfo(extendList,paramMap);
						resultCode=PaResultCode.PA_SUCCESS.code();
						resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
					}
					
				} catch (Exception e) {
					logger.error("error:{}",e.getMessage());
					throw new BusinessException(e.getMessage());
				}
			}
		}
		resultMap.put("resultCode",String.valueOf(resultCode));
		resultMap.put("resultMsg", resultMsg);
		logger.info("*****************************授信制回退接口 end*****************************");
		return JSON.toJSONString(resultMap);
	}
}
