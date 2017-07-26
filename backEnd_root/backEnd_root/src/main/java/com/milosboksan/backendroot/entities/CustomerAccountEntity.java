package com.milosboksan.backendroot.entities;

import java.time.LocalDate;
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
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 
 * CustomerAccountEntity - For storing data on customer accounts.
 * Author: Milos Boksan
 * Created on: 02:26 24.07.2017.
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class CustomerAccountEntity
{
	@JsonProperty("ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private Integer accountType;//0 - Administrator, 1 - User / 1 - default
	@Column(nullable = false, unique = true)
	private String accountNumber;
	@Column(nullable = false)
	private Integer status;//0 - Disabled, 1 - Enabled // 1 - default
	@Column(nullable = false)
	private Double accountBalance;//Default is 0.0
	@Column(nullable = false)
	private Double availableBalance;//Default is 0.0
	@Column(nullable = false)
	private Double reservedBalance;//Default is 0.0
	@Column(nullable = false)
	private LocalDate latestActivity;//Default is creation date
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "customerAccounts")
	private ClientEntity owner;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "bankAccounts")
	private BankEntity bank;
	
	@JsonBackReference
	@OneToMany(mappedBy = "payerAccount", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<CreditTransferOrderEntity> transfersFromAccount;
	
	@JsonBackReference
	@OneToMany(mappedBy = "recipientAccount", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<CreditTransferOrderEntity> transfersToAccount;
	
	@Version
	private Integer version;
	
	//Constructors
	public CustomerAccountEntity() {
		super();
	}

	public CustomerAccountEntity(Integer id, Integer accountType, String accountNumber, Integer status,
			Double accountBalance, Double availableBalance, Double reservedBalance, LocalDate latestActivity,
			ClientEntity owner, BankEntity bank, List<CreditTransferOrderEntity> transfersToAccount,
			List<CreditTransferOrderEntity> transfersFromAccount, Integer version) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.status = status;
		this.accountBalance = accountBalance;
		this.availableBalance = availableBalance;
		this.reservedBalance = reservedBalance;
		this.latestActivity = latestActivity;
		this.owner = owner;
		this.bank = bank;
		this.transfersToAccount = transfersToAccount;
		this.transfersFromAccount = transfersFromAccount;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public LocalDate getLatestActivity() {
		return latestActivity;
	}

	public void setLatestActivity(LocalDate latestActivity) {
		this.latestActivity = latestActivity;
	}

	public ClientEntity getOwner() {
		return owner;
	}

	public void setOwner(ClientEntity owner) {
		this.owner = owner;
	}

	public BankEntity getBank() {
		return bank;
	}

	public void setBank(BankEntity bank) {
		this.bank = bank;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
