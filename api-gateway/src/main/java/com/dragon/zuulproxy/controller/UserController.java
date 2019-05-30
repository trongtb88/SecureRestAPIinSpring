package com.dragon.zuulproxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragon.zuulproxy.exception.CustomException;
import com.dragon.zuulproxy.model.AuthResponse;
import com.dragon.zuulproxy.model.LoginRequest;
import com.dragon.zuulproxy.model.User;
import com.dragon.zuulproxy.service.ILoginService;
import com.dragon.zuulproxy.service.serviceimpl.UserService;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @CrossOrigin("*")
    @PostMapping("/user/register")
    @ResponseBody
    public ResponseEntity<User> register(@RequestBody User newUser) {
    	User existUser = userService.findUserById(newUser.getId());
    	if (existUser != null) {
    		throw new CustomException("Email of users already exist!.", HttpStatus.BAD_REQUEST);
    	} else {
    		userService.saveUser(newUser);
    	}
    	return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    	
    }
    
    
}
    
