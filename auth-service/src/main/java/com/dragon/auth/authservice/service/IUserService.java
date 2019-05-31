package com.dragon.auth.authservice.service;

import com.dragon.auth.authservice.model.User;

public interface IUserService {

	User saveUser(User user);
	
	User findUserById(String Id);
}
