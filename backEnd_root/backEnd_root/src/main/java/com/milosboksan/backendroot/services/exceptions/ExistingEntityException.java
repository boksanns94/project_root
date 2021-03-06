package com.milosboksan.backendroot.services.exceptions;

@SuppressWarnings("serial")
public class ExistingEntityException extends Exception
{
	private Object entity;

	public ExistingEntityException() {
		super();
	}
	
	//If entity doesn't exist return message
	public ExistingEntityException(String message) {
		super(message);
	}
	
	//If the entity doesn't exist return Error
	public ExistingEntityException(Throwable cause) {
		super(cause);
	}
	
	//If the entity doesn't exist return a message and Error Code
	public ExistingEntityException(String message, Throwable cause) {
		super(message, cause);
	}
	
	//If the entity exists in the repository, return the existing object with a message
	public ExistingEntityException(Object entity, String message) {
		super();
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}
	
}
