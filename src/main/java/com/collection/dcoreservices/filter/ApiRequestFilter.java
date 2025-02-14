/*package com.collection.dcoreservices.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.collection.dcoreservices.controllers.GetCardDetailsWithFlagController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;


public class ApiRequestFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(ApiRequestFilter.class);
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, jakarta.servlet.ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        logger.info("Inside dofilter " + httpRequest);
        // Example validation: Check for a custom header
		String channelId = httpRequest.getHeader("Channel-Id");
		
        if (channelId == null ||  channelId.trim().isEmpty() ) {
        	
        	logger.info("Inside channelId " + channelId);
        	
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpResponse.getWriter().write("Invalid or Channel Id ");
            return;
        }
        
        
    
        chain.doFilter(request, response);
    }

    private boolean isValidApiKey(String apiKey) {
        // Example API key validation logic
        return "secret-api-key".equals(apiKey);
    }
    
    
    
    private void writeErrorResponse(HttpServletResponse response, int status, String message) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        String errorResponse = mapper.writeValueAsString(Map.of("error", message));
        response.getWriter().write(errorResponse);
    }
}

*/
