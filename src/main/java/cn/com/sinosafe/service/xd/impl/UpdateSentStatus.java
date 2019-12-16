package cn.com.sinosafe.service.xd.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.SentStatusMapper;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.xd.XdService;

import com.alibaba.fastjson.JSONObject;

@Service("updateSentStatus")
public class UpdateSentStatus implements XdService<JsonProtocol,JSONObject>{
	
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;

	@Autowired
	private SentStatusMapper sentStatusMapper;


		@Override
		public JsonProtocol process(JSONObject param) throws Exception {
			//修改状态为 “已签署”
			JsonProtocol  result = new JsonProtocol();
			try {
				//interface-app 中dubbo接口 signLstIqpInfo		
				String serno = param.getString("serno");
				if(StringUtils.isEmpty(serno)){
					throw new Exception();
				}
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("sentSerno", serno);
				String[] types = {"P95HSXD05_xd_sign","sl_sign","xj_sign"};
				map.put("types", types);
				map.put("sentStatus", "02");
				int i = sentStatusMapper.updateBySernoAndType(map);
				if(i<1){
					throw new Exception();
				}
				//更新接口
				IqpMeLoanApp record = new IqpMeLoanApp();
				record.setSerno(serno);
				record.setBusiStatus("026");
				record.setNewApproveStatus("997");
				iqpMeLoanAppMapper.updateByPrimaryKeySelective(record);
			} catch (Exception e) {
				result.setCode(1);
				result.setMessage("Fail");
				return result;
			}
			result.setMessage("Success");
			result.setCode(0);
			return result;
		}
		
		
		 private void insertSentStatus(String serno, String status, String sentType) {
		        SentStatus sentStatus = new SentStatus();
		        sentStatus.setSentSerno(serno);
		        sentStatus.setSentStatus(status);
		        sentStatus.setSentType(sentType);
		        sentStatus.setTmSmp(DateUtils.getDateTime());
		        sentStatusMapper.insertSelective(sentStatus);
		    }
}
