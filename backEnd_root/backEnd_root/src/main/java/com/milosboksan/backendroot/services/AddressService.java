package com.milosboksan.backendroot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milosboksan.backendroot.entities.AddressEntity;
import com.milosboksan.backendroot.entities.dto.AddressContactInfoDTO;
import com.milosboksan.backendroot.repositories.AddressRepository;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;

@Service
public class AddressService
{
	@Autowired
	private AddressRepository addressRepository;
	
	public AddressService(AddressRepository addressRepository)
	{
		this.addressRepository = addressRepository;
	}
	
	//Allowed for <createAddress> method to expect both BankDTO and ClientDTO types.
	//Precondition: BankDTO and ClientDTO both now extend AddressContactInfoDTO.
	public <T extends AddressContactInfoDTO> AddressEntity createAddress(T addressDTO) throws ExistingEntityException
	{
		AddressEntity existingAddress = new AddressEntity();
		AddressEntity newAddress = new AddressEntity();
		
		//Check if any address exists with all the criteria
		if(this.addressRepository.existsByCountryNameAndStateNameAndPostalCodeAndCityNameAndStreetNumberAndStreetName(addressDTO.getCountryName(), addressDTO.getStateName(), addressDTO.getPostalCode(), addressDTO.getCityName(), addressDTO.getStreetNumber(), addressDTO.getStreetNumber()))
		{	//If exists throw exception and return found existing address entity
			existingAddress = this.addressRepository.findByCountryNameAndStateNameAndPostalCodeAndCityNameAndStreetNumberAndStreetName(addressDTO.getCountryName(), addressDTO.getStateName(), addressDTO.getPostalCode(), addressDTO.getCityName(), addressDTO.getStreetNumber(), addressDTO.getStreetNumber());
			throw new ExistingEntityException(existingAddress, "Address: " + addressDTO.getStreetName() + " " + addressDTO.getStreetNumber() + ", " + addressDTO.getPostalCode() + " " + addressDTO.getCityName() + " already exists.");
		}
		else //If address doesn't exist, create a new address
		{
			newAddress.setStreetName(addressDTO.getStreetName());
			newAddress.setStreetNumber(addressDTO.getStreetNumber());
			newAddress.setCityName(addressDTO.getCityName());
			newAddress.setPostalCode(addressDTO.getPostalCode());
			newAddress.setStateName(addressDTO.getStateName());
			newAddress.setCountryName(addressDTO.getCountryName());
			
			this.addressRepository.save(newAddress);
			
			//Saved.
			return newAddress;
		}
	}

}
