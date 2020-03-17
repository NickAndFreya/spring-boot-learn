package com.freya.springbean.way3;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 19:36
 */
@Slf4j
public class EricService {
	private Eric eric;

	@PostConstruct
	public void init() {
		this.eric = Eric.builder().name("袁泽林").height(91).months(21).build();
		log.info("init a eric instance :【{}】", eric.toString());
	}

	@PreDestroy
	public void destroy() {
		this.eric = null;
		log.info("container close set  eric null :【{}】", this.eric);
	}
}
