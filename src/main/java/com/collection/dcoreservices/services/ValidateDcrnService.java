package com.collection.dcoreservices.services;

import com.collection.dcoreservices.dto.DcrnDetailDto;
import com.collection.dcoreservices.entities.DcrnDetailEntity;
import com.collection.dcoreservices.exceptions.ValidateDcrnException;
import com.collection.dcoreservices.repositories.DcrnDetailRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ValidateDcrnService {
    private static final Logger logger = LoggerFactory.getLogger(ValidateDcrnService.class);


    private final DcrnDetailRepository dcrnDetailRepository;
    private final ModelMapper modelMapper;

    public ValidateDcrnService(DcrnDetailRepository dcrnDetailRepository, ModelMapper modelMapper) {
        this.dcrnDetailRepository = dcrnDetailRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<DcrnDetailDto> validateDcrn(String encryptedDcrn) throws Exception {

        logger.info("Start validating DCRN: {}", encryptedDcrn);
        Optional<DcrnDetailEntity> entityOpt = null;
        Optional<DcrnDetailDto> dcrnDetailDto = null;

        entityOpt = Optional.ofNullable(dcrnDetailRepository.findByEncryptedDcrnNo(encryptedDcrn));

        dcrnDetailDto = entityOpt.map(dcrnDetailEntity -> modelMapper.map(dcrnDetailEntity, DcrnDetailDto.class));


		// Perform account status check for both Loan and Card
		if ("LOAN".equals(entityOpt.get().getProductType())) {
			if (!"OPEN".equals(entityOpt.get().getAcc_status())) {
				logger.error("Loan account for encrypted DCRN {} is not OPEN. Current status: {}", encryptedDcrn,
                        entityOpt.get().getAcc_status());

				throw new ValidateDcrnException("Account is Closed", "10028");

			}
		} else if ("CARD".equals(entityOpt.get().getProductType())) {

			if ("CLOSE".equals(entityOpt.get().getAcc_status())) {
				logger.error("Card account for encrypted DCRN {} is closed due to TOS Amount or Block Code condition",
						encryptedDcrn);

				throw new ValidateDcrnException("Account is Closed", "10028");
			}

		}

		logger.info("DCRN validated successfully for: {}", encryptedDcrn);

        return dcrnDetailDto;
    }
}
