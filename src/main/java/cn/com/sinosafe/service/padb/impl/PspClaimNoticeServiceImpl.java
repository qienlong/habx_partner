/**
 * 
 */
package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.config.constant.PspClaimConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.AccLoanMapper;
import cn.com.sinosafe.dao.PspClaimPaphRecodeMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.entity.AccLoan;
import cn.com.sinosafe.domain.entity.PspClaimPaphRecode;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import cn.com.sinosafe.service.padb.PspClaimNoticeService;

/**  
* <p>Title: PspClaimNoticeServiceImpl</p>  
* <p>Description: 理赔通知接口</p>  
* @author longxiaoqiang  
* @date 2019年8月27日  
*/
@Service
public class PspClaimNoticeServiceImpl implements PspClaimNoticeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PspClaimPaphRecodeMapper pspClaimPaphRecodeMapper;
	@Autowired
	private PaPhCommonService paPhCommonService;
	@Autowired
	private AccLoanMapper accLoanMapper;
	@Override
	public String pspClaimNotice(Map<String, Object> paramMap) throws Exception {
		logger.info("*****************************理赔通知接口 start*****************************");
		logger.info("param={}",JSONUtils.getSingleInstance().toJSon(paramMap));
		String resultCode=PaResultCode.PA_SUCCESS.code();
		String resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
		Map<String, String> resultMap=new HashMap<String, String>();
		//字段校验
		if(LstIqpApplyConstant.checkFieldDefect(paramMap,new String[]{"claimBatchNo","claimCount","claimsApplyList","insuCompany"})){
			resultCode=PaResultCode.PA_FIELD_DELETION.code();
			resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
		}else{
			if (LstIqpApplyConstant.checkListFieldDefectByStr(String.valueOf("claimsApplyList"),paramMap,new String[] {"lnAcct","applNo","claimAmt","claimDate"})) {
				resultCode=PaResultCode.PA_FIELD_DELETION.code();
				resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
			} else {
				try {
					//记录理赔数据
					List<PspClaimPaphRecode> importData=PspClaimConstant.convertPspClaimPaphRecode(paramMap);
					boolean flag = checkAccLoan(importData);
					if (flag) {
						resultCode=PaResultCode.PA_FAIL.code();
						resultMsg="借据信息不存在";
					} else {
						insetPspClaimPaphRecode(importData);
						logger.info("理赔通知批次号：{}数据入库成功",String.valueOf(paramMap.get("claimBatchNo")));
					}
					
				} catch (Exception e) {
					logger.error("error:{}",e.getMessage());
					throw new BusinessException(e.getMessage());
				}
			}
		}
		resultMap.put("resultCode",String.valueOf(resultCode));
		resultMap.put("resultMsg", resultMsg);
		logger.info("*****************************理赔通知接口 end*****************************");
		return JSON.toJSONString(resultMap);
	}
	
	/**  
	 * <p>Title: checkAccLoan</p>  
	 * <p>Description: </p>  
	 * @param importData
	 * @return  
	 */
	private boolean checkAccLoan(List<PspClaimPaphRecode> importData) {
		boolean flag = false ;
		for (PspClaimPaphRecode pspClaimPaphRecode : importData) {
			
			AccLoan accLoan = accLoanMapper.selectByPrimaryKey(pspClaimPaphRecode.getLnAcct());
			if (StringUtils.isNull(accLoan)) {
				flag = true;
				logger.info("{}借据号不存在",pspClaimPaphRecode.getLnAcct());
				break;
			}
		}
		return flag;
	}

	/**  
	 * <p>Title: insetPspClaimPaphRecode</p>  
	 * <p>Description: 理赔通知入库</p>  
	 * @param importData  
	 */
	private void insetPspClaimPaphRecode(List<PspClaimPaphRecode> importData) {
		for (PspClaimPaphRecode psp:importData) {
			pspClaimPaphRecodeMapper.insertSelective(psp);
			//记录日志状态
			paPhCommonService.statusUpdateService(psp.getApplNo(), SentStatusCode.PA_19.code(), "理赔交易报盘");
		}
		
	}

}
