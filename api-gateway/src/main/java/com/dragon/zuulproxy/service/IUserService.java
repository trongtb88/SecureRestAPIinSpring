package com.dragon.zuulproxy.service;

import com.dragon.zuulproxy.model.User;

public interface IUserService {

	User saveUser(User user);
	
	User findUserById(String Id);
}
