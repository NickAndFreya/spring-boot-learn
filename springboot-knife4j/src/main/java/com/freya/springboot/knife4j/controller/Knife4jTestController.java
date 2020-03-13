package com.freya.springboot.knife4j.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/13 0:17
 */
@RestController
@Api(tags = "Group1's Apis")
public class Knife4jTestController {

	@GetMapping("/knife4j")
	public String knife4jTest() {
		return "Hello Knife4j-1 !";
	}
}
