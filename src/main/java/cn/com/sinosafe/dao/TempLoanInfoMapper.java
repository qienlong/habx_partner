package cn.com.sinosafe.dao;


import cn.com.sinosafe.domain.entity.TempLoanInfo;

public interface TempLoanInfoMapper {
    /**
     *
     * 方法说明：
     * @time 2019-07-08
     */
    int deleteByPrimaryKey(String uuid);

    /**
     *
     * 方法说明：
     * @time 2019-07-08
     */
    int insert(TempLoanInfo record);

    /**
     *
     * 方法说明：
     * @time 2019-07-08
     */
    int insertSelective(TempLoanInfo record);

    /**
     *
     * 方法说明：
     * @time 2019-07-08
     */
    TempLoanInfo selectByPrimaryKey(String uuid);

    /**
     *
     * 方法说明：
     * @time 2019-07-08
     */
    int updateByPrimaryKeySelective(TempLoanInfo record);

    /**
     *
     * 方法说明：
     * @time 2019-07-08
     */
    int updateByPrimaryKey(TempLoanInfo record);
}