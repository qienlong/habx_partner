/**   
* @Title:：LstIqpInfoSyncServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月4日 上午10:02:44 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.constant.PadbConstant;
import cn.com.sinosafe.common.config.properties.IssueMsgProperties;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.CusBaseMapper;
import cn.com.sinosafe.dao.FeeRateMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.dto.PaLstIqpInfoSnc;
import cn.com.sinosafe.domain.entity.CusBase;
import cn.com.sinosafe.domain.entity.FeeRate;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.service.padb.PaLstIqpInfoSyncService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/** 
 * @ClassName:：LstIqpInfoSyncServiceImpl 
 * @Description： 保单信息同步接口	(调用平安接口)		
 * @author ：xiewei
 * @date ：2019年6月4日 上午10:02:44  
 */
@Service
public class PaLstIqpInfoSyncServiceImpl implements PaLstIqpInfoSyncService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CusBaseMapper cusBaseMapper;
	
	@Autowired IssueMsgProperties issueMsgPro;
	
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	
	@Autowired
	private FeeRateMapper feeRateMapper;
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	
	@Autowired
	private PaPhCommonService paPhCommonService;

	@Override
	public String infoSync(LstIqpInfo liInfo) {
		logger.info("*****************************保单信息同步通知 start*****************************");
		PaLstIqpInfoSnc paLstIqpInfoSnc=null;
		String msg = "";
		try {
			//获取保单信息
//			LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectBySernoAndStatus(liInfo);
			if(null==liInfo){throw new BusinessException("LstIqpInfo is null");}
			//获取客户信息
			CusBase cusBase=cusBaseMapper.selectByPrimaryKey(liInfo.getCusId());
			if(null==cusBase){throw new BusinessException("CusBase is null");}
			//获取客户信息
			IqpMeLoanApp iqpMeLoanApp=iqpMeLoanAppMapper.selectByPrimaryKey(liInfo.getIqpLoanSerno());
			if(null==iqpMeLoanApp){throw new BusinessException("iqpMeLoanApp is null");}
			//查询费率
			FeeRate feeRate=new FeeRate();
//			feeRate.setParentProductNo(liInfo.getPrdId());
			feeRate = feeRateMapper.queryFeeRateInfoByIqp(iqpMeLoanApp);
			//数据转换
			paLstIqpInfoSnc=convertPaLstInfo(liInfo,cusBase,feeRate);
			//请求平安http同步信息
			logger.info("************** 发起http保单信息同步接口请求  start **************");
			logger.info("请求报文:{}",paLstIqpInfoSnc.toString());

			String responsemessage = JSON.toJSONString(paLstIqpInfoSnc);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("param", PaEncryptUtil.encryptByRSA(responsemessage));
			msg=HttpClientUtil.sendPosts(SystemConfig.cacheMap.get("FCFPBX1005"),jsonObject.toString());
			
			Map<String, Object> resultCode = JSONUtils.getSingleInstance().readMapValue(msg);
			msg = (String)resultCode.get("resultCode");
			//String msg=HttpClientUtil.sendPost(PadbConstant.FCFPBX1005, PaEncryptUtil.encryptByRSA(JSON.toJSONString(paLstIqpInfoSnc)));
			logger.info("响应报文:{}",msg);
			logger.info("************** 发起http保单信息同步接口请求  end **************");
			//请求响应日志
			paPhCommonService.insertBizLog(paLstIqpInfoSnc.getApplNo(), "FCFPBX1005", JSON.toJSONString(paLstIqpInfoSnc), msg);
		} catch (Exception e) {
			logger.error("error:{}",e.getMessage());
			e.printStackTrace();
		}
		logger.info("*****************************保单信息同步通知 end*****************************");
		return msg;
	}
	
	private PaLstIqpInfoSnc convertPaLstInfo(LstIqpInfo lstIqpInfo,CusBase cusBase,FeeRate feeRate) throws Exception{
		PaLstIqpInfoSnc paInfo=null;
		try {
			paInfo=new PaLstIqpInfoSnc();
			paInfo.setApplNo(lstIqpInfo.getIqpLoanSerno());
			paInfo.setPolicyNo(lstIqpInfo.getListSerno());
			paInfo.setCustName(StringUtils.isEmpty(lstIqpInfo.getCusName())?null:lstIqpInfo.getCusName());
			paInfo.setMobile(lstIqpInfo.getMobile());
			paInfo.setId(cusBase.getCertCode());
			paInfo.setInsureOfName(lstIqpInfo.getReceiveCusName());
			paInfo.setInsuredAmt(lstIqpInfo.getCoverAmount());
			paInfo.setInsuredAmtMax(lstIqpInfo.getCoverAmount().multiply(new BigDecimal(0.99)).setScale(2, BigDecimal.ROUND_HALF_UP));
			paInfo.setInsuredTerm(lstIqpInfo.getTerm());
			paInfo.setPayTypeAmt(lstIqpInfo.getPayWay());
			paInfo.setPayDate(lstIqpInfo.getToubaoDate());
			try {
				//直接获取华安的码值费率
				paInfo.setInsureRateMonth(new BigDecimal(StringUtils.isEmpty(feeRate.getFeeRate())?"0.0":feeRate.getFeeRate()));
				//计算每月华安保费=贷款金额*码值费率
				BigDecimal amtMonth=lstIqpInfo.getAmount().multiply(new BigDecimal(0.99)).multiply(new BigDecimal(feeRate.getPaFeeRate())).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
				paInfo.setInsureAmtMonth(amtMonth);
			} catch (Exception e) {
				throw new BusinessException("华安保费计算出错！"+e.getMessage());
			}
			paInfo.setAbatementRate(lstIqpInfo.getExcuseRate().divide(new BigDecimal(100)));
			paInfo.setInsuAddr(SystemConfig.cacheMap.get("HABX_ADDR"));
			paInfo.setSignDate(lstIqpInfo.getSignDate());
			paInfo.setInsuCompany("HABX");
			paInfo.setSource("PAPH");
		} catch (Exception e) {
			throw new BusinessException("转换出错！"+e.getMessage());
		}
		
		return paInfo;
	}
}
