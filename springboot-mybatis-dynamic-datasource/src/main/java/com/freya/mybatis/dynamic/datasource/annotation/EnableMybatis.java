package com.freya.mybatis.dynamic.datasource.annotation;

import com.freya.mybatis.dynamic.datasource.config.MybatisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 10:44
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MybatisConfig.class)
public @interface EnableMybatis {
}
