package com.freya.botain.system.config.conf.property.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 17:14
 */
public class PropertiesListener implements ApplicationListener<ApplicationStartedEvent> {

	private String propertyFileName;

	public PropertiesListener(String propertyFileName) {
		this.propertyFileName = propertyFileName;
	}

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		PropertiesListenerConfig.loadAllProperties(propertyFileName);

	}
}
