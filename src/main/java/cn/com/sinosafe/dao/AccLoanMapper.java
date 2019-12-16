package cn.com.sinosafe.dao;


import java.util.Map;

import cn.com.sinosafe.domain.entity.AccLoan;

public interface AccLoanMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(AccLoan record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(AccLoan record);
    
    /**
    *
    * 方法说明：
    * @time 2019-06-01
    */
   int updateStatusByPrimaryKey(String billNo);
    
    /**
    *
    * 根据身份证号查询是否存在未结清的贷款
    * @time 2019-06-01
    */
    int getCountByCertCode(String certCode);
    /**
     *
     * 根据申请号查询是否存在台账表判断已放款
     * @time 2019-06-01
     */
    int checkIsLoan(String serno);
    /**
     *
     * 根据客户05210306产品已出单、未结清的贷款本金
     * @time 2019-06-01
     */
    String getBalanceByCertCode(String serno);
    /**
     *
     * 根据客户05210306产品已出单、未结清的贷款本金
     * @time 2019-06-01
     */
    int getAccLoanCountByCertCode(String serno);
    /**
     * <p>Title: selectByPrimaryKey</p>  
     * <p>Description: 查询台账数据</p>  
     * @param billNo
     * @return
     */
    AccLoan selectByPrimaryKey (String billNo);
    /**
     * <p>Title: getLstInfoByBillNo</p>  
     * <p>Description: 查询投保单数据</p>  
     * @param billNo
     * @return
     */
    Map<String, Object> getLstInfoByBillNo (String billNo);

	AccLoan selectByIqpLoanSerno(String serno);

    /**
     * <p>Title: selectByContNo</p>  
     * <p>Description: 查询台账数据</p>  
     * @param contrNbr 合同号
     * @return
     */
/*
	AccLoan selectByContNo(String contrNbr);
*/
}