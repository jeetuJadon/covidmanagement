package com.covid.covidmanagement.controller;

import com.covid.covidmanagement.model.PatientDetailsDto;
import com.covid.covidmanagement.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {


	@Autowired
	PatientService patientService;


	@PostMapping(path = "/insertPatientDetails")
	public ResponseEntity insertPatientDetails(@RequestBody PatientDetailsDto patientDetailsDto) {
		HttpHeaders responseHeaders = new HttpHeaders();
		Integer patientId = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			 patientId = patientService.savePatientDetails(patientDetailsDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(patientId);
		}
	}

	@PostMapping(path = "/updatePatientDetails")
	public ResponseEntity updatePatientDetails(@RequestBody PatientDetailsDto patientDetailsDto) {
		HttpHeaders responseHeaders = new HttpHeaders();
		Integer patientId = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			patientId = patientService.savePatientDetails(patientDetailsDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(patientId);
		}
	}


	@GetMapping(path = "/allPatientDetails")
	public ResponseEntity updatePatientDetails() {
		HttpHeaders responseHeaders = new HttpHeaders();
		List<PatientDetailsDto> patientDetailsDtos = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			patientDetailsDtos = patientService.getAllPatients();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(patientDetailsDtos);
		}
	}


}
