package com.freya.springboothikaricp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/11 14:51
 */
@Configuration
@MapperScan({"com.freya.springboothikaricp.mapper"})
public class MybatisConfig {

}
