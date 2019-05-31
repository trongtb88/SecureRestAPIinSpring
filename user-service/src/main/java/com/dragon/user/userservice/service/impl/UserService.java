package com.dragon.user.userservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dragon.user.userservice.model.User;
import com.dragon.user.userservice.repository.UserRepository;
import com.dragon.user.userservice.service.IUserService;



@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;
    
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


	@Override
	public User saveUser(User user) {
	   user.setPassword(passwordEncoder.encode(user.getPassword()) );
	   userRepository.save(user);
	   return user;
	}


	@Override
	public User findUserById(String Id) {
		Optional<User> u = userRepository.findById(Id);
		return u.isPresent() ? u.get() : null;
	}
    

}
