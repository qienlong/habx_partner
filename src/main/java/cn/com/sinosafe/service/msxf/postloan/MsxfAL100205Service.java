package cn.com.sinosafe.service.msxf.postloan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.LstOperDetailsMapper;
import cn.com.sinosafe.domain.bean.MsxfStatus;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.LstOperDetails;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.msxf.MsxfMqMsg;
import cn.com.sinosafe.service.msxf.MsxfService;
import cn.com.sinosafe.service.msxf.common.MsxfAccFeePsNoteService;
import cn.com.sinosafe.service.msxf.common.MsxfAccMtdPsNoteService;

/**
 * 
 * 借据结清状态处理 <br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年9月23日<br>
 */
@Service(MsxfConstant.MSXF_AL100205)
public class MsxfAL100205Service implements MsxfService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MsxfAccMtdPsNoteService msxfAccMtdPsNoteService;
	@Autowired
	private MsxfAccFeePsNoteService msxfAccFeePsNoteService;
	@Autowired
	private LstOperDetailsMapper lstOperDetailsMapper;
	
	/**
	 * 1 结清
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		logger.info("{}正常结清数据处理开始:{}",MsxfConstant.MSXF_AL100205);
		MsxfMqMsg msxfMqMsg = JSON.parseObject(param, MsxfMqMsg.class);
		MsxfAccLoanInfo msxfAccLoanInfo = JSON.parseObject(msxfMqMsg.getData(), MsxfAccLoanInfo.class);
//		if (msxfAccLoanInfo == null){
//			logger.info("{}接口请求参数为空",MsxfConstant.MSXF_AL100205);
//			return MsxfResponse.CODE_9016;
//		}
		// 处理还款明细
		msxfAccMtdPsNoteService.doAccMtdPsNote(msxfAccLoanInfo);

		// 处理保费明细
		msxfAccFeePsNoteService.doFeeRepayDetails(msxfAccLoanInfo);
		logger.info("{}正常结清数据处理结束:{}",MsxfConstant.MSXF_AL100205);

		// 插入轨迹
		insertLstOperDetailsStatus(msxfAccLoanInfo.getSerno(),msxfAccLoanInfo.getIqpLoanSerno(), MsxfStatus.正常结清, null);

		return MsxfResponse.CODE_0000;
	}


	/**
	 * 插入轨迹表
	 * @param serno		业务流水号
	 * @param
	 * @param remark	备注
	 * @return	:
	 */
	public void insertLstOperDetailsStatus(String serno, String iqpLoanSerno,MsxfStatus msxfStatus, String remark) {
		LstOperDetails operDetails = new LstOperDetails();
		operDetails.setSerno(serno);
		operDetails.setIqpSerno(iqpLoanSerno);
		operDetails.setPkId(StringUtils.getRandomNumeric(30));
		operDetails.setOperTime(DateUtils.getDateTime());

		// 获取当前状态描述
		operDetails.setNodename(msxfStatus.name());

		// 获取当前状态第二描述（下一状态描述）
		String newStatusEname = msxfStatus.getNext();
		if (StringUtils.isNotEmpty(newStatusEname)) {
			operDetails.setNodenameTwo(newStatusEname);
		}
		if (StringUtils.isNotEmpty(remark)) {
			operDetails.setRemark(remark);
		}

		lstOperDetailsMapper.insertSelective(operDetails);
	}

}
