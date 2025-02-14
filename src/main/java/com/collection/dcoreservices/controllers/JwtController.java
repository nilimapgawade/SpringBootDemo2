package com.collection.dcoreservices.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.collection.dcoreservices.serviceimpl.ChannelServiceImpl;
import com.collection.dcoreservices.serviceimpl.JwtService;

@RestController
public class JwtController {

	private static final Logger logger = LoggerFactory.getLogger(ChannelServiceImpl.class);
	private final JwtService jwtService;

	public JwtController(JwtService jwtService) {
		this.jwtService = jwtService;

	}

	@PostMapping(value = "/generatetoken", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String, String>> generateToken(@RequestBody Map<String, String> request) {

		String username = request.get("username");

		logger.info("Inside generateToken of JwtController");

		if (username == null || username.isEmpty()) {
			return ResponseEntity.badRequest().body(Map.of("error", "Username is required"));
		}

		String token = jwtService.generateToken(username);

		// Return token in a JSON response with HTTP 200 OK
		return ResponseEntity.ok(Map.of("token", token));
		
	}

	@PostMapping("/verifytoken")
	public boolean verifyToken(@RequestHeader("Authorization") String token) {
		// Remove "Bearer " prefix if present
		if (token.startsWith("Bearer ")) {
			token = token.substring(7);
		}
		return jwtService.verifyToken(token);
	}
}
