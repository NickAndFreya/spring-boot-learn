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
@MapperScan(basePackages = "com.freya.druid.multi.mapper.master", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDatasourceConfig {
	@Bean(name = "masterDataSource")
	//下面这个注解控制哪个实例优先被注入，我们放在第一个数据源上面
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.druid.master")
	public DataSource dataSource() {
		return new DruidDataSource();
	}

	@Bean(name = "masterSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "masterTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "masterSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
			throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
