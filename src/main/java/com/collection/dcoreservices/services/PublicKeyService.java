package com.collection.dcoreservices.services;

import com.collection.dcoreservices.dto.PublicKeyResponseDto;

public interface PublicKeyService {

	PublicKeyResponseDto fetchJWKSet(String key);

}
