package com.example.currency_conversion_service.CurrencyConversionDao;

import java.math.BigDecimal;

public class CurrencyConversion {


	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private String environment;

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity( final BigDecimal p_quantity ) {
		quantity = p_quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount( final BigDecimal p_totalCalculatedAmount ) {
		totalCalculatedAmount = p_totalCalculatedAmount;
	}

	public CurrencyConversion( final Long p_id, final String p_from, final String p_to, final BigDecimal p_quantity, final BigDecimal p_conversionMultiple,
							   final BigDecimal p_totalCalculatedAmount, final String p_environment ) {
		id = p_id;
		from = p_from;
		to = p_to;
		conversionMultiple = p_conversionMultiple;
		quantity = p_quantity;
		totalCalculatedAmount = p_totalCalculatedAmount;
		environment = p_environment;
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