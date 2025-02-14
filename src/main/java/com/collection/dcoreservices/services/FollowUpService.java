package com.collection.dcoreservices.services;

import com.collection.dcoreservices.dto.FollowUpRequestDto;
import com.collection.dcoreservices.dto.FollowUpResponseDto;

public interface FollowUpService {
	
	FollowUpResponseDto registerFollowUp (FollowUpRequestDto followUpRequestDto) throws Exception;

}
