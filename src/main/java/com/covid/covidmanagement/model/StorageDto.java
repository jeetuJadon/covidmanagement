package com.covid.covidmanagement.model;

import java.util.List;

public class StorageDto {

	private String key;
	List<StorageAttributeDto> attributeDtoList;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<StorageAttributeDto> getAttributeDtoList() {
		return attributeDtoList;
	}

	public void setAttributeDtoList(List<StorageAttributeDto> attributeDtoList) {
		this.attributeDtoList = attributeDtoList;
	}


	@Override
	public String toString() {
		return "StorageDto{" +
				"key='" + key + '\'' +
				", attributeDtoList=" + attributeDtoList +
				'}';
	}
}
