package com.freya.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/10 11:27
 */
@RestController
@Api(tags = "测试")
public class HelloController {

	@ApiOperation(value = "Hello Word")
	@GetMapping("/hello")
	public String hello() {
		return "Hello Word";
	}
}
