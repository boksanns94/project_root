package com.milosboksan.backendroot.entities;

/*
 * AddressEntity - For storing data on clients and banks address.
 * Author: Milos Boksan
 * Created on: 00:13 24.07.2017.
 */

public class AddressEntity
{
	private Integer id;
	private String streetName;
	private String streetNumber;
	private String cityName;
	private String postalCode;
	private String stateName;
	private String countryName;
	private Integer version;
	
	//Constructors
	public AddressEntity() {
		super();
	}

	public AddressEntity(Integer id, String streetName, String streetNumber, String cityName, String postalCode,
			String stateName, String countryName, Integer version) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.cityName = cityName;
		this.postalCode = postalCode;
		this.stateName = stateName;
		this.countryName = countryName;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
