package cn.com.sinosafe.service.padb.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.constant.CommonConstant;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.SpringUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.entity.PAHAReq;
import cn.com.sinosafe.extend.padb.PaCommonUtil;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.service.padb.PaPhService;
import cn.com.sinosafe.service.padb.PaphDispatcherService;


/**
 * 平安普惠控制器总线service
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年6月3日 下午8:04:32
 * @Version	: 1.0
 */
@Service
public class PaphDispatcherServiceImpl implements PaphDispatcherService {
	
	private static final Logger log = LoggerFactory.getLogger(PaphDispatcherServiceImpl.class);

	@Override
	public JSONObject requestDispatcher(PAHAReq pahaReq, String id) {
		JSONObject result = null;
		try {
			// 获取明文参数
			String paParam = pahaReq.getParam();
			if (StringUtils.isEmpty(paParam)) {
				throw new ParamException("para参数不存在");
			}
			paParam = PaEncryptUtil.decryptByRSA(paParam);
			log.info("param={}",paParam);
			// 反射获取对应的servcice
			PaPhService paPhService = (PaPhService) SpringUtils.getBean(id);
			
			// 将json字符串转换map
			Map<String, Object> paramMap  = JSONUtils.getSingleInstance().readMapValue(paParam);
			
			// 调用逻辑处理并返回结果
			result = JSON.parseObject(paPhService.service(paramMap));
			//result = PaCommonUtil.getReturnJsonOnEncrypt(paPhService.service(paramMap));
		} catch (ParamException e) {
			e.printStackTrace();
			result = PaCommonUtil.getReturnByType(CommonConstant.DELETION, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			result = PaCommonUtil.getReturnByType(CommonConstant.FAIL, "服务器内部错误");
		}
		
		return result;
	}

	/**
	 * 从平安普惠请求者获取参数并解密
	 * @author	: hirson
	 * @date	: 2019年6月3日 下午8:24:15
	 * @param request
	 * @return
	 * @throws NoSuchProviderException
	 * @throws ParamException	:
	 */
//	private String getParam(HttpServletRequest request) throws NoSuchProviderException, ParamException {
//		String param = request.getParameter("param");
//		if (StringUtils.isEmpty(param)) {
//			throw new ParamException("para参数不存在");
//		}
//		return PaEncryptUtil.decryptByRSA(param);
//	}
	
	
	/**
	 * 根据平安普惠请求编号获取业务处理类
	 * @author	: hirson
	 * @date	: 2019年6月3日 下午8:27:35
	 * @param id	请求业务编号
	 * @return
	 * @throws Exception	:
	 */
//	private PaPhService getService(String id) throws Exception{
////		String method = id + "ServiceImpl";
//		PaPhService paPhService = (PaPhService) SpringUtils.getBean(id);
//// 		PaPhService paPhService = (PaPhService)Class.forName("cn.com.sinosafe.service.padb.impl." + method).newInstance();
//		return paPhService;
//	}
}
