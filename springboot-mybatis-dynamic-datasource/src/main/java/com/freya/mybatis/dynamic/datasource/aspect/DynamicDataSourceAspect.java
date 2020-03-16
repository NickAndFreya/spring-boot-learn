package com.freya.mybatis.dynamic.datasource.aspect;

import com.freya.mybatis.dynamic.datasource.DataSourceContextHolder;
import com.freya.mybatis.dynamic.datasource.annotation.DS;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 14:14
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
	@Before(value = "@annotation(com.freya.mybatis.dynamic.datasource.annotation.DS)")
	public void beforeSwitchDS(JoinPoint point) {
		Class<?> className = point.getTarget().getClass();
		String methodName = point.getSignature().getName();
		Class<?>[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
		String datasource = DataSourceContextHolder.DEFAULT_DS;
		try {
			Method method = className.getMethod(methodName, argClass);
			if (method.isAnnotationPresent(DS.class)) {
				DS annotation = method.getAnnotation(DS.class);
				datasource = annotation.value();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DataSourceContextHolder.setDS(datasource);
	}

	@After("@annotation(com.freya.mybatis.dynamic.datasource.annotation.DS)")
	public void afterSwitchDS(JoinPoint point) {
		DataSourceContextHolder.clearDS();

	}
}
