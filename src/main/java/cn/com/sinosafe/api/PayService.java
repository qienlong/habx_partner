package cn.com.sinosafe.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.constant.SystemConstant;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;

/**
 * 
 * 支付对账相关服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年6月20日<br>
 */
@FeignClient(name = SystemConstant.HAXB_PAY)
public interface PayService {

	/**
     * <p>Title: sendReconInfo</p>  
     * <p>Description:对账数据入库：业务数据上报 </p>  
     * @param jsonReq
     * @return
     */
    @PostMapping("/reconciliation/service/sendReconInfo")
    public JsonProtocol sendReconInfo(@RequestBody JSONObject jsonReq);
    
    /**
     * <p>Title: sendReconInfo</p>  
     * <p>Description:对账数据入库：发送对账单 </p>  
     * @param jsonReq
     * @return
     */
    @PostMapping("/reconciliation/service/manualUploadStatement")
    public JsonProtocol manualUploadStatement(@RequestBody JSONObject jsonReq);
    
}
