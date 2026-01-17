package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dto.UserDTO;



@Repository
public class UserDAOJDBCImpl implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) {

		String sql = "insert into st_user values(?, ?, ?, ?, ?)";

		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return pk;
	}

	public void update(UserDTO dto) {
		
		String sql = "update st_user set firstname = ?,lastName = ?,login = ?,password = ? where id = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword(),dto.getId());
		
		System.out.println("record updated successfully: " + i);
		
	}

	public void delete(int id) {
		
		String sql = "delete from st_user where id = ?";
		
		int i = jdbcTemplate.update(sql, id);

		System.out.println("record deleted: " + i);

  }

  
	
	public UserDTO authenticate(String login,String password) {
		try {
			StringBuffer sql = new StringBuffer("select * from st_user where login = ? and password = ?");
			
			Object[] params = {login , password};
			UserDTO user = jdbcTemplate.queryForObject(sql.toString(), params, new UserMapper());
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public UserDTO findbylogin(String login) {
		try {
			 StringBuffer sql =new StringBuffer("select * from st_user where login = ?");
				
				Object[] params = { login };
				UserDTO user = jdbcTemplate.queryForObject(sql.toString() ,params , new UserMapper());
				return user;
			
		} catch (Exception e) {
			// TODO: handle exception
		
		  return null;
		}

	}

	

	
	public List search(UserDTO dto) {
		String sql = "select * from st_user";
		List l = jdbcTemplate.query(sql, new UserMapper());
		return l;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + dto.getFirstName() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}
		System.out.println("sql===> " + sql.toString());
		List l = jdbcTemplate.query(sql.toString(), new UserMapper());
		return l;
	}

}