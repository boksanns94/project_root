package com.milosboksan.backendroot.entities.dto;

public class ClientDTO
{
	private Integer clientType;//0 - Legal person, 1 - Natural person / 1 - default
	private String name;
	private String surname;
	private String jmbg;
	
	//Information about the clients address
	private String streetName;
	private String streetNumber;
	private String cityName;
	private String postalCode;
	private String stateName;
	private String countryName;
	
	//Information about the banks contact info
	private String email;
	private String primaryPhone;
	private String secondaryPhone;
	
	//Information on authentication details
	private String username;
	private String password;//Initial value is set by an administrator. It can be changed by a user afterwards.
	private Integer status;//0 - Inactive, 1 - Active / 1 - default
	private Integer authorisationLevel;//0 - Administrator, 1 - User / 1 - default
	
	public ClientDTO() {
		super();
	}

	public ClientDTO(Integer clientType, String name, String surname, String jmbg, String streetName,
			String streetNumber, String cityName, String postalCode, String stateName, String countryName, String email,
			String primaryPhone, String secondaryPhone, String username, String password, Integer status,
			Integer authorisationLevel) {
		super();
		this.clientType = clientType;
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.cityName = cityName;
		this.postalCode = postalCode;
		this.stateName = stateName;
		this.countryName = countryName;
		this.email = email;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
		this.username = username;
		this.password = password;
		this.status = status;
		this.authorisationLevel = authorisationLevel;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAuthorisationLevel() {
		return authorisationLevel;
	}

	public void setAuthorisationLevel(Integer authorisationLevel) {
		this.authorisationLevel = authorisationLevel;
	}
	
	
}
