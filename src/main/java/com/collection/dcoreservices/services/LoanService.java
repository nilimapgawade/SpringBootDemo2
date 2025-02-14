package com.collection.dcoreservices.services;

import java.util.Optional;

import com.collection.dcoreservices.dto.LoanResponseDto;

public interface LoanService {

	public LoanResponseDto processLoanRequest(String request);
}
