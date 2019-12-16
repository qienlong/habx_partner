package cn.com.sinosafe.service.padb;

import java.util.Map;

/**
 * @ClassName:：IssuedRateService 
 * @Description： 保费费率下发
 * @author ：pengll
 * @date ：2019年6月3日 下午2:41:16  
 */
public interface IssuedRateService {


	/**
    *
    * 方法说明：保费费率下发
    * @author pengll
    * @param
    * @param paramMap 费率编码
    * @return 
    * @time 2019-06-01
    */
   public String IssueFeeRateInfo(Map<String, Object> paramMap);
}
