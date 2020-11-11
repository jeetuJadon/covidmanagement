package com.covid.covidmanagement.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CovidManagementController {

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

	@PostMapping(path = "/cartItems")
	public ResponseEntity<String> getDiscountedAmountFromItems()
			throws JsonProcessingException {
		return  null;
	}

}
