package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.gbcn.queryInvoice.InvoiceInfo;

public interface InvoiceInfoMapper {

    InvoiceInfo selectByPolicyNo(String policyNo);
}