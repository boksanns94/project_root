package com.milosboksan.backendroot.entities.dto;

public class BankDTO extends AddressContactInfoDTO
{
	private String bankName;
	private String bankIdNumber; //Unique
	
	public BankDTO() {
		super();
	}

	public BankDTO(String bankName, String bankIdNumber) {
		super();
		this.bankName = bankName;
		this.bankIdNumber = bankIdNumber;
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
	
}
