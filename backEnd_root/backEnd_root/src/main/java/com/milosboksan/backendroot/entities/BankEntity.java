package com.milosboksan.backendroot.entities;

import javax.persistence.*;

import java.util.List;

/*
 * 
 * BankEntity - For storing legal data for bank.
 * Author: Milos Boksan
 * Created on: 02:22 24.07.2017.
 */

@Entity
public class BankEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String bankName;
	@Column(nullable = false, unique = true)
	private String bankIdNumber;//The first three numbers in an account number
	
	private AddressEntity address;
	private ContactInfoEntity contactInfo;
	private List<ClientEntity> clients;
	private List<CustomerAccountEntity> accounts;
	
	@Version
	private String version;
	
	//Constructors
	public BankEntity() {
		super();
	}
	
	public BankEntity(Integer id, String bankName, String bankIdNumber, AddressEntity address,
			ContactInfoEntity contactInfo, List<ClientEntity> clients, List<CustomerAccountEntity> accounts,
			String version) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.bankIdNumber = bankIdNumber;
		this.address = address;
		this.contactInfo = contactInfo;
		this.clients = clients;
		this.accounts = accounts;
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
	
	public String getBankIdNumber() {
		return bankIdNumber;
	}

	public void setBankIdNumber(String bankIdNumber) {
		this.bankIdNumber = bankIdNumber;
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

	public List<ClientEntity> getClients() {
		return clients;
	}

	public void setClients(List<ClientEntity> clients) {
		this.clients = clients;
	}

	public List<CustomerAccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<CustomerAccountEntity> accounts) {
		this.accounts = accounts;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
