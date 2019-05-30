package com.dragon.forex.repository;

import com.dragon.forex.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by trongtran on 5/12/19.
 */
public interface ExchangeRateRepository extends
        JpaRepository<ExchangeRate, Long> {
    ExchangeRate findByFromAndTo(String from, String to);

}
