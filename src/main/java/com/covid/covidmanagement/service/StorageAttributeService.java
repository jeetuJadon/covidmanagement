package com.covid.covidmanagement.service;

import com.covid.covidmanagement.exception.StorageAttributeException;
import com.covid.covidmanagement.model.PatientDetailsDto;
import com.covid.covidmanagement.model.StorageAttributeDto;
import com.covid.covidmanagement.model.StorageDto;
import com.covid.covidmanagement.repository.AttributeStorageRepository;
import com.covid.covidmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StorageAttributeService {

	@Autowired
	AttributeStorageRepository attributeStorageRepository;


	public  void removeAttributeStorageKey(String key) throws StorageAttributeException {
           attributeStorageRepository.removeAttributeStorageKey(key);
	}

     public  void  insertStorageAttributes(StorageDto storageDto) throws StorageAttributeException {
		   attributeStorageRepository.insertStorageAttributes(storageDto);
	 }

	 public Set<String> secondaryIndexSearchScan(StorageAttributeDto storageAttributeDto){
         return  attributeStorageRepository.secondaryIndexSearchscan(storageAttributeDto);
	 }
}