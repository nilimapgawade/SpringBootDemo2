package com.collection.dcoreservices.controllers;



import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collection.dcoreservices.advices.ApiErrorResponse;
import com.collection.dcoreservices.advices.ErrorDetails;
import com.collection.dcoreservices.dto.FailureResponseDto;
import com.collection.dcoreservices.dto.LoanResponseDto;
import com.collection.dcoreservices.dto.ValidateDcrnRequestDto;
import com.collection.dcoreservices.services.LoanService;
import com.collection.dcoreservices.utils.DcrnCheckExpiryValid;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/v1/loan")
public class LoanController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	LoanService loanService;
	
	@Autowired
    DcrnCheckExpiryValid dcrnCheckExpiryValid;
	
	@PostMapping("/products")
	public ResponseEntity<LoanResponseDto> getLoanAccount(@RequestBody ValidateDcrnRequestDto request,HttpServletRequest headers)throws Exception{
		
		ResponseEntity<LoanResponseDto> responseEntity=null;
		LoanResponseDto response=null;
		
		logger.info("Received request to get loan account details for dcrn: {}", request.getDcrn());
		 boolean CheckDcrn = false;
		 boolean CheckURLExpiry = false;
		 boolean isError = false;
		 FailureResponseDto failureResponseCatch=new FailureResponseDto();
		 String Failureresponse = null;
		 ObjectMapper objectMapper = new ObjectMapper();
		 
		try {
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
			
			response=loanService.processLoanRequest(request.getDcrn());
			if (response != null) {
			logger.info("Successfully processed loan request for dcrn: {}", request.getDcrn());	
			responseEntity =  ResponseEntity.ok().header("dcrn", request.getDcrn()).header("URC", headers.getHeader("URC")).body(response);
			}else {
				logger.warn("No loan data found for dcrn: {}", request.getDcrn());
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
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