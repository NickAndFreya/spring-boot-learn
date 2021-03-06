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

	/**
	 * version:接口的版本管理，可以通过这个对一个接口进行多版本控制
	 * cluster：集群容错，dubbo提供了五种集群容错模式，默认是failover，失败自动切换
	 * check：启动的时候是否对服务进行检查，默认是true
	 * async：是否支付异步调用，默认是false
	 * timeout：接口的最大响应时间，消费端的优先级大于服务提供端的优先级
	 * loadbalance：负载均衡模式，默认是随机模式
	 */

	@Reference(version = "${freya.server.version}", check = false, cluster = "failover", timeout = 5000, loadbalance = "random")
	private AnimalService service;

	@GetMapping("/animal")
	public Animal get() {
		return service.getAnimal();
	}
}
