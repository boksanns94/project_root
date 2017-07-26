package com.milosboksan.backendroot.services;

import com.milosboksan.backendroot.entities.AddressEntity;
import com.milosboksan.backendroot.entities.ClientEntity;
import com.milosboksan.backendroot.entities.ContactInfoEntity;
import com.milosboksan.backendroot.entities.dto.ClientDTO;
import com.milosboksan.backendroot.repositories.ClientRepository;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;

public class ClientService
{
	private ClientRepository clientRepository;
	
	private AddressService addressService;
	private ContactInfoService contactInfoService;
	
	public ClientService(ClientRepository clientRepository, AddressService addressService,
			ContactInfoService contactInfoService) {
		super();
		this.clientRepository = clientRepository;
		this.addressService = addressService;
		this.contactInfoService = contactInfoService;
	}

	public ClientEntity createClient(ClientDTO clientDTO) throws ExistingEntityException
	{
		ClientEntity newClient = new ClientEntity();
		
		AddressEntity address = new AddressEntity();
		ContactInfoEntity contactInfo = new ContactInfoEntity();
		
		//Check if any client already exists BY JMBG
		if(this.clientRepository.existsByJmbg(clientDTO.getJmbg()))
		{
			throw new ExistingEntityException(this.clientRepository.findByJmbg(clientDTO.getJmbg()), "Bank client with jmbg: " + clientDTO.getJmbg() + " already exists.");
		}
		else //Check if any client already has selected USERNAME
			if(this.clientRepository.existsByUsername(clientDTO.getUsername()))
			{
				throw new ExistingEntityException(this.clientRepository.findByUsername(clientDTO.getUsername()), "The username " + clientDTO.getUsername() + " is already taken.");
			}
				else //Create new client
				{	
					//Check to see if the client type has been set. If not set to default.
					if(clientDTO.getClientType() == null)
					{
						newClient.setClientType(1); //0 - Legal Person, 1 - Natural Person / 1 - default
					}
					
					//Setting basic client parameters
					newClient.setName(clientDTO.getName());
					newClient.setSurname(clientDTO.getSurname());
					newClient.setJmbg(clientDTO.getJmbg());
					
					//Setting address
					try {
						address = this.addressService.createAddress(clientDTO);
					} catch (ExistingEntityException e) {
						address = (AddressEntity) e.getEntity();
					}
					newClient.setAddress(address);
					
					//Setting contact info
					try {
						contactInfo = this.contactInfoService.createContactInfo(clientDTO);
					} catch (ExistingEntityException e) {
						contactInfo = (ContactInfoEntity) e.getEntity();
					}
					newClient.setContactInfo(contactInfo);
					
					//Setting authentification info
					newClient.setUsername(clientDTO.getUsername());
					newClient.setPassword(clientDTO.getPassword());
					newClient.setStatus(1);//0 - Inactive, 1 - Active / 1 - default
					newClient.setAuthorisationLevel(1);//0 - Administrator, 1 - User / 1 - default
					
					//Saved
					this.clientRepository.save(newClient);
					
					return newClient;
					
				}
	}
}
