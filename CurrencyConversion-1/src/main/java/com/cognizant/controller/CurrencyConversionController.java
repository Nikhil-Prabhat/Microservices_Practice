package com.cognizant.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.Repository.CurrencyExchangeServiceProxy;
import com.cognizant.model.CurrencyConversion;

@RestController
public class CurrencyConversionController 
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	//Using Rest Template
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
	{
		//It is used to retrieve data from client using response entity
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to",to);
		
		//url,responsetype,map
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		
		//The object here is initialised with default values for quantity and calculated amount
		CurrencyConversion response = responseEntity.getBody();
		
		return new CurrencyConversion(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
	
	}
	
	//Using Feign Client
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeigh(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
	{
		CurrencyConversion response = proxy.retrieveExchangeValue(from, to);
		logger.info("{}",response);
		
		return new CurrencyConversion(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
	}
}
