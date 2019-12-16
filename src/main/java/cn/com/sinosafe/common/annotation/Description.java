package cn.com.sinosafe.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Project : Java EE 开发平台 <br>
 * Description : 描述注解 <br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2017-2-9<br>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description
{
	String value();
}
