package com.freya.springboot.knife4j.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/13 10:11
 */
@RestController
@Api(tags = "Group2's Apis")
public class Knife4jTest2Controller {

	@ApiOperation(value = "填加此注解的方法被归到Group2中")
	@PostMapping("/knife4j2")
	public String knife4jT() {
		return "Hello knife4j-2";
	}

}
