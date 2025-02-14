package com.collection.dcoreservices.serviceimpl;



import com.collection.dcoreservices.repositories.AccountDetailsViewRepository;
import com.collection.dcoreservices.repositories.PtpViewRepository;
import com.collection.dcoreservices.repositories.SettlementViewRepository;
import com.collection.dcoreservices.services.LoanService;
import com.collection.dcoreservices.dto.DcrnDetailDto;
import com.collection.dcoreservices.dto.LoanResponseDto;
import com.collection.dcoreservices.dto.PtpDto;
import com.collection.dcoreservices.dto.SettlementDto;
import com.collection.dcoreservices.dto.LoanDcrnDetail;
import com.collection.dcoreservices.entities.AccountDetailsViewEntity;
import com.collection.dcoreservices.entities.DcrnDetailEntity;
import com.collection.dcoreservices.entities.PtpViewEntity;
import com.collection.dcoreservices.entities.SettlementViewEntity;
import com.collection.dcoreservices.repositories.DcrnDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

	private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

	
	private final AccountDetailsViewRepository accountDetailsViewRepository;

	
	private final DcrnDetailRepository dcrnDetailRepository;

	
	private final PtpViewRepository ptpViewRepository;

	
	private final SettlementViewRepository settlementViewRepository;

	
    private final ModelMapper modelMapper;
    
    public LoanServiceImpl(AccountDetailsViewRepository accountDetailsViewRepository,DcrnDetailRepository dcrnDetailRepository,PtpViewRepository ptpViewRepository,SettlementViewRepository settlementViewRepository,ModelMapper modelMapper) {
    	this.accountDetailsViewRepository = accountDetailsViewRepository;
    	this.dcrnDetailRepository=dcrnDetailRepository;
    	this.ptpViewRepository = ptpViewRepository;
    	this.settlementViewRepository = settlementViewRepository;
        this.modelMapper = modelMapper;
    }

	@Override
	public LoanResponseDto processLoanRequest(String request) {
		
		LoanResponseDto loanResponseDto = new LoanResponseDto();
		
		try {

			logger.info("Processing loan request for DCRN: {}", request);

		 Optional<DcrnDetailEntity> entityOpt = Optional.ofNullable(dcrnDetailRepository.findByEncryptedDcrnNo(request));

			if (!entityOpt.isPresent()) {
				logger.warn("No VDC DCRN details found for request: {}", request);
				return null; // Returning empty response for no matching DCRN
			}

			DcrnDetailEntity entity = entityOpt.get();

			// Fetch account details using loan account number (dcrn)
			Optional<AccountDetailsViewEntity> accountDetails= Optional.ofNullable(accountDetailsViewRepository.findByAgrseq(entity.getAgrseq()));
			
			

			if (accountDetails.isPresent()) {
				logger.info("Account details found for Agrseq: {}", entity.getAgrseq());
				loanResponseDto = modelMapper.map(accountDetails.get(), LoanResponseDto.class);
			} else {
				logger.warn("No account details found for Agrseq: {}", entity.getAgrseq());
				return null;
			}

			List<PtpViewEntity> ptpViewEntity = ptpViewRepository.findByAgrseq(entity.getAgrseq()) ;
			if (!ptpViewEntity.isEmpty()){
				List<PtpDto> ptpDto = ptpViewEntity.stream().map(ptpviewentity -> modelMapper.map(ptpviewentity, PtpDto.class)).collect(Collectors.toList());
				loanResponseDto.setPtp(ptpDto);
				logger.info("Found {} PTP records for Agrseq: {}", entity.getAgrseq());
			}else {
				logger.warn("No account details found for Agrseq: {}", entity.getAgrseq());
			}

			List<SettlementViewEntity> settlementEntities = settlementViewRepository.findByAgrseq(entity.getAgrseq());
			if (!settlementEntities.isEmpty()) {
				List<SettlementDto> settlementDetails = settlementEntities.stream().map(settlementEntity -> modelMapper.map(settlementEntity, SettlementDto.class)).collect(Collectors.toList());
				loanResponseDto.setSettlement(settlementDetails);
				logger.info("Found {} settlement records for Agrseq: {}", settlementEntities.size(),
						entity.getAgrseq());
			}

			LoanDcrnDetail loanDcrnDetail  = new LoanDcrnDetail();
			loanDcrnDetail.setUrlExpiryDate(entity.getUrlExpiryDate());
			loanDcrnDetail.setNotificationType(entity.getNotificationType());
            loanResponseDto.setDcrnDetail(loanDcrnDetail);

			logger.info("Added DCRN details for request: {}", request);

		} catch (Exception e) {
			logger.error("Error processing loan request for DCRN: {}", request, e);
			e.printStackTrace();
		}

		return loanResponseDto;
	}

	

}