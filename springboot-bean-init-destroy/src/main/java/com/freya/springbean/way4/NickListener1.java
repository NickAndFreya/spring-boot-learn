package com.freya.springbean.way4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 20:14
 */
@Slf4j
public class NickListener1 {
	private Nick nick;

	@EventListener(value = {ContextStartedEvent.class, ContextClosedEvent.class})
	public void receiveEvents(ApplicationEvent event) {
		if (event instanceof ContextStartedEvent) {
			this.nick = Nick.builder().name("林小芳").age(32).height(162).build();
			log.info("context started init nick :【{}】 ", nick);
		}
		if (event instanceof ContextClosedEvent) {
			this.nick = null;
			log.info("context closed set nick null :【{}】", nick);
		}
	}
}
