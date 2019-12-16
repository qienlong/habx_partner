package cn.com.sinosafe.service.xd;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import cn.com.sinosafe.api.BigDataService;
import cn.com.sinosafe.bigdata.other.ylm.YlmRequest;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.constant.PadbConstant;
import cn.com.sinosafe.common.config.constant.XdConstant;
import cn.com.sinosafe.common.config.constant.XdEnum;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.FileUtils;
import cn.com.sinosafe.common.util.FtpUtils;
import cn.com.sinosafe.common.util.IDCardUtil;
import cn.com.sinosafe.common.util.SequenceUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.CreditApplyMapper;
import cn.com.sinosafe.dao.CreditApplyQueryMapper;
import cn.com.sinosafe.dao.FeeRateMapper;
import cn.com.sinosafe.dao.IqpMeAuditOpinionMapper;
import cn.com.sinosafe.dao.IqpMeCoboMapper;
import cn.com.sinosafe.dao.IqpMeCusAppMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.IqpMePrdPrjPaywayMapper;
import cn.com.sinosafe.dao.IqpMePrjCopDao;
import cn.com.sinosafe.dao.IqpMeWsLoanResultMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PartnerBusiImportDetailMapper;
import cn.com.sinosafe.dao.PartnerBusiImportListMapper;
import cn.com.sinosafe.dao.PrjCopAccMapper;
import cn.com.sinosafe.dao.RuleResultInfoMapper;
import cn.com.sinosafe.dao.SentStatusMapper;
import cn.com.sinosafe.dao.WsxdMapper;
import cn.com.sinosafe.domain.entity.CreditApply;
import cn.com.sinosafe.domain.entity.CreditApplyQuery;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.domain.entity.IqpMeAuditOpinion;
import cn.com.sinosafe.domain.entity.IqpMeCobo;
import cn.com.sinosafe.domain.entity.IqpMeCusApp;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.IqpMePrdPrjPayway;
import cn.com.sinosafe.domain.entity.IqpMeWsLoanResult;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.entity.PartnerBusiImportList;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.domain.entity.RuleResultInfo;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.domain.xd.FileTypeHSXD;
import cn.com.sinosafe.domain.xd.XdFileInfo;
import cn.com.sinosafe.domain.xd.XdLoanInfoRequest;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.common.ImageOperaService;
import cn.com.sinosafe.service.common.SmsPushService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinosafe.app.pbc.bean.HtmlBean;
import com.sinosafe.app.pbc.bean.ResultPbcBean;
import com.sinosafe.xinbao.dubbo.service.CreditQueryService;
import com.sinosafe.xinbao.dubbo.service.RuleService;

