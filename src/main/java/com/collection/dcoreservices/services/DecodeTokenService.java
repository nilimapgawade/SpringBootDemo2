package com.collection.dcoreservices.services;

import jakarta.servlet.http.HttpServletRequest;
public interface DecodeTokenService {

	boolean validateToken(HttpServletRequest request) throws Exception;

}
