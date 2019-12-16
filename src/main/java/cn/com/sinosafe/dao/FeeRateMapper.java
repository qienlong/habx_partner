package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.FeeRate;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface FeeRateMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-03
     */
    int deleteByPrimaryKey(String uuid);

    /**
     *
     * 方法说明：
     * @time 2019-06-03
     */
    int insert(FeeRate record);

    /**
     *
     * 方法说明：
     * @time 2019-06-03
     */
    int insertSelective(FeeRate record);

    /**
     *
     * 方法说明：
     * @time 2019-06-03
     */
    FeeRate selectByPrimaryKey(String uuid);

    /**
     *
     * 方法说明：
     * @time 2019-06-03
     */
    int updateByPrimaryKeySelective(FeeRate record);

    /**
     *
     * 方法说明：
     * @time 2019-06-03
     */
    int updateByPrimaryKey(FeeRate record);
    
    /**
    *
    * 方法说明：根据条件查询费率信息
    * @param FeeRate
    * @time 2019-06-03
    */
    FeeRate queryFeeRateInfo(FeeRate record);
    
    /**
    *
    * 方法说明：根据条件查询费率信息
    * @param FeeRate
    * @time 2019-06-03
    */
    FeeRate queryFeeRateInfoByIqp(IqpMeLoanApp iqpMeLoanApp);

    /**
     *
     * 方法说明：根据名称查字典code
     * @param  cnName
     * @time 2019-06-026
     */
    String querySdicForEnname(@Param("cnName") String cnName,@Param("opttype") String opttype);

    String getEnnameByOpttype(String opttype);
    
    String getCnnameByEnname(@Param("enName") String enName);

    String getCnnameByOpttypeAndEnname(Map<String,String> map);
}