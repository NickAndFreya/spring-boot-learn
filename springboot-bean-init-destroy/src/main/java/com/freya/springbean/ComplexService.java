package com.freya.springbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 20:32
 */
@Slf4j
public class ComplexService implements InitializingBean, DisposableBean {

	@PostConstruct
	public void init() {
		log.info("hello @PostConstruct");
	}

	@PreDestroy
	public void PreDestroy() {
		log.info("hello @PreDestroy");
	}

	@Override
	public void destroy() throws Exception {
		log.info("bye DisposableBean...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("hello InitializingBean....");
	}

	public void xmlinit() {
		log.info("hello xml-init...");
	}

	public void xmlDestory() {
		log.info("bye xmlDestory...");
	}

	@EventListener(value = {ContextClosedEvent.class, ContextStartedEvent.class})
	public void receiveEvents(ApplicationEvent event) {
		if (event instanceof ContextClosedEvent) {
			log.info("bye ContextClosedEvent");
		} else if (event instanceof ContextStartedEvent) {
			log.info("hello ContextStartedEvent");
		}
	}

}
