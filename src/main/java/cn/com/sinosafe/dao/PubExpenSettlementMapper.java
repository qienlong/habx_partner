package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PubExpenSettlement;

public interface PubExpenSettlementMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-08
     */
    int insert(PubExpenSettlement record);

    /**
     *
     * 方法说明：
     * @time 2019-06-08
     */
    int insertSelective(PubExpenSettlement record);
    /**
     *
     * 方法说明：
     * @time 2019-06-08
     */
    int selectCountByMonth(PubExpenSettlement record);
}