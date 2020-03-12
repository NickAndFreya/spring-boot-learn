package com.freya.botain.system.config.conf.property.source;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 16:29
 */
@Data
@Accessors(chain = true)
public class OpenIdProperties {
	private String openId;
}
