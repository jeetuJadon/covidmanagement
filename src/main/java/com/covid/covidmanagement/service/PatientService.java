package com.covid.covidmanagement.service;

import com.covid.covidmanagement.model.PatientDetailsDto;
import com.covid.covidmanagement.repository.CovidManagementRepository;
import com.covid.covidmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

public  Integer savePatientDetails(PatientDetailsDto patientDetailsDto){
	  return patientRepository.savePatientDetails(patientDetailsDto);
}

public  void updatePatientStatus(PatientDetailsDto patientDetailsDto){
	 patientRepository.updatePatientStatus(patientDetailsDto);
}

public List<PatientDetailsDto> getAllPatients(){
	return patientRepository.findPatientDetails();
}

}
