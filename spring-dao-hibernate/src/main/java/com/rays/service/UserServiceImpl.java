package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao;


	public long add() {
		long pk = dao.add(dto);
		return pk;

	}

	
}
