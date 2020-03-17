package com.freya.springbean.way4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 20:04
 */
@Slf4j
public class NickListener0 implements ApplicationListener {
	private Nick nick;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextStartedEvent) {
			this.nick = Nick.builder().name("袁成品").age(31).height(183).build();
			log.info("context started init nick :【{}】 ", nick);
		}
		if (event instanceof ContextClosedEvent) {
			this.nick = null;
			log.info("context closed set nick null :【{}】", nick);
		}
	}
}
