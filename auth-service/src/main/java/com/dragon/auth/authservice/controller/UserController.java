package com.dragon.auth.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.auth.authservice.exception.CustomException;
import com.dragon.auth.authservice.model.User;
import com.dragon.auth.authservice.service.impl.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    
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
    public String getUser(@PathVariable String id){        

        return "trongtb";
    }
    
    
}
    
