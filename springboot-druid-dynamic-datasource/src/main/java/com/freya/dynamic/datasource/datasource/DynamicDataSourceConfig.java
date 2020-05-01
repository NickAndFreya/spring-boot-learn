package com.freya.dynamic.datasource.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 *
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource firstDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.third")
    public DataSource thirdDataSource() {
        return DruidDataSourceBuilder.create().build();
    }



    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource, DataSource thirdDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(SourceName.FIRST, firstDataSource);
        targetDataSources.put(SourceName.SECOND, secondDataSource);
        targetDataSources.put(SourceName.THIRD, thirdDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }
}
