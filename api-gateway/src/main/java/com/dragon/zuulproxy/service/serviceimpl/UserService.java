package com.dragon.zuulproxy.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dragon.zuulproxy.exception.CustomException;
import com.dragon.zuulproxy.model.MongoUserDetails;
import com.dragon.zuulproxy.model.Role;
import com.dragon.zuulproxy.model.User;
import com.dragon.zuulproxy.repository.UserRepository;
import com.dragon.zuulproxy.service.IUserService;

@Service
public class UserService implements UserDetailsService, IUserService{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null || user.getRole() == null || user.getRole().isEmpty()) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        String [] authorities = new String[user.getRole().size()];
        int count=0;
        for (Role role : user.getRole()) {
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            authorities[count] = "ROLE_"+role.getRole();
            count++;
        }
        MongoUserDetails userDetails = new MongoUserDetails(user.getEmail(),user.getPassword(),user.getActive(),
                user.isLoacked(), user.isExpired(),user.isEnabled(),authorities);
        return userDetails;
    }
    


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
