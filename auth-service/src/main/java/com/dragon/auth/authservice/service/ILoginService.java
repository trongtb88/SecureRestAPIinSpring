package com.dragon.auth.authservice.service;

public interface ILoginService {
    String login(String username, String password);
    
    boolean logout(String token);
    
}
