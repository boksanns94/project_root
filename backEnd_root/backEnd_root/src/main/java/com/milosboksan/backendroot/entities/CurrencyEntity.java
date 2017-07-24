package com.milosboksan.backendroot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 
 * CurrencyEntity - For storing data on currencies.
 * Author: Milos Boksan
 * Created on: 02:49 24.07.2017.
 */

@Entity
public class CurrencyEntity
{
	@JsonProperty("ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String currencyName;
	@Column(nullable = false, unique = true)
	private String isoCode;
	@Column(nullable = false)
	private Double upperExchangeRate;
	@Column(nullable = false)
	private Double middleExchangeRate;
	@Column(nullable = false)
	private Double lowerExchangeRate;
	
	@JsonBackReference
	@OneToMany(mappedBy = "currency", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private CreditTransferOrderEntity transfer;
	
	@Version
	private Integer version;
	
	//Constructors
	public CurrencyEntity() {
		super();
	}

	public CurrencyEntity(Integer id, String currencyName, String isoCode, Double upperExchangeRate,
			Double middleExchangeRate, Double lowerExchangeRate, CreditTransferOrderEntity transfer,
			Integer version) {
		super();
		this.id = id;
		this.currencyName = currencyName;
		this.isoCode = isoCode;
		this.upperExchangeRate = upperExchangeRate;
		this.middleExchangeRate = middleExchangeRate;
		this.lowerExchangeRate = lowerExchangeRate;
		this.transfer = transfer;
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

	public CreditTransferOrderEntity getTransfer() {
		return transfer;
	}

	public void setAccounts(CreditTransferOrderEntity transfer) {
		this.transfer = transfer;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
