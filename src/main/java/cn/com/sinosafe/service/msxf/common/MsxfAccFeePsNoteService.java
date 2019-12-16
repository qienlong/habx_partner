package cn.com.sinosafe.service.msxf.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzj.util.UUID32;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.AccFeeMtdPlanMapper;
import cn.com.sinosafe.dao.AccFeePsNoteMapper;
//import cn.com.sinosafe.dao.MsxfAccLoanInfoMapper;
import cn.com.sinosafe.dao.MsxfFeeRepayDetailsMapper;
//import cn.com.sinosafe.domain.bean.MsxfLoanStatus;
import cn.com.sinosafe.domain.entity.AccFeePsNote;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.entity.MsxfFeeRepayDetails;

/**
 * 
 * 马上消费-保费明细操作服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月23日<br>
 */
@Service
public class MsxfAccFeePsNoteService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MsxfFeeRepayDetailsMapper msxfFeeRepayDetailsMapper;
	@Autowired
	private AccFeePsNoteMapper accFeePsNoteMapper;
	@Autowired
	private AccFeeMtdPlanMapper accFeeMtdPlanMapper;
//	@Autowired
//	private MsxfAccFeeMtdPlanService msxfAccFeeMtdPlanService;
//	@Autowired
//	private MsxfAccLoanInfoMapper msxfAccLoanInfoMapper;
	
	/**
     * 处理保费明细
     * @param msxfAccLoanInfo
     */
    public void doFeeRepayDetails(MsxfAccLoanInfo msxfAccLoanInfo) throws  Exception{
        
    	logger.info("处理保费明细开始:{}",msxfAccLoanInfo.getRefNbr());
        
    	// 根据贷款编号、业务日期、同步状态（默认未处理）查询保费明细中间表
        List<MsxfFeeRepayDetails> msxfFeeRepayDetailsList = msxfFeeRepayDetailsMapper.selectByContNoAndDate(msxfAccLoanInfo.getRefNbr(),msxfAccLoanInfo.getBusinessDate(),"0");
        if(StringUtils.isNotEmpty(msxfFeeRepayDetailsList)) {
        	Short maxPerdNo = 0;
            for (MsxfFeeRepayDetails msxfFeeRepayDetails: msxfFeeRepayDetailsList) {
                // 新增正式保费明细表
                insertAccFeePsNote(msxfAccLoanInfo,msxfFeeRepayDetails);
                // 更新正式保费计划表
                accFeeMtdPlanMapper.updateAccFeeMtdPlanByPrimaryKey(msxfAccLoanInfo.getSerno(),Convert.toStr(msxfFeeRepayDetails.getRepayTerm()));
                accFeeMtdPlanMapper.updateAccFeeMtdPlanStateByPrimaryKey(msxfAccLoanInfo.getSerno(), Convert.toStr(msxfFeeRepayDetails.getRepayTerm()));

                // 更新同步状态
                msxfFeeRepayDetails.setSyncStatus("1");
                msxfFeeRepayDetailsMapper.updateByPrimaryKeySelective(msxfFeeRepayDetails);
                
                // 获取最大期次
                if(maxPerdNo.compareTo(msxfFeeRepayDetails.getRepayTerm()) < 0) {
                	maxPerdNo = msxfFeeRepayDetails.getRepayTerm();
                }
            }
            
            // 判断之前是否有延期状态
//        	List<MsxfAccLoanInfo> list = msxfAccLoanInfoMapper.selectByContNoAndTxStatus(msxfAccLoanInfo.getRefNbr(), new String[] {MsxfLoanStatus.延期.getMsStatus()});
//        	if(StringUtils.isNotEmpty(list)) {
//        		// 有延期状态，有的话则做退保，不用更新保费计划，在之前已经更新
//        		logger.info("合同号：{}，业务日期：{}，延期状态，需要退保");
//        		msxfAccFeeMtdPlanService.doAccFeePlan(msxfAccLoanInfo, null, true, maxPerdNo,"1");
//        	}

        }else {
            logger.info("贷款编号：{}，业务日期：{}没有保费明细数据处理",msxfAccLoanInfo.getRefNbr(),msxfAccLoanInfo.getBusinessDate());
        }
        
        logger.info("处理保费明细结束:{}",msxfAccLoanInfo.getRefNbr());
    }
    
    /**
     * 插入保费明细
     * @param msxfAccLoanInfo
     * @param msxfFeeRepayDetails
     * @return
     * @throws Exception
     */
    public void insertAccFeePsNote(MsxfAccLoanInfo msxfAccLoanInfo, MsxfFeeRepayDetails msxfFeeRepayDetails) throws Exception{
        AccFeePsNote accFeePsNote = new AccFeePsNote();
        accFeePsNote.setLstSerno(msxfAccLoanInfo.getSerno());  //投保单业务流水号
        accFeePsNote.setPsRealDt(DateUtils.formatDate1(msxfFeeRepayDetails.getBizDate()));//实还日期  PS_REAL_FEE_AMT
        accFeePsNote.setPsRealFeeAmt(Convert.toBigDecimal(msxfFeeRepayDetails.getPremiumPaid())); //实收保费  REPAYMENT_STATE
        if("01".equals(msxfFeeRepayDetails.getRepayType())||"02".equals(msxfFeeRepayDetails.getRepayType())) {
            accFeePsNote.setSummary("10"); //摘要 正常还款(10) 2：逾期还款(21) 3：理赔还款（保险公司理赔）(21) 4：提前还款(10)
            accFeePsNote.setRepaymentState("1");//还款状态  1 正常 2 逾期 3 超期
            accFeePsNote.setPremiumRepayType("1"); //保费还款类型   1 正常 2 逾期 3 超期
        }else if("03".equals(msxfFeeRepayDetails.getRepayType()) || "04".equals(msxfFeeRepayDetails.getRepayType())) {
            accFeePsNote.setSummary("21");//摘要
            accFeePsNote.setRepaymentState("2");//还款状态  1 正常 2 逾期 3 超期
            accFeePsNote.setPremiumRepayType("1"); //保费还款类型 1 正常 2 逾期 3 超期

        }
        accFeePsNote.setInputDate(DateUtils.getDate());//录入时间
        accFeePsNote.setUpdateDate(DateUtils.getDate());//更新时间  PS_PERD_NO
        accFeePsNote.setPsPerdNo(msxfFeeRepayDetails.getRepayTerm()); //期次
        accFeePsNote.setBankSerno(msxfFeeRepayDetails.getRefNbr());//银行还款流水号
        accFeePsNote.setInputId(MsxfConstant.MSXF_SYSTEM);//录入人
        accFeePsNote.setInputBrId(MsxfConstant.MSXF_ORG);//INPUT_BR_ID  录入机构  PREMIUM_REPAY_TYPE
        accFeePsNote.setInputDateTime(DateUtils.getDate());
        accFeePsNote.setPkId(UUID32.getUUID());
        //插入保费明细
        accFeePsNoteMapper.insertSelective(accFeePsNote);
    }

}
