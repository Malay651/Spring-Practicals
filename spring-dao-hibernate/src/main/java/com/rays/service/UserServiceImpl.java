package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {

		long pk = dao.add(dto);
		return pk;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		dao.delete(id);

	}

	@Transactional(readOnly = true)
	public UserDTO findbypk(long id) {
		return dao.findbypk(id);

	}
     
	 @Transactional(readOnly = true)
	 public UserDTO findbylogin(String login) {
        return dao.findbylogin(login);
		 
	 }
     
	 @Transactional(readOnly = true)
	 public List search(UserDTO dto,int pageNo ,int pageSize) {
		 return dao.search(dto, pageNo, pageSize);
	 }
	 
	 @Transactional(readOnly = true)
	 public UserDTO authenticate(String login , String password) {
		return dao.authenticate(login, password);
	}
}
