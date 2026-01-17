package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		// test.testAdd();
		// test.testUpdate();
		// test.testdelete();
	       test.testsearch();
		//  test.testfindbylogin();
	}

	private void testfindbylogin() {
	
		UserDTO dto = service.findbylogin("malay@gmail.com");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User not exist..!!!");
		}
		
	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("malay");
		dto.setLastName("dongre");
		dto.setLogin("abc@gmail.com");
		dto.setPassword("abc123");
		long pk = service.add(dto);
		System.out.println("Data Inserted... pk = " + pk);

	}

	public void testUpdate() {
		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Aalay");
		dto.setLastName("dongre");
		dto.setLogin("malay@gmail.com");
		dto.setPassword("123");
		service.update(dto);
		System.out.println("data updated : 1 !!");

	}

	public void testdelete() {
		service.delete(1);

	}

	public void testsearch() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("Shyam");
		
		List<UserDTO> list = service.search(dto, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		}
	}
}
