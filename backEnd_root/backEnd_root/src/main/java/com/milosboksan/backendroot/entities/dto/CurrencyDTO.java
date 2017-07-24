package com.milosboksan.backendroot.entities.dto;

public class CurrencyDTO
{
	private String currencyName;
	private String isoCode;
	private String upperExchangeRate;
	private String middleExchangeRate;
	private String lowerExchangeRate;
	
	public CurrencyDTO() {
		super();
	}

	public CurrencyDTO(String currencyName, String isoCode, String upperExchangeRate, String middleExchangeRate,
			String lowerExchangeRate) {
		super();
		this.currencyName = currencyName;
		this.isoCode = isoCode;
		this.upperExchangeRate = upperExchangeRate;
		this.middleExchangeRate = middleExchangeRate;
		this.lowerExchangeRate = lowerExchangeRate;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getUpperExchangeRate() {
		return upperExchangeRate;
	}

	public void setUpperExchangeRate(String upperExchangeRate) {
		this.upperExchangeRate = upperExchangeRate;
	}

	public String getMiddleExchangeRate() {
		return middleExchangeRate;
	}

	public void setMiddleExchangeRate(String middleExchangeRate) {
		this.middleExchangeRate = middleExchangeRate;
	}

	public String getLowerExchangeRate() {
		return lowerExchangeRate;
	}

	public void setLowerExchangeRate(String lowerExchangeRate) {
		this.lowerExchangeRate = lowerExchangeRate;
	}
	
}
