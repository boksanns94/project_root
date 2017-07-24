package com.milosboksan.backendroot.entities;

import java.time.LocalDate;

/*
 * CreditTransferOrderEntity - For storing data about a single credit transfer.
 * Author: Milos Boksan
 * Created on: 02:55 24.07.2017.
 */

public class CreditTransferOrderEntity
{
	private Integer id;
	private String recipient;
	private String transferPurpose;
	private Integer paymentCode;
	private Double ammount;
	private String modelNumber;
	private String referenceNumber;
	private LocalDate paymentDate;
	private Boolean urgencyStatus;//0 - Not urgent, 1 - Urgent / 0 - default
	private Integer version;
	
	//Constructors
	public CreditTransferOrderEntity() {
		super();
	}

	public CreditTransferOrderEntity(Integer id, String recipient, String transferPurpose, Integer paymentCode,
			Double ammount, String modelNumber, String referenceNumber, LocalDate paymentDate, Boolean urgencyStatus,
			Integer version) {
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
		this.version = version;
	}
	
	//get() and set() methods
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
