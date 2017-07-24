package com.milosboksan.backendroot.entities.dto;

public class CreditTransferOrderDTO
{
	private String recipient;
	private String transferPurpose;
	private Integer paymentCode;
	private Double ammount;
	private String modelNumber;
	private String referenceNumber;
	//The date is set automatically on the current date.
	private Boolean urgencyStatus;
	private Integer payingClientID;
	private Integer payerAccountID;
	private Integer recipientAccountID;
	private Integer currencyID;
	
	public CreditTransferOrderDTO() {
		super();
	}
	
	public CreditTransferOrderDTO(String recipient, String transferPurpose, Integer paymentCode, Double ammount,
			String modelNumber, String referenceNumber, Boolean urgencyStatus, Integer payingClientID,
			Integer payerAccountID, Integer recipientAccountID, Integer currencyID) {
		super();
		this.recipient = recipient;
		this.transferPurpose = transferPurpose;
		this.paymentCode = paymentCode;
		this.ammount = ammount;
		this.modelNumber = modelNumber;
		this.referenceNumber = referenceNumber;
		this.urgencyStatus = urgencyStatus;
		this.payingClientID = payingClientID;
		this.payerAccountID = payerAccountID;
		this.recipientAccountID = recipientAccountID;
		this.currencyID = currencyID;
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

	public Boolean getUrgencyStatus() {
		return urgencyStatus;
	}

	public void setUrgencyStatus(Boolean urgencyStatus) {
		this.urgencyStatus = urgencyStatus;
	}

	public Integer getPayingClientID() {
		return payingClientID;
	}

	public void setPayingClientID(Integer payingClientID) {
		this.payingClientID = payingClientID;
	}

	public Integer getPayerAccountID() {
		return payerAccountID;
	}

	public void setPayerAccountID(Integer payerAccountID) {
		this.payerAccountID = payerAccountID;
	}

	public Integer getRecipientAccountID() {
		return recipientAccountID;
	}

	public void setRecipientAccountID(Integer recipientAccountID) {
		this.recipientAccountID = recipientAccountID;
	}

	public Integer getCurrencyID() {
		return currencyID;
	}

	public void setCurrencyID(Integer currencyID) {
		this.currencyID = currencyID;
	}
	
}
