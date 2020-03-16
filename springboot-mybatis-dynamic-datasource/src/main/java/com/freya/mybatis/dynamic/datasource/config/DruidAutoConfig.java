package com.freya.mybatis.dynamic.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import com.freya.mybatis.dynamic.datasource.constant.DSConfig;
import com.freya.mybatis.dynamic.datasource.properties.DruidCommonProperties;
import com.freya.mybatis.dynamic.datasource.properties.DruidMasterProperties;
import com.freya.mybatis.dynamic.datasource.properties.DruidSlaveProperties;
import com.freya.mybatis.dynamic.datasource.servlet.DruidStatViewServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 10:54
 */
@Slf4j
@Configuration
@Import({PropertiesConfig.class})
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = DSConfig.DS_PREFIX, value = DSConfig.DS_ACTIVE, havingValue = DSConfig.DRUID)
public class DruidAutoConfig implements DSConfig {
	@Autowired
	private Environment env;

	@Bean(name = DB_MASTER)
	public DataSource dataSourceMaster(DruidMasterProperties masterProperties, DruidCommonProperties commonProperties) throws SQLException {
		log.debug("master properties : 【{}】", masterProperties.toString());
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(masterProperties.getDriverClassName());
		dds.setUrl(masterProperties.getUrl());
		dds.setUsername(masterProperties.getUsername());
		dds.setPassword(masterProperties.getPassword());
		dds.setInitialSize(commonProperties.getInitialSize());
		dds.setMinIdle(commonProperties.getMinIdle());
		dds.setMaxActive(commonProperties.getInitialSize());
		dds.setMaxWait(commonProperties.getMaxWait());
		dds.setTimeBetweenEvictionRunsMillis(commonProperties.getTimeBetweenEvictionRunsMillis());
		dds.setMinEvictableIdleTimeMillis(commonProperties.getMinEvictableIdleTimeMillis());
		dds.setValidationQuery(commonProperties.getValidationQuery());
		dds.setValidationQueryTimeout(commonProperties.getValidationQueryTimeout());
		dds.setTestWhileIdle(commonProperties.getTestWhileIdle());
		dds.setTestOnReturn(commonProperties.getTestOnReturn());
		dds.setPoolPreparedStatements(commonProperties.getPoolPreparedStatements());
		dds.setMaxPoolPreparedStatementPerConnectionSize(commonProperties.getMaxPoolPreparedStatementPerConnectionSize());
		dds.setFilters(commonProperties.getFilters());
		dds.setRemoveAbandoned(commonProperties.getRemoveAbandoned());
		dds.setRemoveAbandonedTimeoutMillis(commonProperties.getRemoveAbandonedTimeoutMillis());
		dds.setLogAbandoned(commonProperties.getLogAbandoned());
		return dds;
	}

	@Bean(name = DB_SLAVE)
	public DataSource dataSourceSlave(DruidSlaveProperties slaveProperties,DruidCommonProperties commonProperties) throws SQLException {
		log.info("slave properties : 【{}】", slaveProperties.toString());
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(slaveProperties.getDriverClassName());
		dds.setUrl(slaveProperties.getUrl());
		dds.setUsername(slaveProperties.getUsername());
		dds.setPassword(slaveProperties.getPassword());
		dds.setInitialSize(commonProperties.getInitialSize());
		dds.setMinIdle(commonProperties.getMinIdle());
		dds.setMaxActive(commonProperties.getInitialSize());
		dds.setMaxWait(commonProperties.getMaxWait());
		dds.setTimeBetweenEvictionRunsMillis(commonProperties.getTimeBetweenEvictionRunsMillis());
		dds.setMinEvictableIdleTimeMillis(commonProperties.getMinEvictableIdleTimeMillis());
		dds.setValidationQuery(commonProperties.getValidationQuery());
		dds.setValidationQueryTimeout(commonProperties.getValidationQueryTimeout());
		dds.setTestWhileIdle(commonProperties.getTestWhileIdle());
		dds.setTestOnReturn(commonProperties.getTestOnReturn());
		dds.setPoolPreparedStatements(commonProperties.getPoolPreparedStatements());
		dds.setMaxPoolPreparedStatementPerConnectionSize(commonProperties.getMaxPoolPreparedStatementPerConnectionSize());
		dds.setFilters(commonProperties.getFilters());
		dds.setRemoveAbandoned(commonProperties.getRemoveAbandoned());
		dds.setRemoveAbandonedTimeoutMillis(commonProperties.getRemoveAbandonedTimeoutMillis());
		dds.setLogAbandoned(commonProperties.getLogAbandoned());
		return dds;
	}

	@Bean
	public ServletRegistrationBean druidServletRegistrationBean() {
		String username = env.getProperty(DSConfig.DRUID_MONITOR_USERNAME);
		String password = env.getProperty(DSConfig.DRUID_MONITOR_PASSWORD);
		return new ServletRegistrationBean(new DruidStatViewServlet(username, password), DSConfig.DRUID_MONITOR_URL);
	}

	@Bean
	public FilterRegistrationBean druidFilterRegistrationBean() {
		WebStatFilter wsf = new WebStatFilter();
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(wsf);
		filterRegistrationBean.setUrlPatterns(Arrays.asList(DSConfig.DRUID_FILTER_URL));
		filterRegistrationBean.setInitParameters(Collections.singletonMap("exclusions", DSConfig.DRUID_FILTER_EXCLUSIONS));
		return filterRegistrationBean;
	}

}
