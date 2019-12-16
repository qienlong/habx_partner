package cn.com.sinosafe.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.com.sinosafe.domain.entity.LstIqpInfo;
import org.apache.ibatis.annotations.Param;

public interface LstIqpInfoMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int deleteByPrimaryKey(String serno);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(LstIqpInfo record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(LstIqpInfo record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    LstIqpInfo selectByPrimaryKey(String serno);
    /**使用serno查询保单表*/
    LstIqpInfo selectBySerno(String serno);
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKeySelective(LstIqpInfo record);
    
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByIqpSerno(LstIqpInfo record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKey(LstIqpInfo record);
    
    /**
     * 
    * @Title：selectBySernoAndStatus 
    * @Description：根据申请号及状态查询投保数据
    * @param ：@param serno 申请号
    * @param ：@param status 状态
    * @param ：@return 
    * @return ：LstIqpInfo 
    * @throws
     */
    LstIqpInfo selectBySernoAndStatus(LstIqpInfo record);
    
    
    
    /**
    *
    * 方法说明：根据申请号校验已完成签署投保单行为的保单
    * @time 2019-06-01
    */
    LstIqpInfo selectByIqpLoanSerno(String applNo);
    /**
     *
     * 方法说明：根据投保单号查询保单是否存在
     */
    LstIqpInfo selectByIqpLoanSerno1(String applNo);
    /**
     *
     * 方法说明：根据投保单号查询保单是否存在
     */
    LstIqpInfo selectByIqpLoanSerno2(String applNo);
    /**
    *
    * 方法说明：根据产品编号查询特别约定
    * @time 2019-06-01
    */
    Map<String, Object> queryCAppnt(String prdId);
    /**
     *
     * 方法说明：根据出单人员编号查询名称
     * @time 2019-06-01
     */
    String getInputNameById(String inputId);
    /**
     *
     * 方法说明：根据保单号查询电子保单是否生成
     * @time 2019-06-01
     */
    Map<String, Object> selectEleStatus(String iqpLoanSerno);

    /**
     *
     * 方法说明：根据保单号查询投保数据
     * @time 2019-09-04
     */
    LstIqpInfo selectByListSerno(String listSerno);


    /**
     *
     * 方法说明：根据申请号和保单号校验表中 是否存在数据
     * @time 2019-06-01
     */
    LstIqpInfo selectByApplNoAndListSerno(@Param("applNo") String applNo, @Param("listSerno") String listSerno);
    
    /**
   * 查询保险止期之内的所有重农商借呗的数据
   * @Description
   * @date 2019年9月26日  
   * @return
   */
  List<LstIqpInfo> selectLstIqpListByCqnsjb(String currentDate);
  /**
   * 查询逾期买断期数
   * @Description
   * @date 2019年11月13日  
   * @return
   */
  BigDecimal selectSurrenderNo(String serno);
}