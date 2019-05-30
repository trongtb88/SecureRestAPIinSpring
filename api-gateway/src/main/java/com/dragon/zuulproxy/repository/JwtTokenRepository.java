package com.dragon.zuulproxy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dragon.zuulproxy.model.JwtToken;

@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken,String> {
}

