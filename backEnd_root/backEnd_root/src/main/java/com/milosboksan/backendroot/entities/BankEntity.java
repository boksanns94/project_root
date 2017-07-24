package com.milosboksan.backendroot.entities;

/*
 * BankEntity - For storing legal data for bank.
 * Author: Milos Boksan
 * Created on: 02:22 24.07.2017.
 */

public class BankEntity
{
	private Integer id;
	private String bankName;
	private AddressEntity address;
	private ContactInfoEntity contactInfo;
	private String bankIdNumber;
	private String swift;
	private String version;
	
	//Constructors
	public BankEntity() {
		super();
	}

	public BankEntity(Integer id, String bankName, AddressEntity address, ContactInfoEntity contactInfo,
			String bankIdNumber, String swift, String version) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.address = address;
		this.contactInfo = contactInfo;
		this.bankIdNumber = bankIdNumber;
		this.swift = swift;
		this.version = version;
	}
	
	//get() and set() methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public ContactInfoEntity getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfoEntity contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getBankIdNumber() {
		return bankIdNumber;
	}

	public void setBankIdNumber(String bankIdNumber) {
		this.bankIdNumber = bankIdNumber;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
