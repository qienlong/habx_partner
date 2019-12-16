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
import cn.com.sinosafe.dao.MsxfAccMtdPsNoteMapper;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.MsxfAccMtdPsNote;
import cn.com.sinosafe.service.msxf.MsxfService;

/**
 * 马上消费-还款明细文件处理 <br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年9月18日<br>
 */
@Service(MsxfConstant.MSXF_AL1001_REPAY_FILE)
public class MsxfRepayFileService implements MsxfService{

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired(required = false)
	private MsxfAccMtdPsNoteMapper msxfAccMtdPsNoteMapper;

	@Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		logger.info("{}还款明细数据落地开始",MsxfConstant.MSXF_AL1001_REPAY_FILE);
		ArrayList<MsxfAccMtdPsNote> accMtdPsNoteList = new ArrayList<MsxfAccMtdPsNote>();
		try {
			JSONObject params = JSON.parseObject(param);
			String copNo = Convert.toStr(params.get("partner")); //资金方
			String businessDate = Convert.toStr(params.get("date"));//华安业务时间
			@SuppressWarnings("unchecked")
			List<String> contents =(List<String>)params.get("contents");//txt文档内容
			if(StringUtils.isNotEmpty(contents)) {
				logger.info("解析还款明细txt文档共有{}条记录",contents.size());
				int count = 1;
				for (String content: contents) {
					MsxfAccMtdPsNote msxfAccMtdPsNote = coverToEntity(content,count);
					//主键
					msxfAccMtdPsNote.setMsxfAccMtdPsNoteId(UUID32.getUUID());
					//资金方
					msxfAccMtdPsNote.setCopNo(copNo);
					//华安业务日期
					msxfAccMtdPsNote.setBusinessDate(businessDate);
					//同步状态 初始状态
					msxfAccMtdPsNote.setSyncStatus("0");

					accMtdPsNoteList.add(msxfAccMtdPsNote);
				}
			}
			
			logger.info("{}批量插入还款明细开始,总记录数:{}",MsxfConstant.MSXF_AL1001_REPAY_FILE,accMtdPsNoteList.size());
			
			//批量插入 还款明细
			if(StringUtils.isNotEmpty(accMtdPsNoteList)) msxfAccMtdPsNoteMapper.batchInsert(accMtdPsNoteList);
			
			logger.info("{}批量插入还款明细结束,总记录数:{}",MsxfConstant.MSXF_AL1001_REPAY_FILE,accMtdPsNoteList.size());
			
		} catch (Exception e){
			logger.error(MsxfConstant.MSXF_AL1001_REPAY_FILE + "批量插入还款明细失败!",e);
		} finally {
			logger.info("{}还款明细数据落地结束",MsxfConstant.MSXF_AL1001_REPAY_FILE);
		}
		return MsxfResponse.CODE_0000;
	}

	/**
	 * 读取文本内容并生成相应实体类
	 */
	private MsxfAccMtdPsNote coverToEntity(String content,int count) throws Exception{
		MsxfAccMtdPsNote msxfAccMtdPsNote = new MsxfAccMtdPsNote();
		int i=0;
		String[] contentArray = content.split(MsxfConstant.MSXF_SPLIT);
		if(contentArray.length!= MsxfConstant.ACC_MTD_PS_NOTE_PARAMCOUNT){
			logger.info("还款计划txt文档中第{}行参数个数有误!",count);
			throw new IllegalArgumentException("还款计划txt文档中第"+count+"行参数个数有误!");
		}
		msxfAccMtdPsNote.setBizDate(contentArray[i++]);
		msxfAccMtdPsNote.setContrNbr(contentArray[i++]);
		msxfAccMtdPsNote.setProductCd(contentArray[i++]);
		msxfAccMtdPsNote.setRefNbr(contentArray[i++]);
		msxfAccMtdPsNote.setRepayDate(contentArray[i++]);
		msxfAccMtdPsNote.setRepayRefNbr(contentArray[i++]);
		msxfAccMtdPsNote.setPrincipalDue(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPsNote.setPrincipalAmt(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPsNote.setInterestDue(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPsNote.setInterestAmt(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPsNote.setPenaltyDue(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPsNote.setPenaltyAmt(Convert.toBigDecimal(contentArray[i++]));
		msxfAccMtdPsNote.setRepayTerm(contentArray[i++]);
		msxfAccMtdPsNote.setRepayType(contentArray[i++]);
		msxfAccMtdPsNote.setRepayCardNo(contentArray[i++]);
		return msxfAccMtdPsNote;
	}


}
