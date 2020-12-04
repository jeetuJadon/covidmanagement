package com.covid.covidmanagement.model;

import java.util.Date;

public class StorageAttributeDto {

	private String key;
	private Object value;
	private String dataType;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	@Override
	public String toString() {
		return "StorageAttributeDto{" +
				"key='" + key + '\'' +
				", value=" + value +
				", dataType='" + dataType + '\'' +
				'}';
	}
}
