package com.freya.springbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 20:37
 */
public class ComplexServiceApplication {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		context.start();
		context.close();
	}
}
