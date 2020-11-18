package com.covid.covidmanagement.model;

import java.util.Date;

public class PatientDetailsDto {

	private String patientName;
	private Integer stateId;
	private  Integer areaId;
	private  Integer patientId;
	private  Integer patientStatus;
	private Date createDate;
	private  Date updateDate;


	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(Integer patientStatus) {
		this.patientStatus = patientStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}



	@Override
	public String toString() {
		return "PatientDetailsDto{" +
				"patientName='" + patientName + '\'' +
				", stateId=" + stateId +
				", areaId=" + areaId +
				", patientId=" + patientId +
				", patientStatus=" + patientStatus +
				", createDate=" + createDate +
				", updateDate=" + updateDate +
				'}';
	}
}
