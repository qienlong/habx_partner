package cn.com.sinosafe.service.msxf.postloan;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yzj.util.UUID32;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.MsxfAccLoanInfoMapper;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.service.msxf.MsxfService;

/**
 * 
 * 马上消费-贷款借据信息 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月17日<br>
 */
@Service(MsxfConstant.MSXF_AL1001_LOANFILE)
public class MsxfLoanFileService implements MsxfService{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MsxfAccLoanInfoMapper msxfAccLoanInfoMapper;
	
	@Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		logger.info("{}贷款借据信息数据落地开始",MsxfConstant.MSXF_AL1001_LOANFILE);
		try {
			ArrayList<MsxfAccLoanInfo> arrayList = new ArrayList<>();
			JSONObject params = JSON.parseObject(param);
			
			@SuppressWarnings("unchecked")
			List<String> contents = (List<String>) params.get("contents");
			if(StringUtils.isNotEmpty(contents)) {
				int count=1;
				for (String node : contents) {
					MsxfAccLoanInfo msxfAccLoanInfo = getRequest(node,count);//组装实体类
					msxfAccLoanInfo.setDkId(UUID32.getUUID());//主键
					msxfAccLoanInfo.setCopNo(Convert.toStr(params.get("partner")));
					msxfAccLoanInfo.setBusinessDate(Convert.toStr(params.get("date")));
					msxfAccLoanInfo.setSyncStatus("0");
					arrayList.add(msxfAccLoanInfo);
					count++;
				}
				logger.info("批量插入贷款借据信息开始,总记录数:{}",arrayList.size());
				msxfAccLoanInfoMapper.insertAll(arrayList);
				logger.info("批量插入贷款借据信息结束,总记录数:{}",arrayList.size());
			}
		} catch (Exception e) {
			logger.error(MsxfConstant.MSXF_AL1001_LOANFILE + "批量插入贷款借据信息失败!",e);
		} finally {
			logger.info("{}贷款借据信息数据落地结束",MsxfConstant.MSXF_AL1001_LOANFILE);
		}
		return MsxfResponse.CODE_0000;
	}

	private MsxfAccLoanInfo getRequest(String node, int count) throws Exception {
		
		MsxfAccLoanInfo msxfAccLoanInfo = new MsxfAccLoanInfo();
		String[] val = node.split(MsxfConstant.MSXF_SPLIT);
		if(val.length!=31) {
			throw new Exception("{}MSXFSinosafeLoanFile.txt{}第"+count+"行,数据格式不正确");
		}
		int i=0;
		msxfAccLoanInfo.setBizDate(val[i++]);
		msxfAccLoanInfo.setUuid(val[i++]);
		msxfAccLoanInfo.setContrNbr(val[i++]);
		msxfAccLoanInfo.setProductCd(val[i++]);
		msxfAccLoanInfo.setRefNbr(val[i++]);
		msxfAccLoanInfo.setCurrency(val[i++]);
		msxfAccLoanInfo.setTxnStatus(val[i++]);
		msxfAccLoanInfo.setTxnDate(val[i++]);
		msxfAccLoanInfo.setTxnAmt(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setInitTerm(val[i++]);
		
		msxfAccLoanInfo.setCurrTerm(val[i++]);
		msxfAccLoanInfo.setOverdueDays(Convert.toShort(val[i++]));
		msxfAccLoanInfo.setOverdueDate(val[i++]);
		msxfAccLoanInfo.setPrincipalBal(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setInterestBal(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setOverduePrin(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setOverdueInt(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setPenaltyBal(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setIntType(val[i++]);
		msxfAccLoanInfo.setIntFlag(val[i++]);
		
		msxfAccLoanInfo.setCardNo(val[i++]);
		msxfAccLoanInfo.setGuaranteeFlag(val[i++]);
		msxfAccLoanInfo.setPmtType(val[i++]);
		msxfAccLoanInfo.setInterestRate(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setLoanrate(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setPenaltyRate(Convert.toBigDecimal(val[i++]));
		msxfAccLoanInfo.setIntRateType(val[i++]);
		msxfAccLoanInfo.setPenRateType(val[i++]);
		msxfAccLoanInfo.setPolicyNumber(val[i++]);
		msxfAccLoanInfo.setLoanRatio(val[i++]);
		
		msxfAccLoanInfo.setCoopId(val[i]);
		return msxfAccLoanInfo;
	}


}
