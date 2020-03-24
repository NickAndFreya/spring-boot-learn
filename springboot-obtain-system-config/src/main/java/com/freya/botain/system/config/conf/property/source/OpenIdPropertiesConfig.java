package com.freya.botain.system.config.conf.property.source;

import com.freya.botain.system.config.conf.property.source.OpenIdProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 16:30
 */
//@PropertySource("classpath:openid.properties")
@PropertySource(value="openid.properties")
public class OpenIdPropertiesConfig {
	@Autowired
	private Environment environment;

	@Bean
	public OpenIdProperties openIdProperties() {
		OpenIdProperties properties = new OpenIdProperties().setOpenId(environment.getRequiredProperty("define.openid"));
		return properties;
	}

}
