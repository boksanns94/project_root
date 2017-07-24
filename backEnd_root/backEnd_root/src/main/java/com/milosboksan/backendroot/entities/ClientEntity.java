package com.milosboksan.backendroot.entities;

/*
 * ClientEntity - For storing data on a single client.
 * Author: Milos Boksan
 * Created on: 03:06 24.07.2017.
 */

public class ClientEntity
{
	private Integer id;
	private Integer clientType;//0 - Legal person, 1 - Natural person / 1 - default
	private String name;
	private String surname;
	private String jmbg;
	private AddressEntity address;
	private ContactInfoEntity contactInfo;
	private String username;
	private String password;
	private Boolean status;//0 - Inactive, 1 - Active / 1 - default
	private Integer authorisationLevel;//0 - Administrator, 1 - User / 1 - default
	
	//Constructors
	public ClientEntity() {
		super();
	}

	public ClientEntity(Integer id, Integer clientType, String name, String surname, String jmbg, AddressEntity address,
			ContactInfoEntity contactInfo, String username, String password, Boolean status,
			Integer authorisationLevel) {
		super();
		this.id = id;
		this.clientType = clientType;
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.address = address;
		this.contactInfo = contactInfo;
		this.username = username;
		this.password = password;
		this.status = status;
		this.authorisationLevel = authorisationLevel;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getAuthorisationLevel() {
		return authorisationLevel;
	}

	public void setAuthorisationLevel(Integer authorisationLevel) {
		this.authorisationLevel = authorisationLevel;
	}
	
}
