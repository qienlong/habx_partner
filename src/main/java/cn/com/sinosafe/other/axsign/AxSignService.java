package cn.com.sinosafe.other.axsign;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;

/**
 * 安心签签业务
 * TODO 需建议一张表记录签署相关信息，便于控制签署逻辑
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年6月9日 下午8:57:33
 * @Version	: 1.0
 */
@Service
public class AxSignService {
	private final static Logger logger = LoggerFactory.getLogger(AxSignService.class);
	
	// TODO 用户在安心签平台开户，资源地址使用常量拼接
	private static String REGISTER_URL = "/other/electsign/register";
	// TODO 发送授权验证码，资源地址使用常量拼接
	private static String SENDSMS_URL = "/other/electsign/sendAuthorizedSms";
	// TODO 确认授权验证码，资源地址使用常量拼接
	private static String CONFIRMSMS_URL = "/other/electsign/confirmAuthorizedSms";
	// TODO 批量签署电子合同，资源地址使用常量拼接
	private static String BATCHSIGN_URL = "/other/electsign/batchCreateContractVOAndSign";
	// TODO 签署电子合同，资源地址使用常量拼接
	private static String SIGN_URL = "/other/electsign/createContractVOAndSign";
	// TODO 合同下载上传，资源地址使用常量拼接
	private static String DOWNUP_URL = "/other/electsign/downUpContractList";
	
	/**
	 * 用户在安心签平台开户
	 * @author	: hirson
	 * @date	: 2019年6月9日 下午9:01:36
	 * @param name		用户姓名
	 * @param identNo	身份证号码
	 * @param mobile	手机号码
	 * @return	:		返回用户在安心签平台的ID，建议保存到数据库，便于后续使用 REGISTER_ID保存到数据库
	 */
	public String registerOnAxSign(String name, String identNo, String mobile) {
		String url = SystemConfig.cacheMap.get("PAPH_AXSIGN_PREFIX")+SystemConfig.cacheMap.get("REGISTER_URL");
		Assert.notNull(name, "name is empty on register on anxin sign.......");
		Assert.notNull(identNo, "identNo is empty on register on anxin sign.......");
		Assert.notNull(mobile, "mobile is empty on register on anxin sign.......");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", name);
		paramMap.put("identNo", identNo);
		paramMap.put("mobile", mobile);
		
		String rsp = HttpClientUtil.sendPost(url, paramMap);
		logger.info("【用户安心签注册】用户{}在安心签注册开户的响应参数为{}", identNo, rsp);
		JSONObject rspJson = JSONObject.parseObject(rsp);
		int rspCode = (int) JSONPath.eval(rspJson, "$.code");
		String userId = null;
		if (rspCode == 1) {
			userId = (String) JSONPath.eval(rspJson, "$.data.person.userId");
		}
		return userId;
	}
	
	/**
	 * 发送授权验证码
	 * @author	: hirson
	 * @date	: 2019年6月9日 下午10:04:32
	 * @param signAccount	用户安心签ID
	 * @param projectCode	签署项目号，建议传入申请流水号
	 * @return	:			返回是否发送成功
	 */
	public boolean sendAuthorizedSms(String signAccount, String projectCode, String prdId) {
		String url = SystemConfig.cacheMap.get("PAPH_AXSIGN_PREFIX")+SystemConfig.cacheMap.get("SENDSMS_URL");
		Assert.notNull(signAccount, "signAccount is empty on sendAuthorizedSms on anxinSign.......");
		Assert.notNull(projectCode, "projectCode is empty on sendAuthorizedSms on anxinSign.......");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("signAccount", signAccount);
		paramMap.put("projectCode", projectCode);
		paramMap.put("productCode", prdId);
		
		String rsp = HttpClientUtil.sendPost(url, paramMap);
		logger.info("【用户发送安心签授权验证码】流水号{}在安心签发送授权验证码的响应参数为{}", projectCode, rsp);
		JSONObject rspJson = JSONObject.parseObject(rsp);
		int rspCode = (int) JSONPath.eval(rspJson, "$.code");
		return rspCode == 1 ? true : false;
	}
	
	/**
	 * 确认授权验证码
	 * @author	: hirson
	 * @date	: 2019年6月9日 下午10:04:32
	 * @param signAccount	用户安心签ID
	 * @param projectCode	签署项目号，建议传入申请流水号
	 * @param code			验证码
	 * @return	:			确认是否通过
	 */
	public boolean confirmAuthorizedSms(String signAccount, String projectCode, String code) {
		String url = SystemConfig.cacheMap.get("PAPH_AXSIGN_PREFIX")+SystemConfig.cacheMap.get("CONFIRMSMS_URL");
		Assert.notNull(signAccount, "signAccount is empty on confirmAuthorizedSms on anxinSign.......");
		Assert.notNull(projectCode, "projectCode is empty on confirmAuthorizedSms on anxinSign.......");
		Assert.notNull(code, "code is empty on confirmAuthorizedSms on anxinSign.......");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("signAccount", signAccount);
		paramMap.put("projectCode", projectCode);
		paramMap.put("code", code);
		
		String rsp = HttpClientUtil.sendPost(url, paramMap);
		logger.info("【用户确认安心签授权验证码】流水号{}在安心签确认授权验证码的响应参数为{}", projectCode, rsp);
		JSONObject rspJson = JSONObject.parseObject(rsp);
		int rspCode = (int) JSONPath.eval(rspJson, "$.code");
		return rspCode == 1 ? true : false;
	}
	
