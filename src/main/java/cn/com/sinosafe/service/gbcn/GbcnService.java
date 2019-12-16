package cn.com.sinosafe.service.gbcn;


public interface GbcnService<T1,T2> {
	
	public T1 process(T2 param) throws Exception;

}