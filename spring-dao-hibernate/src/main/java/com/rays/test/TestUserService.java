package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

public class TestUserService {

	public  UserServiceInt service = null;
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Applicationcontext.xml");
		
		      TestUserService test = (TestUserService) context.getBean("testUserService");
		      
		      test.testAdd();
	}
	
	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Ram");
		dto.setLastName("Yadav");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");
		long pk = service.add(dto);
		System.out.println("PK----> " + pk);
	}
}
