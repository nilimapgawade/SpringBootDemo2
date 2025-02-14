package com.collection.dcoreservices.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.collection.dcoreservices.repositories.CheckDcrnRepository;



@Component
public class DcrnCheckExpiryValid {
	
	@Autowired
	CheckDcrnRepository checkDcrnRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(DcrnCheckExpiryValid.class);
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public boolean isValidDcrn(String Dcrn) {
		if (Dcrn != null) {

			Dcrn = Dcrn.trim();

			logger.info("Checking if DCRN '{}' exists in the repository After trim ", Dcrn);

			if (checkDcrnRepository.existsByEncryptedDcrnNo(Dcrn)) {
				logger.info("DCRN '{}' exists in the repository", Dcrn);
				return true;
			}
			return false;
		}

		return false;
	}

	
	public boolean isUrlExpired(String encryptedDcrnNo) {
		logger.info("Checking if the URL for DCRN '{}' is expired", encryptedDcrnNo);

		String expiryFlag = checkDcrnRepository.checkUrlExpiry(encryptedDcrnNo);

		logger.info("Result of checkUrlExpiry query for DCRN '{}': {}", encryptedDcrnNo, expiryFlag);

		if ("Y".equals(expiryFlag)) {
			logger.info("The URL for DCRN '{}' has expired", encryptedDcrnNo);
			return false;
		}
		logger.info("The URL for DCRN '{}' is not expired", encryptedDcrnNo);
		return true;
	}
	
	 public boolean isValidPromiseDate(String promiseDate) {
	        try {
	            // Parse the promise date to LocalDate
	            LocalDate parsedPromiseDate = LocalDate.parse(promiseDate, DATE_FORMATTER);
	            // Get today's date
	            LocalDate today = LocalDate.now();

	            // Compare promise date with current system date
	            return !parsedPromiseDate.isBefore(today);
	        } catch (Exception e) {
	            logger.error("Invalid promise date format: {}", promiseDate);
	            return false;
	        }
	    }
}
