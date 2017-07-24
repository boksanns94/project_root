package com.milosboksan.backendroot.entities.dto;

public class BankDTO
{
	private String bankName;
	private String bankIdNumber; //Unique
	
	//Information about the banks address
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
	
	public BankDTO() {
		super();
	}

	public BankDTO(String bankName, String bankIdNumber, String streetName, String streetNumber, String cityName,
			String postalCode, String stateName, String countryName, String email, String primaryPhone,
			String secondaryPhone) {
		super();
		this.bankName = bankName;
		this.bankIdNumber = bankIdNumber;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.cityName = cityName;
		this.postalCode = postalCode;
		this.stateName = stateName;
		this.countryName = countryName;
		this.email = email;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankIdNumber() {
		return bankIdNumber;
	}

	public void setBankIdNumber(String bankIdNumber) {
		this.bankIdNumber = bankIdNumber;
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

}
