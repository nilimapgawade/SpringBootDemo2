package com.collection.dcoreservices.services;

import com.collection.dcoreservices.dto.CardResponseDto;

public interface CardService {

	public CardResponseDto fetchCardDetails(String dcrn)throws Exception;
	
}
