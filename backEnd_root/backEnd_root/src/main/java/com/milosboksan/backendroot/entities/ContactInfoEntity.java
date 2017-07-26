package com.milosboksan.backendroot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 
 * ContactInfoEntity - For storing data on clients and banks contact info.
 * Author: Milos Boksan
 * Created on: 00:22 24.07.2017.
 */

@Entity
public class ContactInfoEntity
{
	@JsonProperty("ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = true, unique = true)
	private String email;
	@Column(nullable = true, unique = true)
	private String primaryPhone;
	@Column(nullable = true)
	private String secondaryPhone;
	
	@JsonBackReference
	@OneToOne(mappedBy = "clientContact", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private ClientEntity client;
	
	@JsonBackReference
	@OneToOne(mappedBy = "bankContact", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private BankEntity bank;
	
	@Version
	private Integer version;
	
	//Constructors
	public ContactInfoEntity() {
		super();
	}
	
	public ContactInfoEntity(Integer id, String email, String primaryPhone, String secondaryPhone,
			ClientEntity client, BankEntity bank, Integer version) {
		super();
		this.id = id;
		this.email = email;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
		this.client = client;
		this.bank = bank;
		this.version = version;
	}

	//get() and set() methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ClientEntity getClients() {
		return client;
	}

	public void setClients(ClientEntity client) {
		this.client = client;
	}

	public BankEntity getBanks() {
		return bank;
	}

	public void setBanks(BankEntity bank) {
		this.bank = bank;
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
