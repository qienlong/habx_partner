package cn.com.sinosafe.service.xd.impl;

import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.xd.XdLoanInfoRequest;
import cn.com.sinosafe.domain.xd.XdRequest;
import cn.com.sinosafe.domain.xd.XdResponse;
import cn.com.sinosafe.service.xd.XdBaseService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @version 1.0
 * @Description 文件补传接口
 * @auther 林良
 * @Date 2019-11-11
 */
@Service("HAXB0514")
public class HAXB0514 extends XdBaseService {

    private final static Logger logger = LoggerFactory.getLogger(HAXB0514.class);

    @Override
    public String process(XdRequest xdRequest) throws Exception {

        logger.info("------"+xdRequest.getAccid()+" again upload ---- start -----");

        XdLoanInfoRequest loanInfo = JSONObject.parseObject(xdRequest.getParams(),XdLoanInfoRequest.class);
        if(ObjectUtils.isEmpty(loanInfo) || StringUtils.isEmpty(loanInfo.getSerno())){
            throw new Exception("参数为空");
        }

        // 获取业务来源合作方的编号
        //IqpMeApiCop iqpMeApiCop = iqpMeApiCopMapper.getIqpMeApiCopByAccid(xdRequest.getAccid());
        PartnerBusiImportDetail pbImportDetail = partnerBusiImportDetailMapper.selectByPrimaryKey(loanInfo.getSerno());
        if(ObjectUtils.isEmpty(pbImportDetail)){
            throw new Exception("没有查询到该笔业务");
        }else if(!loanInfo.getContNO().equals(pbImportDetail.getLoanContNo())){
            throw new Exception("业务流水号与合同号不对应");
        }

        // 判断该笔业务状态，拒绝则上传文件，通过上传文件及生成投保单
        IqpMeLoanApp iqpMeLoanApp = iqpMeLoanAppMapper.selectByPrimaryKey(pbImportDetail.getSerno());
        if(ObjectUtils.isEmpty(iqpMeLoanApp)){
            throw new Exception("没有查询到该笔业务");
        }
        // 异步处理
        xdAsynService.fileSupplement(xdRequest.getParams(),iqpMeLoanApp,loanInfo,getIqpMeApiCop());
        logger.info("------ "+xdRequest.getAccid()+" again upload ---- end  -----");
        return JSONObject.toJSONString(new XdResponse("0000",null,null));
    }
}
