package com.collection.dcoreservices.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.collection.dcoreservices.dto.ApiLogDto;




public interface ApiLogService {
	
	static final Logger logger = LoggerFactory.getLogger(ApiLogService.class);

	
	boolean logApiRequestResponse(ApiLogDto request) throws Exception;

	public boolean isValidUrc(String SZURC);
	
	
}