	/**
	 * 批量签署电子合同
	 * @author	: hirson
	 * @date	: 2019年6月9日 下午10:04:32
	 * @param contractVolist	合同列表字符串
	 * @param projectCode		签署项目号，建议传入申请流水号
	 * @param batchNo			批次号（建议传业务申请号）
	 * @return	:				确认是否通过
	 */
	public String batchCreateContractVOAndSign(String contractVolist, String projectCode, String batchNo) {
		String url = SystemConfig.cacheMap.get("PAPH_AXSIGN_PREFIX")+SystemConfig.cacheMap.get("BATCHSIGN_URL");
		Assert.notNull(contractVolist, "contractVolist is empty on batchCreateContractVOAndSign on anxinSign.......");
		Assert.notNull(projectCode, "projectCode is empty on batchCreateContractVOAndSign on anxinSign.......");
		Assert.notNull(batchNo, "batchNo is empty on batchCreateContractVOAndSign on anxinSign.......");
		
		JSONObject paramMap = new JSONObject();
		paramMap.put("contractVolist", contractVolist);
		paramMap.put("projectCode", projectCode);
		paramMap.put("batchNo", batchNo);
		
		String rsp = HttpClientUtil.sendPost(url, paramMap);
		logger.info("【用户在安心签批量签署电子合同】流水号{}在安心签批量签署的响应参数为{}", projectCode, rsp);
		return rsp;
	}
	
	/**
	 * 签署电子合同
	 * @author	: hirson
	 * @date	: 2019年6月9日 下午10:04:32
	 * @param contractVolist	合同列表字符串
	 * @param projectCode		签署项目号，建议传入申请流水号
	 * @return	:				确认是否通过
	 */
	public String createContractVOAndSign(String contractVo, String projectCode) {
		String url = SystemConfig.cacheMap.get("PAPH_AXSIGN_PREFIX")+SystemConfig.cacheMap.get("SIGN_URL");
		Assert.notNull(contractVo, "contractVolist is empty on batchCreateContractVOAndSign on anxinSign.......");
		Assert.notNull(projectCode, "projectCode is empty on batchCreateContractVOAndSign on anxinSign.......");
		
		JSONObject paramMap = new JSONObject();
		paramMap.put("contractVoStr", contractVo);
		paramMap.put("projectCode", projectCode);
		
		String rsp = HttpClientUtil.sendPost(url, paramMap);
		logger.info("【用户在安心签批量签署电子合同】流水号{}在安心签批量签署的响应参数为{}", projectCode, rsp);
		return rsp;
	}
	
	/**
	 * 将安心签签好的合同下载上传到华安影像系统
	 * @author	: hirson
	 * @date	: 2019年6月9日 下午11:21:48
	 * @param contractInfoList	合同上传信息对象列表字符串，信息对象为：cn.com.sinosafe.domain.dto.ContractUpload
	 * @return	:				返回对应类型合同的影像URL
	 */
	public String downUpContractList(String contractInfoList) {
		String url = SystemConfig.cacheMap.get("PAPH_AXSIGN_PREFIX")+SystemConfig.cacheMap.get("DOWNUP_URL");
		Assert.notNull(contractInfoList, "contractInfoList is empty on downUpContractList on anxinSign.......");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("contractInfoList", contractInfoList);
		
		String rsp = HttpClientUtil.sendPost(url, paramMap);
		logger.info("【下载安心签合同上传公司影像系统】合同信息{}在上传影像系统的的响应参数为{}", contractInfoList, rsp);
		return rsp;
	}
	
	/**
	 * 构建电子合同对接
	 * @author	: hirson
	 * @date	: 2019年6月9日 下午10:32:42
	 * @param templateId	模板ID
	 * @param userId		用户在安心签的ID
	 * @param location		用户签署时的IP地址
	 * @param signLocation	签名域标识
	 * @param projectCode	项目号（与发送授权短信时的项目号一致，建议申请流水号）
	 * @param textMap		文本域键值对
	 * @return	:			对子合同对象
	 */
	public JSONObject createContractVO(String templateId, String userId, String location, String signLocation, String projectCode , Map<String, String> textMap) {
		Map<String, Object> signInfos = new HashMap<String, Object>();
		signInfos.put("userId", userId);
		signInfos.put("authorizationTime", DateUtils.getDateStr());
		signInfos.put("location", location);
		signInfos.put("signLocation", signLocation);
		signInfos.put("projectCode", projectCode);
		signInfos.put("isProxySign", 1);
		
		JSONObject contranMap = new JSONObject();
		contranMap.put("investmentInfo", textMap);
		contranMap.put("templateId", templateId);
		contranMap.put("signInfos", new Object[]{signInfos});
		
		return contranMap;
	}
	
	
	
}
