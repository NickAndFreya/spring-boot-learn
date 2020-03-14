package com.freya.dubbo.server1.service;

import com.freya.dubbo.api.model.Person;
import com.freya.dubbo.api.service.PersonService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/14 19:42
 */
@Service(version = "${freya.server.version}")
public class PersonServiceImpl implements PersonService {
	@Override
	public Person obtainInfo() {
		return new Person().setId(1).setBehavior("walking");
	}
}
