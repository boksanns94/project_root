package com.milosboksan.backendroot.entities;

import java.util.List;
import java.time.LocalDate;

/*
 * CustomerAccountEntity - For storing data on customer accounts.
 * Author: Milos Boksan
 * Created on: 02:26 24.07.2017.
 */

public class CustomerAccountEntity
{
	private Integer id;
	private Integer accountType;//0 - Administrator, 1 - User / 1 - default
	private String accountNumber;
	private Boolean status;//0 - Disabled, 1 - Enabled // 1 - default
	private Double accountBalance;
	private Double availableBalance;
	private Double reservedBalance;
	private List<CreditTransferOrderEntity> transfersToAccount;
	private List<CreditTransferOrderEntity> transfersFromAccount;
	private LocalDate latestActivity;
	private Integer version;
	
	//Constructors
	public CustomerAccountEntity() {
		super();
	}

	public CustomerAccountEntity(Integer id, Integer accountType, String accountNumber, Boolean status,
			Double accountBalance, Double availableBalance, Double reservedBalance,
			List<CreditTransferOrderEntity> transfersToAccount, List<CreditTransferOrderEntity> transfersFromAccount,
			LocalDate latestActivity, Integer version) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.status = status;
		this.accountBalance = accountBalance;
		this.availableBalance = availableBalance;
		this.reservedBalance = reservedBalance;
		this.transfersToAccount = transfersToAccount;
		this.transfersFromAccount = transfersFromAccount;
		this.latestActivity = latestActivity;
		this.version = version;
	}
	
	//get() and set() methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Double getReservedBalance() {
		return reservedBalance;
	}

	public void setReservedBalance(Double reservedBalance) {
		this.reservedBalance = reservedBalance;
	}

	public List<CreditTransferOrderEntity> getTransfersToAccount() {
		return transfersToAccount;
	}

	public void setTransfersToAccount(List<CreditTransferOrderEntity> transfersToAccount) {
		this.transfersToAccount = transfersToAccount;
	}

	public List<CreditTransferOrderEntity> getTransfersFromAccount() {
		return transfersFromAccount;
	}

	public void setTransfersFromAccount(List<CreditTransferOrderEntity> transfersFromAccount) {
		this.transfersFromAccount = transfersFromAccount;
	}

	public LocalDate getLatestActivity() {
		return latestActivity;
	}

	public void setLatestActivity(LocalDate latestActivity) {
		this.latestActivity = latestActivity;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
