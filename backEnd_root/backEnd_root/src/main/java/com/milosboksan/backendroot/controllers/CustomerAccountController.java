package com.milosboksan.backendroot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.milosboksan.backendroot.entities.CustomerAccountEntity;
import com.milosboksan.backendroot.entities.dto.CustomerAccountDTO;
import com.milosboksan.backendroot.repositories.CustomerAccountRepository;
import com.milosboksan.backendroot.services.CustomerAccountService;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;
import com.milosboksan.backendroot.util.RESTError;

@RestController
@RequestMapping("api/account")
public class CustomerAccountController
{
	@Autowired
	CustomerAccountRepository customerAccountRepository;
	@Autowired
	CustomerAccountService customerAccountService;
	
	public CustomerAccountController(CustomerAccountRepository customerAccountRepository,
			CustomerAccountService customerAccountService) {
		super();
		this.customerAccountRepository = customerAccountRepository;
		this.customerAccountService = customerAccountService;
	}
	
	//Create Customer Account
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createCustomerAccount(@RequestBody CustomerAccountDTO customerAccountDTO)
	{
		try {
			return new ResponseEntity<>(this.customerAccountService.createCustomerAccount(customerAccountDTO), HttpStatus.OK);
		} catch(ExistingEntityException ee) {
			return new ResponseEntity<>(new RESTError(400, ee.getMessage()), HttpStatus.BAD_REQUEST);
		} catch(IllegalArgumentException ia) {
			return new ResponseEntity<>(new RESTError(400, ia.getMessage()), HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete Customer Account
	@RequestMapping(method = RequestMethod.DELETE, value = "/{accountId}")
	public ResponseEntity<?> deleteCustomerAccount(@PathVariable Integer accountId)
	{
		CustomerAccountEntity deletedCustomerAccount = new CustomerAccountEntity();
		
		try {
			if(this.customerAccountRepository.exists(accountId))
			{
				deletedCustomerAccount = this.customerAccountRepository.findOne(accountId);
				this.customerAccountRepository.delete(deletedCustomerAccount);
				return new ResponseEntity<>(deletedCustomerAccount, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new RESTError(404, "Account with Id: " + accountId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get Account By Id
	@RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
	public ResponseEntity<?> getAccountById(@PathVariable Integer accountId)
	{
		try {
			if(this.customerAccountRepository.exists(accountId))
			{
				return new ResponseEntity<>(this.customerAccountRepository.findOne(accountId), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new RESTError(404, "Customer Account with Id: " + accountId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get All Accounts
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllAccounts()
	{
		try {
			return new ResponseEntity<>(this.customerAccountRepository.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Change Account Balance
	@RequestMapping(method = RequestMethod.PUT, value = "/{accountID}/balance")
	public ResponseEntity<?> changeCustomerBalance(@PathVariable Integer accountId, @RequestParam Double amount)
	{
		CustomerAccountEntity customerAccount = new CustomerAccountEntity();
		
		try {
			if(this.customerAccountRepository.exists(accountId))
			{
				customerAccount = this.customerAccountService.changeAccountBalance(accountId, amount);
				return new ResponseEntity<>(customerAccount, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new RESTError(404, "Account with Id: " + accountId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
