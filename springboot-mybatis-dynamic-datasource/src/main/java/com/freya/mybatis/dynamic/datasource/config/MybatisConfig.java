package com.freya.mybatis.dynamic.datasource.config;

import com.freya.mybatis.dynamic.datasource.DynamicDataSource;
import com.freya.mybatis.dynamic.datasource.constant.DSConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 10:49
 */
@Configuration
@MapperScan(basePackages = DSConfig.MYBATIS_BASE_PACKAGES)//mapper 路径配置
public class MybatisConfig implements DSConfig {

	@Primary
	@Bean
	public DynamicDataSource dynamicDataSource(@Qualifier(DB_MASTER) DataSource master,
											   @Qualifier(DB_SLAVE) DataSource slave) {
		Map<Object, Object> dsMap = new HashMap<>();
		dsMap.put(DB_MASTER, master);
		dsMap.put(DB_SLAVE, slave);
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		dynamicDataSource.setDefaultTargetDataSource(master);
		dynamicDataSource.setTargetDataSources(dsMap);
		return dynamicDataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DynamicDataSource dynamicDataSource) {
		return new DataSourceTransactionManager(dynamicDataSource);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dynamicDataSource);
		sessionFactory.setMapperLocations(((ResourcePatternResolver) new PathMatchingResourcePatternResolver())
				.getResources(DSConfig.MYBATIS_MAPPER_LOCATIONS));//mapper.xml路径配置
		return sessionFactory.getObject();
	}
}
