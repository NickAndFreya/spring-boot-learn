package com.freya.mybatis.dynamic.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 11:01
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		log.info("当前数据源为:【{}】", DataSourceContextHolder.getDS());
		return DataSourceContextHolder.getDS();
	}
}
