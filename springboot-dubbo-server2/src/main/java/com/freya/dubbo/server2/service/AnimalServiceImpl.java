package com.freya.dubbo.server2.service;

import com.freya.dubbo.api.model.Animal;
import com.freya.dubbo.api.service.AnimalService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/14 21:16
 */
@Service(version = "${freya.server.version}")
public class AnimalServiceImpl implements AnimalService {

	@Override
	public Animal getAnimal() {
		return Animal.builder().id(1).name("cat").build();
	}
}
