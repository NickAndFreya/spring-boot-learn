package com.freya.mybatis.dynamic.datasource.annotation;

import com.freya.mybatis.dynamic.datasource.constant.DSConfig;

import java.lang.annotation.*;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 11:07
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DS {
	String value() default DSConfig.DB_MASTER;
}
