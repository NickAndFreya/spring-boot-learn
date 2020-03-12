package com.freya.redis.sentinel.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 11:10
 */
@EnableCaching
@Slf4j
public class RedisConfig extends CachingConfigurerSupport {
	@Value("${redis.key.expiredsecond}")
	private Long expiredsecond;

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
		//配置缓存过期时间为60s
		log.info("expired second time 【{}】", expiredsecond);
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofSeconds(expiredsecond < 60 ? 60 : expiredsecond))
				.disableCachingNullValues();

		return RedisCacheManager.builder(factory)
				.cacheDefaults(config)
				.transactionAware()
				.build();
	}

	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		// 设置key序列化类，否则key前面会多了一些乱码
		RedisSerializer keySerializer = new StringRedisSerializer();
		template.setKeySerializer(keySerializer);
		//设置value序列化
		setValueSerializer(template);
		template.afterPropertiesSet();
		template.setEnableTransactionSupport(true);
		return template;
	}

	private void setValueSerializer(StringRedisTemplate template) {
		@SuppressWarnings({"rawtypes", "unchecked"})
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
	}
}
