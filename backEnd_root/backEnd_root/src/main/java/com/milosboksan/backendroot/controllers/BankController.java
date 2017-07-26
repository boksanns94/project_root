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

import com.milosboksan.backendroot.entities.AddressEntity;
import com.milosboksan.backendroot.entities.BankEntity;
import com.milosboksan.backendroot.entities.ContactInfoEntity;
import com.milosboksan.backendroot.entities.dto.BankDTO;
import com.milosboksan.backendroot.repositories.AddressRepository;
import com.milosboksan.backendroot.repositories.BankRepository;
import com.milosboksan.backendroot.repositories.ContactInfoRepository;
import com.milosboksan.backendroot.services.BankService;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;
import com.milosboksan.backendroot.util.RESTError;

@RestController
@RequestMapping("api/bank")
public class BankController
{
	private BankRepository bankRepository;
	private AddressRepository addressRepository;
	private ContactInfoRepository contactInfoRepository;
	private BankService bankService;
	
	@Autowired
	public BankController(BankRepository bankRepository, AddressRepository addressRepository,
			ContactInfoRepository contactInfoRepository, BankService bankService) {
		super();
		this.bankRepository = bankRepository;
		this.addressRepository = addressRepository;
		this.contactInfoRepository = contactInfoRepository;
		this.bankService = bankService;
	}

	//Create Bank
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createBank(@RequestBody BankDTO bankDTO)
	{
		BankEntity bank = new BankEntity();
		
		try {
			bank = this.bankService.createBank(bankDTO);
			return new ResponseEntity<>(bank, HttpStatus.OK);
		} catch (ExistingEntityException ee) {
			return new ResponseEntity<>(new RESTError(400, ee.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Update Bank
	@RequestMapping(method = RequestMethod.PUT, value="/{bankId}")
	public ResponseEntity<?> updateBank(@PathVariable("bankId") Integer bankId, @RequestBody(required = false) BankDTO bankDTO)
	{
		try {
			if(this.bankRepository.exists(bankId))
			{
				BankEntity updatedBank = this.bankRepository.findOne(bankId);
				
				if(bankDTO.getBankName() != null)
					updatedBank.setBankName(bankDTO.getBankName());
				if(bankDTO.getBankIdNumber() != null)
					updatedBank.setBankIdNumber(bankDTO.getBankIdNumber());
					
				this.bankRepository.save(updatedBank);
				
				return new ResponseEntity<>(updatedBank, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Bank with Id: " + bankId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete Bank
	@RequestMapping(method = RequestMethod.DELETE, value = "/{bankId}")
	public ResponseEntity<?> deleteBank(@PathVariable("bankId") Integer bankId)
	{
		try {
			if(this.bankRepository.exists(bankId))
			{
				BankEntity deletedBank = this.bankRepository.findOne(bankId);
				
				this.bankRepository.delete(deletedBank);
				
				return new ResponseEntity<>(deletedBank, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Client with Id: " + bankId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get Bank By Id
	@RequestMapping(method = RequestMethod.GET, value = "/{bankId}")
	public ResponseEntity<?> getBankById(@PathVariable("bankId") Integer bankId)
	{
		try {
			if(this.bankRepository.exists(bankId))
			{
				return new ResponseEntity<>(this.bankRepository.findOne(bankId), HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Client with Id: " + bankId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get All Banks
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllBanks()
	{
		try {
			return new ResponseEntity<>(this.bankRepository.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Add Address To Bank
	@RequestMapping(method = RequestMethod.PUT, value = "/{bankId}/address")
	public ResponseEntity<?> addAddressToBank(@PathVariable Integer bankId, @RequestParam Integer addressId)
	{
		BankEntity bank = new BankEntity();
		AddressEntity address = new AddressEntity();
		
		try {
			if(this.bankRepository.exists(bankId))
			{
				bank = this.bankRepository.findOne(bankId);
				
				if(this.addressRepository.exists(addressId))
				{
					address = this.addressRepository.findOne(addressId);
					bank.setAddress(address);
					
					this.bankRepository.save(bank);
					
					return new ResponseEntity<>(bank, HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<>(new RESTError(404, "Address with Id: " + addressId + " doesn't exist."), HttpStatus.NOT_FOUND);
				}
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Bank with Id: " + bankId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Add Contact Info To Bank
	@RequestMapping(method = RequestMethod.PUT, value = "/{bankId}/contactInfo")
	public ResponseEntity<?> addContactInfoToBank(@PathVariable Integer bankId, @RequestParam Integer contactInfoId)
	{
		BankEntity bank = new BankEntity();
		ContactInfoEntity contactInfo = new ContactInfoEntity();
		
		try {
			if(this.bankRepository.exists(bankId))
			{
				bank = this.bankRepository.findOne(bankId);
				
				if(this.contactInfoRepository.exists(contactInfoId))
				{
					contactInfo = this.contactInfoRepository.findOne(contactInfoId);
					bank.setContactInfo(contactInfo);
					
					this.bankRepository.save(bank);
					
					return new ResponseEntity<>(bank, HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<>(new RESTError(404, "Contact Info with Id: " + contactInfoId + " doesn't exist."), HttpStatus.NOT_FOUND);
				}
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Bank with Id: " + bankId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
