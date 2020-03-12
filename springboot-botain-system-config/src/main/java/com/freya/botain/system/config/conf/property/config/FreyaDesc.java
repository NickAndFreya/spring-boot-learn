package com.freya.botain.system.config.conf.property.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 16:56
 */
@Component
@ConfigurationProperties(prefix = "freya.desc")
@Data
@Accessors(chain = true)
public class FreyaDesc {
	private String name;
}
