package com.rays.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionfactory = null;

	public long add(UserDTO dto) {

		Session session = sessionfactory.getCurrentSession();
		Long pk = (Long) session.save(dto);
		return pk;
	}

}
