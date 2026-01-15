package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAOInt userdao;
	
	public void testAdd() {
		
		userdao.add();
	}
	
}
