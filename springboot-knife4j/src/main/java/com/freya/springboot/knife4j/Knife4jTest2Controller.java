package com.freya.springboot.knife4j;

import com.freya.springboot.knife4j.models.Nick;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/13 10:11
 */
@RestController
@Api(tags = "Group2's Apis")
@RequestMapping(value = "/nick")
public class Knife4jTest2Controller {

	@ApiOperation(value = "填加此注解的方法被归到Group2中")
	@PostMapping("/knife4j2")
	public Nick knife4jT() {
		return Nick.builder().name("nick").hobby("watching Movie").hight(183).build();
	}

}
