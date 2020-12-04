package com.covid.covidmanagement.controller;

import com.covid.covidmanagement.model.PatientDetailsDto;
import com.covid.covidmanagement.model.StorageAttributeDto;
import com.covid.covidmanagement.model.StorageDto;
import com.covid.covidmanagement.service.PatientService;
import com.covid.covidmanagement.service.StorageAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class AttributeStorageController {


	@Autowired
	StorageAttributeService storageAttributeService;

	@PostMapping(path = "/insertStorageAttributes")
	public ResponseEntity insertStorageAttributes(@RequestBody StorageDto storageDto) {
		System.out.println("added parameter "+storageDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		Integer patientId = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			storageAttributeService.insertStorageAttributes(storageDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body("Success");
		}

	}


	@PostMapping(path = "/deleteStorageAttributeKey")
	public ResponseEntity deleteStorageAttributeKey(@RequestBody String deleteStorageKey) {
		System.out.println("added parameter "+deleteStorageKey);
		HttpHeaders responseHeaders = new HttpHeaders();
		Integer patientId = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			storageAttributeService.removeAttributeStorageKey(deleteStorageKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body("Success");
		}

	}


	@GetMapping(path = "/secondarySearchIndex")
	public ResponseEntity secondarySearchIndex(@RequestBody StorageAttributeDto storageAttributeDto) {
		System.out.println("added parameter "+storageAttributeDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		Integer patientId = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		Set<String> listOfKeys = null;
		try {
		listOfKeys = storageAttributeService.secondaryIndexSearchScan(storageAttributeDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(listOfKeys);
		}

	}


}
