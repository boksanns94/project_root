package com.milosboksan.backendroot.entities;

import javax.persistence.*;

import java.util.List;

/*
 * ClientEntity - For storing data on a single client.
 * Author: Milos Boksan
 * Created on: 03:06 24.07.2017.
 */

@Entity
public class ClientEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private Integer clientType;//0 - Legal person, 1 - Natural person / 1 - default
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false, unique = true)
	private String jmbg;
	
	private AddressEntity address;
	private ContactInfoEntity contactInfo;
	
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = true)
	private String password;
	@Column(nullable = false)
	private Integer status;//0 - Inactive, 1 - Active / 1 - default
	@Column(nullable = false)
	private Integer authorisationLevel;//0 - Administrator, 1 - User / 1 - default
	
	private BankEntity bank;
	private List<CustomerAccountEntity> accounts;
	private List<CreditTransferOrderEntity> transactionHistory;
	
	@Version
	private Integer version;
	
	//Constructors
	public ClientEntity() {
		super();
	}

	public ClientEntity(Integer id, Integer clientType, String name, String surname, String jmbg, AddressEntity address,
			ContactInfoEntity contactInfo, BankEntity bank, List<CustomerAccountEntity> accounts,
			List<CreditTransferOrderEntity> transactionHistory, String username, String password, Integer status,
			Integer authorisationLevel, Integer version) {
		super();
		this.id = id;
		this.clientType = clientType;
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.address = address;
		this.contactInfo = contactInfo;
		this.bank = bank;
		this.accounts = accounts;
		this.transactionHistory = transactionHistory;
		this.username = username;
		this.password = password;
		this.status = status;
		this.authorisationLevel = authorisationLevel;
		this.version = version;
	}
	
	//get() and set() methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BankEntity getBank() {
		return bank;
	}

	public void setBank(BankEntity bank) {
		this.bank = bank;
	}

	public List<CustomerAccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<CustomerAccountEntity> accounts) {
		this.accounts = accounts;
	}

	public List<CreditTransferOrderEntity> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<CreditTransferOrderEntity> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
