package cn.com.sinosafe.domain.gbcn.request;



/**
 * 工保统一入参
 * @author FanKun
 * @date   2019年9月23日 下午3:56:22
 * @param <T>
 */
public class GBRequest<T>{
	
	private T obj;
	
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}	
