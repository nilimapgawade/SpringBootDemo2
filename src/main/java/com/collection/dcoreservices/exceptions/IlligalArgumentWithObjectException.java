package com.collection.dcoreservices.exceptions;

public class IlligalArgumentWithObjectException extends IllegalArgumentException{

    private final Object errorDetails;
    public IlligalArgumentWithObjectException(String message, Object object){
        super(message);
        this.errorDetails = object;
    }

    public Object getErrorDetails(){
        return errorDetails;
    }
}
