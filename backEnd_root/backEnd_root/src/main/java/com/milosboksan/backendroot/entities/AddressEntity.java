

package com.milosboksan.backendroot.entities;

import java.util.List;

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
 * AddressEntity - For storing data on clients and banks address.
 * Author: Milos Boksan
 * Created on: 00:13 24.07.2017.
 */

@Entity
public class AddressEntity
{
	@JsonProperty("ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = true)
	private String streetName;
	@Column(nullable = true)
	private String streetNumber;
	@Column(nullable = true)
	private String cityName;
	@Column(nullable = true)
	private String postalCode;
	@Column(nullable = true)
	private String stateName;
	@Column(nullable = true)
	private String countryName;
	
	@JsonBackReference
	@OneToMany(mappedBy = "clientAddress", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ClientEntity> clients;
	
	@JsonBackReference
	@OneToMany(mappedBy = "bankAddress", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
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
