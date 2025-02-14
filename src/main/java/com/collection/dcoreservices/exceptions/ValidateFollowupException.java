package com.collection.dcoreservices.exceptions;

import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

//import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

public class ValidateFollowupException extends Exception {
 private String errorcode;

public String getErrorcode() {
	return errorcode;
}

public  ValidateFollowupException(String message,String errorcode) {
	super(message);
	this.errorcode = errorcode;
}
 
 
}
