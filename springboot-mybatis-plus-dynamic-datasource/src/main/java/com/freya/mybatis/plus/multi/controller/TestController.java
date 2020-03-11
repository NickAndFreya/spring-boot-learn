package com.freya.mybatis.plus.multi.controller;

import com.freya.mybatis.plus.multi.service.DeptPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:29
 */
@RestController
public class TestController {

	@Autowired
	private DeptPeopleService service;


	@GetMapping("/dept")
	List<Map<String, Object>> getDept() {
		return service.getDeptList();
	}

	@GetMapping("/people")
	List<Map<String, Object>> getPeople() {
		return service.getPeopleList();
	}
}
