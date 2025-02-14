package com.collection.dcoreservices.serviceimpl;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collection.dcoreservices.repositories.CheckURCRepository;
import com.collection.dcoreservices.services.HeadersValidation;

@Service
public class HeadersValidationImpl implements HeadersValidation {
	
	private static final Logger logger = LoggerFactory.getLogger(HeadersValidationImpl.class);

	@Autowired
	private CheckURCRepository checkurc;
	
	@Override
	public boolean isValidUrc(String SZURC) {
		if (SZURC != null) {

			SZURC = SZURC.trim();

			if (Pattern.matches("^[a-zA-Z0-9]+$", SZURC)) {
				logger.info("SZURC '{}' matches regex", SZURC);

				if (checkurc.existsByUrc(SZURC)) {
					logger.info("SZURC '{}' already exists in the repository", SZURC);
					return false;
				}
				logger.info("SZURC '{}' is valid and not found in the repository", SZURC);
				return true;
			}
		}

		return false;
	}

}
