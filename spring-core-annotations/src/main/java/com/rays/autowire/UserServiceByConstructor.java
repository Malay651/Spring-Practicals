package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceByConstructor {

	@Autowired
	private UserDAOInt userDao;
	
	public UserServiceByConstructor (UserDAOInt userDao) {
		
		this.userDao = userDao;
	}
	 public void testAdd() {
		 
		 userDao.add();
	 }
}
