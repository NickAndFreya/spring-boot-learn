package com.freya.springbean.way1.config;

import com.freya.springbean.way1.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 17:00
 */
@Configuration
public class BeanConfig {

	@Bean(name = "message", initMethod = "init", destroyMethod = "destroy")
	public MessageService messageService() {
		return MessageService.builder().message("hello world").build();
	}
}
