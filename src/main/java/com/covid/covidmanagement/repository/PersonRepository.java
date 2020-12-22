package com.covid.covidmanagement.repository;

import com.covid.covidmanagement.model.PatientDetailsDto;
import com.covid.covidmanagement.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonRepository {


	@Autowired
	JdbcTemplate jdbcTemplate;

   private  static final String INSERT_QUERY = "INSERT INTO PERSON(PERSON_NAME,PERSON_ADDRESS) VALUES " +
		   "(?,?)";
	private  static final  String DELETE_PERSON_BY_ID =
			"delete from PERSON where person_id = ?";

	public int savePersonDetails(PersonDto personDto) {
		return	 jdbcTemplate.update(INSERT_QUERY,
				personDto.getPersonName(), personDto.getPersonAddress());
	}



	public int deletePersonFromPersonId(Integer personId) {
		return jdbcTemplate.update(DELETE_PERSON_BY_ID,
				personId);
	}




	public List<PersonDto> findPatientDetails() {

		String sql = "SELECT * FROM PERSON";

		List<PersonDto> patientDetailsDtos = jdbcTemplate.query(
					sql,
					(rs,rownum)->{

						PersonDto pto = new PersonDto();
						pto.setPersonId(Integer.valueOf(rs.getString("PERSON_ID")));
						pto.setPersonName(rs.getString("PERSON_NAME"));
						pto.setPersonAddress(rs.getString("PERSON_ADDRESS"));
						return  pto;
					});

			return patientDetailsDtos;

	}



}
