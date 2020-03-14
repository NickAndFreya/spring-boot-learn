package com.freya.botain.system.config.conf;

import com.freya.botain.system.config.conf.property.factorybean.PropertiesConfig;
import com.freya.botain.system.config.conf.property.source.OpenIdPropertiesConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 16:27
 */
@Configuration
@Import({OpenIdPropertiesConfig.class, PropertiesConfig.class})
public class MainConfig {

}
