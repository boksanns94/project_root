package com.milosboksan.backendroot.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 
 * BankEntity - For storing legal data for bank.
 * Author: Milos Boksan
 * Created on: 02:22 24.07.2017.
 */

@Entity
public class BankEntity
{
	@JsonProperty("ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String bankName;
	@Column(nullable = false, unique = true)
	private String bankIdNumber;//The first three numbers in an account number
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "bankAddress")
	private AddressEntity address;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "bankContact")
	private ContactInfoEntity contactInfo;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "clients")
	private ClientEntity client;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "bankAccounts")
	private List<CustomerAccountEntity> accounts;
	
	@Version
	private String version;
	
	//Constructors
	public BankEntity() {
		super();
	}
	
	public BankEntity(Integer id, String bankName, String bankIdNumber, AddressEntity address,
			ContactInfoEntity contactInfo, ClientEntity client, List<CustomerAccountEntity> accounts,
			String version) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.bankIdNumber = bankIdNumber;
		this.address = address;
		this.contactInfo = contactInfo;
		this.client = client;
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

	public ClientEntity getClients() {
		return client;
	}

	public void setClients(ClientEntity client) {
		this.client = client;
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
