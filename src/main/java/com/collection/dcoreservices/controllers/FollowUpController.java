package com.collection.dcoreservices.controllers;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.collection.dcoreservices.dto.DcrnDetailDto;
import com.collection.dcoreservices.dto.FollowUpRequestDto;
import com.collection.dcoreservices.services.FollowUpService;
import com.collection.dcoreservices.utils.DcrnCheckExpiryValid;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.collection.dcoreservices.dto.FollowUpResponseDto;
import com.collection.dcoreservices.exceptions.ValidateDcrnException;
import com.collection.dcoreservices.exceptions.ValidateFollowupException;
import com.collection.dcoreservices.dto.FailureResponseDto;
import com.collection.dcoreservices.advices.ApiErrorResponse;
import com.collection.dcoreservices.advices.ErrorDetails;
import org.springframework.http.HttpHeaders;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/products")
public class FollowUpController {

	private static final Logger logger = LoggerFactory.getLogger(FollowUpController.class);

	@Autowired
	private FollowUpService followUpService;

	@Autowired
	DcrnCheckExpiryValid dcrnCheckExpiryValid;

	@PostMapping("/followup")
	public ResponseEntity<FollowUpResponseDto> registerFollowUp(@RequestBody @Valid FollowUpRequestDto request,
			HttpServletRequest headers)throws JsonProcessingException {

		String Failureresponse = null;
		boolean CheckDcrn = false;
		boolean CheckURLExpiry = false;
		boolean CheckPromisedate = false;
		boolean isError = false;
		FollowUpResponseDto response = null;
		FailureResponseDto failureResponseCatch=new FailureResponseDto();
		ObjectMapper objectMapper = new ObjectMapper();

		ResponseEntity<FollowUpResponseDto> responseEntity = null;

		try {

			// Validate each field and return appropriate error responses
			if (request.getUserId() == null || request.getUserId().isEmpty()) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10012", "User ID is not specified", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}

			if (request.getActionDate() == null || request.getActionDate().isEmpty()) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10013", "Action Date is not specified", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}
			if (request.getActionCode() == null || request.getActionCode().isEmpty()) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10014", "Action Code is not specified", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}

			if (request.getResultCode() == null || request.getResultCode().isEmpty()) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10015", "Result Code is not Specified", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}
			if (request.getNextActionDateTime() == null || request.getNextActionDateTime().isEmpty()) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10016",
						"Next Action Date and Time not specified", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}
			if (request.getPromiseDate() == null || request.getPromiseDate().isEmpty()) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10017", "Promise Date is not Specified",
						"");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}
			if (request.getPromiseAmount() == null || request.getPromiseAmount().isEmpty()) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10018", "Promise Amount is not specified",
						"");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}
			if (request.getRemark() == null || request.getRemark().isEmpty()) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10019", "Remark is not specified", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}
			if (request.getRemark().length() > 300) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10029", "Remark length should be less than 300 characters", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}
			// If there are special characters in the remark
			if (!request.getRemark().matches("[a-zA-Z0-9^@ .,-?]+")) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10030", "Special Character not allowed in remark\"", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			}
			// Validate the promise date is not before the system date
			CheckPromisedate =dcrnCheckExpiryValid.isValidPromiseDate(request.getPromiseDate());
			if (!CheckPromisedate) {
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10020", "Promise Date cannot be less than system date", "");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));
				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);
			} 

			CheckDcrn = dcrnCheckExpiryValid.isValidDcrn(request.getDcrn());

			if (!CheckDcrn) {
				logger.error("Invalid DCRN: {}", request.getDcrn());
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10002", "Invalid DCRN", "Invalid DCRN");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));

				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);

			}

			CheckURLExpiry = dcrnCheckExpiryValid.isUrlExpired(request.getDcrn());

			if (!CheckURLExpiry) {
				logger.error("URL expired for DCRN: {}", request.getDcrn());
				ErrorDetails errorDetails = new ErrorDetails("Functional", "10006", "URL is expired", "URL is expired");
				ApiErrorResponse failureResponse = new ApiErrorResponse(Collections.singletonList(errorDetails));

				return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);

			}

			response = followUpService.registerFollowUp(request);
			String urc = headers.getHeader("URC");

			// Set up headers for the ResponseEntity
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("URC", urc);
			if (response != null) {
				
				 responseEntity = new ResponseEntity(response, responseHeaders,
				 HttpStatus.CREATED);
			} else {
				logger.warn("DCRN validation failed, returning bad request.");
				responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (ValidateFollowupException e) {
            logger.error("DCRN validation failed with error code: {} and message: {}", e.getErrorcode(),
                    e.getMessage());
            ErrorDetails errorDetails = new ErrorDetails("Functional", e.getErrorcode(), e.getMessage(), "");
            ApiErrorResponse failureResponse = new ApiErrorResponse(
                    Collections.singletonList(errorDetails));
            return new ResponseEntity(failureResponse, HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
			// TODO: handle exception
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
