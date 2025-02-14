package com.collection.dcoreservices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class ValidateDcrnRequestDto {

	@JsonProperty(value = "dcrn")
	@NotBlank
	private String dcrn;

	public String getDcrn() {
		return dcrn;
	}

	public void setDcrn(String dcrn) {
		this.dcrn = dcrn;
	}
	
}
