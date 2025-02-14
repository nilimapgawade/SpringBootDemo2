package com.collection.dcoreservices.dto;

import java.util.ArrayList;
import java.util.List;

import com.collection.dcoreservices.entities.Key;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PublicKeyResponseDto {

	@JsonProperty(value = "keys")
	public ArrayList<Key> keys;

	public ArrayList<Key> getKeys() {
		return keys;
	}

	public void setKeys(List<Key> keyList) {
		this.keys = (ArrayList<Key>) keyList;
	}

	@Override
	public String toString() {
		return "PublicKeyResponse [keys=" + keys + "]";
	}

}
