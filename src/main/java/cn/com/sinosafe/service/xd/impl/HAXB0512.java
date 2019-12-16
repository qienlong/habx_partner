package cn.com.sinosafe.service.xd.impl;

import java.math.BigDecimal;
import java.util.List;

import cn.com.sinosafe.common.config.constant.XdConstant;
import cn.com.sinosafe.domain.xd.XdLoanInfoRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.entity.PartnerBusiImportList;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.domain.xd.XdFileInfo;
import cn.com.sinosafe.domain.xd.XdRequest;
import cn.com.sinosafe.domain.xd.XdResponse;
import cn.com.sinosafe.service.xd.XdBaseService;

/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Project : Java EE 开发平台 <br>
 * Description : 网商小贷通知接口 <br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2018年4月23日<br>
 */
@Service("HAXB0512")
public class HAXB0512 extends XdBaseService {

    private static final Logger logger = LoggerFactory.getLogger(HAXB0512.class);

	@Override
	public String process(XdRequest xdRequest) throws Exception {
		
		logger.info("------"+xdRequest.getAccid()+" upload ---- start -----");
		
		if(StringUtils.isEmpty(xdRequest.getAccid())){
			throw new Exception("请求信息为空");
		}
		
		XdLoanInfoRequest info = JSONObject.parseObject(xdRequest.getParams(), XdLoanInfoRequest.class);
		
		// 获取业务来源合作方的编号
		if(StringUtils.isEmpty(info.getResult())) {
			throw new Exception("审批结果不能为空");
		}
		if(StringUtils.isEmpty(info.getPartnerNo())) {
			throw new Exception("资金方编号为空");
		}
		
/*		if("0000".equals(info.getResult())) {
			if(StringUtils.isEmpty(info.getTerm())){
				throw new Exception("贷款期限不能为空");
			}
			if(StringUtils.isNull(info.getApplyAmt())){
				throw new Exception("贷款金额不能为空");
			}
		}*/
		
		// 检查流水号和合同号是否对应
		PartnerBusiImportDetail busiImportDetail = partnerBusiImportDetailMapper.selectByPrimaryKey(info.getSerno());
		if(StringUtils.isNull(busiImportDetail)){
			throw new Exception("没有查询到该笔业务");
		}else if(!info.getContNO().equals(busiImportDetail.getLoanContNo())){
			throw new Exception("业务流水号与合同号不对应");
		}
		
		// 判断该笔业务状态，拒绝则上传文件，通过上传文件及生成投保单
		IqpMeLoanApp loanInfo = iqpMeLoanAppMapper.selectByPrimaryKey(info.getSerno());
		if(StringUtils.isNull(loanInfo)){
			throw new Exception("没有查询到该笔业务");
		}
		if("P95HSXD05".equals(getIqpMeApiCop().getAccid())){
			PrjCopAcc prjCopAcc = prjCopAccMapper.selectByPrimaryKey(info.getPartnerNo());
			if(StringUtils.isNull(prjCopAcc)) {
				throw new Exception("资金方编号不正确");
			}
//			if("PRJ20190801091636".equals(info.getPartnerNo())){ 
//				//查询如果没有签署通过，则需要进行绑卡
//				SentStatus record = new SentStatus();
//				record.setSentSerno(loanInfo.getSerno());
//				record.setSentStatus("01");
//				record.setSentType("hmyh_bandCard");
//				SentStatus result = sentStatusMapper.selectByPrimaryKey(record);
//				if(ObjectUtils.isEmpty(result)){
//					throw new Exception("请先到‘华安信保’微信公众号进行签署绑卡");
//				}
//			}
			//如果是浩森，放款銀行是哈密 ，前端需要设置这两个值
			info.setApplyAmt(String.valueOf(loanInfo.getAmount()));
			info.setTerm(String.valueOf(loanInfo.getTerm()));
		}
		if("0000".equals(info.getResult()) && loanInfo.getAmount().compareTo(new BigDecimal(info.getApplyAmt())) < 0) {
			throw new Exception("贷款金额不能大于申请金额");
		}
		// 判断结果
		if("0000".equals(info.getResult())){
			// 查询批次状态，判断是否是待上传文件状态
			PartnerBusiImportList busiImportList = partnerBusiImportListMapper.selectByPrimaryKey(info.getSerno());
			if(StringUtils.isNotNull(busiImportList) && "06".equals(busiImportList.getStatus())){
				// 校验文件
				if(StringUtils.isEmpty(info.getFilePaths())){
					throw new Exception("文件不能为空");
				}else{
					String checkResult = checkFiles(info.getFilePaths(),loanInfo);
					if(StringUtils.isNotEmpty(checkResult)){
						throw new Exception("【"+info.getContNO()+"】缺少文件类型为【"+checkResult.substring(0,checkResult.lastIndexOf(","))+"】的文件");
					}
				}
				// 异步处理
		        xdAsynService.fileOpera(xdRequest.getParams(), loanInfo, busiImportDetail, info, getIqpMeApiCop());
			}else{
				throw new Exception("该业务状态无需上传文件");
			}
		}else{
			// 更新申请表和明细表审批结果
			updateStatus(info, busiImportDetail);
		}
		
		logger.info("------"+xdRequest.getAccid()+" upload ---- end -----");
		
		return JSONObject.toJSONString(new XdResponse("0000",null,null));
	}

