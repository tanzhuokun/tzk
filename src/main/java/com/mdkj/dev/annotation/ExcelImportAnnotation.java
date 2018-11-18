package com.mdkj.dev.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * 
 * 描述:自定义EXCEL主键，也作其他用途
 *
 * @type_name 类名:ExcelImportAnnotation
 * @project_name 项目:HealthPlatform
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelImportAnnotation {

	String propertyName() default "";

	String fieldName() default "";

	String fieldType() default "varchar";

	String chineseName() default "";

	boolean allowNull() default true;

	boolean autoIncrementKey() default false;
}