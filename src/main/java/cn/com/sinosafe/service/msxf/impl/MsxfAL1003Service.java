package cn.com.sinosafe.service.msxf.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.com.sinosafe.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.api.CommonService;
import cn.com.sinosafe.api.PayService;
import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.dao.MsxfFeeRepayDetailsMapper;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.msxf.MsxfBaseService;


/**
 * 
 * 马上消费--保费明细对账 <br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年9月24日<br>
 */
@Service(MsxfConstant.MSXF_AL1003)
public class MsxfAL1003Service extends MsxfBaseService {

	@Autowired
	private CommonService commonService;

    @Autowired
    private MsxfFeeRepayDetailsMapper msxfFeeRepayDetailsMapper;

    @Autowired
    private PayService payService;


    @Async
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
        logger.info("{}保费对账业务数据上报开始:{}",MsxfConstant.MSXF_AL1003,param);
        MsxfResponse msxfResponse =  MsxfResponse.CODE_0000;
        try {
            //判断是否工作日
            String date = DateUtils.getDate1();
            JsonProtocol result = commonService.isWorkDay(date);
            List<String> errorRequestList = new ArrayList<>();
            //是工作日
            if (result.getCode()== 0 && Convert.toBool(result.getData())){
                //获取上一个工作日
                JsonProtocol protocol = commonService.getPreWorkDay(date);
                if(protocol.getCode() != 0) {
                    throw new Exception(date + "获取上一工作日失败：" + protocol.getMessage());
                }
                String beforeDate = Convert.toStr(protocol.getData()).replaceAll("-","");
                logger.info("对账日期起始时间:{}",beforeDate);
                //查询时间段内需要对账的保费明细
                //List<MsxfFeeRepayDetails> msxfFeeRepayDetailsList = msxfFeeRepayDetailsMapper.selectByDate(beforeDate);
                List<Map<String, String>> msxfFeeRepayDetailsList = msxfFeeRepayDetailsMapper.selectByDate(beforeDate);

                if (StringUtils.isEmpty(msxfFeeRepayDetailsList)){
                    logger.info("没有查询到{}至{}时间段需上报的业务数据",beforeDate,DateUtils.getDate("yyyyMMdd"));
                    return msxfResponse;
                }
                logger.info("{}查询需对账的保费明细结束,总记录数:{}",MsxfConstant.MSXF_AL1003,msxfFeeRepayDetailsList.size());

                for (Map<String, String> map: msxfFeeRepayDetailsList) {
                    Map<String, Object> params  = convertToMsxfPayRequest(map);
                    logger.info("上传对账请求参数：{}",params);
                    JsonProtocol jsonProtocol = payService.sendReconInfo(JSON.parseObject(JSON.toJSONString(params)));
                    logger.info("上传对账返回结果：{}",JSON.toJSONString(jsonProtocol));
                    //记录错误信息
                    if (jsonProtocol.getCode()!= 0){
                        errorRequestList.add("贷款编号:"+map.get("REF_NBR")+",保费明细流水号:"+map.get("BF_ID")+"，调用业务数据上报接口失败！原因"+jsonProtocol.getMessage());
                    }
                }
            }
            if(StringUtils.isNotEmpty(errorRequestList)) {
                throw new Exception(StringUtils.join(errorRequestList, ",\n"));
            }
        }catch (Exception e){
            logger.error("调用保费明细对账接口失败！",e);
            //发送邮件
            msxfAsynDealService.pushEmail(MsxfConstant.MSXF_AL1003, "保费对账业务数据上报:"+param, e);
        }
        logger.info(MsxfConstant.MSXF_AL1003 + "=======结束=======" + param);
        return msxfResponse;
	}

    private Map<String, Object> convertToMsxfPayRequest(Map<String, String> map) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app_id","00201907");// 鉴权id
        params.put("app_key","recon_2019");//鉴权key
        params.put("recon_bus_type","7");// 对账业务类型
        params.put("app_base_pay_app_no",map.get("BF_ID"));//从外部收款通道获取的唯一支付申请号
        params.put("app_base_inpayment_date",map.get("BIZ_DATE").replace("-", ""));// 完成缴费的交易日期格式YYYYMMDD
        params.put("app_base_inpayment_time","000000");//完成缴费的交易时间格式HHMMSS
        params.put("app_base_insu_mid_no","DZ00201907");//商户号(由统一对账平台配置）
        params.put("app_base_amount",Convert.toStr(Convert.toBigDecimal(map.get("PREMIUM_PAID")).multiply(new BigDecimal(100))));//交易金额，以分为单位
        params.put("app_base_policy_start_date",map.get("COVER_START_DATE").replace("-", ""));//起保时间
        params.put("app_base_sub_company",map.get("BELONG_BR_ID").substring(0, 4));//分公司   lstIqpInfo.getBelongBrId().substring(0, 4)
        params.put("app_base_department_code",map.get("CORE_ORGANNO"));// 业务归属部门
        params.put("app_base_cus_bank_card_no",systemConfig.getValue("MSXF_PREMIUM_BANK_CODE"));//  客户刷卡卡号
        //params.put("app_base_cus_bank_card_no","2222222");//  客户刷卡卡号

        List<Map<String,Object>>listMap = new ArrayList<Map<String,Object>>();
        Map<String,Object>appInfoListMap = new HashMap<String,Object>();
        appInfoListMap.put("app_info_cust_seq",map.get("REF_NBR"));//流水号 贷款编号ref_nbr
        appInfoListMap.put("app_info_applicant_no",map.get("LIST_SERNO"));// 投保单/保单，代表业务单号（结合datatype看，0-投保单、2-保单，1-批改申请单号）
        appInfoListMap.put("app_info_policy_no",map.get("LIST_SERNO"));//保单号
        appInfoListMap.put("app_info_amount",Convert.toStr(Convert.toBigDecimal(map.get("PREMIUM_PAID")).multiply(new BigDecimal(100))));//金额单位分
        appInfoListMap.put("app_info_start_date",map.get("COVER_START_DATE").replace("-", ""));//起保生效日期 20190711
        appInfoListMap.put("app_info_data_type","2");//0-见费出单、2-非见费，1-见费批改申请
        appInfoListMap.put("app_info_department_code",map.get("CORE_ORGANNO"));//业务归属部门代码(10位出单机构代码)
        listMap.add(appInfoListMap);
        params.put("app_info_list",listMap);
        return params;
    }

}
