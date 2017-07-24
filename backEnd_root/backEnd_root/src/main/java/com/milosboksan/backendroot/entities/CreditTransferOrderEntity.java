package com.milosboksan.backendroot.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 
 * CreditTransferOrderEntity - For storing data about a single credit transfer.
 * Author: Milos Boksan
 * Created on: 02:55 24.07.2017.
 */

@Entity
public class CreditTransferOrderEntity
{
	@JsonProperty("ID")
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
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "dd-MM-yyyy hh:mm:ss"
			)
	private LocalDate paymentDate;
	@Column(nullable = false)
	private Boolean urgencyStatus;//0 - Not urgent, 1 - Urgent / 0 - default
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "payingClient")
	private ClientEntity payingClient;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "payerAccount")
	private CustomerAccountEntity payerAccount;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "recipientAccount")
	private CustomerAccountEntity recipientAccount;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "currency")
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
