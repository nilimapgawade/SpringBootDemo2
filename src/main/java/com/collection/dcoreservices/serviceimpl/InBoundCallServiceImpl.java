package com.collection.dcoreservices.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collection.dcoreservices.advices.ErrorDetails;
import com.collection.dcoreservices.dto.InBoundCallRequestDto;
import com.collection.dcoreservices.dto.InBoundCallResponseDto;
import com.collection.dcoreservices.entities.InBoundCallResponseEntity;
import com.collection.dcoreservices.repositories.InBoundCallRepository;
import com.collection.dcoreservices.services.InBoundCallService;


@Service
public class InBoundCallServiceImpl implements InBoundCallService {

	@Autowired
	InBoundCallRepository boundCallRepository;

	@Override
	public InBoundCallResponseDto fetchAccountData(InBoundCallRequestDto callRequest) {
		InBoundCallResponseDto boundCallResponse = new InBoundCallResponseDto();
		InBoundCallResponseEntity boundCallResponseEntity = null;

		if (callRequest != null && callRequest.getAccountNo() != null) {

			boolean exists = boundCallRepository.existsById(callRequest.getAccountNo());
 
			boundCallResponseEntity = boundCallRepository.findByAccountNO(callRequest.getAccountNo());
			if(boundCallResponseEntity != null ) {
			boundCallResponse.setTotalOutstandingAmount(boundCallResponseEntity.getTotalOutstandingAmount());
			boundCallResponse.setEmailID(boundCallResponseEntity.getEmailID());
			boundCallResponse.setCollectorCode(boundCallResponseEntity.getCollectorCode());
			boundCallResponse.setDailerKey(boundCallResponseEntity.getDailerKey());
			}
		}
		return boundCallResponse;
	}

	public ErrorDetails getErrorDetails(String type, String code, String message, String additionalProp1) {
		return new ErrorDetails(type, code, message, additionalProp1);
	}

}
