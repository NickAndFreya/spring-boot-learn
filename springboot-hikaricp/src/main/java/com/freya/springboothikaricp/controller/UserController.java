package com.freya.springboothikaricp.controller;

import com.freya.springboothikaricp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/11 14:42
 */
@RestController
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/list")
	public List<Map<String, String>> getUserList() {
		return service.getUserList();
	}
}
