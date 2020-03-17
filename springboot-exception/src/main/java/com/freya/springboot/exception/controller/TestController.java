package com.freya.springboot.exception.controller;

import com.freya.springboot.exception.exception.IllegalPropertiesException;
import com.freya.springboot.exception.exception.NullOrEmptyException;
import com.freya.springboot.exception.exception.SessionNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 11:46
 */
@RestController
@RequestMapping("/test")
public class TestController {
	@GetMapping("/user/{param}")
	public ResponseEntity<?> save(@PathVariable String param) throws Exception {
		if ("a".equals(param)) {
			throw new IllegalPropertiesException();
		}
		if ("b".equals(param)) {
			throw new SessionNotFoundException();
		}
		if ("c".equals(param)) {
			throw new NullOrEmptyException(param);
		}
		return ResponseEntity.ok("Successful");
	}
}
