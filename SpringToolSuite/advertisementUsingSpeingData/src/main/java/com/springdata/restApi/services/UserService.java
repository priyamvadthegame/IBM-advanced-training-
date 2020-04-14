package com.springdata.restApi.services;

import java.util.List;

import com.springdata.restApi.json.User;



public interface UserService {
public List<User> getAllUsers();
	
	public User getCurrentUserDetails(String id);
	
	public List<User> getUsersByFirstName(String firstName);
	
	public User save(User user);
	
	public User update(User user);
	
	public boolean delete(String id);
	
	public List<User> getUsersByOrderByFirstNameAsc();
	
	public List<User> getUsersByOrderByFirstNameDesc();
	public String autoLogin(User user);
	public User autoLogout(String apiKey);
}
