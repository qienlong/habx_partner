package cn.com.sinosafe.service.msxf.common;

import java.util.ArrayList;
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
import cn.com.sinosafe.dao.AccMtdPlanMapper;
import cn.com.sinosafe.dao.AccMtdPsNoteMapper;
import cn.com.sinosafe.dao.MsxfAccLoanInfoMapper;
import cn.com.sinosafe.dao.MsxfAccMtdPsNoteMapper;
import cn.com.sinosafe.domain.bean.MsxfLoanStatus;
import cn.com.sinosafe.domain.entity.AccMtdPlan;
import cn.com.sinosafe.domain.entity.AccMtdPlanKey;
import cn.com.sinosafe.domain.entity.AccMtdPsNote;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.entity.MsxfAccMtdPsNote;

/**
 * 
 * 马上消费-还款明细操作服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月23日<br>
 */
@Service
public class MsxfAccMtdPsNoteService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
    private MsxfAccMtdPsNoteMapper msxfAccMtdPsNoteMapper;
    @Autowired
    private AccMtdPsNoteMapper accMtdPsNoteMapper;
	@Autowired
	private AccMtdPlanMapper accMtdPlanMapper;
	@Autowired
	private MsxfAccLoanInfoMapper msxfAccLoanInfoMapper;
	@Autowired
	private MsxfAccFeeMtdPlanService msxfAccFeeMtdPlanService;

	
	 /**
     * 插入还款明细表
     * @param msxfAccLoanInfo
     * @param
     * @return
     * @throws Exception
     */
    public void doAccMtdPsNote(MsxfAccLoanInfo msxfAccLoanInfo) throws Exception{
        
    	logger.info("处理还款明细开始:{}",msxfAccLoanInfo.getBillNo());
       
    	// 根据贷款编号、业务日期、同步状态未处理,查询还款明细中间表
        List<MsxfAccMtdPsNote> msxfAccMtdPsNoteList = msxfAccMtdPsNoteMapper.selectByContNoAndDate(msxfAccLoanInfo.getRefNbr(),msxfAccLoanInfo.getBusinessDate(),"0");
        if(StringUtils.isNotEmpty(msxfAccMtdPsNoteList)) {
        	List<AccMtdPlan> accMtdPlans = new ArrayList<AccMtdPlan>();
        	Short maxPerdNo = 0;
            for (MsxfAccMtdPsNote msxfAccMtdPsNote: msxfAccMtdPsNoteList) {
                
            	//新增正式还款明细表
                insertAccMtdPsNote(msxfAccLoanInfo.getBillNo(),msxfAccMtdPsNote);
                
                // 更新正式还款计划表
                accMtdPlanMapper.updateAccMtdPlanByPrimaryKey(msxfAccLoanInfo.getBillNo(), msxfAccMtdPsNote.getRepayTerm());
                accMtdPlanMapper.updateAccMtdPlanStateByPrimaryKey(msxfAccLoanInfo.getBillNo(), msxfAccMtdPsNote.getRepayTerm());
               
                // 更新同步状态
                msxfAccMtdPsNote.setSyncStatus("1");
                msxfAccMtdPsNoteMapper.updateByPrimaryKeySelective(msxfAccMtdPsNote);
                
                // 查询最新的还款计划
                AccMtdPlanKey accMtdPlanKey = new AccMtdPlanKey();
                accMtdPlanKey.setBillNo(msxfAccLoanInfo.getBillNo());
                accMtdPlanKey.setPsPerdNo(Convert.toShort(msxfAccMtdPsNote.getRepayTerm()));
                AccMtdPlan accMtdPlan = accMtdPlanMapper.selectByPrimaryKey(accMtdPlanKey);
                accMtdPlans.add(accMtdPlan);
                
                // 获取最大期次
                if(maxPerdNo.compareTo(accMtdPlanKey.getPsPerdNo()) < 0) {
                	maxPerdNo = accMtdPlanKey.getPsPerdNo();
                }
            }
            
            // 判断该笔借据是否结清
            over(msxfAccLoanInfo, accMtdPlans,true, maxPerdNo);
        }else {
        	// 判断该笔借据是否结清
        	over(msxfAccLoanInfo, null,false, null);
            logger.info("贷款编号：{}，业务日期：{}没有还款明细数据处理",msxfAccLoanInfo.getRefNbr(),msxfAccLoanInfo.getBusinessDate());
        }
        
        logger.info("处理还款明细结束:{}",msxfAccLoanInfo.getBillNo());
    }

    /**
     * 判断该笔借据是否结清 且有终止状态
     * @param msxfAccLoanInfo
     * @param accMtdPlans
     * @param maxPerdNo
     * @throws Exception
     */
	public void over(MsxfAccLoanInfo msxfAccLoanInfo, List<AccMtdPlan> accMtdPlans,boolean needDelete, Short maxPerdNo) throws Exception {
		if(StringUtils.equals(MsxfLoanStatus.结清.getMsStatus(), msxfAccLoanInfo.getTxnStatus())) {
			// 判断借据之前是否有 正常终止 或  逾期终止 状态 
			List<MsxfAccLoanInfo> list = msxfAccLoanInfoMapper.selectByContNoAndTxStatus(msxfAccLoanInfo.getRefNbr(), 
							new String[] {MsxfLoanStatus.正常终止.getMsStatus(),MsxfLoanStatus.逾期终止.getMsStatus()});
			if(StringUtils.isNotEmpty(list)) {
				// 有终止情况的 处理保费计划，保险止期，保单保费
				logger.info("合同号：{}，业务日期：{}，终止状态还款结清，需要批改");
				msxfAccFeeMtdPlanService.doAccFeePlan(msxfAccLoanInfo, accMtdPlans, needDelete, maxPerdNo,"1");
			}
		}
	}
    
    /**
     * 更新正式还款明细表
     * @param billNo
     * @param msxfAccMtdPsNote
     */
    public void insertAccMtdPsNote(String billNo, MsxfAccMtdPsNote msxfAccMtdPsNote){
        AccMtdPsNote accMtdPsNote = new AccMtdPsNote();
        accMtdPsNote.setPkId(UUID32.getUUID());//唯一主键
        accMtdPsNote.setBillNo(billNo);//借据号
        accMtdPsNote.setBankSerno(msxfAccMtdPsNote.getRefNbr());//交易流水号
        accMtdPsNote.setPsPerdNo(Convert.toShort(msxfAccMtdPsNote.getRepayTerm()));//还款期次
        accMtdPsNote.setPsRealDt(DateUtils.formatDate1(msxfAccMtdPsNote.getRepayDate()));//还款日期
        accMtdPsNote.setPsOdIntAmt(msxfAccMtdPsNote.getPenaltyDue());// 应还罚息
        //accMtdPsNote.setPsCommOdInt("");// 应还复息
        accMtdPsNote.setPsRealPrcpAmt(msxfAccMtdPsNote.getPrincipalAmt());//实还本金
        accMtdPsNote.setPsRealIntAmt(msxfAccMtdPsNote.getInterestAmt());//实还利息
        accMtdPsNote.setSetlOdIncTaken(msxfAccMtdPsNote.getPenaltyAmt());//实还罚息.
        //accMtdPsNote.setSetlCommOdInt("");//实还复利.
        //accMtdPsNote.setUpdateWay(""); //更新方式
        accMtdPsNote.setInputDate(DateUtils.getDate());//录入时间
        accMtdPsNote.setInputId(MsxfConstant.MSXF_SYSTEM);//录入人
        accMtdPsNote.setInputBrId("cmis");//录入机构
        //摘要  /还款类型1：正常还款(10) 2：逾期还款(21) 3：理赔还款（保险公司理赔）(21) 4：提前还款(10)
        if("01".equals(msxfAccMtdPsNote.getRepayType())||"02".equals(msxfAccMtdPsNote.getRepayType())) {
            accMtdPsNote.setAbstract_("10");
        }else if("03".equals(msxfAccMtdPsNote.getRepayType()) || "04".equals(msxfAccMtdPsNote.getRepayType())) {
            accMtdPsNote.setAbstract_("21");
        }
        accMtdPsNoteMapper.insertSelective(accMtdPsNote);
    }

}
