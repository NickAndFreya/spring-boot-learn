package com.freya.mybatis.dynamic.datasource.properties;

import com.freya.mybatis.dynamic.datasource.constant.DSConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 15:58
 */
@Data
@Component
@ConfigurationProperties(prefix = DSConfig.DRUID_COMMON_CONFIG_PREFIX)
public class DruidCommonProperties {
	int initialSize;

	int minIdle;

	long maxActive;

	long maxWait;

	long timeBetweenEvictionRunsMillis;

	long minEvictableIdleTimeMillis;

	String validationQuery;

	int validationQueryTimeout;

	Boolean testOnBorrow;

	Boolean testWhileIdle;

	Boolean testOnReturn;

	Boolean poolPreparedStatements;

	int maxPoolPreparedStatementPerConnectionSize;

	String filters;

	Boolean removeAbandoned;

	long removeAbandonedTimeoutMillis;

	Boolean logAbandoned;
}
