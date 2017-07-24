package com.milosboksan.backendroot.entities;

import java.util.List;

/*
 * CurrencyEntity - For storing data on currencies.
 * Author: Milos Boksan
 * Created on: 02:49 24.07.2017.
 */

public class CurrencyEntity
{
	private Integer id;
	private String currencyName;
	private String isoCode;
	private Double upperExchangeRate;
	private Double middleExchangeRate;
	private Double lowerExchangeRate;
	private List<CustomerAccountEntity> accountList;
	private Integer version;
	
	//Constructors
	public CurrencyEntity() {
		super();
	}

	public CurrencyEntity(Integer id, String currencyName, String isoCode, Double upperExchangeRate,
			Double middleExchangeRate, Double lowerExchangeRate, List<CustomerAccountEntity> accountList,
			Integer version) {
		super();
		this.id = id;
		this.currencyName = currencyName;
		this.isoCode = isoCode;
		this.upperExchangeRate = upperExchangeRate;
		this.middleExchangeRate = middleExchangeRate;
		this.lowerExchangeRate = lowerExchangeRate;
		this.accountList = accountList;
		this.version = version;
	}
	
	//get() and set() methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getUpperExchangeRate() {
		return upperExchangeRate;
	}

	public void setUpperExchangeRate(Double upperExchangeRate) {
		this.upperExchangeRate = upperExchangeRate;
	}

	public Double getMiddleExchangeRate() {
		return middleExchangeRate;
	}

	public void setMiddleExchangeRate(Double middleExchangeRate) {
		this.middleExchangeRate = middleExchangeRate;
	}

	public Double getLowerExchangeRate() {
		return lowerExchangeRate;
	}

	public void setLowerExchangeRate(Double lowerExchangeRate) {
		this.lowerExchangeRate = lowerExchangeRate;
	}

	public List<CustomerAccountEntity> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<CustomerAccountEntity> accountList) {
		this.accountList = accountList;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
