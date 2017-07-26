package com.milosboksan.backendroot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milosboksan.backendroot.entities.AddressEntity;
import com.milosboksan.backendroot.entities.BankEntity;
import com.milosboksan.backendroot.entities.ContactInfoEntity;
import com.milosboksan.backendroot.entities.dto.BankDTO;
import com.milosboksan.backendroot.repositories.BankRepository;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;

@Service
public class BankService
{
	private BankRepository bankRepository;
	
	private AddressService addressService;
	private ContactInfoService contactInfoService;
	
	@Autowired
	public BankService(BankRepository bankRepository, AddressService addressService,
			ContactInfoService contactInfoService) {
		super();
		this.bankRepository = bankRepository;
		this.addressService = addressService;
		this.contactInfoService = contactInfoService;
	}
	
	public BankEntity createBank(BankDTO bankDTO) throws ExistingEntityException
	{
		BankEntity existingBank = new BankEntity();
		BankEntity newBank = new BankEntity();
		
		AddressEntity address = new AddressEntity();
		ContactInfoEntity contactInfo = new ContactInfoEntity();
		
		//Check if any bank already exists BY NAME
		if(this.bankRepository.existsByBankName(bankDTO.getBankName()))
		{
			existingBank = this.bankRepository.findByBankName(bankDTO.getBankName());
			throw new ExistingEntityException(existingBank, "Bank with name: " + bankDTO.getBankName() + " already exists." );
		}
		else //Check if any bank already exists BY ID NUMBER
			if(this.bankRepository.existsByBankIdNumber(bankDTO.getBankIdNumber()))
			{
				existingBank = this.bankRepository.findByBankIdNumber(bankDTO.getBankIdNumber());
				throw new ExistingEntityException(existingBank, "Bank with ID: " + bankDTO.getBankIdNumber() + " already exists.");
			}
				else //Create new bank
				{
					//Setting basic bank parameters
					newBank.setBankName(bankDTO.getBankName());
					newBank.setBankIdNumber(bankDTO.getBankIdNumber());
					
					//Setting address
					try {
						address = this.addressService.createAddress(bankDTO);
					} catch (ExistingEntityException e) {
						address = (AddressEntity) e.getEntity();
					}
					newBank.setAddress(address);
					
					//Setting contact info
					try {
						contactInfo = this.contactInfoService.createContactInfo(bankDTO);
					} catch (ExistingEntityException e) {
						contactInfo = (ContactInfoEntity) e.getEntity();
					}
					newBank.setContactInfo(contactInfo);
					
					//Saved.
					return this.bankRepository.save(newBank);
				}
	}	

}