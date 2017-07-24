package com.milosboksan.backendroot.entities;

import javax.persistence.*;

import java.time.LocalDate;

/*
 * CreditTransferOrderEntity - For storing data about a single credit transfer.
 * Author: Milos Boksan
 * Created on: 02:55 24.07.2017.
 */

@Entity
public class CreditTransferOrderEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String recipient;//Any recipient data can be recorded here, preferably an account number. Used to check if account exists.
	@Column(nullable = false)
	private String transferPurpose;//Translation: SVRHA UPLATE
	@Column(nullable = false)
	private Integer paymentCode;//Translation: SIFRA PLACANJA
	@Column(nullable = false)
	private Double ammount;
	@Column
	private String modelNumber;//97 - default
	@Column
	private String referenceNumber;//Translation: POZIV NA BROJ / null - default
	@Column(nullable = false)
	private LocalDate paymentDate;
	@Column(nullable = false)
	private Boolean urgencyStatus;//0 - Not urgent, 1 - Urgent / 0 - default
	
	private ClientEntity payingClient;
	private CustomerAccountEntity payerAccount;
	private CustomerAccountEntity recipientAccount;
	private CurrencyEntity currency;
	
	@Version
	private Integer version;
	
	//Constructors
	public CreditTransferOrderEntity() {
		super();
	}

	public CreditTransferOrderEntity(Integer id, String recipient, String transferPurpose, Integer paymentCode,
			Double ammount, String modelNumber, String referenceNumber, LocalDate paymentDate, Boolean urgencyStatus,
			ClientEntity payingClient, CustomerAccountEntity payerAccount, CustomerAccountEntity recipientAccount,
			CurrencyEntity currency, Integer version) {
		super();
		this.id = id;
		this.recipient = recipient;
		this.transferPurpose = transferPurpose;
		this.paymentCode = paymentCode;
		this.ammount = ammount;
		this.modelNumber = modelNumber;
		this.referenceNumber = referenceNumber;
		this.paymentDate = paymentDate;
		this.urgencyStatus = urgencyStatus;
		this.payingClient = payingClient;
		this.payerAccount = payerAccount;
		this.recipientAccount = recipientAccount;
		this.currency = currency;
		this.version = version;
	}
	
	//get() i set() metode
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getTransferPurpose() {
		return transferPurpose;
	}

	public void setTransferPurpose(String transferPurpose) {
		this.transferPurpose = transferPurpose;
	}

	public Integer getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(Integer paymentCode) {
		this.paymentCode = paymentCode;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Boolean getUrgencyStatus() {
		return urgencyStatus;
	}

	public void setUrgencyStatus(Boolean urgencyStatus) {
		this.urgencyStatus = urgencyStatus;
	}

	public ClientEntity getPayingClient() {
		return payingClient;
	}

	public void setPayingClient(ClientEntity payingClient) {
		this.payingClient = payingClient;
	}

	public CustomerAccountEntity getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(CustomerAccountEntity payerAccount) {
		this.payerAccount = payerAccount;
	}

	public CustomerAccountEntity getRecipientAccount() {
		return recipientAccount;
	}

	public void setRecipientAccount(CustomerAccountEntity recipientAccount) {
		this.recipientAccount = recipientAccount;
	}

	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
}