	/**
	 * 合作方拒绝后修改状态
	 * @param info
	 * @param busiImportDetail
	 */
	public void updateStatus(XdLoanInfoRequest info, PartnerBusiImportDetail busiImportDetail) {
		IqpMeLoanApp loanInfo_ = new IqpMeLoanApp();
		loanInfo_.setSerno(info.getSerno());
		loanInfo_.setApproveStatus("998");
		loanInfo_.setNewApproveStatus("998");
		iqpMeLoanAppMapper.updateByPrimaryKeySelective(loanInfo_);
		
		busiImportDetail.setApprResult("998");
		busiImportDetail.setNoPassReason("渠道合作方审批拒绝");
		partnerBusiImportDetailMapper.updateByPrimaryKeySelective(busiImportDetail);
		
		PartnerBusiImportList importList = new PartnerBusiImportList();
		importList.setBatchNo(info.getSerno());
		importList.setPassCount(new BigDecimal("0"));
		importList.setNoPassCount(new BigDecimal("1"));
		importList.setStatus("00");// 已审批
		partnerBusiImportListMapper.updateByPrimaryKeySelective(importList);
	}
	
	private String checkFiles(List<XdFileInfo> files, IqpMeLoanApp loanInfo) throws Exception {
		if (XdConstant.MTPN.equals(loanInfo.getPartnerNo())) {//民泰
			if (XdConstant.consumerLoan.equals(loanInfo.getPrdId())) {//消费贷
				String paramerValue = systemConfig.getValue("WSXD_XFD_FILE_TYPE");
				return getNotFileTypes(paramerValue, files);
			} else if ("05210304".equals(loanInfo.getPrdId())) {//经营贷
				String paramerValue = systemConfig.getValue("WSXD_JYD_FILE_TYPE");
				return getNotFileTypes(paramerValue, files);
			}else{
				throw new Exception("产品【"+loanInfo.getPrdId()+"】不是允许的消费贷和经营贷");
			}
		} else if (XdConstant.SXPN.equals(loanInfo.getPartnerNo())) {//三湘
			if (XdConstant.consumerLoan.equals(loanInfo.getPrdId())) {//消费贷
				String paramerValue = systemConfig.getValue("WSXD_SX_XFD_FILE");
				return getNotFileTypes(paramerValue, files);
			} else if (XdConstant.operatingLoan.equals(loanInfo.getPrdId())) {//经营贷除以下外22和23二选一
				String paramerValue = systemConfig.getValue("WSXD_SX_XFD_FILE");
				String returnCheck = getNotFileTypes(paramerValue, files);
				if (StringUtils.isBlank(returnCheck)) {
					String ta = getNotFileTypes("22", files);
					String tb = getNotFileTypes("23", files);
					if (!StringUtils.isBlank(ta) && !StringUtils.isBlank(tb)) {
						throw new Exception("经营贷除其他外22和23二选一");
					}
				}
				return returnCheck;
			}else{
				throw new Exception("产品【"+loanInfo.getPrdId()+"】不是允许的消费贷和经营贷");
			}
		}else if (XdConstant.CQNSHPN.equals(loanInfo.getPartnerNo())) {//重庆农商行
			String paramerValue = systemConfig.getValue("WSXD_CQNSH_XFD_FILE");
			return getNotFileTypes(paramerValue, files);
		}else if (XdConstant.HMPN.equals(loanInfo.getPartnerNo())) {//哈密银行
			String paramerValue = systemConfig.getValue("WSXD_HMYH_YX_FILE");
			  //业务类型 05210305-消费贷； 05210304 -经营贷 浩森经营贷 需要9的类型
	        if(XdConstant.HSPN.equals(loanInfo.getInfoChannel())&&XdConstant.operatingLoan.equals(loanInfo.getPrdId())){
	        	paramerValue = "23," + paramerValue;
	        }
			return getNotFileTypes(paramerValue, files);
		}else{
			throw new Exception("资金方【"+loanInfo.getPartnerNo()+"】非法");
		}
	}
	
}
