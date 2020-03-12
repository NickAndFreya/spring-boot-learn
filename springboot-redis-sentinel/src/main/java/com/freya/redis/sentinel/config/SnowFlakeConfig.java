package com.freya.redis.sentinel.config;

import com.freya.redis.sentinel.util.SnowFlakeWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 11:12
 */
public class SnowFlakeConfig {

	@Bean
	@Scope("singleton")
	private SnowFlakeWorker getIdWorker() {
		return new SnowFlakeWorker(0, 0);
	}
}
