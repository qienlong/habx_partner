package cn.com.sinosafe.dao;

import java.util.List;

import cn.com.sinosafe.domain.gbcn.request.InvoiceRequest.InvoiceRequestBody;

public interface GbcnInvoiceMapper {
    int deleteByPrimaryKey(String pkId);

    int insertSelective(InvoiceRequestBody record);

    InvoiceRequestBody selectByPrimaryKey(String pkId);
    
    List<InvoiceRequestBody> selectByPolicyNo(String policyNo);

    int updateByPrimaryKeySelective(InvoiceRequestBody record);

    List<InvoiceRequestBody> queryWithoutSend();

	int updateInvoiceStatus(InvoiceRequestBody record);
}