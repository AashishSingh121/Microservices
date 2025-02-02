package com.example.currency_exchange_service.DAO;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {

	@Id
	private Long id;
	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;

	public CurrencyExchange( final Long p_id, final String p_from, final String p_to, final BigDecimal p_conversionMultiple ) {
		id = p_id;
		from = p_from;
		to = p_to;
		conversionMultiple = p_conversionMultiple;
	}

	public CurrencyExchange() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId( final Long p_id ) {
		id = p_id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom( final String p_from ) {
		from = p_from;
	}

	public String getTo() {
		return to;
	}

	public void setTo( final String p_to ) {
		to = p_to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple( final BigDecimal p_conversionMultiple ) {
		conversionMultiple = p_conversionMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment( final String p_environment ) {
		environment = p_environment;
	}
}
