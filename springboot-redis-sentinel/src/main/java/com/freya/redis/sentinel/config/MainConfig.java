package com.freya.redis.sentinel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 11:13
 */
@Configuration
@Import({RedisConfig.class,SnowFlakeConfig.class})
public class MainConfig {
}
