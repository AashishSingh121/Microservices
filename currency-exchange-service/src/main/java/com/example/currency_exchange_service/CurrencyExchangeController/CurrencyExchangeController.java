package com.example.currency_exchange_service.CurrencyExchangeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.currency_exchange_service.DAO.CurrencyExchange;
import com.example.currency_exchange_service.DAO.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue( @PathVariable final String from,
												   @PathVariable final String to){
		final CurrencyExchange l_currencyExchange = repository.findByFromAndTo( from, to );
		if(null == l_currencyExchange){
			throw new RuntimeException("No record Found");
		}
		final String port = environment.getProperty( "local.server.port" );
		l_currencyExchange.setEnvironment( port );
		return l_currencyExchange;
	}


}
