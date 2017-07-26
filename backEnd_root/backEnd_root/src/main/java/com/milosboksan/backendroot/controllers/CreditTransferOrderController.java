package com.milosboksan.backendroot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.milosboksan.backendroot.entities.CreditTransferOrderEntity;
import com.milosboksan.backendroot.entities.dto.CreditTransferOrderDTO;
import com.milosboksan.backendroot.repositories.CreditTransferOrderRepository;
import com.milosboksan.backendroot.services.CreditTransferOrderService;
import com.milosboksan.backendroot.util.RESTError;

@RestController
@RequestMapping("api/creditTransferOrder")
public class CreditTransferOrderController
{
	private CreditTransferOrderRepository creditTransferOrderRepository;
	private CreditTransferOrderService creditTransferOrderService;
	
	@Autowired
	public CreditTransferOrderController(CreditTransferOrderRepository creditTransferOrderRepository,
			CreditTransferOrderService creditTransferOrderService) {
		super();
		this.creditTransferOrderRepository = creditTransferOrderRepository;
		this.creditTransferOrderService = creditTransferOrderService;
	}
	
	//Create Credit Transfer Order
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createCreditTransferOrder(@RequestBody CreditTransferOrderDTO creditTransferOrderDTO)
	{
		try {
			return new ResponseEntity<>(this.creditTransferOrderService.creditTransferOrder(creditTransferOrderDTO), HttpStatus.OK);
		} catch (IllegalArgumentException ee) {
			return new ResponseEntity<>(new RESTError(400, ee.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete Credit Transfer Order
	@RequestMapping(method = RequestMethod.DELETE, value = "/{creditTransferId}")
	public ResponseEntity<?> deleteCreditTransferOrder(@PathVariable Integer creditTransferId)
	{
		CreditTransferOrderEntity creditTransferOrder = new CreditTransferOrderEntity();
		try {
			if(this.creditTransferOrderRepository.exists(creditTransferId))
			{
				creditTransferOrder = this.creditTransferOrderRepository.findOne(creditTransferId);
				this.creditTransferOrderRepository.delete(creditTransferOrder);
				
				return new ResponseEntity<>(creditTransferOrder, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Credit Transfer Order with Id: " + creditTransferId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get Credit Transfer Order By Id
	@RequestMapping(method = RequestMethod.GET, value = "/{creditTransferId}")
	public ResponseEntity<?> getCreditTransferOrderById(@PathVariable Integer creditTransferId)
	{
		try {
			if(this.creditTransferOrderRepository.exists(creditTransferId))
			{
				return new ResponseEntity<>(this.creditTransferOrderRepository.findOne(creditTransferId), HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(new RESTError(404, "Address with Id: " + creditTransferId + " doesn't exist."), HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get All Credit Transfer Order
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllCreditTransferOrder()
	{
		try {
			return new ResponseEntity<>(this.creditTransferOrderRepository.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(new RESTError(500, "Exception: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
