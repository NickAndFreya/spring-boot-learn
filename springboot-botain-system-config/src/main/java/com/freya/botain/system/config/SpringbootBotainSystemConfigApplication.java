package com.freya.botain.system.config;

import com.freya.botain.system.config.conf.property.listener.PropertiesListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBotainSystemConfigApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringbootBotainSystemConfigApplication.class, args);

		SpringApplication application = new SpringApplication(SpringbootBotainSystemConfigApplication.class);
		application.addListeners(new PropertiesListener("freya.properties"));
		application.run(args);
	}

}
