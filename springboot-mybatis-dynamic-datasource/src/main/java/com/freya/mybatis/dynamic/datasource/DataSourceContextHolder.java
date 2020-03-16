package com.freya.mybatis.dynamic.datasource;

import com.freya.mybatis.dynamic.datasource.constant.DSConfig;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 11:02
 */
public class DataSourceContextHolder {
	public static final String DEFAULT_DS = DSConfig.DB_MASTER;

	private static final ThreadLocal<String> DS_HOLDER = new ThreadLocal<>();

	public static void setDS(String dbType) {
		DS_HOLDER.set(dbType);
	}

	public static String getDS() {
		return DS_HOLDER.get();
	}

	public static void clearDS() {
		DS_HOLDER.remove();
	}
}
