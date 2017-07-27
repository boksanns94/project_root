package com.milosboksan.backendroot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.milosboksan.backendroot.entities.AddressEntity;
import com.milosboksan.backendroot.entities.dto.AddressContactInfoDTO;
import com.milosboksan.backendroot.repositories.AddressRepository;
import com.milosboksan.backendroot.services.AddressService;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;
import com.milosboksan.backendroot.util.RESTError;

/*
 * 
 * AddressController - Functionality for the AddressEntity
 * Author: Milos Boksan
 * Created on: 23:56 24.07.2017.
 */

@RestController
@RequestMapping("api/address")
public class AddressController
{
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AddressService addressService;
	
	public AddressController(AddressRepository addressRepository, AddressService addressService) {
		super();
		this.addressRepository = addressRepository;
		this.addressService = addressService;
	}
	
	//Create Address
	@RequestMapping(method = RequestMethod.POST, value = "/createAddress")
	public ResponseEntity<?> createAddress(@RequestBody AddressContactInfoDTO addressDTO)
	{
		//Try creating an address. If the address exists <ExistingEntityException> will trigger. If anything else goes wrong <Exception> will trigger.
		try	{
			return new ResponseEntity<>(this.addressService.createAddress(addressDTO), HttpStatus.OK);
		} catch (ExistingEntityException ee) {
			return new ResponseEntity<>(new RESTError(400, ee.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Update Address
	@RequestMapping(method = RequestMethod.PUT, value = "/{addressId}")
	public ResponseEntity<?> updateAddress(@PathVariable("addressId") Integer addressId, @RequestBody(required = false) AddressContactInfoDTO addressDTO)
	{
		//Check if the address exists. If the address exists it is updated. If the address doesn't exist <NOT_FOUND> is triggered. If anything else goes wrong <Exception> will trigger.
		try {
			if(this.addressRepository.exists(addressId))
			{
				AddressEntity updatedAddress = this.addressRepository.findOne(addressId);
				
				if(addressDTO.getStreetName() != null)
					updatedAddress.setStreetName(addressDTO.getStreetName());
				if(addressDTO.getStreetNumber() != null)
					updatedAddress.setStreetNumber(addressDTO.getStreetNumber());
				if(addressDTO.getCityName() != null)
					updatedAddress.setCityName(addressDTO.getCityName());
				if(addressDTO.getPostalCode() != null)
					updatedAddress.setPostalCode(addressDTO.getPostalCode());
				if(addressDTO.getStateName() != null)
					updatedAddress.setStateName(addressDTO.getStateName());
				if(addressDTO.getCountryName() != null)
					updatedAddress.setCountryName(addressDTO.getStreetName());
				
				this.addressRepository.save(updatedAddress);
				
				return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Address with Id: " + addressId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete Address
	@RequestMapping(method = RequestMethod.DELETE, value = "/{addressId}")
	public ResponseEntity<?> deleteAddress(@PathVariable("addressId") Integer addressId)
	{
		//Check if the address exists. If the address exists it is deleted. If the address doesn't exist <NOT_FOUND> is triggered. If anything else goes wrong <Exception> will trigger.
		try {
			if(this.addressRepository.exists(addressId))
			{
				AddressEntity deletedAddress = this.addressRepository.findOne(addressId);
				
				this.addressRepository.delete(deletedAddress);
				
				return new ResponseEntity<>(deletedAddress, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Address with Id: " + addressId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get Address By Id
	@RequestMapping(method = RequestMethod.GET, value = "/{addressId}")
	public ResponseEntity<?> getAddressById(@PathVariable("addressId") Integer addressId)
	{
		//Check if the address exists. If the address exists it is returned. If the address doesn't exist <NOT_FOUND> is triggered. If anything else goes wrong <Exception> will trigger.
		try {
			if(this.addressRepository.exists(addressId))
			{
				return new ResponseEntity<>(this.addressRepository.findOne(addressId), HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Address with Id: " + addressId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get All Addresses
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllAddresses()
	{
		try {
			return new ResponseEntity<>(this.addressRepository.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
