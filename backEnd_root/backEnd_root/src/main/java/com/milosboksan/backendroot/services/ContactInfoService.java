package com.milosboksan.backendroot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milosboksan.backendroot.entities.ContactInfoEntity;
import com.milosboksan.backendroot.entities.dto.AddressContactInfoDTO;
import com.milosboksan.backendroot.repositories.ContactInfoRepository;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;

@Service
public class ContactInfoService
{
	private ContactInfoRepository contactInfoRepository;
	
	@Autowired
	public ContactInfoService(ContactInfoRepository contactInfoRepository)
	{
		this.contactInfoRepository = contactInfoRepository;
	}
	
	public <T extends AddressContactInfoDTO> ContactInfoEntity createContactInfo(T contactInfoDTO) throws ExistingEntityException
	{
		ContactInfoEntity existingContactInfo = new ContactInfoEntity();
		ContactInfoEntity newContactInfo = new ContactInfoEntity();
		
		if(this.contactInfoRepository.existsByEmail(contactInfoDTO.getEmail()))
		{
			existingContactInfo = this.contactInfoRepository.findByEmail(contactInfoDTO.getEmail());
			throw new ExistingEntityException(existingContactInfo, "Contact with email: " + contactInfoDTO.getEmail() + " already exists.");
		}
		else
			if(this.contactInfoRepository.existsByPrimaryPhone(contactInfoDTO.getPrimaryPhone()))
			{
				existingContactInfo = this.contactInfoRepository.findByPrimaryPhone(contactInfoDTO.getPrimaryPhone());
				throw new ExistingEntityException(existingContactInfo, "Contact with phone number: " + contactInfoDTO.getPrimaryPhone() + " already exists.");
			}
			else
			{
				newContactInfo.setEmail(contactInfoDTO.getEmail());
				newContactInfo.setPrimaryPhone(contactInfoDTO.getPrimaryPhone());
				newContactInfo.setSecondaryPhone(contactInfoDTO.getSecondaryPhone());
				
				this.contactInfoRepository.save(newContactInfo);
				
				return newContactInfo;
			}
	}
}
