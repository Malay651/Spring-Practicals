package com.rays.autowire.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestAutowireConstructor {

	public static void main(String[] args) {
		
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire-by-constructor.xml");
		
		UserService userService = context.getBean("userService", UserService.class);

		userService.testAdd();

	}
}
