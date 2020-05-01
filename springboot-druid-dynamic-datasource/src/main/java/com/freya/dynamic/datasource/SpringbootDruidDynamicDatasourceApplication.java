package com.freya.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.freya.dynamic.datasource.business.mapper"})
public class SpringbootDruidDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDruidDynamicDatasourceApplication.class, args);
    }

}
