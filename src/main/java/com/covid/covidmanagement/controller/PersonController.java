package com.covid.covidmanagement.controller;

import com.covid.covidmanagement.model.PatientDetailsDto;
import com.covid.covidmanagement.model.PersonDto;
import com.covid.covidmanagement.model.StorageAttributeDto;
import com.covid.covidmanagement.model.StorageDto;
import com.covid.covidmanagement.service.PersonService;
import com.covid.covidmanagement.service.StorageAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class PersonController {


	@Autowired
	PersonService personService;

	@PostMapping(path = "/insertPerson")
	public ResponseEntity insertPersonDetails(@RequestBody PersonDto personDto ) {
		HttpHeaders responseHeaders = new HttpHeaders();
		Integer patientId = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			patientId = personService.savePatientDetails(personDto);
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


	@PostMapping(path = "/deletePerson")
	public ResponseEntity deletePersonByPersonId(@RequestParam("person_id") Integer personId ) {
		HttpHeaders responseHeaders = new HttpHeaders();
		Integer patientId = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			 personService.deletePersonFromPersonId(personId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body("success");
		}
	}


	@GetMapping(path = "/allPersonDetails")
	public ResponseEntity updatePatientDetails() {
		HttpHeaders responseHeaders = new HttpHeaders();
		List<PersonDto> patientDetailsDtos = null;
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			patientDetailsDtos = personService.getAllPersonalDetails();
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
