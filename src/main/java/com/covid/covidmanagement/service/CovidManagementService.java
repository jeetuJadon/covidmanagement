package com.covid.covidmanagement.service;

import com.covid.covidmanagement.repository.CovidManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidManagementService {

	@Autowired
	CovidManagementRepository covidManagementRepository;

	public void geTotalCovidCases() throws Exception {

	
	}

}
