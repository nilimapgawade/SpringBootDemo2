package com.collection.dcoreservices.services;

import com.collection.dcoreservices.dto.InBoundCallHeaderDto;
import com.collection.dcoreservices.dto.InBoundCallRequestDto;

public interface InBoundCallHeaderService {

	public void saveInBoundCallHeader(InBoundCallHeaderDto inBoundCallHeader, InBoundCallRequestDto callRequest, String szStatus, Object szResponseBody);

}
