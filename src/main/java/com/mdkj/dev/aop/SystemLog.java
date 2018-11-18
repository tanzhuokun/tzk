package com.mdkj.dev.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * 描述:日志配置
 *
 * @type_name 类名:SystemLog
 * @project_name 项目:HealthPlatform
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface SystemLog {
	String message()  default "";  
	String methods()  default ""; 
	String logType()  default "普通操作"; 
}
