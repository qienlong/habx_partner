package cn.com.sinosafe.dao;

import java.util.List;

import cn.com.sinosafe.domain.gbcn.request.SurrendRequest.SurrendRequestBody;

public interface GbcnSurrendMapper {
    int deleteByPrimaryKey(String pkId);

    int insertSelective(SurrendRequestBody record);

    SurrendRequestBody selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(SurrendRequestBody record);

    List<SurrendRequestBody> queryWithoutSend();
    
    List<SurrendRequestBody> selectByPolicyNo(String policyno);
    
    int updateSurrendStatus(SurrendRequestBody record);

    SurrendRequestBody queryHasSendByPolicyNo(String policyno);

    //查询退保审批意见
    String queryAdviceByPolicyNo(String policyno);
}