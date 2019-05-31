package com.dragon.auth.authservice.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dragon.auth.authservice.exception.CustomException;
import com.dragon.auth.authservice.model.JwtToken;
import com.dragon.auth.authservice.model.Role;
import com.dragon.auth.authservice.model.User;
import com.dragon.auth.authservice.repository.JwtTokenRepository;
import com.dragon.auth.authservice.repository.UserRepository;
import com.dragon.auth.authservice.service.ILoginService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class LoginService implements ILoginService
{
   
	private static final String AUTH="auth";
    private static final String AUTHORIZATION="Authorization";
    private static String secretKey="secret-key";
    private long validityInMilliseconds = 3600000; // 1h
   
//    @Autowired
//    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    @Override
    public String login(String username, String password) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
//                    password));
//            User user = userRepository.findByEmail(username);
//            if (user == null || user.getRole() == null || user.getRole().isEmpty()) {
//                throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
//            }
//            
//    		Claims claims = Jwts.claims().setSubject(username);
//            claims.put(AUTH, user.getRole().stream()
//                    .map((Role role)-> "ROLE_"+role.getRole()).filter(Objects::nonNull).collect(Collectors.toList()));
//
//            Date now = new Date();
//            Date validity = new Date(now.getTime() + validityInMilliseconds);
//
//            String token =  Jwts.builder()//
//                    .setClaims(claims)//
//                    .setIssuedAt(now)//
//                    .setExpiration(validity)//
//                    .signWith(SignatureAlgorithm.HS256, secretKey)//
//                    .compact();
//            jwtTokenRepository.save(new JwtToken(token));
//            return token;
//
//        } catch (AuthenticationException e) {
//            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
//        }
    	return "";
    }

    @Override
    public boolean logout(String token) {
         jwtTokenRepository.delete(new JwtToken(token));
         return true;
    }

   
}
