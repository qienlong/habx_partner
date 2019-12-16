package cn.com.sinosafe.common.util;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import cn.com.sinosafe.domain.entity.PAHAReq;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 切面工具类
 * @Author	: hesong
 * @Date	: 2019年1月2日 下午2:24:04
 * @Version	: 1.0
 */
@Component
public class AspectUtils {
	
	/**
	 * 获取请求头里面的信息
	 * @desc	: 获取请求头里面的信息
	 * @author	: hirson
	 * @date	: 2019年1月2日 下午3:07:36
	 * @param header
	 * @return	:
	 */
	public Object headerParam(String header) {
		RequestAttributes ra 			= RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra 	= (ServletRequestAttributes) ra;
		HttpServletRequest request 		= sra.getRequest();
		return request.getHeader(header);
	}
	
	/**
	 * 获取请求参数
	 * @desc	: 获取请求参数
	 * @author	: hirson
	 * @date	: 2019年1月10日 下午3:01:32
	 * @param joinPoint
	 * @return
	 * @throws Throwable	:
	 */
	public Map<String,Object > targetParamMap(JoinPoint joinPoint) throws Throwable{
        Class<?> clazz 		= Class.forName(joinPoint.getTarget().getClass().getName());  
        String clazzName 	= clazz.getName();
        //获取方法名称
        String methodName 	= joinPoint.getSignature().getName();  
        //获取所有的参数
        Object[] args 		= joinPoint.getArgs();
        //获取参数名称和值
        Map<String,Object > nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName, args); 
        return nameAndArgs;
	}
	
	/**
	 * 参数获取
	 * @desc	: 参数获取
	 * @author	: hirson
	 * @date	: 2019年1月2日 下午2:44:03
	 * @param cls
	 * @param clazzName
	 * @param methodName
	 * @param args
	 * @return
	 * @throws NotFoundException	:
	 */
	@SuppressWarnings("rawtypes")
	private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws NotFoundException { 
		Map<String,Object > map 	= new HashMap<String,Object>();
	    ClassPool pool 				= ClassPool.getDefault();  
	    ClassClassPath classPath 	= new ClassClassPath(cls);  
	    pool.insertClassPath(classPath);  
	    CtClass cc 					= pool.get(clazzName);  
	    CtMethod cm 				= cc.getDeclaredMethod(methodName);  
	    MethodInfo methodInfo 		= cm.getMethodInfo();
	    CodeAttribute codeAttribute = methodInfo.getCodeAttribute();  
	    LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);  
	    if (attr == null) {}
	    int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;  
	    for (int i = 0; i < cm.getParameterTypes().length; i++){  
	        map.put(attr.variableName(i + pos),getParamValue(args[i]));  
	    }
//	    map.put("methodName", methodName);
	    return map;  
	}
	
	/**
	 * 针对平安普惠做的特殊处理
	 * @author	: hirson
	 * @date	: 2019年6月21日 上午11:05:44
	 * @param obj
	 * @return	:
	 */
	private Object getParamValue(Object obj) {
		if (obj instanceof PAHAReq) {
			obj = ((PAHAReq) obj).getParam();
		}
		return obj;
	}
}
