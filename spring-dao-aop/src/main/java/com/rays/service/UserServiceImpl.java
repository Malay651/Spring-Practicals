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

	
		public long add(UserDTO dto) {

			long pk = dao.add(dto);
			return pk;

		}

		
		public void update(UserDTO dto) {
			dao.update(dto);

		}

		
		public void delete(int id) {
			dao.delete(id);

		}
	     
		 public UserDTO findbylogin(String login) {
	        return dao.findbylogin(login);
			 
		 }
	     
		 
		 public List search(UserDTO dto,int pageNo ,int pageSize) {
			 return dao.search(dto, pageNo, pageSize);
		 }
		 
		 public UserDTO authenticate(String login , String password) {
			return dao.authenticate(login, password);
		}


		public UserDTO findbypk(int pk) {
			// TODO Auto-generated method stub
			return dao.findbypk(pk);
		}


		public List search(UserDTO dto) {
			// TODO Auto-generated method stub
			return dao.search(dto);
		}
	}


