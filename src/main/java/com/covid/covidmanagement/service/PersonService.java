package com.covid.covidmanagement.service;

import com.covid.covidmanagement.model.PatientDetailsDto;
import com.covid.covidmanagement.model.PersonDto;
import com.covid.covidmanagement.repository.PatientRepository;
import com.covid.covidmanagement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

public  Integer savePatientDetails(PersonDto personDto){
	  return personRepository.savePersonDetails(personDto);
}

public  void deletePersonFromPersonId(Integer personId){
	personRepository.deletePersonFromPersonId(personId);
}

public  List<PersonDto> getAllPersonalDetails() {

	return  personRepository.findPatientDetails();

}

}
