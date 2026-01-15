package com.rays.autowire;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDAOImpl implements UserDAOInt {

	public void add() {
		
		System.out.println("add method..!!");
		
	}

}
