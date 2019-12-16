package cn.com.sinosafe.controller.msxf;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.SpringUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.service.msxf.MsxfAsynDealService;
import cn.com.sinosafe.service.msxf.MsxfService;

/**
 * 
 * 马上消费接口 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年8月30日<br>
 */
@Log
@RestController
@RequestMapping("/cop/msxf")
public class MsxfController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MsxfAsynDealService msxfAsynDealService;

	/**
	 *
	 * @param params
	 * @param id
	 * @return
	 */
	@PostMapping(value="/dispatcher/{id}")
	public String requestDispatcher(@RequestBody(required = false) String params, @PathVariable("id") String id) {
		MsxfResponse response = null;
		try {
			if (StringUtils.isEmpty(params)) {
				response = MsxfResponse.CODE_9011;
			}else {
				MsxfService msxfService = SpringUtils.getBean(id,MsxfService.class);
				// 调用业务方法
				response = msxfService.busiDeal(params);
			}
		} catch (Exception e) {
			logger.error(id,e);
			if(e instanceof ParamException) {
				response = new MsxfResponse(MsxfResponse.CODE_9016.getRetCode(),MsxfResponse.CODE_9016.getRetMsg() + "," + e.getMessage());;
			}else {
				// 发送异常邮件
				msxfAsynDealService.pushEmail(id, params, e);
				response = MsxfResponse.CODE_9500;
			}
		}
		return JSON.toJSONString(response);
	}
	
	/**
	 * 异常处理
	 * @param params
	 * @param serno
	 * @param id
	 * @return
	 */
	@PostMapping(value="/exception/{id}/{serno}")
	public MsxfResponse exception(@RequestBody String params,@PathVariable("serno") String serno, @PathVariable("id") String id) {
		if(StringUtils.equals(id, "approve")) {
			msxfAsynDealService.approve(params, serno);
		}else if(StringUtils.equals(id, "lstInfo")) {
			msxfAsynDealService.lstInfo(params, serno);
		}
		return MsxfResponse.CODE_0000;
	}

}
