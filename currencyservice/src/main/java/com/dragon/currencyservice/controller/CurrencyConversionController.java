package com.dragon.currencyservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dragon.currencyservice.feign.CurrencyExchangeServiceProxy;
import com.dragon.currencyservice.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
	      @PathVariable BigDecimal quantity) {
	
	    Map<String, String> uriVariables = new HashMap<>();
	    uriVariables.put("from", from);
	    uriVariables.put("to", to);
	
	    CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
	
	    logger.info("{}", response);
	
	    return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
	        quantity.multiply(response.getConversionMultiple()), response.getPort());
	
	  }

}
