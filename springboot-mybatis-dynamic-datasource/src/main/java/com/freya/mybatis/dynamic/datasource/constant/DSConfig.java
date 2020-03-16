package com.freya.mybatis.dynamic.datasource.constant;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 10:46
 */
public interface DSConfig {

	String DS_PREFIX = "spring.datasource";

	String DS_ACTIVE = "active";

	String DB_MASTER = "db-master";

	String DB_SLAVE = "db-slave";

	String DRUID = "druid";

	String DRUID_MONITOR_USERNAME = "spring.druid.username";

	String DRUID_MONITOR_PASSWORD = "spring.druid.password";

	String DRUID_MONITOR_URL = "/druid/*";

	String DRUID_FILTER_EXCLUSIONS = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";

	String DRUID_FILTER_URL = "/*";

	String MYBATIS_BASE_PACKAGES = "com.freya.**.mapper";

	String MYBATIS_MAPPER_LOCATIONS = "classpath:mapper/*.xml";

	String DRUID_COMMON_CONFIG_PREFIX = "com.alibaba.druid";

	String MASTER_DATASOURCE_PREFIX = "spring.dataspurce.druid.master";

	String SLAVE_DATASOURCE_PREFIX = "spring.dataspurce.druid.slave";


}
