package com.covid.covidmanagement.repository;

import com.covid.covidmanagement.model.PatientDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PatientRepository {


	@Autowired
	JdbcTemplate jdbcTemplate;

   private  static final String INSERT_QUERY = "INSERT INTO T_PATIENT_DETAILS(PATIENT_NAME,COUNTRY_ID,AREA_ID,PATIENT_STATUS) VALUES " +
		   "(?,?,?,?)";
	private  static final  String UPDATE_PATIENT_STATUS =
			"update T_PATIENT_DETAILS set PATIENT_STATUS = ? where COUNTRY_ID = ? AND AREA_ID = ?";

	public int savePatientDetails(PatientDetailsDto patientDto) {
		return jdbcTemplate.update(INSERT_QUERY,
				patientDto.getPatientName(), patientDto.getStateId(),patientDto.getAreaId(),patientDto.getPatientStatus());
	}


	public void updatePatientStatus(PatientDetailsDto patientDto) {
		int status = jdbcTemplate.update(UPDATE_PATIENT_STATUS, patientDto.getPatientId(),
				patientDto.getStateId(),patientDto.getAreaId());
		if(status != 0){
			System.out.println("Employee data updated for ID " + patientDto.getPatientId());
		}else{
			System.out.println("No Employee found with ID " + patientDto.getPatientId());
		}
	}


	public List<PatientDetailsDto> findPatientDetails() {


			String sql = "SELECT * FROM T_PATIENT_DETAILS";

			List<PatientDetailsDto> patientDetailsDtos = jdbcTemplate.query(
					sql,
					(rs,rownum)->{
						PatientDetailsDto pto = new PatientDetailsDto();
						pto.setPatientName(rs.getString("PATIENT_NAME"));
						pto.setPatientId(Integer.valueOf(rs.getString("PATIENT_ID")));
						pto.setStateId(Integer.valueOf(rs.getString("COUNTRY_ID")));
						pto.setAreaId(Integer.valueOf(rs.getString("AREA_ID")));
						pto.setPatientStatus(Integer.valueOf(rs.getString("PATIENT_STATUS")));
						return  pto;
					});

			return patientDetailsDtos;

	}



}
