package cn.com.sinosafe.api;

import java.text.ParseException;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.constant.SystemConstant;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;

/**
 * 
 * 公用相关服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年6月20日<br>
 */
@FeignClient(name = SystemConstant.COMMONSERVICE)
public interface CommonService {
	
	/**
	 * 生成保费计划
	 * @param jsonReq
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("/common-service/common/core/installmentPlan")
    public JsonProtocol installmentPlan(@RequestBody JSONObject jsonReq) throws ParseException;
	
	/**
	 * 退保公共接口
	 * @param jsonReq
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/common-service/common/policySurrender")
    public JsonProtocol policySurrender(@RequestBody JSONObject jsonReq) throws Exception;
	
	/**
	 * 判断该日是否工作日
	 * @param date 
	 * @return
	 */
	@PostMapping("common-service/common/holiday/isWorkDay/{date}")
	public JsonProtocol isWorkDay(@PathVariable("date") String date);
	
	/**
	 * 获取上一个工作日
	 * @param date 
	 * @return
	 */
	@PostMapping("common-service/common/holiday/getPreWorkDay/{date}")
	public JsonProtocol getPreWorkDay(@PathVariable("date") String date) ;
	
	/**
	 * 调用规则
	 * @param params
	 * @param type app端终审：appAuto， app端预审：appPre， pc端终审：pcAuto， pc端预审：pcPre
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/common-service/common/approve/rule/{type}")
	public JsonProtocol rule(@RequestBody String params,@PathVariable("type") String type) throws Exception;

	 /**
     * <p>Title: sendReconInfo</p>  
     * <p>Description:对账数据入库：批改保单保费，费率批改 </p>  
     * @param jsonReq
     * @return
     */
    @PostMapping("common-service/common/policyModify")
    public JsonProtocol policyModify(@RequestBody JSONObject jsonReq);
}
