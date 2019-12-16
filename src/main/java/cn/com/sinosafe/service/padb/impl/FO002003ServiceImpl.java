package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.config.properties.FileProperties;
import cn.com.sinosafe.common.util.RedisUtils;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.service.padb.PaPhService;

/**
 * 电子保单查询接口
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年7月19日 下午5:25:15
 * @Version	: 1.0
 */
@Service("FO002003")
public class FO002003ServiceImpl implements PaPhService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private FileProperties fileProperties;
	
	@Override
	public String service(Map<String, Object> paramMap) {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("resultCode", "9999");
		resultMap.put("resultMsg", "暂未查询到保单！");
		String applNo = null;
		try {
//			applNo = paramMap.get("applNo").toString();
//			String policyUrl = getPolicyUrl(applNo);
//			// 最后在判断有没有
//			if (StringUtils.isNotEmpty(policyUrl)) {
//				resultMap.put("resultCode", "0000");
//				resultMap.put("resultMsg", "查询成功！");
//				resultMap.put("policyURL", transformPolicyConvasPlug(applNo));
//			}
			if(LstIqpApplyConstant.checkFieldDefect(paramMap,new String[]{"applNo"})){
				resultMap.put("resultCode", PaResultCode.PA_FIELD_DELETION.code());
				resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE);
			} else {
				applNo = paramMap.get("applNo").toString();
				resultMap.put("resultCode", "0000");
				resultMap.put("resultMsg", "查询成功！");
				resultMap.put("policyURL", transformPolicyConvasPlug(applNo));
			}
			
		} catch (Exception e) {
			logger.error("【平安查询电子保单异常】流水号为{}，异常信息为{}", applNo, e.getMessage());
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
		}
		
		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * 拼接canvas插件地址
	 * @author	: hirson
	 * @date	: 2019年7月25日 下午6:51:12
	 * @param policyUrl
	 * @return	:
	 */
	public String transformPolicyConvasPlug(String applNo) {
//		String test = "http://proxytest.sinosafe.com.cn/xbapp//";
//		String prod = "http://ecmp.sinosafe.com.cn:8080/";
//		// 提前影像地址前缀为https的
//		if (policyUrl.startsWith(test)) {
//			policyUrl.replace(test, fileProperties.getImgDomainHttps());
//			
//		}
//		if (policyUrl.startsWith(prod)) {
//			policyUrl.replace(prod, fileProperties.getImgDomainHttps());
//			
//		}
		
		// 然后拼接到canvas插件地址后面
		return fileProperties.getCanvasPlugPrefix() + applNo;
	}
	
	
	/**
	 * 获取电子保单影像系统原始地址
	 * @author	: hirson
	 * @date	: 2019年7月25日 下午7:18:11
	 * @param applNo
	 * @return	:
	 */
	public String getPolicyUrl(String applNo) {
		String policyUrl = null;
		Object urlCache = redisUtils.getValue(applNo);
		// 缓存有取缓存的
		if (urlCache != null) {
			policyUrl = (String) urlCache;
		}
		
		// 缓存没有取库里面的，再加入缓存
		if (urlCache == null) {
			Map<String,Object> eleStatus = lstIqpInfoMapper.selectEleStatus(applNo);
			if ("2".equals((String)eleStatus.get("SEAL_STATUS"))) {
				policyUrl = (String)eleStatus.get("SIGNED_PDF_URL");
				redisUtils.setValue(applNo, policyUrl, 60 * 60 * 24 * 7);
			}
		}
		
		return policyUrl;
	}
	
}
