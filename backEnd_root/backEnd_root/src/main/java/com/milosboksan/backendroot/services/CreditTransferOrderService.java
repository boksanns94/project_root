package com.milosboksan.backendroot.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milosboksan.backendroot.entities.CreditTransferOrderEntity;
import com.milosboksan.backendroot.entities.CustomerAccountEntity;
import com.milosboksan.backendroot.entities.dto.CreditTransferOrderDTO;
import com.milosboksan.backendroot.repositories.ClientRepository;
import com.milosboksan.backendroot.repositories.CreditTransferOrderRepository;
import com.milosboksan.backendroot.repositories.CustomerAccountRepository;

@Service
public class CreditTransferOrderService
{
	private CustomerAccountRepository customerAccountRepository;
	private ClientRepository clientRepository;
	private CreditTransferOrderRepository creditTransferOrderRepository;
	
	@Autowired
	public CreditTransferOrderEntity creditTransferOrder(CreditTransferOrderDTO creditTransferOrderDTO)
	{
		//We need to validate the data of the incoming transfer order before proceeding
		//If any of the fields are missing, the transaction will not be initiated
		creditTransferOrderValidation(creditTransferOrderDTO);
		
		CustomerAccountEntity payingAccount = this.customerAccountRepository.findOne(creditTransferOrderDTO.getPayerAccountID());
		CustomerAccountEntity recipientAccount = this.customerAccountRepository.findOne(creditTransferOrderDTO.getRecipientAccountID());
		
		//Creating a new credit transfer entity.
		CreditTransferOrderEntity creditTransfer = new CreditTransferOrderEntity();
		
		//Initializing a credit transfer
		creditTransfer.setRecipient(creditTransfer.getRecipient());
		creditTransfer.setTransferPurpose(creditTransfer.getTransferPurpose());
		creditTransfer.setPaymentCode(creditTransfer.getPaymentCode());
		creditTransfer.setAmount(creditTransfer.getAmount());
		creditTransfer.setModelNumber(creditTransfer.getModelNumber());
		creditTransfer.setReferenceNumber(creditTransfer.getReferenceNumber());
		creditTransfer.setPaymentDate(LocalDate.now());
		creditTransfer.setUrgencyStatus(creditTransfer.getUrgencyStatus());
		
		creditTransfer.setPayingClient(this.clientRepository.findOne(creditTransferOrderDTO.getPayingClientID()));
		creditTransfer.setPayerAccount(payingAccount);
		creditTransfer.setRecipientAccount(recipientAccount);
		
		//Executing a credit transfer
		payingAccount.setAccountBalance(payingAccount.getAccountBalance() - creditTransferOrderDTO.getAmount());
		recipientAccount.setAccountBalance(recipientAccount.getAccountBalance() + creditTransferOrderDTO.getAmount());
		
		//Ending a credit transfer
		//Saving balances
		this.customerAccountRepository.save(payingAccount);
		this.customerAccountRepository.save(recipientAccount);
		
		//Saving credit transfer history
		this.creditTransferOrderRepository.save(creditTransfer);
		
		return creditTransfer;
	}
	
	private void creditTransferOrderValidation(CreditTransferOrderDTO creditTransferOrderDTO) throws IllegalArgumentException
	{
		//Validate existence of paying client
		if(!(this.clientRepository.exists(creditTransferOrderDTO.getPayingClientID())))
			throw new IllegalArgumentException("Payer with ID: " + creditTransferOrderDTO.getPayingClientID() + " doesn't exist.");
		
		//Validate existence of paying clients account
		if(!(this.clientRepository.exists(creditTransferOrderDTO.getPayerAccountID())))
			throw new IllegalArgumentException("Paying account with ID: " + creditTransferOrderDTO.getPayerAccountID() + " doesn't exist.");
		
		//Validate existence of recipient clients account
		if(!(this.clientRepository.exists(creditTransferOrderDTO.getRecipientAccountID())))
			throw new IllegalArgumentException("Recipient account with ID: " + creditTransferOrderDTO.getRecipientAccountID() + " doesn't exist.");
		
		//Validate existence of positive amount
		if(creditTransferOrderDTO.getAmount() <= 0.0)
			throw new IllegalArgumentException("Ammount must be positive!");
		
		//Validate existence of available funds on paying account for credit transfer
		if((this.customerAccountRepository.findOne(creditTransferOrderDTO.getPayerAccountID()).getAccountBalance()) < creditTransferOrderDTO.getAmount())
			throw new IllegalArgumentException("Insufficient funds!");
	}
}
