package cn.com.sinosafe.service.xd;


/**
 * 
 * 小贷对接接口 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
public interface XdService<T1,T2> {

    T1 process(T2 param) throws Exception;
    
}
