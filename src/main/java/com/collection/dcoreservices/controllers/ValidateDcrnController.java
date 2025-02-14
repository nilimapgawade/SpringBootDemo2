package com.collection.dcoreservices.controllers;


import com.collection.dcoreservices.advices.ApiErrorResponse;
import com.collection.dcoreservices.advices.ErrorDetails;
import com.collection.dcoreservices.dto.DcrnDetailDto;
import com.collection.dcoreservices.dto.FailureResponseDto;
import com.collection.dcoreservices.dto.ValidateDcrnRequestDto;
import com.collection.dcoreservices.exceptions.ValidateDcrnException;
import com.collection.dcoreservices.services.ValidateDcrnService;
import com.collection.dcoreservices.utils.DcrnCheckExpiryValid;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;


@RestController
@RequestMapping("/v1")
public class ValidateDcrnController {

    private static final Logger logger = LoggerFactory.getLogger(ValidateDcrnController.class);
    @Autowired
    ValidateDcrnService validateDcrnService;

    @Autowired
    DcrnCheckExpiryValid dcrnCheckExpiryValid;
    
    @PostMapping("/validate-dcrn")
    public ResponseEntity<DcrnDetailDto> validateDCRN(@RequestBody @Valid ValidateDcrnRequestDto request,
                                                      HttpServletRequest headers)throws Exception{
        logger.info("Starting validation for DCRN: {}", request.getDcrn());

        DcrnDetailDto response = null;
        ResponseEntity<DcrnDetailDto> responseEntity = null;
        boolean CheckDcrn = false;
		boolean CheckURLExpiry = false;
		boolean isError = false;
		 FailureResponseDto failureResponseCatch=new FailureResponseDto();
		 String Failureresponse = null;
		 ObjectMapper objectMapper = new ObjectMapper();

        try{
        	
    		CheckDcrn = dcrnCheckExpiryValid.isValidDcrn(request.getDcrn());

			if (!CheckDcrn) {
				logger.error("Invalid DCRN: {}", request.getDcrn());
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10002", "Invalid DCRN", "Invalid DCRN");
				ApiErrorResponse failureResponse = new ApiErrorResponse(
						Collections.singletonList(errorDetails));

				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);

			}

			CheckURLExpiry = dcrnCheckExpiryValid.isUrlExpired(request.getDcrn());

			if (!CheckURLExpiry) {
				logger.error("URL expired for DCRN: {}", request.getDcrn());
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10006", "URL is expired", "URL is expired");
				ApiErrorResponse failureResponse = new ApiErrorResponse(
						Collections.singletonList(errorDetails));

				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);

			}
        	
        response = validateDcrnService.validateDcrn(request.getDcrn()).orElse(null);

        if (response != null) {
            logger.info("DCRN validation successful for: {}", request.getDcrn());
            
            responseEntity = ResponseEntity.ok().header("dcrn", request.getDcrn()).header("URC", headers.getHeader("URC")).body(response);
        } else {
            logger.warn("DCRN validation failed, returning bad request.");
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        } catch (ValidateDcrnException e) {
            logger.error("DCRN validation failed with error code: {} and message: {}", e.getErrorcode(),
                    e.getMessage());
            ErrorDetails errorDetails = new ErrorDetails("Functional", e.getErrorcode(), e.getMessage(), "");
            ApiErrorResponse failureResponse = new ApiErrorResponse(
                    Collections.singletonList(errorDetails));
            return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);

        } catch (IllegalArgumentException e) {
            logger.error("Invalid DCRN format: {}", request.getDcrn(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // DCRN is invalid
        } catch (Exception e) {
        	isError = true;
			 logger.info("In the catch block making it true ");
	         logger.error("An error occurred while fetching account details: {}", e.getMessage(), e);
        }finally {
            if (isError) {
            	failureResponseCatch.setStatus("failure");
            	failureResponseCatch.setMsg("Exception occurred");
            	
                try {
                	Failureresponse = objectMapper.writeValueAsString(failureResponseCatch);
                } catch (JsonProcessingException jsonException) {
                    logger.error("Error serializing failure response: {}", jsonException.getMessage(), jsonException);
                }
                responseEntity = new ResponseEntity(Failureresponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return responseEntity;

    }
}
