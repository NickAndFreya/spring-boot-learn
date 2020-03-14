package com.freya.dubbo.server2.controller;

import com.freya.dubbo.api.model.Person;
import com.freya.dubbo.api.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/14 19:54
 */
@RestController
@Slf4j
public class AnimalController {
	@Reference(version = "${freya.server.version}",check = false,cluster = "failover",timeout = 5000,loadbalance = "random")
	private PersonService service;

	@GetMapping("/person")
	public Person get(){
		log.info("Person:【{}】",service.obtainInfo().toString());
		return service.obtainInfo();
	}

}
