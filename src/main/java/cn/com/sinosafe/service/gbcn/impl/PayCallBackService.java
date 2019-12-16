package cn.com.sinosafe.service.gbcn.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

import com.alibaba.fastjson.JSONObject;

@Service(value = GBCNConstant.PAY_CALLBACK)
public class PayCallBackService extends CommonService implements GbcnService<JsonProtocol,JSONObject>{

    private static final Logger logger = LoggerFactory.getLogger(PayCallBackService.class);
    
	public JsonProtocol process(JSONObject param) throws Exception {
    	JsonProtocol jsonProtocol = new JsonProtocol();
    	String paySessionId = DateUtils.getMillisecond();
    	MDC.put("sessionID", "gbcn"+paySessionId);
		logger.info("【请求自IP：{}】 ====>>>>【{}】请求参数：{}", 	ThreadLocalUtil.get("ip"), ThreadLocalUtil.get("url"), param);
    	//通过送过来的保单号找到保单信息
    	LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(param.getString("policyNo"));
        if(ObjectUtils.isEmpty(lstIqpInfo)){
        	logger.info("工保支付回调没有找到保单信息！");
            return jsonProtocol.setup(ResultCode.SERVER_ERROR);
        }
        //将支付信息缓存
        IqpMeLoanApp oldIqpmeLoadApp = iqpMeLoanAppMapper.selectByPrimaryKey(param.getString("iqpLoanSerno"));
        oldIqpmeLoadApp.setApproveStatus("997");
        iqpMeLoanAppMapper.updateByPrimaryKey(oldIqpmeLoadApp);
        Map<String, Object> map = new HashMap<>();
        map.put("payTime", DateUtils.getDateTime());
        map.put("payType", "3");
        map.put("proposalNo", lstIqpInfo.getCoverSerno());
        map.put("policyNo", lstIqpInfo.getListSerno());
        map.put("sessionID", paySessionId);
        String payTime = param.getString("payTime");
        Date payDate =  DateUtils.strToDate("yyyy-MM-dd HH:mm:ss",payTime);
        Date startDate = DateUtils.addDays(payDate, 30);
        Date endDate = DateUtils.addDays(startDate, 90);
        redisUtils.setValue(GBCNConstant.INSURANCE_CALLBACK + param.getString("policyNo"), map, 60 * 60 * 24 * 1);
        String tender = "自"+DateUtils.format(startDate, "yyyy年MM月dd日")+"零时起，至"
                +DateUtils.format(endDate, "yyyy年MM月dd日")+"23:59:59止";
        sendSeal(lstIqpInfo,GBCNConstant.getLocalIpPort()+GBCNConstant.INSURANCE_CALLBACK,tender);
        return jsonProtocol.setup(ResultCode.SUCCESS);
	}
	
	

	
}
