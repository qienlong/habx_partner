package cn.com.sinosafe.service.gbcn.impl;

import java.util.List;

import cn.com.sinosafe.domain.entity.PolicyModifyRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.domain.gbcn.request.QuerySurrendRequest;
import cn.com.sinosafe.domain.gbcn.request.QuerySurrendRequest.QuerySurrendRequestBody;
import cn.com.sinosafe.domain.gbcn.request.RequestHead;
import cn.com.sinosafe.domain.gbcn.request.SurrendRequest.SurrendRequestBody;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

import com.alibaba.fastjson.JSONObject;

import org.springframework.util.ObjectUtils;

@Service(value = GBCNConstant.SEND_SURREND)
public class SendSurrendService extends CommonService implements GbcnService<JsonProtocol,JSONObject>{

	private static final Logger logger = LoggerFactory.getLogger(SendSurrendService.class);

	@Override
	public JsonProtocol process(JSONObject param) {
		JsonProtocol jsonProtocol = new JsonProtocol();
		try {
			String policyNo = param.getString("policyNo");// 保险单号
			logger.info("发送退保回执开始；policyNo={}",policyNo);
			if(StringUtils.isEmpty(policyNo)){
				jsonProtocol.setMessage("保单号不能为空！");
				jsonProtocol.setCode(1);
				return jsonProtocol;
			}
			QuerySurrendRequestBody requestBody = new QuerySurrendRequestBody();
			requestBody.setPolicyNo(policyNo);
			//查询退保单中是否有该笔单，如果有，则判断他的状态是否已经发送
			List<SurrendRequestBody> list = surrendMapper.selectByPolicyNo(policyNo);
			if(CollectionUtils.isEmpty(list)){
				jsonProtocol.setMessage("没有找到该保单退保记录！");
				jsonProtocol.setCode(1);
				return jsonProtocol;
			}
			//验证是否已审批完成
			PolicyModifyRecord policyModifyRecord = pmRecordMapper.querySurrend(policyNo);
			if (ObjectUtils.isEmpty(policyModifyRecord)) {
				jsonProtocol.setMessage("该保单未审批完成！");
				jsonProtocol.setCode(1);
				return jsonProtocol;
			}
			//更新状态为
			SurrendRequestBody record = new SurrendRequestBody();
			record.setPolicyno(policyNo);
			if ("997".equals(policyModifyRecord.getApproveStatus())) {
				record.setSurrendStatus("1");
				// 保险公司代码
				requestBody.setInsuranceCode("00013");
				requestBody.setResultFlag(true);
				requestBody.setResultMessage("已退款至原账户");
			}else if ("998".equals(policyModifyRecord.getApproveStatus())){
				record.setSurrendStatus("2");
				// 保险公司代码
				requestBody.setInsuranceCode("00013");
				requestBody.setResultFlag(false);
				String  reason = surrendMapper.queryAdviceByPolicyNo(policyNo);
				requestBody.setResultMessage(StringUtils.isEmpty(reason)==true ? "否决" : reason);
			}

			// 退保回执信息头
			RequestHead requestHead = new RequestHead(StringUtils.uuid(),tosign(requestBody));
			QuerySurrendRequest request = new QuerySurrendRequest(requestHead,requestBody);
			String surrendUrl = XmlUtil.convertToXml(request, false);
			logger.info("发送给工保网-->方法-->退保回执:"+surrendUrl);
			String surrendResponse = HttpClientUtil.doPostXML(SystemConfig.cacheMap.get("GBCN_QUERY_SURREND_URL"), surrendUrl);
			logger.info("工保返回-->方法-->退保回执:" + surrendResponse);
			if(!(surrendResponse.contains("成功")&&surrendResponse.contains("true"))){
				jsonProtocol.setMessage("发送退保回执失败！");
				jsonProtocol.setCode(1);
				return jsonProtocol;
			}
			surrendMapper.updateSurrendStatus(record);
			return jsonProtocol.setup(ResultCode.SUCCESS);
		}catch (Exception e){
			e.printStackTrace();
			jsonProtocol.setMessage("发送退保回执失败！");
			jsonProtocol.setCode(1);
			return jsonProtocol;
		}
	}
}
