package com.freya.redis.sentinel.controller;

import com.example.redissentinel.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/2/18 15:14
 */
@RestController
public class TestContoller {

	@Resource
	private RedisUtil redisUtil;

	@GetMapping("/")
	public void test(@RequestParam(value = "v") String string){
		String key = String.valueOf(System.currentTimeMillis());
		redisUtil.set(key,string,1000L);
	}

	@GetMapping("/get")
	public String get(){
		return (String) redisUtil.get("test");
	}
}
