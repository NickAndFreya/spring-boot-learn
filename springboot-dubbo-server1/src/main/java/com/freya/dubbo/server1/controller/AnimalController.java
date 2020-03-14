package com.freya.dubbo.server1.controller;

import com.freya.dubbo.api.model.Animal;
import com.freya.dubbo.api.service.AnimalService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/14 22:04
 */
@RestController
public class AnimalController {

	@Reference(version = "${freya.server.version}", check = false, cluster = "failover", timeout = 5000, loadbalance = "random")
	private AnimalService service;

	@GetMapping("/animal")
	public Animal get() {
		return service.getAnimal();
	}
}
