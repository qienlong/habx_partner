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
import cn.com.sinosafe.dao.MsxfFeeRepayDetailsMapper;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.MsxfFeeRepayDetails;
import cn.com.sinosafe.service.msxf.MsxfService;

/**
 * 
 * 马上消费-保费明细 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月17日<br>
 */
@Service(MsxfConstant.MSXF_AL1001_INFOFILE)
public class MsxfPremiumInfoFileService implements MsxfService{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MsxfFeeRepayDetailsMapper msxfFeeRepayDetailsMapper;
	
	@Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		logger.info("{}保费明细数据落地开始",MsxfConstant.MSXF_AL1001_INFOFILE);
		try {
			ArrayList<MsxfFeeRepayDetails> arrayList = new ArrayList<>();
			JSONObject params = JSON.parseObject(param);
			
			@SuppressWarnings("unchecked")
			List<String> contents = (List<String>) params.get("contents");
			if(StringUtils.isNotEmpty(contents)) {
				int count=1;
				for (String node : contents) {
					MsxfFeeRepayDetails details = getRequest(node,count);//组装实体类
					details.setBfId(UUID32.getUUID());//主键
					details.setCopNo(Convert.toStr(params.get("partner")));
					details.setBusinessDate(Convert.toStr(params.get("date")));
					details.setSyncStatus("0");
					arrayList.add(details);
					count++;
				}
				logger.info("批量插入保费明细开始,总记录数:{}",arrayList.size());
				msxfFeeRepayDetailsMapper.insertAll(arrayList);
				logger.info("批量插入保费明细结束,总记录数:{}",arrayList.size());
			}
		} catch (Exception e) {
			logger.error(MsxfConstant.MSXF_AL1001_INFOFILE + "批量插入保费明细失败!",e);
		} finally {
			logger.info("{}保费明细数据落地结束",MsxfConstant.MSXF_AL1001_INFOFILE);
		}
		return MsxfResponse.CODE_0000;
	}
	
	private MsxfFeeRepayDetails getRequest(String node,int count) throws Exception {
		MsxfFeeRepayDetails msxfFeeRepayDetails = new MsxfFeeRepayDetails();
		String[] split = node.split(MsxfConstant.MSXF_SPLIT);
		if(split.length!=8) {
			throw new Exception("{}MSXFSinosafePremiumInfoFile.txt{}第"+count+"行,数据格式不正确");
		}
		int i=0;
		msxfFeeRepayDetails.setBizDate(split[i++]);
		msxfFeeRepayDetails.setContrNbr(split[i++]);
		msxfFeeRepayDetails.setProductCd(split[i++]);
		msxfFeeRepayDetails.setRefNbr(split[i++]);
		msxfFeeRepayDetails.setRepayTerm(Convert.toShort(split[i++]));
		msxfFeeRepayDetails.setPremium(split[i++]);
		msxfFeeRepayDetails.setPremiumPaid(split[i++]);
		msxfFeeRepayDetails.setRepayType(split[i]);
		return msxfFeeRepayDetails;
	}


}
