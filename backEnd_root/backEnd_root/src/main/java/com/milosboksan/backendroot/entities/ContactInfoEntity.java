package com.milosboksan.backendroot.entities;

import javax.persistence.*;

import java.util.List;

/*
 * 
 * ContactInfoEntity - For storing data on clients and banks contact info.
 * Author: Milos Boksan
 * Created on: 00:22 24.07.2017.
 */

@Entity
public class ContactInfoEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String primaryPhone;
	@Column(unique = true)
	private String secondaryPhone;
	
	private List<ClientEntity> clients;
	private List<BankEntity> banks;
	
	@Version
	private Integer version;
	
	//Constructors
	public ContactInfoEntity() {
		super();
	}
	
	public ContactInfoEntity(Integer id, String email, String primaryPhone, String secondaryPhone,
			List<ClientEntity> clients, List<BankEntity> banks, Integer version) {
		super();
		this.id = id;
		this.email = email;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
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
