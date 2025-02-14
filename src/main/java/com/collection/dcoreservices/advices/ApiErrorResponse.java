package com.collection.dcoreservices.advices;


import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiErrorResponse {

	private List<ErrorDetails> errors;

    // Constructor, getters, and setters
    public ApiErrorResponse(List<ErrorDetails> errors) {

        this.errors = errors;
    }

    public List<ErrorDetails> getErrors() {

        return errors;
    }

    public void setErrors(List<ErrorDetails> errors) {
        this.errors = errors;
    }
    
}
