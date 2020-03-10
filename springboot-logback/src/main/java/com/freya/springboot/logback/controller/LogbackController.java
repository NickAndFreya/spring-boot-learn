package com.freya.springboot.logback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/10 16:26
 */
@RestController
public class LogbackController {

	@GetMapping("/hi")
	public String hi(){
		return "Hi Logback!";
	}
}
