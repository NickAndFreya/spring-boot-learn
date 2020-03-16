package com.freya.mybatis.dynamic.datasource.properties;

import com.freya.mybatis.dynamic.datasource.constant.DSConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 11:29
 */
@Data
@Component
@ConfigurationProperties(prefix = DSConfig.MASTER_DATASOURCE_PREFIX)
public class DruidMasterProperties {
	String driverClassName;

	String url;

	String username;

	String password;


}
