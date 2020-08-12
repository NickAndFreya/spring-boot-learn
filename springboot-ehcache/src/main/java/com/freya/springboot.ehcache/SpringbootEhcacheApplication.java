package com.freya.springboot.ehcache;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableCaching
@RestController
@Slf4j
public class SpringbootEhcacheApplication {
    @Resource
    private CacheManager cacheManager;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEhcacheApplication.class, args);
    }

    @GetMapping("ehcache-test")
    public String test() {
        Cache cache = cacheManager.getCache("testCache");
        String test = cache.get("test", String.class);
        if (StringUtils.isNotBlank(test)) {
            log.info("data from ehcache!");
            return test;
        }
        String freya = "Hello world!";
        cache.put("test", freya);
        return freya;
    }
}
