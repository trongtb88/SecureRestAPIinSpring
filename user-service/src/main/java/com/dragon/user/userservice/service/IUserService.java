package com.dragon.user.userservice.service;

import com.dragon.user.userservice.model.User;

public interface IUserService {

	User saveUser(User user);
	
	User findUserById(String Id);
}
