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
import com.milosboksan.backendroot.entities.ClientEntity;
import com.milosboksan.backendroot.entities.ContactInfoEntity;
import com.milosboksan.backendroot.entities.dto.ClientDTO;
import com.milosboksan.backendroot.repositories.AddressRepository;
import com.milosboksan.backendroot.repositories.ClientRepository;
import com.milosboksan.backendroot.repositories.ContactInfoRepository;
import com.milosboksan.backendroot.services.ClientService;
import com.milosboksan.backendroot.services.exceptions.ExistingEntityException;
import com.milosboksan.backendroot.util.RESTError;

@RestController
@RequestMapping("api/client")
public class ClientController
{
	private ClientRepository clientRepository;
	private AddressRepository addressRepository;
	private ContactInfoRepository contactInfoRepository;
	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientRepository clientRepository, AddressRepository addressRepository,
			ContactInfoRepository contactInfoRepository, ClientService clientService) {
		super();
		this.clientRepository = clientRepository;
		this.addressRepository = addressRepository;
		this.contactInfoRepository = contactInfoRepository;
		this.clientService = clientService;
	}
	
	//Create Client
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createClient(@RequestBody ClientDTO clientDTO)
	{
		try	{
			return new ResponseEntity<>(this.clientService.createClient(clientDTO), HttpStatus.OK);
		} catch (ExistingEntityException ee) {
			return new ResponseEntity<>(new RESTError(400, ee.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Update Client
	@RequestMapping(method = RequestMethod.PUT, value = "/{clientId}")
	public ResponseEntity<?> updateClient(@PathVariable("clientId") Integer clientId, @RequestBody(required = false) ClientDTO clientDTO)
	{
		try {
			if(this.clientRepository.exists(clientId))
			{
				ClientEntity updatedClient = this.clientRepository.findOne(clientId);
				
				if(clientDTO.getClientType() != null)
					updatedClient.setClientType(clientDTO.getClientType());
				if(clientDTO.getName() != null)
					updatedClient.setName(clientDTO.getName());
				if(clientDTO.getSurname() != null)
					updatedClient.setSurname(clientDTO.getSurname());
				if(clientDTO.getJmbg() != null)
					updatedClient.setJmbg(clientDTO.getJmbg());
				if(clientDTO.getUsername() != null)
					updatedClient.setUsername(clientDTO.getUsername());
				if(clientDTO.getPassword() != null)
					updatedClient.setPassword(clientDTO.getPassword());
				if(clientDTO.getStatus() != null)
					updatedClient.setStatus(clientDTO.getStatus());
				if(clientDTO.getAuthorisationLevel() != null)
					updatedClient.setAuthorisationLevel(clientDTO.getAuthorisationLevel());
				
				this.clientRepository.save(updatedClient);
				
				return new ResponseEntity<>(updatedClient, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Client with Id: " + clientId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete Client
	@RequestMapping(method = RequestMethod.DELETE, value = "/{clientId}")
	public ResponseEntity<?> deleteClient(@PathVariable("clientId") Integer clientId)
	{
		try {
			if(this.clientRepository.exists(clientId))
			{
				ClientEntity deletedClient = this.clientRepository.findOne(clientId);
				
				this.clientRepository.delete(deletedClient);
				
				return new ResponseEntity<>(deletedClient, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Client with Id: " + clientId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get Client By Id
	@RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
	public ResponseEntity<?> getClientById(@PathVariable("clientId") Integer clientId)
	{
		try {
			if(this.clientRepository.exists(clientId))
			{
				return new ResponseEntity<>(this.clientRepository.findOne(clientId), HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Client with Id: " + clientId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get All Clients
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllClients()
	{
		try {
			return new ResponseEntity<>(this.clientRepository.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Add Address To Client
	@RequestMapping(method = RequestMethod.PUT, value = "/{cliendId}/address")
	public ResponseEntity<?> addAddressToClient(@PathVariable Integer clientId, @RequestParam Integer addressId)
	{
		ClientEntity client = new ClientEntity();
		AddressEntity address = new AddressEntity();
		
		try {
			if(this.clientRepository.exists(clientId))
			{
				client = this.clientRepository.findOne(clientId);
				
				if(this.addressRepository.exists(addressId))
				{
					address = this.addressRepository.findOne(addressId);
					client.setAddress(address);
					
					this.clientRepository.save(client);
					
					return new ResponseEntity<>(client, HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<>(new RESTError(404, "Address with Id: " + addressId + " doesn't exist."), HttpStatus.NOT_FOUND);
				}
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Client with Id: " + clientId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Add Contact Info To Client
	@RequestMapping(method = RequestMethod.PUT, value = "/{cliendId}/contactInfo")
	public ResponseEntity<?> addContactInfoToClient(@PathVariable Integer clientId, @RequestParam Integer contactInfoId)
	{
		ClientEntity client = new ClientEntity();
		ContactInfoEntity contactInfo = new ContactInfoEntity();
		
		try {
			if(this.clientRepository.exists(clientId))
			{
				client = this.clientRepository.findOne(clientId);
				
				if(this.contactInfoRepository.exists(contactInfoId))
				{
					contactInfo = this.contactInfoRepository.findOne(contactInfoId);
					client.setContactInfo(contactInfo);
					
					this.clientRepository.save(client);
					
					return new ResponseEntity<>(client, HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<>(new RESTError(404, "Contact Info with Id: " + contactInfoId + " doesn't exist."), HttpStatus.NOT_FOUND);
				}
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Client with Id: " + clientId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
