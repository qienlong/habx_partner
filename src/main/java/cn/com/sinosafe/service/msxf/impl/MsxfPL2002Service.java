package cn.com.sinosafe.service.msxf.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.config.constant.Status;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PartnerBusiImportDetailMapper;
import cn.com.sinosafe.dao.SentStatusMapper;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.service.msxf.MsxfBaseService;

/**
 * 
 * 马上消费--承保申请结果查询	<br>					
 * @Author : ganyingying <br>
 * @Date : 2019年9月2日<br>
 */
@Service(MsxfConstant.MSXF_PL2002)
public class MsxfPL2002Service extends MsxfBaseService{
	
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private SentStatusMapper sentStatusMapper;
	@Autowired
	private PartnerBusiImportDetailMapper busiImportDetailMapper;
	
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		
		// 解密
		String request = decrypt(param);
		logger.info("[{}]请求参数解密后：{}",MsxfConstant.MSXF_PL2002, request);
		
		JSONObject jsonObj = JSONObject.parseObject(request);
		//借据号
		String billNo = jsonObj.getString("loanNoExt");
		if (StringUtils.isEmpty(billNo)) {
            throw new ParamException("请求参数不能为空!");
        }
		
		// 查询明细
		PartnerBusiImportDetail detail = busiImportDetailMapper.selectByReqListSerno(billNo);
		if(StringUtils.isNull(detail)) {
			throw new ParamException("借据号不存在!");
		}
		
		//有 返回成功
		MsxfResponse msxfResponse = new MsxfResponse(MsxfResponse.CODE_0000.getRetCode(),MsxfResponse.CODE_0000.getRetMsg());
		
		// 查询保单表
		LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno1(detail.getSerno());
		if(StringUtils.isNull(lstIqpInfo)) {
			//没有 就是 处理中
			logger.info("[{}][{}]投保失败",MsxfConstant.MSXF_PL2002, billNo);
			msxfResponse.setStatus(Status.失败.getResponseStatus());
			msxfResponse.setMsg("投保失败");
		}else if(StringUtils.isEmpty(lstIqpInfo.getListSerno())) {
			//没有 就是 处理中
			logger.info("[{}][{}]出单处理中",MsxfConstant.MSXF_PL2002, billNo);
			msxfResponse.setStatus(Status.处理中.getResponseStatus());
			msxfResponse.setMsg("保单生成中");
		}else {
			//查询是否出电子保单 sent_status elec_policy
			SentStatus key = new SentStatus();
			key.setSentSerno(lstIqpInfo.getSerno());
			key.setSentType("elec_policy");
			key.setSentStatus("01");
			SentStatus sentStatus = sentStatusMapper.selectByPrimaryKey(key);
			
			if(StringUtils.isNotNull(sentStatus)) {
				logger.info("[{}][{}]出单成功",MsxfConstant.MSXF_PL2002, billNo);
				msxfResponse.setStatus(Status.成功.getResponseStatus());
				msxfResponse.setMsg("出单成功");
				msxfResponse.setPolicyNo(lstIqpInfo.getListSerno());
				String elecUrl = systemConfig.getValue("elecUrl");
				elecUrl = elecUrl.replace("${list_serno}", lstIqpInfo.getListSerno()).replace("${cert_code}", lstIqpInfo.getCertCode());
				msxfResponse.setPolicyURL(elecUrl);
			}else {
				//没有 就是 处理中
				logger.info("[{}][{}]出单处理中",MsxfConstant.MSXF_PL2002, billNo);
				msxfResponse.setStatus(Status.处理中.getResponseStatus());
				msxfResponse.setMsg("保单生成中");
			}
		}
		
		return  msxfResponse;
	}

}
