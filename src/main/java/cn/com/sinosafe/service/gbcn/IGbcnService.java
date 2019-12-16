package cn.com.sinosafe.service.gbcn;

import cn.com.sinosafe.domain.gbcn.ResponseBody;
import cn.com.sinosafe.domain.gbcn.claim.ClaimRequest;
import cn.com.sinosafe.domain.gbcn.correct.CorrectRequest;
import cn.com.sinosafe.domain.gbcn.correct.CorrectResponseBody;
import cn.com.sinosafe.domain.gbcn.invoice.InvoiceRequest;
import cn.com.sinosafe.domain.gbcn.surrend.SurrendRequest;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-09-02
 */
public interface IGbcnService {

    ResponseBody claimAccept(ClaimRequest claimRequest);

    CorrectResponseBody correctAccept(CorrectRequest correctRequest);

    ResponseBody surrendAccept(SurrendRequest surrendRequest);

    ResponseBody invoiceAccept(InvoiceRequest invoiceRequest);
}
