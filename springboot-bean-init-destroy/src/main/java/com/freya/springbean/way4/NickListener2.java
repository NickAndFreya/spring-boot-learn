package com.freya.springbean.way4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 20:14
 */
@Slf4j
public class NickListener2 {
	private Nick nick;

	@EventListener(value = {ContextRefreshedEvent.class, ContextClosedEvent.class})
	public void receiveEvents(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			this.nick = Nick.builder().name("泽林").age(2).height(90).build();
			log.info("context started init nick :【{}】 ", nick);
		}
		if (event instanceof ContextClosedEvent) {
			this.nick = null;
			log.info("context closed set nick null :【{}】", nick);
		}
	}
}
