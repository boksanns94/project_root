package com.milosboksan.backendroot.util;

import com.fasterxml.jackson.annotation.JsonView;
import com.milosboksan.backendroot.security.Views;

public class RESTError
{
	/*
	 * CODES:
	 * 400 - BAD_REQUEST
	 * 403 - FORBIDDEN
	 * 404 - NOT_FOUND
	 * 500 - INTERNAL_SERVER_ERROR
	 */
	
	@JsonView(Views.Public.class)
	private int code;
	@JsonView(Views.Public.class)
	private String message;
	
	public RESTError(int code, String message)
	{
		this.code = code;
		this.message = message;
	}
	
	public int getCode()
	{
		return code;
	}
	
	public String getMessage()
	{
		return message;
	}
}
