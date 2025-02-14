package com.collection.dcoreservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.collection.dcoreservices.advices.ApiErrorResponse;
import com.collection.dcoreservices.advices.ErrorDetails;
import com.collection.dcoreservices.dto.CardResponseDto;
import com.collection.dcoreservices.dto.FailureResponseDto;
import com.collection.dcoreservices.dto.LoanResponseDto;

//import com.Collection.GetCardDetailsWithFlag.Response.CardResponse;

import com.collection.dcoreservices.dto.ValidateDcrnRequestDto;
import com.collection.dcoreservices.services.CardService;
import com.collection.dcoreservices.utils.DcrnCheckExpiryValid;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/card/products")
public class GetCardDetailsWithFlagController {

	private static final Logger logger = LoggerFactory.getLogger(GetCardDetailsWithFlagController.class);

	@Autowired
	private CardService cardService;

	@Autowired
	DcrnCheckExpiryValid dcrnCheckExpiryValid;

	@PostMapping
	public ResponseEntity<CardResponseDto> getCardDetails(@RequestBody ValidateDcrnRequestDto dcrn,
			HttpServletRequest request) throws Exception {

		String Failureresponse = null;
		ResponseEntity<CardResponseDto> responseEntity = null;
		CardResponseDto response = null;
		boolean CheckDcrn = false;
		boolean CheckURLExpiry = false;
		boolean isError = false;
		FailureResponseDto failureResponseCatch=new FailureResponseDto();
		ObjectMapper objectMapper = new ObjectMapper();

		logger.info("Received request to get loan account details for dcrn: {}", dcrn.getDcrn());

		try {
			
			CheckDcrn = dcrnCheckExpiryValid.isValidDcrn(dcrn.getDcrn());

			if (!CheckDcrn) {
				logger.error("Invalid DCRN: {}", dcrn.getDcrn());
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10002", "Invalid DCRN", "Invalid DCRN");
				ApiErrorResponse failureResponse = new ApiErrorResponse(
						Collections.singletonList(errorDetails));

				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);

			}

			CheckURLExpiry = dcrnCheckExpiryValid.isUrlExpired(dcrn.getDcrn());

			if (!CheckURLExpiry) {
				logger.error("URL expired for DCRN: {}", dcrn.getDcrn());
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10006", "URL is expired", "URL is expired");
				ApiErrorResponse failureResponse = new ApiErrorResponse(
						Collections.singletonList(errorDetails));

				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);

			}
			
			response = cardService.fetchCardDetails(dcrn.getDcrn());
			if (response != null) {
				logger.info("Successfully processed loan request for dcrn: {}", dcrn.getDcrn());
				responseEntity = ResponseEntity.ok().header("dcrn", dcrn.getDcrn()).header("URC", request.getHeader("URC")).body(response);
			} else {
				logger.warn("No loan data found for dcrn: {}", dcrn.getDcrn());
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
