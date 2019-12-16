package cn.com.sinosafe.dao;
import cn.com.sinosafe.domain.entity.IqpMeCusApp;

public interface IqpMeCusAppMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(IqpMeCusApp record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(IqpMeCusApp record);
    
    
    /**
    *
    * 方法说明：
    * @time 2019-06-01
    */
   int updateByPrimaryKeySelective(IqpMeCusApp record);
   
   /**
    * 
   * @Title：deleteByPrimaryKey 
   * @Description：删除
   * @param ：@param serno
   * @param ：@return 
   * @return ：int 
   * @throws
    */
   int deleteByPrimaryKey(String serno);
   
   /**
   *
   * 方法说明：
   * @time 2019-06-01
   */
   IqpMeCusApp selectByPrimaryKey(String serno);
   
   
}