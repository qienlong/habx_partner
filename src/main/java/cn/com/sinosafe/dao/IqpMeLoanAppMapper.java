package cn.com.sinosafe.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.IqpMeLoanApp;

public interface IqpMeLoanAppMapper {
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
    int insert(IqpMeLoanApp record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(IqpMeLoanApp record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    IqpMeLoanApp selectByPrimaryKey(String serno);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKeySelective(IqpMeLoanApp record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKey(IqpMeLoanApp record);
    
    /**
     * 
    * @Title：getCountBySerno 
    * @Description：查询该用户是否申请过
    * @param ：@param serno
    * @param ：@return 
    * @return ：int 
    * @throws
     */
    int getCountBySerno(String serno);
    /**
     * 
     * @Title：getCancelBySerno
     * @Description：查询是否之前是否注销过
     * @param ：@param serno
     * @param ：@return 
     * @return ：int 
     * @throws
     */
    int getCancelBySerno(String serno);
    /**
     * 
     * @Title：getCancelBySerno
     * @Description：查询是否之前是否申请过
     * @param ：@param serno
     * @param ：@return 
     * @return ：int 
     * @throws
     */
    int getIqpSucBySerno(String serno);
    /**
     * 
     * getIqpSucSignBySerno
     * @Description：查询是否之前是否申请过且已签署
     * @param ：@param serno
     * @param ：@return 
     * @return ：int 
     * @throws
     */
    int getIqpSucSignBySerno(String serno);
    
    /**
     * 
     * @Title：getCountBySerno 
     * @Description：根据证件号查询该用户是否存在申请中的
     * @param ：@param serno
     * @param ：@return 
     * @return ：int 
     * @throws
     */
    int getCountById(String serno);
    
    
    /**
     * 
    * @Title：getCountBySernoAndSatus
    * @Description：根据申请号查询已核保的数据
    * @param IqpMeLoanApp
    * @param ：@return 
    * @return ：int 
    * @throws
     */
    IqpMeLoanApp getBySernoAndSatus(IqpMeLoanApp iqpMeLoanApp);

    /**
     * 根据借据协议编号查询已有数据
     */
    IqpMeLoanApp getByAccAgreeNo(String accAgreeNo);

    String getContNoByAccAgreeNo(String accAgreeNo);
    
    List<HashMap<String,Object>> selectCusSignIqpInfo(@Param("cusName")String cusName,@Param("certCode")String certCode);

}