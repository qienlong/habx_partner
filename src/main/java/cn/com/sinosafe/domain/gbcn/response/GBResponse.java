package cn.com.sinosafe.domain.gbcn.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 工保网统一xml返回
 * @author FanKun
 * @date   2019年9月23日 下午2:37:56
 * @param <T>
 */
public class GBResponse<T> {
	
	private T obj;
	
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	/**
	 * 投保
	 */
	@XmlRootElement(name ="InsureResponse")
	public static class InsureResponse extends BaseResponse{
		public InsureResponse () {
			super();
		}
		public InsureResponse (ResponseHead responseHead,ResponseBody responseBody) {
			super(responseHead,responseBody);
		}
		public static GBResponse<InsureResponse> getInstance(){
			GBResponse<InsureResponse> gbResult = new GBResponse<InsureResponse>();
	    	gbResult.setObj(new InsureResponse());
	    	return gbResult;
		}
	}
	
	/**
	 * 理赔
	 */
	@XmlRootElement(name ="claimResponse")
	public static class ClaimResponse extends BaseResponse{
		public ClaimResponse () {
			super();
		}
		public ClaimResponse (ResponseHead responseHead,ResponseBody responseBody) {
			super(responseHead,responseBody);
		}
		public static GBResponse<ClaimResponse> getInstance(){
			GBResponse<ClaimResponse> gbResult = new GBResponse<ClaimResponse>();
	    	gbResult.setObj(new ClaimResponse());
	    	return gbResult;
		}
	}
	
	/**
	 * 批改
	 */
	@XmlRootElement(name ="correctResponse")
	public static class CorrectResponse extends BaseResponse{
		public CorrectResponse () {
			super();
		}
		public CorrectResponse (ResponseHead responseHead,ResponseBody responseBody) {
			super(responseHead,responseBody);
		}
		public static GBResponse<CorrectResponse> getInstance(){
			GBResponse<CorrectResponse> gbResult = new GBResponse<CorrectResponse>();
	    	gbResult.setObj(new CorrectResponse());
	    	return gbResult;
		}
	}
	
	/**
	 * 申请发票
	 */
	@XmlRootElement(name ="invoiceResponse")
	public static class InvoiceResponse extends BaseResponse{
		public InvoiceResponse () {
			super();
		}
		public InvoiceResponse (ResponseHead responseHead,ResponseBody responseBody) {
			super(responseHead,responseBody);
		}
		public static GBResponse<InvoiceResponse> getInstance(){
			GBResponse<InvoiceResponse> gbResult = new GBResponse<InvoiceResponse>();
	    	gbResult.setObj(new InvoiceResponse());
	    	return gbResult;
		}
	}
	
	/**
	 * 退保
	 */
	@XmlRootElement(name ="surrendResponse")
	public static class SurrendResponse extends BaseResponse	{
		public SurrendResponse () {
			super();
		}
		public SurrendResponse (ResponseHead responseHead,ResponseBody responseBody) {
			super(responseHead,responseBody);
		}
		public static GBResponse<SurrendResponse> getInstance(){
			GBResponse<SurrendResponse> gbResult = new GBResponse<SurrendResponse>();
	    	gbResult.setObj(new SurrendResponse());
	    	return gbResult;
		}
	}

}
