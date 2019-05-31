package com.dragon.user.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.common.commonservice.exception.CustomException;
import com.dragon.user.userservice.model.User;
import com.dragon.user.userservice.service.IUserService;




@RestController
public class UserController {

    @Autowired
    private IUserService userService;
    
    
    @CrossOrigin("*")
    @PostMapping("/register")
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
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){        

    	User existUser = userService.findUserById(id);
    	if (existUser == null) {
    		throw new CustomException("User is not already exist!.", HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<>(existUser, HttpStatus.CREATED);
    	
    }
    
    
}
    
