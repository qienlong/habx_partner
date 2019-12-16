package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.IqpMeAuditOpinion;
import cn.com.sinosafe.domain.entity.IqpMeAuditOpinionKey;

public interface IqpMeAuditOpinionMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int deleteByPrimaryKey(IqpMeAuditOpinionKey key);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(IqpMeAuditOpinion record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(IqpMeAuditOpinion record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    IqpMeAuditOpinion selectByPrimaryKey(IqpMeAuditOpinionKey key);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKeySelective(IqpMeAuditOpinion record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKey(IqpMeAuditOpinion record);
    
    
    /**
    *
    * 方法说明：根据申请号和客户号更新审批风控决议表
    * @time 2019-06-01
    */
   int updateBySernoAndCustIdSelective(IqpMeAuditOpinion record);
}