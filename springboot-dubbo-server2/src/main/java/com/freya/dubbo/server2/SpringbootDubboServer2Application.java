package com.freya.dubbo.server2;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SpringbootDubboServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboServer2Application.class, args);
	}

}
