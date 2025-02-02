package com.example.currency_conversion_service.CurrencyConversionController;

import java.math.BigDecimal;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.currency_conversion_service.CurrencyConversionDao.CurrencyConversion;
import com.example.currency_conversion_service.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getConversionFeign( @PathVariable final String from,
											 @PathVariable final String to,
											 @PathVariable final BigDecimal quantity ){

		final CurrencyConversion l_currencyConversion = proxy.retrieveExchangeValue( from, to );

		return new CurrencyConversion( l_currencyConversion.getId(), from, to, quantity,l_currencyConversion.getConversionMultiple(),
									   quantity.multiply( l_currencyConversion.getConversionMultiple() ) , l_currencyConversion.getEnvironment());

	}

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getConversion( @PathVariable final String from,
											 @PathVariable final String to,
											 @PathVariable final BigDecimal quantity ){

		final HashMap<String, String> uriVariables =new HashMap<>();
		uriVariables.put( "from", from );
		uriVariables.put( "to", to );

		final ResponseEntity<CurrencyConversion> l_conversionResponseEntity =
			new RestTemplate().getForEntity( "http://localhost:8001/currency-exchange/from/{from}/to/{to}",
							  CurrencyConversion.class, uriVariables);

		final CurrencyConversion l_currencyConversion = l_conversionResponseEntity.getBody();

		return new CurrencyConversion( l_currencyConversion.getId(), from, to, quantity,l_currencyConversion.getConversionMultiple(),
									   quantity.multiply( l_currencyConversion.getConversionMultiple() ) , l_currencyConversion.getEnvironment());

	}

}
