package com.freya.springboot.knife4j.controller;

import com.freya.springboot.knife4j.models.Freya;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/13 0:17
 */
@RestController
@Api(tags = "Group1's Apis")
@RequestMapping("/freya")
public class Knife4jTestController {

	@GetMapping("/knife4j")
	public Freya knife4jTest() {
		return Freya.builder().name("freya").hobby("eating").weight(70).build();
	}
}
