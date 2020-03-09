package com.freya.druid.multi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:08
 */
@MapperScan(basePackages = "com.freya.druid.multi.mapper.db1", sqlSessionTemplateRef  = "db1SqlSessionTemplate")
public class DB1DatasourceConfig {
	@Bean(name = "db1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.db1")
	public DataSource dataSource() {
		return  new DruidDataSource();
	}

	@Bean(name = "db1SqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "db1TransactionManager")
	@Primary
	public DataSourceTransactionManager transactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "db1SqlSessionTemplate")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory)
			throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
