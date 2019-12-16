package cn.com.sinosafe.common.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.AspectUtils;
import cn.com.sinosafe.common.util.CommonUtils;
import cn.com.sinosafe.common.util.IpAddressUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;

/**
 * 操作日志打印  <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年3月2日<br>
 */
@Aspect
@Component
public class LogAspect
{
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
	AspectUtils aspectUtils;
    @Autowired
    CommonUtils commonUtils;
    
    /**
     * 拦截类注解
     */
    @Pointcut("@within(cn.com.sinosafe.common.annotation.Log)")
    public void logPointCut()
    {
    }
    
    /**
     * 拦截方法注解
     */
    @Pointcut("@annotation(cn.com.sinosafe.common.annotation.Log)")
    public void logMethodPointCut()
    {
    }

    /**
     * 前置通知 用于拦截操作
     *
     * @param joinPoint 切点
     * @throws Throwable 
     */
    @Around(value = "logPointCut() || logMethodPointCut()")
    public Object doBefore(ProceedingJoinPoint invocation) throws Throwable
    {
        return handleLog(invocation);
    }

    protected Object handleLog(final ProceedingJoinPoint joinPoint) throws Throwable
    {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	// 获得注解
        Log controllerLog = getAnnotationLog(joinPoint);
        if (controllerLog == null) { return null;}
        long start = System.currentTimeMillis();
        
        // 获取方法名称IP地址等
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String ip = IpAddressUtils.getIpAddr(request);
       
        // 获取请求参数集合并进行遍历拼接
        Map<String, Object> paramMap = aspectUtils.targetParamMap(joinPoint);
        // 针对平安普惠的特殊处理
        if (paramMap.get("id") != null) {
        	methodName = methodName + "/" + paramMap.get("id");
		}
        
        // 打印请求参数
        log.info("【请求自IP：{}】 ====>>>>【{}.{}】请求参数：{}", ip, className,methodName, paramMap.toString());
        
        Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			log.error("【"+className+"】【"+methodName+"】", e);
			if(e instanceof BusinessException) {
				result = new JsonProtocol().setupAsException(e);
			}else {
				result = new JsonProtocol().setup(ResultCode.SERVER_ERROR);
			}
			
			// 发送警报邮件
			commonUtils.exceptionMail(e, "接口名", className + "." + methodName, "参数为", paramMap.toString());
		}
		
		// 打印返回结果及耗时
        log.info("【响应给IP：{}】 <<<<====【{}.{}】耗时[{}ms]，返回结果：{}", ip, className,methodName,(System.currentTimeMillis()-start),JSON.toJSONString(result));
        return result;
    }

   /* private String getReqParams(ProceedingJoinPoint pjp) throws Exception {
        String reqParams = "";
        Object[] args = pjp.getArgs();
        if (args.length > 0) {
            if ("post".equalsIgnoreCase(ServletUtils.getRequest().getMethod())) {
                Object object = args[0];
                Map<String, Object> reqMap = getKeyAndValue(object);
                reqParams = JSON.toJSONString(reqMap);
            } else if ("get".equalsIgnoreCase(ServletUtils.getRequest().getMethod())) {
                reqParams = ServletUtils.getRequest().getQueryString();
            }
        }
        return reqParams;
    }*/
    
    /**
     * 反射获取POST请求参数
     * @param obj
     * @return
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Object> getKeyAndValue(Object obj) {
		Map<String, Object> paraMap = new HashMap<>();
		// 如果本来就是map则返回
		if (obj instanceof Map<?, ?>) {
			return (Map<String, Object>) obj;
		}
		// 得到类对象
		Class userCla = (Class) obj.getClass();
		// 得到类中的所有属性集合
		Field[] fs = userCla.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true); // 设置些属性是可以访问的
			Object val = new Object();
			try {
				val = f.get(obj);
				// 排除空值和文件
				if (StringUtils.isNotNull(val)) {
					paraMap.put(f.getName(), val);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return paraMap;
	}
  	
  	 /**
     * 是否存在注解，如果存在就获取
     */
    private Log getAnnotationLog(JoinPoint joinPoint) throws Exception
    {
    	// 判断class上是否有注解
    	Log log = joinPoint.getTarget().getClass().getAnnotation(Log.class);
    	if(log != null) {
    		return log;
    	}
    	
    	// 判断method上是否有注解
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(Log.class);
        }
        return null;
    }

}
