/*package com.collection.dcoreservices.filter;

import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.collection.dcoreservices.services.HeadersValidation;
import com.collection.dcoreservices.serviceimpl.HeadersValidationImpl;

import com.collection.dcoreservices.advices.ApiErrorResponse;
import com.collection.dcoreservices.advices.ErrorDetails;
import com.collection.dcoreservices.exceptions.IlligalArgumentWithObjectException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HeaderValidationFilter extends OncePerRequestFilter {

	// Cache to track processed reference numbers
	private final ConcurrentHashMap<String, Instant> processedReferences = new ConcurrentHashMap<>();

	@Autowired
	private HeadersValidation headersValidation;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String referenceNumber = request.getHeader("URC");
		String timestamp = request.getHeader("Client-Timestamp");
		String channel = request.getHeader("Channel-Id");
		String financialId = request.getHeader("Financial-Id");

		try {
			// Validate headers
			validateHeaders(referenceNumber, timestamp,channel, financialId);
			// Proceed with the request
			filterChain.doFilter(request, response);
		} catch (IlligalArgumentWithObjectException e) {
			// Handle invalid headers

			ApiErrorResponse failureResponse = new ApiErrorResponse(
					Collections.singletonList((ErrorDetails) e.getErrorDetails()));

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write(new ObjectMapper().writeValueAsString(failureResponse));

		}
	}

	private void validateHeaders(String urc,String timestamp, String channel, String financialId) {

		boolean CheckUniqueURC = false;

		
		if (financialId == null || financialId.trim().isEmpty()) {
			ErrorDetails errorDetails = getErrorDetails("Technical", "10003", "Financial-Id not specified",
					"Financial-Id not specified");
			throw new IlligalArgumentWithObjectException("Financial-Id not specified", errorDetails);

		}

		CheckUniqueURC = headersValidation.isValidUrc(urc);

		if (!CheckUniqueURC) {

			ErrorDetails errorDetails = getErrorDetails("Technical", "10005", "URC not specified", "URC not specified");
			throw new IlligalArgumentWithObjectException("URC not specified", errorDetails);

		}

	

		// Validate reference number uniqueness
		if (processedReferences.putIfAbsent(urc, Instant.now()) != null) {
			ErrorDetails errorDetails = getErrorDetails("Technical", "100090", "Duplicate Unique Reference Code",
					"Duplicate Unique Reference Code");
			String pratik = "";
			throw new IlligalArgumentWithObjectException("Duplicate Unique Reference Code" + pratik, errorDetails);

		}
		 //Validate timestamp format (e.g., ISO-8601) and freshness
		 try {
	              
	            
	            long timestampMillis = Long.parseLong(timestamp);

	            // Convert to Instant
	            Instant requestTime = Instant.ofEpochMilli(timestampMillis);
	            Instant now = Instant.now();
	            if (requestTime.isBefore(now.minusSeconds(300)) || requestTime.isAfter(now.plusSeconds(300))) {

	                ErrorDetails errorDetails = getErrorDetails("Technical", "100090", "Invalid or stale timestamp",
	                        "Invalid or stale timestamp");
	                throw new IlligalArgumentWithObjectException("Invalid or stale timestamp:" + timestamp, errorDetails);

	        } 
	      }catch (Exception e) {
				ErrorDetails errorDetails = getErrorDetails("Technical", "10004", "Client-Timestamp not specified",
					"Client-Timestamp not specified");
			String pratik = "";
			throw new IlligalArgumentWithObjectException("Invalid timestamp format:" + pratik, errorDetails);

		}
		// Validate channel (example: allow only specific values)
		try {
			if (!"COL".equalsIgnoreCase(channel)) {
				ErrorDetails errorDetails = getErrorDetails("Technical", "10003", "channel-Id not Specified",
						"channel-Id not Specified");
				throw new IlligalArgumentWithObjectException("Invalid Channel-Id" + channel, errorDetails);

			}

		} catch (Exception e) {
			String pratik = "";
			throw new IllegalArgumentException("Invalid timestamp format: " + pratik);

		}

	}

	public ErrorDetails getErrorDetails(String type, String code, String message, String additionalProp1) {
		return new ErrorDetails(type, code, message, additionalProp1);
	}

}
*/
