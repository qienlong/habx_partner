package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.CusBlkList;

public interface CusBlkListMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-04
     */
    int insert(CusBlkList record);

    /**
     *
     * 方法说明：
     * @time 2019-06-04
     */
    int insertSelective(CusBlkList record);
    
    
    /**
    *
    * 方法说明：根据身份证查询客户是否命中内部黑名单
    * @time 2019-06-01
    */
    CusBlkList selectByCertCode(String certCode);
}