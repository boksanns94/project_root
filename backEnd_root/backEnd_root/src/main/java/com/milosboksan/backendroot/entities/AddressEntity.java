package com.milosboksan.backendroot.entities;

import javax.persistence.*;

import java.util.List;

/*
 * 
 * AddressEntity - For storing data on clients and banks address.
 * Author: Milos Boksan
 * Created on: 00:13 24.07.2017.
 */

@Entity
public class AddressEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String streetName;
	@Column(nullable = false)
	private String streetNumber;
	@Column(nullable = false)
	private String cityName;
	@Column(nullable = false)
	private String postalCode;
	@Column(nullable = false)
	private String stateName;
	@Column(nullable = false)
	private String countryName;
	
	private List<ClientEntity> clients;
	private List<BankEntity> banks;

	@Version
	private Integer version;
	
	//Constructors
	public AddressEntity() {
		super();
	}

	public AddressEntity(Integer id, String streetName, String streetNumber, String cityName, String postalCode,
			String stateName, String countryName, List<ClientEntity> clients, List<BankEntity> banks, Integer version) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.cityName = cityName;
		this.postalCode = postalCode;
		this.stateName = stateName;
		this.countryName = countryName;
		this.clients = clients;
		this.banks = banks;
		this.version = version;
	}

	//get() and set() methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public List<ClientEntity> getClients() {
		return clients;
	}

	public void setClients(List<ClientEntity> clients) {
		this.clients = clients;
	}

	public List<BankEntity> getBanks() {
		return banks;
	}

	public void setBanks(List<BankEntity> banks) {
		this.banks = banks;
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
