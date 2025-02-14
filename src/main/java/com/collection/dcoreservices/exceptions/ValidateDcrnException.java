package com.collection.dcoreservices.exceptions;

public class ValidateDcrnException extends Exception {

	private String errorcode;

	public String getErrorcode() {
		return errorcode;
	}

	public ValidateDcrnException(String message, String errorcode) {
		super(message);
		this.errorcode = errorcode;
	}
	
	

}
