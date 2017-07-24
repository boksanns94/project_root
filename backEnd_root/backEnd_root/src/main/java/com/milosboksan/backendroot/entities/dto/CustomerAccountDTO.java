package com.milosboksan.backendroot.entities.dto;

public class CustomerAccountDTO
{
	private Integer accountType;
	private String accountNumber;
	private Integer status;
	
	//The <*balance> fields and the <latestActivity> field will be filled in automatically
	
	public CustomerAccountDTO() {
		super();
	}

	public CustomerAccountDTO(Integer accountType, String accountNumber, Integer status) {
		super();
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.status = status;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
