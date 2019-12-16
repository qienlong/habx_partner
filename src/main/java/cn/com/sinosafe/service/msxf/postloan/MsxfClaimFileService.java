package cn.com.sinosafe.service.msxf.postloan;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.service.msxf.MsxfService;

/**
 * 
 * 马上消费-索赔申请文件处理 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月17日<br>
 */
@Service("MSXFSinosafeClaimFile")
public class MsxfClaimFileService implements MsxfService{

	// bat_claim_apply
	
	@Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
//		JSONObject params = JSON.parseObject(param);
//		Object object = params.get("contents");
		return null;
	}


}
