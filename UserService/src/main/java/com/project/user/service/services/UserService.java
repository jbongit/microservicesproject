package com.project.user.service.services;

import java.util.List;

import com.project.user.service.entities.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAlUsers();
	
	User getUser(String userId);
	
	void deleteUser(String userId);

}