/**
 * 
 * 渠道进件异步处理
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
@Async
@Service
public class XdAsynService {
	
	private final static Logger logger = LoggerFactory.getLogger(XdAsynService.class);
	
    @Autowired
    private IqpMePrdPrjPaywayMapper	 iqpMePrdPrjPaywayMapper;
    @Autowired
    private IqpMeCusAppMapper iqpMeCusAppMapper;
    @Autowired
    private IqpMePrjCopDao iqpMePrjCopDao;
    @Autowired
    private IqpMeCoboMapper iqpMeCoboMapper;
    @Autowired
    private RuleResultInfoMapper ruleResultInfoMapper;
    @Autowired
    private CreditApplyMapper creditApplyMapper;
    @Autowired
    private CreditApplyQueryMapper creditApplyQueryMapper;
    @Autowired
    private PartnerBusiImportListMapper partnerBusiImportListMapper;
    @Autowired
    private ImageOperaService imageOperaService;
    @Autowired
    private SentStatusMapper sentStatusMapper;
    @Autowired
    private LstIqpInfoMapper lstIqpInfoMapper;
    @Autowired
    private IqpMeAuditOpinionMapper iqpMeAuditOpinionMapper;
    @Autowired
    private IqpMeWsLoanResultMapper iqpMeWsLoanResultMapper;
    @Autowired
    private FeeRateMapper feeRateMapper;
    @Autowired
    private IqpMeLoanAppMapper iqpMeLoanAppMapper;
    @Autowired
    private PartnerBusiImportDetailMapper partnerBusiImportDetailMapper;
    @Autowired
    private PrjCopAccMapper prjCopAccMapper;
    @Autowired
    private DataSource dataSource;
    @Reference(retries = 3, timeout = 60000, check = false)
    private RuleService ruleService;
    @Reference(retries = 3, timeout = 60000, check = false)
    private CreditQueryService creditQueryService;
	@Autowired
	private SmsPushService smsPushService;
	@Autowired
    private SystemConfig systemConfig;
	@Autowired
	private WsxdMapper wsxdMapper;
	@Autowired
	private BigDataService bigDataService;
     
    /**
     * 申请进件异步处理
     * @param params
     * @param loanInfo
     * @param iqpMeApiCop
     * @param iqpMeLoanApp
     */
	public void loanApply(String params, XdLoanInfoRequest loanInfo, IqpMeApiCop iqpMeApiCop, IqpMeLoanApp iqpMeLoanApp) {
		try {
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【线程处理】开始");
            
            // 获取配置信息
            IqpMePrdPrjPayway prjPayway = getPayWay(iqpMeLoanApp.getPartnerNo(), iqpMeApiCop.getCopNo(),loanInfo);
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【获取配置信息】完成");

            // 客户申请表
            IqpMeCusApp iqpMeCusApp = insertIqpMeCusApp(loanInfo);
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【获取申请客户表】完成");

            // 插入合作机构关联表
            insertIqpMePrjCop(loanInfo.getSerno(),iqpMeApiCop.getCopNo());
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【插入合作机构关联表】完成");

            // 信用机构代码表
            if (XdConstant.operatingLoan.equals(loanInfo.getBusiType())) {//经营贷插表：微小贷款共同借款人
                insertIqpMeCobo(loanInfo);
                logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【插入信用机构代码表】完成");
            }

            // 调用审批规则
            JSONObject ruleResult = rule(iqpMeApiCop, loanInfo, iqpMeLoanApp, iqpMeCusApp);
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【审批】完成");

            // 修改申请表状态及缴费方式
            updateIqpMeLoanApp(iqpMeLoanApp, prjPayway, iqpMeApiCop, ruleResult);
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【修改申请表状态及缴费方式】完成");

            // 保存导入列表信息
            insertPartnerList(loanInfo, iqpMeApiCop, iqpMeLoanApp, ruleResult);
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【保存导入列表信息】完成");

            // 保存导入明细
            insertPartnerDetail(loanInfo, iqpMeApiCop, ruleResult, iqpMeLoanApp);
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【保存导入明细】完成");

            // 判断结果
            if(!ObjectUtils.isEmpty(ruleResult) && "9999".equals(ruleResult.getString("rtnCode"))){
                throw new Exception("调用规则异常");
            }
            //文件上传
            fileUpload(loanInfo, iqpMeApiCop, iqpMeLoanApp);

            // 通知
            if(StringUtils.isNotEmpty(iqpMeApiCop.getNoticeUrl())){
                // 当资金方为民泰且 我们审批通过 时，不能进行通知，需要定时调用民泰预进件接口，然后再定时查询民泰预进件审批结果，最好再通知渠道审批结果
                if(XdConstant.MTPN.equals(loanInfo.getPartnerNo()) && "997".equals(iqpMeLoanApp.getNewApproveStatus())) {
                    insertSentStatus(loanInfo.getSerno(),"0",iqpMeApiCop.getAccid() + "_mt_preloan");
                    logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】等待定时调用民泰预进件接口");
                  //资金方为哈密银行
                }else if(XdConstant.HMPN.equals(loanInfo.getPartnerNo()) && "997".equals(iqpMeLoanApp.getNewApproveStatus())){
                	//发送通知短信
                	//修改sentStatus表状态
                	//发送短信测试  X先生{X女士}
//                	String person = loanInfo.getCusName();
//                	if("1".equals(StringUtils.getSexByCertNo(loanInfo.getCertNo()))){
//                		person = person + "先生";
//                	}else {
//                		person = person + "女士";
//					}
//            		smsPushService.pushMessage("尊敬的"+person+"，您已提出投保申请，请您进入微信公众号“华安信保”及时完成投保相关文件签署。", loanInfo.getPhone());
//                    //修改状态为 “待签署”
//                    insertSentStatus(loanInfo.getSerno(),"01",iqpMeApiCop.getAccid() + "_xd_sign");
                    insertSentStatus(loanInfo.getSerno(),"0",iqpMeApiCop.getAccid() + "_appr");
                }else {
                    insertSentStatus(loanInfo.getSerno(),"0",iqpMeApiCop.getAccid() + "_appr");
                    logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【增加通知】结束");
                }
            }

            //判断在进件时是否需要自动出投保单
            autoLstiqpInfo(iqpMeApiCop,iqpMeLoanApp);

            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【线程处理】结束");
        }catch (Exception e){
            logger.error("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【处理异常】",e);
            // 失败写入处理结果表
            addMsgResult(loanInfo.getSerno(), iqpMeApiCop.getAccid() + "_APPLY", "0", "接口参数：" + params + "进件失败：" + e.getMessage());
        }
	}

    private void insertSentStatus(String serno, String status, String sentType) {
        SentStatus sentStatus = new SentStatus();
        sentStatus.setSentSerno(serno);
        sentStatus.setSentStatus(status);
        sentStatus.setSentType(sentType);
        sentStatus.setTmSmp(DateUtils.getDateTime());
        sentStatusMapper.insertSelective(sentStatus);
    }

    private void fileUpload(XdLoanInfoRequest loanInfo, IqpMeApiCop iqpMeApiCop, IqpMeLoanApp iqpMeLoanApp) throws Exception {
        // 从ftp上下载
        List<XdFileInfo> fileList = new ArrayList<>();
        for (XdFileInfo FileInfoHSXD : loanInfo.getFilePaths()) {
            File file = FtpUtils.downloadFile(FileInfoHSXD.getFilePath(),iqpMeLoanApp.getSerno(), iqpMeApiCop.getFtpType(),
                    iqpMeApiCop.getFtpHost(), Convert.toInt(iqpMeApiCop.getFtpPort()), iqpMeApiCop.getFtpAcc(), iqpMeApiCop.getFtpPwd(), systemConfig.getValue("XD_TEMPFILE"));
            XdFileInfo info = new XdFileInfo();
            info.setFilePath(file.getPath());
            info.setFileType(FileInfoHSXD.getFileType());
            fileList.add(info);
        }
        if(!ObjectUtils.isEmpty(fileList)){
            JSONObject flag = uploadFiles(fileList,iqpMeLoanApp);
            if("1".equals(flag.get("code").toString())){
                logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【上传文件】完成");
                FileUtils.deleteDir(new File( systemConfig.getValue("XD_TEMPFILE")+ File.separator + iqpMeLoanApp.getSerno() + File.separator));
            }else{
                throw new Exception("上传文件失败");
            }
        }
    }

    /**
     * @Description 文件补传
     * @Date 2019/11/11 9:28
     * @param params
     * @param iqpMeLoanApp
     * @param loanInfo
     * @param iqpMeApiCop
     * @return void
     */
    public void fileSupplement(String params, IqpMeLoanApp iqpMeLoanApp, XdLoanInfoRequest loanInfo, IqpMeApiCop iqpMeApiCop) {

        try {
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【文件补传线程处理】开始");
            fileUpload(loanInfo, iqpMeApiCop, iqpMeLoanApp);
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【文件补传线程处理】结束");
        }catch (Exception e) {
            logger.error("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【文件补传线程处理】异常",e);
            // 失败写入处理结果表
            addMsgResult(iqpMeLoanApp.getSerno(),iqpMeApiCop.getAccid()+"_AGAIN_FILES","0","接口参数：" + params + "上传失败：" + e.getMessage());
        }
	}


    /**
	 * 文件上传异步
	 * @param loanStr
	 * @param loanInfo
	 * @param busiImportDetail
	 * @param info
	 * @param iqpMeApiCop
	 */
	public void fileOpera(String loanStr, IqpMeLoanApp loanInfo, PartnerBusiImportDetail busiImportDetail,XdLoanInfoRequest info, IqpMeApiCop iqpMeApiCop) {
		try {
			logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】开始");
            fileUpload(info, iqpMeApiCop, loanInfo);
			logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】【判断审批结果】完成，结果：" +loanInfo.getApproveStatus());
			
			if("997".equals(loanInfo.getApproveStatus())){
				
				// 修改申请表金额
				loanInfo.setAmount(new BigDecimal(info.getApplyAmt()));
				// 修改资金方
				if(!StringUtils.equals(loanInfo.getPartnerNo(),info.getPartnerNo())) {
					PrjCopAcc prjCopAcc = prjCopAccMapper.selectByPrimaryKey(info.getPartnerNo());
					if(StringUtils.isNotNull(prjCopAcc)) {
						loanInfo.setPartnerNo(info.getPartnerNo());
						loanInfo.setPartnerName(prjCopAcc.getCopCusName());
					}
				}
				// 判断期限是否有变更，有的话，则需要重新获取费率
				if(new BigDecimal(info.getTerm()).compareTo(loanInfo.getTerm()) != 0) {
					loanInfo.setTerm(new BigDecimal(info.getTerm()));
					loanInfo.setCostRate(getCostRate(loanInfo,iqpMeApiCop.getAccid()).divide(new BigDecimal("100"),9,RoundingMode.HALF_UP));
				}
				
				// 插入决议表
				IqpMeAuditOpinion option = insertIqpMeAuditOpinion(loanInfo);
				logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】【插入决议表】完成");
				// 修改明细表金额及利息
				// 计算利息
				BigDecimal lx = compute_interest(loanInfo.getRepaymentMode(),Double.valueOf(info.getApplyAmt()),
						loanInfo.getUsingIr().doubleValue(), Convert.toInt(loanInfo.getTerm()));
				busiImportDetail.setAmtLx(lx.toString());
				busiImportDetail.setAmount(info.getApplyAmt());
				busiImportDetail.setTerm(info.getTerm());
				partnerBusiImportDetailMapper.updateByPrimaryKeySelective(busiImportDetail);
				logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】【更改明细表利息期限和金额】完成");
				
				// 生成投保单
				LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno2(info.getSerno());
				if(StringUtils.isNull(lstIqpInfo)){
					IqpMeCusApp cusInfo = iqpMeCusAppMapper.selectByPrimaryKey(info.getSerno());
					PrjCopAcc prjCopAcc = prjCopAccMapper.selectByPrimaryKey(loanInfo.getPartnerNo());
					insertLstIqpInfo(cusInfo,prjCopAcc,option,loanInfo,iqpMeApiCop,RoundingMode.UP);
					logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】【自动生成投保单】完成");
				}else{
					logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】【当前状态为已生成投保单】完成");
				}
				// 更改批次状态 , 改成已提交投保
				PartnerBusiImportList importList = new PartnerBusiImportList();
				importList.setBatchNo(loanInfo.getSerno());
				importList.setStatus("04");// 已审批
				// 更改批次状态 , 改成已审批
				partnerBusiImportListMapper.updateByPrimaryKeySelective(importList);
				//短信通知客户已审批通过 
				
            	String person = loanInfo.getCusName();
            	if("1".equals(StringUtils.getSexByCertNo(loanInfo.getCertCode()))){
            		person = person + "先生";
            	}else {
            		person = person + "女士";
				}
        		smsPushService.pushMessage("尊敬的"+person+"，您已提出投保申请，请您进入微信公众号“华安信保”及时完成投保相关文件签署。", loanInfo.getPhone());
                //修改状态为 “待签署”
                insertSentStatus(loanInfo.getSerno(),"01",iqpMeApiCop.getAccid() + "_xd_sign");
				
				logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】【更改批次状态】完成，状态为04");
			}else{
				PartnerBusiImportList importList = new PartnerBusiImportList();
				importList.setBatchNo(loanInfo.getSerno());
				importList.setPassCount(new BigDecimal("0"));
				importList.setNoPassCount(new BigDecimal("1"));
				importList.setStatus("00");// 已审批
				// 更改批次状态 , 改成已审批
				partnerBusiImportListMapper.updateByPrimaryKeySelective(importList);
				logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】【更改批次状态】完成，状态为00");
			}
			
			logger.info("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】结束");
			
			
		} catch (Exception e) {
			logger.error("【"+iqpMeApiCop.getAccid()+"】【"+loanInfo.getSerno()+"】【文件线程处理】异常",e);
			addMsgResult(loanInfo.getSerno(),iqpMeApiCop.getAccid()+"_FILES","0","接口参数：" + loanStr + "上传失败：" + e.getMessage());
		}
	}
	
	public BigDecimal compute_interest(String payType,double capital,double year_rate,int term) throws Exception{
		double interest = -1;
		if(payType.equals("3")){
			// 按月等额本息，利息=本金×月利率×期限月×（1+月利率）^期限月/(（1+月利率）^期限月-1)
			interest = capital*year_rate/12*term*Math.pow(1+year_rate/12, term)/(Math.pow(1+year_rate/12, term)-1)-capital; 
		}else{
			// 一次性还本付息、按月付息一次性还本、按月付息+部分本，到期还本,利息=本金×日利率×期限天
			interest = capital * year_rate / 360 * (DateUtils.getDays(DateUtils.getDate1(), DateUtils.getAddMonthDate$1(DateUtils.getDate(), term)));
		}
		return new BigDecimal(interest).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	private IqpMeAuditOpinion insertIqpMeAuditOpinion(IqpMeLoanApp iqpMeLoanApp) {
		IqpMeAuditOpinion option = new IqpMeAuditOpinion();
		// 新增决议
		option.setSerno(iqpMeLoanApp.getSerno());
		option.setPkId("JY" + RandomStringUtils.randomNumeric(10));
		option.setCusId(iqpMeLoanApp.getCusId());
		option.setAmount(iqpMeLoanApp.getAmount());
		option.setApproveTermTimeType(iqpMeLoanApp.getTermTimeType());
		option.setApproveRate(iqpMeLoanApp.getUsingIr());
		option.setTerm("02".equals(iqpMeLoanApp.getTermTimeType())?Convert.toStr(iqpMeLoanApp.getTerm()):null);
		option.setApproveTermday("01".equals(iqpMeLoanApp.getTermTimeType())?Convert.toStr(iqpMeLoanApp.getTerm()):null);
		option.setApproveAmount(iqpMeLoanApp.getAmount());
		option.setApproveTerm(Convert.toStr(iqpMeLoanApp.getTerm()));
		option.setApproveRepaymode(iqpMeLoanApp.getRepaymentMode());
		option.setRepaymode(iqpMeLoanApp.getRepaymentMode());
		option.setInsurAmount(iqpMeLoanApp.getAmount().multiply(new BigDecimal("1.08")).setScale(2, RoundingMode.HALF_UP));
		
		option.setCostRate(iqpMeLoanApp.getCostRate());
		iqpMeAuditOpinionMapper.insertSelective(option);
		return option;
	}

	private BigDecimal getCostRate(IqpMeLoanApp loanInfo,String accid) throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		// 规则判断统一按accid
		String prdId = loanInfo.getPrdId();
		loanInfo.setPrdId(accid + "_RATE");
		param.put("loanInfoJson", JSON.toJSONString(loanInfo));
		loanInfo.setPrdId(prdId);
		param.put("creditInfoJson", null);
		param.put("cusInfoJson", "{}");
		param.put("guarCreditInfoJson", null);
		param.put("otherInfoJson", null);

		String result = ruleService.rule(param);
		JSONObject parseObject = JSON.parseObject(result);
		if(StringUtils.isNotNull(parseObject) && (StringUtils.isNull(parseObject.get("rate")) || "0".equals(Convert.toStr(parseObject.get("rate"))))) {
			throw new Exception("费率没有获取到配置信息");
		}else {
			return new BigDecimal(Convert.toStr(parseObject.get("rate")));
		}
	}
	
	private JSONObject rule(IqpMeApiCop iqpMeApiCop,XdLoanInfoRequest loanInfo,IqpMeLoanApp iqpMeLoanApp,IqpMeCusApp iqpMeCusApp) throws Exception {
        JSONObject rtn = new JSONObject();
        // 判断是否调用规则
        if("1".equals(iqpMeApiCop.getPreRule()) || "1".equals(iqpMeApiCop.getAutoRule())){
            // 挡板
            String paramerValue = feeRateMapper.getEnnameByOpttype("STD_PRE_RULE");
            String result;
            if("1".equals(iqpMeApiCop.getPreRule())){
                if("Y".equalsIgnoreCase(paramerValue)){
                    // 预审
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("serno", loanInfo.getSerno());
                    map.put("account_name", loanInfo.getCusName());
                    map.put("id_number", loanInfo.getCertNo());
                    map.put("account_mobile", loanInfo.getPhone());
                    map.put("card_number", iqpMeLoanApp.getBankCardNo());
                    map.put("busi_resources", iqpMeApiCop.getAccid());
                    result = ruleService.preRule(JSONObject.toJSONString(map));
                    rtn = JSONObject.parseObject(result);
                    // 插入规则结果表
                    insertPreRuleResultInfoBlobData(rtn,iqpMeLoanApp.getSerno());
                }else{
                    rtn.put("rtnCode","0000");
                    // 插入规则结果表
                    insertPreRuleResultInfoBlobData(rtn,iqpMeLoanApp.getSerno());
                }
            }

            if("1".equals(iqpMeApiCop.getAutoRule())){
                if("Y".equalsIgnoreCase(paramerValue)){
                    if(!rtn.isEmpty() && ("0000".equals(rtn.get("rtnCode")) || "0003".equals(rtn.get("rtnCode")))){
                        // 自动审批
                        Map<String, Object> param = new HashMap<String, Object>();

                        // 判断是否查询征信
                        if("1".equals(iqpMeApiCop.getQueryCredit())){
                            // 组装自动审批所需字段
                            // 查征信之前 插入查询记录
                            String pbcSerno = addCreditQuery(loanInfo, iqpMeApiCop, iqpMeLoanApp);
                            // 查询征信
                            Map<String, Object> creditInfoMap = null;
                            try {
                                creditInfoMap = getCreditJson(loanInfo, iqpMeApiCop, "1",pbcSerno);
                            } catch (Exception e) {
                                logger.error("查询征信有误");
                            }
                            creditInfoMap = timeOutDeal(loanInfo, iqpMeApiCop, creditInfoMap,pbcSerno);
                            if (creditInfoMap != null && creditInfoMap.size() > 0) {
                                // 借款人
                                Object creditInfoJson = creditInfoMap.get("creditInfoJson");
                                if (creditInfoJson != null) {
                                    param.put("creditInfoJson", creditInfoJson);
                                }
                            }
                        }else{
                            param.put("creditInfoJson", null);
                        }

                        // 规则判断统一按accid
                        String prdId = iqpMeLoanApp.getPrdId();
                        iqpMeLoanApp.setPrdId(iqpMeApiCop.getAccid());
                        param.put("loanInfoJson", JSONObject.toJSONString(iqpMeLoanApp));
                        iqpMeLoanApp.setPrdId(prdId);

                        param.put("cusInfoJson", JSONObject.toJSONString(iqpMeCusApp));
                        param.put("guarCreditInfoJson", null);
                        param.put("otherInfoJson", null);

                        result = ruleService.rule(param);
                        rtn = JSONObject.parseObject(result);
                        rtn.put("errMsg", null);
                        if(StringUtils.isEmpty(rtn.get("busiCode").toString())) {
                            rtn.put("busiCode", iqpMeLoanApp.getSerno());
                        }
                        // 插入规则结果表
                        insertRuleResultInfoBlobData(rtn, iqpMeLoanApp.getSerno());
                    }
                }else {
                    result = "{\"wsxdDetail\":{\"data1\":1,\"data4\":1,\"data5\":1,\"data17\":3,\"data2\":1,\"data18\":[4],\"data3\":1,\"data8\":2,\"data9\":1,\"data6\":1,\"data7\":1,\"data20\":[3],\"data11\":1,\"data10\":1},\"personMsg\":[\"WSXD0020\"],\"rate\":1.5,\"term\":12,\"passMsg\":[],\"errMsg\":[],\"rtnCode\":\"0000\",\"busiCode\":\"WXSQ20180518839573\",\"detailMsg\":[\"WSXD0001\",\"WSXD0002\",\"WSXD0003\",\"SXD0004\",\"WSXD0005\",\"WSXD0006\",\"WSXD0007\",\"WSXD0008\",\"WSXD0009\",\"WSXD0010\",\"WSXD0011\",\"WSXD0012\",\"WSXD0013\",\"WSXD0014\",\"WSXD0015\",\"WSXD0016\",\"WSXD0017\",\"WSXD0018\",\"WSXD0019\",\"WSXD0021\",\"WSXD0022\",\"WSXD0023\",\"WSXD0024\",\"WSXD0025\",\"WSXD0026\",\"WSXD0027\",\"WSXD0028\"]}";
                    // 拒绝
                    //			result = "{\"wsxdDetail\":{\"data0\":[2,3,4]},\"personMsg\":[\"WSXD0020\"],\"rate\":1.5,\"term\":12,\"passMsg\":[],\"errMsg\":[],\"rtnCode\":\"0001\",\"busiCode\":\"WXSQ20180518839573\",\"detailMsg\":[\"WSXD0001\",\"WSXD0002\",\"WSXD0003\",\"SXD0004\",\"WSXD0005\",\"WSXD0006\",\"WSXD0007\",\"WSXD0008\",\"WSXD0009\",\"WSXD0010\",\"WSXD0011\",\"WSXD0012\",\"WSXD0013\",\"WSXD0014\",\"WSXD0015\",\"WSXD0016\",\"WSXD0017\",\"WSXD0018\",\"WSXD0019\",\"WSXD0021\",\"WSXD0022\",\"WSXD0023\",\"WSXD0024\",\"WSXD0025\",\"WSXD0026\",\"WSXD0027\",\"WSXD0028\"]}";
                    rtn = JSONObject.parseObject(result);
                    rtn.put("busiCode", iqpMeLoanApp.getSerno());
                    rtn.put("rate", new BigDecimal("2.5"));
                    // 插入规则结果表
                    insertRuleResultInfoBlobData(rtn,iqpMeLoanApp.getSerno());
                }

                // 如果通过 但费率为空或者0 抛出异常
                if(!rtn.isEmpty() && "0000".equals(rtn.get("rtnCode")) && (ObjectUtils.isEmpty(rtn.get("rate")) || "0".equals(String.valueOf(rtn.get("rate"))))){
                    throw new Exception("费率没有获取到配置信息");
                }
            }
        }
        return rtn;
    }

    private void insertPreRuleResultInfoBlobData(JSONObject rtn,String serno) {
        ruleResultInfoMapper.deleteBySernoAndFlag(serno,"02");
        RuleResultInfo ruleResultInfo = new RuleResultInfo();
        insertRuleResultInfo(ruleResultInfo,rtn,serno,"02");
    }

    private void insertRuleResultInfoBlobData(JSONObject rtn,String serno) {
        ruleResultInfoMapper.deleteBySernoAndFlag(serno,null);
        RuleResultInfo ruleResultInfo = new RuleResultInfo();
        BigDecimal loanAmt = ObjectUtils.isEmpty(rtn.get("loanAmt"))?null:new BigDecimal(rtn.get("loanAmt").toString());
        ruleResultInfo.setLoanAmt(loanAmt);
        insertRuleResultInfo(ruleResultInfo,rtn,serno,null);
    }

    private void insertRuleResultInfo(RuleResultInfo ruleResultInfo,JSONObject rtn,String serno,String flag) {
        ruleResultInfo.setPkId(StringUtils.uuid());
        ruleResultInfo.setSerno(serno);
        ruleResultInfo.setRtnCode(String.valueOf(rtn.get("rtnCode")));
        ruleResultInfo.setErrMsg(String.valueOf(rtn.get("errMsg")));
        ruleResultInfo.setDetailMsg(String.valueOf(rtn.get("detailMsg")));
        ruleResultInfo.setPersonMsg(String.valueOf(rtn.get("personMsg")));
        ruleResultInfo.setOperTime(DateUtils.getDate());
        ruleResultInfo.setFlag(flag);
        ruleResultInfo.setIsBlackCus(String.valueOf(rtn.get("isBlackCus")));
        ruleResultInfo.setBlackReason(String.valueOf(rtn.get("blackReason")));
        ruleResultInfoMapper.insertSelective(ruleResultInfo);
    }


    private String addCreditQuery(XdLoanInfoRequest loanInfo,IqpMeApiCop iqpMeApiCop,IqpMeLoanApp iqpMeLoanApp) {
        // 先查询之前是否查询过
        CreditApply creditApply = new CreditApply();
        String serno = "PBC02" + DateUtils.getDate("yyyyMMdd") + StringUtils.getRandomNumeric(6);
        creditApply.setPkId(serno);
        creditApply.setSerno(serno);
        creditApply.setCusType("401");
        creditApply.setCusId(loanInfo.getCusId());
        creditApply.setCusName(loanInfo.getCusName());
        creditApply.setPrdId(iqpMeApiCop.getPrdId());
        creditApply.setPrdName(iqpMeLoanApp.getPrdName());
        creditApply.setApplyReason("loan_before");
        creditApply.setRemark("保前审查");
        creditApply.setApplyBrId(iqpMeApiCop.getBrId());
        creditApply.setApplyUser(iqpMeApiCop.getCusMgr());
        creditApply.setApplyTime(DateUtils.getDate1());
        creditApply.setApproveStatus("997");
        creditApply.setApproveTime(DateUtils.getDate1());
        creditApply.setOldSerno(loanInfo.getSerno());
        creditApply.setBizMode(iqpMeLoanApp.getBizMode());
        creditApply.setCertCode(loanInfo.getCertNo());
        creditApply.setCertType(loanInfo.getCertType());
        creditApply.setIsUpCredit("1");
        creditApply.setIsPretrial("");
        creditApply.setIsPretrialFlag("");
        creditApply.setSubmitTime(DateUtils.getDateTime());
        creditApply.setChannel("3");

        creditApplyMapper.insertSelective(creditApply);

        CreditApplyQuery creditApplyQuery = new CreditApplyQuery();
        creditApplyQuery.setSerno(serno);
        creditApplyQuery.setpNo("1");
        creditApplyQuery.setIsQueryCredit("1");
        String ct = StringUtils.isEmpty(loanInfo.getCusType())?"110":loanInfo.getCusType();
        creditApplyQuery.setCusType(ct);
        creditApplyQuery.setCusName(loanInfo.getCusName());
        creditApplyQuery.setCusId(loanInfo.getCusId());
        creditApplyQuery.setCertType(loanInfo.getCertType());
        creditApplyQuery.setCertCode(loanInfo.getCertNo());
        creditApplyQuery.setIsUpCredit("1");
        creditApplyQuery.setFlag("1");
        creditApplyQueryMapper.insertSelective(creditApplyQuery);

        return serno;
    }

    private Map<String, Object> getCreditJson(XdLoanInfoRequest loanInfo ,IqpMeApiCop iqpMeApiCop,String queryType, String pbcSerno) throws Exception {

        Map<String, Object> creditMap = new HashMap<>();
        List<String> creditInfoList = new ArrayList<>();
        Map<String, String> pbcParamer = new HashMap<>();
        pbcParamer.put("name", loanInfo.getCusName());
        pbcParamer.put("idno", loanInfo.getCertNo());
        pbcParamer.put("idtype", "0");
        pbcParamer.put("queryReason", "20"); //默认贷前审查
        pbcParamer.put("branch", iqpMeApiCop.getBrId());
        pbcParamer.put("serno", pbcSerno);
        pbcParamer.put("obligate", queryType);//2 查询本地 1 在线查询
        pbcParamer.put("currentuserid", iqpMeApiCop.getCusMgr());
        pbcParamer.put("channel", "3");
        ResultPbcBean returnBean = creditQueryService.accessPbc(pbcParamer);
        HtmlBean htmlBean = returnBean.getHtmlBean();

        if (htmlBean != null) {
            if(htmlBean.getResultByte()!=null){
                String creditJson = new String(htmlBean.getResultByte(), "utf-8");
                creditInfoList.add(creditJson);
            }
        }
        creditMap.put("creditInfoJson", creditInfoList);
        return creditMap;
    }

    private Map<String, Object> timeOutDeal(XdLoanInfoRequest loanInfo ,IqpMeApiCop iqpMeApiCop,Map<String, Object> creditInfoMap, String pbcSerno) throws Exception {
        if (ObjectUtils.isEmpty(creditInfoMap) || ObjectUtils.isEmpty(creditInfoMap.get("creditInfoJson"))) {
            for (int i = 0; i < 3; i++) {//当查询征信记录为空时查询三次
                Thread.sleep(10000);
                creditInfoMap = getCreditJson(loanInfo,iqpMeApiCop,"2",pbcSerno);//查本地的征信记录
                if (!ObjectUtils.isEmpty(creditInfoMap) && !ObjectUtils.isEmpty(creditInfoMap.get("creditInfoJson"))) {
                    break;
                }
            }
            if (ObjectUtils.isEmpty(creditInfoMap) || ObjectUtils.isEmpty(creditInfoMap.get("creditInfoJson"))) {
                throw new Exception("查询征信超时！");
            }
        }
        return creditInfoMap;
    }

    private void updateIqpMeLoanApp(IqpMeLoanApp iqpMeLoanApp,IqpMePrdPrjPayway prdPrjPayway,IqpMeApiCop iqpMeApiCop,JSONObject ruleResult) {
//		IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
//		iqpMeLoanApp.setSerno(loanInfo.getSerno());
        iqpMeLoanApp.setPayWay(prdPrjPayway.getPayWay());
        iqpMeLoanApp.setUsingIr(new BigDecimal(prdPrjPayway.getGrossRate()));

        // 判断是否预审
        if("1".equals(iqpMeApiCop.getPreRule())){
            iqpMeLoanApp.setValidResult("0000".equals(ruleResult.get("rtnCode"))?"000":null);
        }

        // 判断是否调用规则
        if("0".equals(iqpMeApiCop.getPreRule()) && "0".equals(iqpMeApiCop.getAutoRule())){
            iqpMeLoanApp.setAppStatus("997");
            iqpMeLoanApp.setApproveStatus("997");
            iqpMeLoanApp.setNewApproveStatus("997");
            // 费率？？？
        }else{
            iqpMeLoanApp.setAppStatus("0000".equals(ruleResult.get("rtnCode").toString())?"997":"998");
            iqpMeLoanApp.setApproveStatus("0000".equals(ruleResult.get("rtnCode").toString())?"997":"998");
            iqpMeLoanApp.setNewApproveStatus("0000".equals(ruleResult.get("rtnCode").toString())?"997":"998");
            String rate = StringUtils.isEmpty(ruleResult.get("rate").toString())?"0":ruleResult.get("rate").toString();
            iqpMeLoanApp.setCostRate(new BigDecimal(rate).divide(new BigDecimal("100"),9, RoundingMode.HALF_UP));
        }

        iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeLoanApp);
    }

    private void insertPartnerList(XdLoanInfoRequest loanInfo, IqpMeApiCop iqpMeApiCop, IqpMeLoanApp iqpMeLoanApp, JSONObject ruleResult) {
        PartnerBusiImportList importList = new PartnerBusiImportList();
        importList.setBatchNo(loanInfo.getSerno());
        importList.setBatchName((StringUtils.isEmpty(iqpMeApiCop.getCopDesc())?"":iqpMeApiCop.getCopDesc()) + "接口进件");
        importList.setImportDate(DateUtils.getDateTime());
        importList.setInputUserId(iqpMeApiCop.getInputId());
        importList.setInputBrId(iqpMeApiCop.getBrId());
        importList.setCopNo(iqpMeLoanApp.getPartnerNo());
        importList.setPrdCode(iqpMeLoanApp.getPrdId());
        importList.setBusiCopNo(iqpMeApiCop.getCopNo());
        importList.setIsBatchInsur("1");
        importList.setTotalCount(new BigDecimal("1"));

        // 判断是否调用规则
        if("0".equals(iqpMeApiCop.getPreRule()) && "0".equals(iqpMeApiCop.getAutoRule())){
            importList.setPassCount(new BigDecimal("1"));
            importList.setNoPassCount(new BigDecimal("0"));
            if("loan".equals(iqpMeApiCop.getInsurType())){// 进件审批通过立马自动出投保单
                importList.setStatus("04");// 已提交投保
            }else if("file".equals(iqpMeApiCop.getInsurType())){// 进件审批通过后需文件通知接口后再出投保单
                importList.setStatus("06");// 待上传文件
            }
        }else{
            // 已提交投保 或者 待上传文件  或者 已审批
            if("0001".equals(ruleResult.get("rtnCode")) || "9999".equals(ruleResult.get("rtnCode"))){
                importList.setPassCount(new BigDecimal("0"));
                importList.setNoPassCount(new BigDecimal("1"));
                importList.setStatus("00");// 已审批
            }else{
                importList.setPassCount(new BigDecimal("1"));
                importList.setNoPassCount(new BigDecimal("0"));
                importList.setStatus("loan".equals(iqpMeApiCop.getInsurType())?"04":"06");
            }
        }

        importList.setBizMode(iqpMeLoanApp.getBizMode());
        partnerBusiImportListMapper.insertSelective(importList);
    }

    private PartnerBusiImportDetail insertPartnerDetail(XdLoanInfoRequest loanInfo, IqpMeApiCop iqpMeApiCop, JSONObject ruleResult, IqpMeLoanApp iqpMeLoanApp) {
        PartnerBusiImportDetail detail = new PartnerBusiImportDetail();

        detail.setBatchNo(loanInfo.getSerno());
        detail.setSerno(loanInfo.getSerno());
        detail.setLoanContNo(loanInfo.getContNO());

        detail.setLoanStartDate(DateUtils.getDate1());
        if("02".equals(loanInfo.getTermType())){
            detail.setLoanEndDate(DateUtils.getAddMonthDate$1(DateUtils.getDate1(), Integer.valueOf(loanInfo.getTerm())));
        }else{
            detail.setLoanEndDate(DateUtils.getAddDayDate(DateUtils.getDate1(), Integer.valueOf(loanInfo.getTerm())));
        }

        // 判断是否调用规则
        if("0".equals(iqpMeApiCop.getPreRule()) && "0".equals(iqpMeApiCop.getAutoRule())){
            detail.setApprResult("997");
//			detail.setNoPassReason(null);
        }else{
            detail.setApprResult("0000".equals(ruleResult.get("rtnCode"))?"997":"998");

            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) ruleResult.get("errMsg");
            // 否决
            if(!ObjectUtils.isEmpty(list)){
                detail.setNoPassReason(StringUtils.join(list, ","));
            }
        }

        detail.setAmount(loanInfo.getApplyAmt());
        detail.setAmtLx("0");
        detail.setCertCode(loanInfo.getCertNo());
        detail.setCusName(loanInfo.getCusName());
        detail.setPhone(loanInfo.getPhone());
        detail.setLoanUse(loanInfo.getLoanUse());
        detail.setLiveAddr(loanInfo.getRsdAddress());
        detail.setCertType(loanInfo.getCertType());
        detail.setRepayModel(loanInfo.getRepayModel());
        detail.setBankCardNo(loanInfo.getBankCardNo());
        detail.setTerm(loanInfo.getTerm());
        detail.setComName(loanInfo.getComName());

        if("loan".equals(iqpMeApiCop.getInsurType())){
            // 计算利息
            BigDecimal lx = StringUtils.compute_interest(iqpMeLoanApp.getRepaymentMode(), iqpMeLoanApp.getAmount().doubleValue(),
                    iqpMeLoanApp.getUsingIr().doubleValue(), Integer.valueOf(iqpMeLoanApp.getTerm().toString()));
            detail.setAmtLx(lx.toString());
        }

        partnerBusiImportDetailMapper.insertSelective(detail);

        return detail;
    }

    private JSONObject uploadFiles(List<XdFileInfo> fileList, IqpMeLoanApp iqpMeLoanApp) {

        List<String> locList = new ArrayList<String>();
        List<String> destList = new ArrayList<String>();

        for (XdFileInfo file : fileList) {
            for (FileTypeHSXD fileType : FileTypeHSXD.values()) {
                if(fileType.getValue().equalsIgnoreCase(file.getFileType())){
                    locList.add(file.getFilePath());
                    destList.add(FileTypeHSXD.getPrdCode(iqpMeLoanApp.getBizMode())+"_" + fileType.getDesc());
                    break;
                }
            }
        }
        JSONObject flg = imageOperaService.uploadImg(locList, destList, FileTypeHSXD.getPrdCode(iqpMeLoanApp.getBizMode()),iqpMeLoanApp.getSerno());
        return flg;
    }

    private void autoLstiqpInfo(IqpMeApiCop iqpMeApiCop,IqpMeLoanApp iqpMeLoanApp) throws Exception {
        // 判断是否自动投保
        if("loan".equals(iqpMeApiCop.getInsurType()) && "997".equals(iqpMeLoanApp.getApproveStatus())){
            // 插入决议表
            IqpMeAuditOpinion option = insertIqpMeAuditOpinion(iqpMeLoanApp);
            logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【插入决议表】完成");

            // 生成投保单
            LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno2(iqpMeLoanApp.getSerno());
            if(ObjectUtils.isEmpty(lstIqpInfo)){
                IqpMeCusApp cusInfo = iqpMeCusAppMapper.selectByPrimaryKey(iqpMeLoanApp.getSerno());
                PrjCopAcc prjCopAcc = prjCopAccMapper.selectByPrimaryKey(iqpMeLoanApp.getPartnerNo());
                insertLstIqpInfo(cusInfo,prjCopAcc,option, iqpMeLoanApp, iqpMeApiCop,RoundingMode.HALF_UP);
                logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【自动投保】完成");
            }else{
                logger.info("【"+iqpMeApiCop.getAccid()+"】【"+iqpMeLoanApp.getSerno()+"】【自动投保】当前状态为已生成投保单");
            }
        }
    }
    
    private void insertLstIqpInfo(IqpMeCusApp cusInfo,PrjCopAcc prjCopAcc,IqpMeAuditOpinion option,
    		IqpMeLoanApp iqpMeLoanApp, IqpMeApiCop iqpMeApiCop, RoundingMode roundingMode) throws Exception {
        LstIqpInfo lstIqpInfo = new LstIqpInfo();
        Connection conn = dataSource.getConnection();
        String lstSerno = SequenceUtil.getLSTSerno(conn);
        // 合同号默认取申请表的
        String contNo = iqpMeLoanApp.getAccAgreeNo();

        Map<String,String> map = new HashMap<>();
        map.put("prdId", iqpMeLoanApp.getPrdId());
        map.put("copNo", iqpMeLoanApp.getInfoChannel());
        map.put("partnerNo", iqpMeLoanApp.getPartnerNo());
        // 查询合作方对应资金方
        map = prjCopAccMapper.getByPrdIdAndCopNoAndPartnerNo(map);
        if(conn != null) {
            conn.close();
        }
        lstIqpInfo.setSerno(lstSerno);
        lstIqpInfo.setIsCredit("0");
        lstIqpInfo.setBizMode(iqpMeLoanApp.getBizMode());
        lstIqpInfo.setPrdId(iqpMeLoanApp.getPrdId());
        lstIqpInfo.setPrdName(iqpMeLoanApp.getPrdName());
        lstIqpInfo.setCusId(iqpMeLoanApp.getCusId());
        lstIqpInfo.setCusName(iqpMeLoanApp.getCusName());
        lstIqpInfo.setCusType(iqpMeLoanApp.getCusType());
        lstIqpInfo.setIndivSex(cusInfo.getIndivSex());
        lstIqpInfo.setCertType(iqpMeLoanApp.getCertType());
        lstIqpInfo.setCertCode(iqpMeLoanApp.getCertCode());
        lstIqpInfo.setIndivMarSt(cusInfo.getIndivMarSt());
        lstIqpInfo.setAddress(cusInfo.getIndivRsdAddr());
        lstIqpInfo.setTelephone(iqpMeLoanApp.getPhone());
        lstIqpInfo.setCountry("193001");
        lstIqpInfo.setMobile(iqpMeLoanApp.getPhone());
        lstIqpInfo.setCoverAccountName(iqpMeLoanApp.getCusName());
        lstIqpInfo.setCoverAccount(iqpMeLoanApp.getBankCardNo());
        lstIqpInfo.setIspermit("1");
        lstIqpInfo.setServiceCharge(new BigDecimal("0"));
        lstIqpInfo.setInvoiceType("02");
        //update by fankun 2019 12 11
        lstIqpInfo.setSinglePrem("2");
        lstIqpInfo.setPayeeAccountName(iqpMeLoanApp.getPayeeAccountName());
       
        
        lstIqpInfo.setPayeeBank(StringUtils.isEmpty(iqpMeLoanApp.getPayeeBank())==true?
        		getBankName(iqpMeLoanApp.getPayeeAccount()):iqpMeLoanApp.getPayeeBank());

        lstIqpInfo.setReceiverCusId(iqpMeLoanApp.getPartnerNo());
        if ("18".equals(prjCopAcc.getCopCusType())) {
            lstIqpInfo.setReceiveCusName("详见投资人清单");
            lstIqpInfo.setReceiverCusAddress("详见投资人清单");
            lstIqpInfo.setReceiveCusPhone("详见投资人清单");
            lstIqpInfo.setReceiveCusCertType("详见投资人清单");
            lstIqpInfo.setReceiveCusCertCode("详见投资人清单");
            lstIqpInfo.setStatus("000");
        }else{
            lstIqpInfo.setReceiveCusName(iqpMeLoanApp.getPartnerName());
            lstIqpInfo.setReceiverCusAddress(map.get("PARTNERADDRESS"));
            lstIqpInfo.setReceiveCusPhone(map.get("PARTNERPHONE"));
            lstIqpInfo.setReceiveCusCertType(map.get("PARTNERCERTTYPE"));
            lstIqpInfo.setReceiveCusCertCode(map.get("PARTNERCERTCODE"));
            lstIqpInfo.setStatus("997");
        }

        lstIqpInfo.setAmount(iqpMeLoanApp.getAmount());
        String term = null;
        String termDay = null;
        try {
            term = iqpMeLoanApp.getTerm().toString();
        }catch (Exception e){}
        try {
            termDay = iqpMeLoanApp.getTermDay().toString();
        }catch (Exception e){}
        lstIqpInfo.setTerm(term);
        lstIqpInfo.setTermDay(termDay);
        lstIqpInfo.setTermTimeType(iqpMeLoanApp.getTermTimeType());
        lstIqpInfo.setRepaymentMode(iqpMeLoanApp.getRepaymentMode());
        //期次需计算
        Map<String,String> paraMap=new HashMap<>();
        paraMap.put("repayMod", iqpMeLoanApp.getRepaymentMode());
        paraMap.put("termType", iqpMeLoanApp.getTermTimeType());
        paraMap.put("term", "0".equals(term)?termDay:term);
        //通过还款方式 申请期限 期限类型 计算期次
        String period = getPeriodByRepayMod(paraMap);
        lstIqpInfo.setPeriod(period);
        // 注意 当为三湘银行时，合同号需生成 / 为民泰时，合同号为空，定时任务去查到后返写
        //如果是哈密银行
    	Map<String,Object> contNo1 = wsxdMapper.selectHamiContfun(iqpMeLoanApp.getSerno());
		if(!CollectionUtils.isEmpty( contNo1)&&contNo1.containsKey("CONTNO")){
			contNo = String.valueOf(contNo1.get("CONTNO"));
		}
        lstIqpInfo.setContNo(contNo);
        lstIqpInfo.setFlag("0");
        lstIqpInfo.setCoverAmount(option.getInsurAmount());
        lstIqpInfo.setCoverCurrencyType("CNY");
        // 保费=贷款本金*费率
        lstIqpInfo.setCoverageFee(iqpMeLoanApp.getAmount().multiply(option.getCostRate()));
        if(XdConstant.HSPN.equals(iqpMeApiCop.getCopNo())) {
            lstIqpInfo.setRate((lstIqpInfo.getCoverageFee().multiply(new BigDecimal("1000")).divide(option.getInsurAmount(), 4,roundingMode)));
        }else {
            lstIqpInfo.setRate((lstIqpInfo.getCoverageFee().multiply(new BigDecimal("1000")).divide(option.getInsurAmount(), 2,roundingMode)));
        }
        lstIqpInfo.setFeeCurrencyType("CNY");
        String coverStartDate = DateUtils.getAddDayDate(DateUtils.getDate1(),1);
        String coverEndDate = DateUtils.getAddMonthDate$1(DateUtils.getDate1(), Convert.toInt(term));
        lstIqpInfo.setCoverStartDate(coverStartDate);
        lstIqpInfo.setCoverEndDate(coverEndDate);
        lstIqpInfo.setToubaoDate(DateUtils.getDate1());
        lstIqpInfo.setSignDate(DateUtils.getDate1());
        lstIqpInfo.setInputDate(DateUtils.getDate1());
        lstIqpInfo.setcConinsrncCde("0");
        lstIqpInfo.setPayWay(iqpMeLoanApp.getPayWay());
        lstIqpInfo.setCreateType("0");
        lstIqpInfo.setInputId(iqpMeApiCop.getInsurInputId());
        lstIqpInfo.setActorno(iqpMeLoanApp.getCusMgr());
        lstIqpInfo.setTelnum(iqpMeLoanApp.getBusinessPersionPhone());
        lstIqpInfo.setcFeeFlag("0");
        lstIqpInfo.setMgrId(iqpMeLoanApp.getCusMgr());
        lstIqpInfo.setMgrOrg(iqpMeLoanApp.getInputBrId());
        lstIqpInfo.setPayeeAccount(iqpMeLoanApp.getBankCardNo());
        lstIqpInfo.setP2pFlag("00");
        lstIqpInfo.setBelongBrId(iqpMeLoanApp.getInputBrId());
        lstIqpInfo.setMainBrId(iqpMeLoanApp.getInputBrId());
        lstIqpInfo.setIspermit("1");
        lstIqpInfo.setLoanStartDate(DateUtils.getDate1());
        lstIqpInfo.setLoanEndDate(DateUtils.getAddMonthDate$1(DateUtils.getDate1(), Integer.valueOf(term)));
        lstIqpInfo.setPrintWay("0");
        lstIqpInfo.setExchangeRate(new BigDecimal("0"));
        lstIqpInfo.setIsAgriculture("0");
        lstIqpInfo.setRiskLevel("928001");
        lstIqpInfo.setGrossRate(iqpMeLoanApp.getUsingIr());
        lstIqpInfo.setOptType("1");
        lstIqpInfo.setIqpLoanSerno(iqpMeLoanApp.getSerno());
        lstIqpInfo.setTradeSign("01");
        lstIqpInfo.setExcuseRate(new BigDecimal("0"));
        lstIqpInfo.setCoverCreateStatus("00");
        lstIqpInfo.setcAppnt(map.get("CAPPNT").replace("XXXX", term));
        lstIqpInfo.setInsRatio(new BigDecimal("1"));
        // 还款日 1固定日 2对日
        lstIqpInfo.setWithHoldKind(iqpMeApiCop.getWithHoldKind());
        //经营贷
        if (XdConstant.operatingLoan.equals(iqpMeLoanApp.getPrdId())) {
            lstIqpInfo.setMtReceiveCusName(cusInfo.getIndivComName());
            lstIqpInfo.setMtCertCode(cusInfo.getOperNo());
            lstIqpInfo.setMtCertType("Ent02");
            String ct = iqpMeLoanApp.getCusType();
            if ("260".equals(ct)) {
                lstIqpInfo.setMtCusType("0401");
            } else if ("211".equals(ct)) {
                lstIqpInfo.setMtCusType("0402");
            } else if ("120".equals(ct)) {
                lstIqpInfo.setMtCusType("");
            }
            lstIqpInfo.setMtIndustryType(XdEnum.getValueByKey(cusInfo.getIndivCllId()));
        }
        lstIqpInfoMapper.insertSelective(lstIqpInfo);
    }

    private String getPeriodByRepayMod(Map<String, String> map){
        String repayMod=map.get("repayMod");
        String termType=map.get("termType");
        String term=map.get("term");
        String period="";
        //目前还款方式为9 按月等本等息
        if(repayMod.equals("9")||repayMod.equals("6")||repayMod.equals("3")||repayMod.equals("2")||repayMod.equals("5")){//按月等本等息
            if("01".equals(termType)){//按天
                period=String.valueOf(Math.ceil(Float.parseFloat(term)/30)).split("\\.")[0];
            }else if("02".endsWith(termType)){//按月
                period=term;
            }
        }else if(repayMod.equals("7")){
            period="1";
        }else if(repayMod.equals("4")){//按季
            if("01".equals(termType)){//按天
                period=String.valueOf(Math.ceil(Float.parseFloat(term)/90)).split("\\.")[0];
            }else if("02".endsWith(termType)){//按月
                period=String.valueOf(Math.ceil(Float.parseFloat(term)/3)).split("\\.")[0];
            }
        }
        return period;
    }
	
	private void insertIqpMeCobo(XdLoanInfoRequest loanInfo) throws SQLException {
        IqpMeCobo imc = new IqpMeCobo();
        Connection conn = dataSource.getConnection();
        imc.setPkId(SequenceUtil.getInBoundNo(conn));
        imc.setSerno(loanInfo.getSerno());
        imc.setCertNo(loanInfo.getCertNo());
        imc.setCoboType("1");
        //imc.setMonthlyPay(new BigDecimal(loanInfo.getLoanPurpose()));
        imc.setCusId(loanInfo.getCusId());
        imc.setCertType(loanInfo.getCertType());
        imc.setCoboName(loanInfo.getCusName());
        iqpMeCoboMapper.insertSelective(imc);
        if(conn != null){
            conn.close();
        }
    }
	
	private void insertIqpMePrjCop(String serno,String copNo) {
        Map<String,String> map = new HashMap<>();
        map.put("pkId",StringUtils.uuid());
        map.put("serno",serno);
        map.put("copNo",copNo);
        iqpMePrjCopDao.insertIqpMePrjCopBySerno(map);
    }
	
	private IqpMeCusApp insertIqpMeCusApp(XdLoanInfoRequest loanInfo) {

        IqpMeCusApp iqpMeCusApp = new IqpMeCusApp();
        iqpMeCusApp.setSerno(loanInfo.getSerno());
        iqpMeCusApp.setCusId(loanInfo.getCusId());
        iqpMeCusApp.setCusName(loanInfo.getCusName());
        String ct = StringUtils.isEmpty(loanInfo.getCusType())?"110":loanInfo.getCusType();
        iqpMeCusApp.setCusType(ct);
        iqpMeCusApp.setCertType(loanInfo.getCertType());
        iqpMeCusApp.setCertCode(loanInfo.getCertNo());
        iqpMeCusApp.setMobile(loanInfo.getPhone());
        iqpMeCusApp.setIndivDtOfBirth(StringUtils.getBirthdayByCertNo(loanInfo.getCertNo()));
        iqpMeCusApp.setIndivSex(StringUtils.getSexByCertNo(loanInfo.getCertNo()));
        iqpMeCusApp.setIndivMarSt(StringUtils.isEmpty(loanInfo.getSpouseName())?"10":"20");
        iqpMeCusApp.setIndivRsdPleId(loanInfo.getRsdRelId());
        iqpMeCusApp.setIndivRsdAddr(loanInfo.getRsdAddress());
        iqpMeCusApp.setIndivEdt(loanInfo.getEducation());
        iqpMeCusApp.setEduLevel(loanInfo.getEducation());
        iqpMeCusApp.setIndivBrtPleId(loanInfo.getRegRelId());
        iqpMeCusApp.setIndivBrtPlace(loanInfo.getRegisterAddress());
        iqpMeCusApp.setIndivSpsName(loanInfo.getSpouseName());
        iqpMeCusApp.setIndivSpsIdCode(loanInfo.getSpouseCertNo());
        iqpMeCusApp.setIndivSpsMphn(loanInfo.getSpousePhone());
        iqpMeCusApp.setIndivSpsIdTyp(loanInfo.getSpouseCertType());
        iqpMeCusApp.setIndivComPleId(loanInfo.getComRelId());
        iqpMeCusApp.setIndivComName(loanInfo.getComName());
        iqpMeCusApp.setIndivComAddr(loanInfo.getComAddr());
        iqpMeCusApp.setIndivComPhn(loanInfo.getComPhone());
        iqpMeCusApp.setIndivRsdSt(loanInfo.getLiveStatus());
        if (StringUtils.isNotEmpty(loanInfo.getComCertNo())) {
            iqpMeCusApp.setOperNo(loanInfo.getComCertNo());
        }
        if (StringUtils.isNotEmpty(loanInfo.getComFld())) {
            iqpMeCusApp.setIndivCllId(loanInfo.getComFld());
        }

        // 增加 职业 和 证件有效期
        iqpMeCusApp.setIndivOcc(loanInfo.getOccupation());
        Map<String,String> map = new HashMap<>();
        map.put("opttype","OCU_GB_T1000");
        map.put("enName",loanInfo.getOccupation());
        String cnname = feeRateMapper.getCnnameByOpttypeAndEnname(map);
        iqpMeCusApp.setIndivOccName(cnname);
        iqpMeCusApp.setIndivIdLong(loanInfo.getValidation());
        iqpMeCusApp.setIndivSpsIdStartDate(loanInfo.getIdStartDate());
        iqpMeCusApp.setIndivSpsIdEndDate(loanInfo.getValidation());

        iqpMeCusAppMapper.insertSelective(iqpMeCusApp);

        return iqpMeCusApp;
    }
	
	private IqpMePrdPrjPayway getPayWay(String partnerNo, String prdId, XdLoanInfoRequest loanInfo) throws Exception {
        String term = loanInfo.getTerm();
        String termType = loanInfo.getTermType();
//        String repayModel = loanInfo.getRepayModel();
        IqpMePrdPrjPayway param = new IqpMePrdPrjPayway();
        param.setPartnerNo(partnerNo);
        param.setPrdId(prdId);
        //param.setTerm(term);
        //param.setTermType(termType);
        //param.setRepayModel(repayModel);

        List<IqpMePrdPrjPayway> iqpMePrdPrjPayways = iqpMePrdPrjPaywayMapper.queryIqpMePrdPrjPaywayByBean(param);

        if(ObjectUtils.isEmpty(iqpMePrdPrjPayways)){
            throw new Exception("资金方【"+partnerNo+"】和产品【"+prdId+"】在IqpMePrdPrjPayway表里没有配置信息");
        }

        IqpMePrdPrjPayway iqpMePrdPrjPayway = null;

        /**
         *
         * 1、只有一条记录 则默认
         * 2、多条记录，根据期限及期限类型获取
         *
         */
        if(iqpMePrdPrjPayways.size() == 1){
            iqpMePrdPrjPayway = iqpMePrdPrjPayways.get(0);
        }else{
            for (IqpMePrdPrjPayway payway : iqpMePrdPrjPayways) {
                if(StringUtils.isNotEmpty(payway.getTerm()) &&
                        Double.valueOf(term).compareTo(Double.valueOf(payway.getTerm())) == 0 &&
                        termType.equals(payway.getTermType())){
                    iqpMePrdPrjPayway = payway;
                    break;
                }
            }
        }
        if(ObjectUtils.isEmpty(iqpMePrdPrjPayway) || StringUtils.isEmpty(iqpMePrdPrjPayway.getPayWay())){
            throw new Exception("资金方【"+partnerNo+"】和产品【"+prdId+"】在IqpMePrdPrjPayway表里没有配置信息");
        }
        return iqpMePrdPrjPayway;
    }

    /**
     * 失败写入处理结果表
     * @param pkId
     * @param type
     * @param result
     * @param msg
     */
    public void addMsgResult(String pkId,String type,String result,String msg){
        IqpMeWsLoanResult iqpMeWsLoanResult = new IqpMeWsLoanResult();
        iqpMeWsLoanResult.setPkId(pkId);
        iqpMeWsLoanResult.setType(type);
        iqpMeWsLoanResult.setResult(result);
        iqpMeWsLoanResult.setMsg(msg);
        iqpMeWsLoanResult.setInputDate(DateUtils.getDateTime());
        iqpMeWsLoanResultMapper.insertSelective(iqpMeWsLoanResult);
    }
    
    
	public String getBankName(String payee_account) throws Exception {
		YlmRequest request = new YlmRequest();
		request.setBankcard(payee_account);
		request.setSerno(PadbConstant.PADB_SYSTEM);
		request.setType("1359");
		JsonProtocol json = bigDataService.ylmPyQuery(request);
		JSONObject json1 = JSONObject.parseObject(
				JSONObject.toJSONString(json), JSONObject.class);
		if ("0".equals(json1.getString("code"))) {
			JSONObject data = (JSONObject) JSONObject.toJSON(json1.get("data"));
			if ("0000".equals(data.getString("result"))) {
				JSONObject data2 = (JSONObject) JSONObject.toJSON(data
						.get("data"));
				String payee_bank = data2.getString("bank_description");
				return payee_bank;
			}
		}
		return null;
	}
}
