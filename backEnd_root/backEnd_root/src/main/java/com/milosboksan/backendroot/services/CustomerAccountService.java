package com.milosboksan.backendroot.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milosboksan.backendroot.entities.CustomerAccountEntity;
import com.milosboksan.backendroot.entities.dto.CustomerAccountDTO;
import com.milosboksan.backendroot.repositories.BankRepository;
import com.milosboksan.backendroot.repositories.ClientRepository;
import com.milosboksan.backendroot.repositories.CustomerAccountRepository;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;

@Service
public class CustomerAccountService
{
	private BankRepository bankRepository;
	private CustomerAccountRepository customerAccountRepository;
	private ClientRepository clientRepository;
	
	@Autowired
	public CustomerAccountService(BankRepository bankRepository, CustomerAccountRepository customerAccountRepository,
			ClientRepository clientRepository) {
		super();
		this.bankRepository = bankRepository;
		this.customerAccountRepository = customerAccountRepository;
		this.clientRepository = clientRepository;
	}

	public CustomerAccountEntity createCustomerAccount(CustomerAccountDTO customerAccountDTO) throws ExistingEntityException, IllegalArgumentException
	{
		CustomerAccountEntity newCustomerAccount = new CustomerAccountEntity();
		
		//Check if any account exists with same account number
		if(this.customerAccountRepository.existsByAccountNumber(customerAccountDTO.getAccountNumber()))
		{
			throw new ExistingEntityException(this.customerAccountRepository.findByAccountNumber(customerAccountDTO.getAccountNumber()), "Account with number: " + customerAccountDTO.getAccountNumber() + " already exists.");
		}
		else
		{	//Check if the bank this account is created in exists
			if(this.bankRepository.exists(customerAccountDTO.getBankID()))
			{	//Check if the client exists in the bank
				if(this.clientRepository.exists(customerAccountDTO.getOwnerID()))
				{
					//Setting basic account parameters
					newCustomerAccount.setAccountType(customerAccountDTO.getAccountType());
					newCustomerAccount.setAccountNumber(customerAccountDTO.getAccountNumber());
					
					//Setting default values of every NEW account
					
					//Default Value of <Status> is 1 (Enabled)
					newCustomerAccount.setStatus(1);
					//Default Value of **Balance fields is 0.0 (There is no balance on a new account)
					newCustomerAccount.setAccountBalance(0.0);
					newCustomerAccount.setAvailableBalance(0.0);
					newCustomerAccount.setReservedBalance(0.0);
					//Default Value is date of creation
					newCustomerAccount.setLatestActivity(LocalDate.now());
					
					//Setting owner of account
					newCustomerAccount.setOwner(this.clientRepository.findOne(customerAccountDTO.getOwnerID()));
					//Setting bank account belongs to
					newCustomerAccount.setBank(this.bankRepository.findOne(customerAccountDTO.getBankID()));
					
					//Saved
					return this.customerAccountRepository.save(newCustomerAccount);
				}
				else
					throw new IllegalArgumentException("Client with id: " + customerAccountDTO.getOwnerID() + " doesn't exist.");
			}
			else
				throw new IllegalArgumentException("Bank with id: " + customerAccountDTO.getBankID() + " doesn't exist.");
		}
	}

	//Method for direct account balance change
	//Available only to administrators
	public CustomerAccountEntity changeAccountBalance(Integer AccountID, Double ammount)
	{
		//Getting the account whose balance is getting changed
		CustomerAccountEntity customerAccount;
		Double newBalance;
		
		//Getting the account whose balance is getting changed
		customerAccount = this.customerAccountRepository.findOne(AccountID);
		
		//Calculating the account balance
		newBalance = customerAccount.getAccountBalance();

		//Setting new balance
		//There is no check for overdraft on account
		//This is an evil bank. We take even the money you dont have
		customerAccount.setAccountBalance(newBalance);
			
		//Updating the latest activity
		customerAccount.setLatestActivity(LocalDate.now());
		
		//Saved
		return this.customerAccountRepository.save(customerAccount);
	}
	
}
