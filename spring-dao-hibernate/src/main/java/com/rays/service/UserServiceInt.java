package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);
		
	public void update(UserDTO dto);
	
	 public void delete(int id);
	    
	  public UserDTO findbypk(long id);
	  
	  public UserDTO findbylogin(String login);
	    
	  public UserDTO authenticate(String login , String password);
	    public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);
		
}
	

