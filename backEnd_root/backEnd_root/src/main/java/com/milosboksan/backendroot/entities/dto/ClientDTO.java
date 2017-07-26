package com.milosboksan.backendroot.entities.dto;

public class ClientDTO extends AddressContactInfoDTO
{
	private Integer clientType;//0 - Legal person, 1 - Natural person / 1 - default
	private String name;
	private String surname;
	private String jmbg;
	
	//Information on authentication details
	private String username;
	private String password;
	private Integer status;//0 - Inactive, 1 - Active / 1 - default
	private Integer authorisationLevel;//0 - Administrator, 1 - User / 1 - default
	
	public ClientDTO() {
		super();
	}

	public ClientDTO(Integer clientType, String name, String surname, String jmbg, String username, String password,
			Integer status, Integer authorisationLevel) {
		super();
		this.clientType = clientType;
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
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
