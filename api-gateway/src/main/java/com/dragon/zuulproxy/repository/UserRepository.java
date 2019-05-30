package com.dragon.zuulproxy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dragon.zuulproxy.model.User;

@Repository
	public interface UserRepository extends MongoRepository<User,String> {
	    @Query(value="{'email' : ?0}")
	    User findByEmail(String email);
	
}
