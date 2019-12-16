/**
 * projectName: haxb_partner
 * fileName: PaPhTrustPlanService.java
 * packageName: cn.com.sinosafe.service.padb
 * date: 2019-09-02 10:52
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.service.padb;

import java.util.Map;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: PaPhTrustPlanService
 * @packageName: cn.com.sinosafe.service.padb
 * @description: 信托计划信息同步
 * @data: 2019-09-02 10:52
 **/
public interface PaPhTrustPlanService{

    /**
     * 信托计划信息同步
     * @param paramMap
     * @return
     */
    String TrustPlanInfoSyn(Map<String, Object> paramMap) throws Exception;
}
