package cn.com.sinosafe.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.CusBase;

public interface CusBaseMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int deleteByPrimaryKey(String cusId);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(CusBase record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(CusBase record);

    /**
     *
     * 方法说明：不在sql中生成cusId
     * @time 2019-11-07
     */
    int insertSelective2(CusBase record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    CusBase selectByPrimaryKey(String cusId);
    
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    CusBase selectCusInfoByNameId(@Param("cusName")String cusName, @Param("certCode")String certCode);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKeySelective(CusBase record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKey(CusBase record);
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    String createCusId();

    CusBase queryByCertCode(String certCode);
}