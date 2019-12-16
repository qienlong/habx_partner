package cn.com.sinosafe.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Project : Java EE �?��平台 <br>
 * Description : Spring工具�?<br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2017-4-17<br>
 */
@Component
public class SpringUtils implements ApplicationContextAware {
	
	/**
	 * Spring容器
	 */
	private static ApplicationContext context = null;
	
	/**
	 * 实现ApplicationContextAware接口
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
	{
		context = applicationContext;
	}
	
	/**
	 * Spring容器是否已经初始�?	 * @return
	 */
	public static boolean hasInit(){
		return context != null;
	}
	
	/**
     * 获取当前环境
     * @return
     */
    public static String getActiveProfile() {
        return context.getEnvironment().getActiveProfiles()[0];

    }
	
	/**
	 * 获取Spring容器
	 * @return
	 * @throws Exception 
	 */
	public static ApplicationContext getApplicationContext() throws Exception{
		if(context==null){
			throw new Exception("Spring容器尚未初始化");
		}
		return context;
	}
	
	/**
	 * 根据name获取容器中配置的Bean
	 * @param name
	 * @return
	 * @throws Exception 
	 * @throws BeansException 
	 */
	public static Object getBean(String name) throws Exception{
		return getApplicationContext().getBean(name);
	}
	
	/**
	 * 根据Class获取容器中配置的Bean
	 * @param cls
	 * @return
	 * @throws Exception 
	 */
	public static <E>E getBean(Class<E> cls) throws Exception{
		try{
			return getApplicationContext().getBean(cls);	
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 根据名字和Class获取容器中配置的Bean
	 * @param name
	 * @param cls
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public static <E>E getBean(String name, Class<E> cls) throws Exception{
		return getApplicationContext().getBean(name, cls);
	}
	
	/**
	 * 获取同一Class的所有配�?	 * @param cls
	 * @return
	 */
	public static <E> Map<String, E> getBeansOfType(Class<E> cls) throws Exception{
		return getApplicationContext().getBeansOfType(cls);
	}
	
	/**
	 * 获取同一Class的所有配�?	 * @param cls
	 * @return
	 */
	public static <E> List<E> getBeanslistOfType(Class<E> cls) throws Exception{
		Map<String, E> map = getBeansOfType(cls);
		if(null != map){
			List<E> list = new ArrayList<E>(map.size());
			for(E bean : map.values()){
				list.add(bean);
			}
			return list;
		}
		return null;
	}
	
	/**
	 * 获取服务器IP地址
	 * @Description
	 * @date 2019年9月2日  
	 * @return
	 */
	public static String  getServerIp(){
		String serverIp="";
		try {
			InetAddress address = InetAddress.getLocalHost();
			serverIp = address.getHostAddress();//获取IP地址
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
         return serverIp;
     }
}
