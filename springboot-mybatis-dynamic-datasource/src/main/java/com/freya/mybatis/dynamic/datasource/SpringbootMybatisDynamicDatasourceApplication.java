package com.freya.mybatis.dynamic.datasource;

import com.freya.mybatis.dynamic.datasource.annotation.EnableMybatis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableMybatis
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootMybatisDynamicDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDynamicDatasourceApplication.class, args);
	}

}
