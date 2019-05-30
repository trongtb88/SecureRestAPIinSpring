package com.dragon.forex.controller;

import com.dragon.forex.model.ExchangeRate;
import com.dragon.forex.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeRateRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeRate retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

        ExchangeRate exchangeRate =
                repository.findByFromAndTo(from, to);

        exchangeRate.setPort(
                Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeRate;
    }
}
