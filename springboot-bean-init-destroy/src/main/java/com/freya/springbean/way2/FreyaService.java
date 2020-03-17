package com.freya.springbean.way2;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 17:15
 */
@ToString
@Slf4j
public class FreyaService implements InitializingBean, DisposableBean {
	private String name;

	public FreyaService() {
		this.name = "Freya";
	}

	public FreyaService(String name) {
		this.name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("FreyaService afterPropertiesSet:【{}】", name);
	}

	@Override
	public void destroy() throws Exception {
		log.info("Spring Container closeed,FreyaService destroy:【{}】", this);
	}
}
