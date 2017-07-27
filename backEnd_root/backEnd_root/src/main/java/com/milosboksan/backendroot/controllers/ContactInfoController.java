package com.milosboksan.backendroot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.milosboksan.backendroot.entities.ContactInfoEntity;
import com.milosboksan.backendroot.entities.dto.AddressContactInfoDTO;
import com.milosboksan.backendroot.repositories.ContactInfoRepository;
import com.milosboksan.backendroot.services.ContactInfoService;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;
import com.milosboksan.backendroot.util.RESTError;

@RestController
@RequestMapping("api/contactInfo")
public class ContactInfoController
{
	@Autowired
	private ContactInfoRepository contactInfoRepository;
	@Autowired
	private ContactInfoService contactInfoService;
	
	public ContactInfoController(ContactInfoRepository contactInfoRepository, ContactInfoService contactInfoService) {
		super();
		this.contactInfoRepository = contactInfoRepository;
		this.contactInfoService = contactInfoService;
	}
	
	//Create Contact Info
	@RequestMapping(method = RequestMethod.POST, value = "/createContactInfo")
	public ResponseEntity<?> createContactInfo(@RequestBody AddressContactInfoDTO contactInfoDTO)
	{
		try	{
			return new ResponseEntity<>(this.contactInfoService.createContactInfo(contactInfoDTO), HttpStatus.OK);
		} catch (ExistingEntityException ee) {
			return new ResponseEntity<>(new RESTError(400, ee.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Update Contact Info
	@RequestMapping(method = RequestMethod.PUT, value = "/{contactInfoId}")
	public ResponseEntity<?> updateAddress(@PathVariable("contactInfoId") Integer contactInfoId, @RequestBody(required = false) AddressContactInfoDTO contactInfoDTO)
	{
		try {
			if(this.contactInfoRepository.exists(contactInfoId))
			{
				ContactInfoEntity updatedContactInfo = this.contactInfoRepository.findOne(contactInfoId);
				
				if(contactInfoDTO.getEmail() != null)
					updatedContactInfo.setEmail(contactInfoDTO.getEmail());
				if(contactInfoDTO.getPrimaryPhone() != null)
					updatedContactInfo.setPrimaryPhone(contactInfoDTO.getPrimaryPhone());
				if(contactInfoDTO.getSecondaryPhone() != null)
					updatedContactInfo.setSecondaryPhone(contactInfoDTO.getSecondaryPhone());
				
				this.contactInfoRepository.save(updatedContactInfo);
				
				return new ResponseEntity<>(updatedContactInfo, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Contact Info with Id: " + contactInfoId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete Contact Info
	@RequestMapping(method = RequestMethod.DELETE, value = "/{contactInfoId}")
	public ResponseEntity<?> deleteContactInfo(@PathVariable("contactInfoId") Integer contactInfoId)
	{
		try {
			if(this.contactInfoRepository.exists(contactInfoId))
			{
				ContactInfoEntity deletedContactInfo = this.contactInfoRepository.findOne(contactInfoId);
				
				this.contactInfoRepository.delete(deletedContactInfo);
				
				return new ResponseEntity<>(deletedContactInfo, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Address with Id: " + contactInfoId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get Contact Info By Id
	@RequestMapping(method = RequestMethod.GET, value = "/{contactInfoId}")
	public ResponseEntity<?> getContactInfoById(@PathVariable("contactInfoId") Integer contactInfoId)
	{
		try {
			if(this.contactInfoRepository.exists(contactInfoId))
			{
				return new ResponseEntity<>(this.contactInfoRepository.findOne(contactInfoId), HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Address with Id: " + contactInfoId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get All Contact Info
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllContactInfo()
	{
		try {
			return new ResponseEntity<>(this.contactInfoRepository.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
