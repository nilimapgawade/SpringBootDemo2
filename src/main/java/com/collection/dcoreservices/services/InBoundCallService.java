package com.collection.dcoreservices.services;

import com.collection.dcoreservices.dto.InBoundCallRequestDto;
import com.collection.dcoreservices.dto.InBoundCallResponseDto;

public interface InBoundCallService {

	InBoundCallResponseDto fetchAccountData(InBoundCallRequestDto callRequest);

}
