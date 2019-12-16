/**
 * projectName: haxb_partner
 * fileName: PublicRepaymentService.java
 * packageName: cn.com.sinosafe.service.padb
 * date: 2019-09-05 9:47
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.service.padb;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: PublicRepaymentService
 * @packageName: cn.com.sinosafe.service.padb
 * @description: 对公还款存入通知接口
 * @data: 2019-09-05 9:47
 **/
public interface PublicRepaymentService {
    /**
     * 对公还款存入通知
     * @param paramMap
     * @return
     * @throws Exception
     */
    String PublicRepaymentNotice(Map<String, Object> paramMap) throws Exception;
}
