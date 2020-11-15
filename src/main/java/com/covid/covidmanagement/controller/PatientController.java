package com.covid.covidmanagement.controller;

import com.covid.covidmanagement.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {


	@Autowired
	PatientService patientService;


	@PostMapping(path = "/covidCasesByCountryName")
	public ResponseEntity<String> getCovidDetailsFromCountry()
			throws JsonProcessingException {
		Double discountedAmount = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (discountedAmount == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(discountedAmount.toString());
		}
	}


}
