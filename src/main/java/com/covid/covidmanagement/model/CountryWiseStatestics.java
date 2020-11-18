package com.covid.covidmanagement.model;

import java.util.Date;

public class CountryWiseStatestics {

  private Integer countryId;
  private Integer totalCovidCount;
  private  Integer totalCovidCountToday;
  private Integer totalActiveCount;
  private  Integer totalActiveCountToday;
  private  Integer totalRecoveredCount;
  private  Integer getTotalRecoveredCountToday;
  private  Integer  totalDeceaseCount;
  private  Integer totalDecasedCountToday;

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getTotalCovidCount() {
		return totalCovidCount;
	}

	public void setTotalCovidCount(Integer totalCovidCount) {
		this.totalCovidCount = totalCovidCount;
	}

	public Integer getTotalCovidCountToday() {
		return totalCovidCountToday;
	}

	public void setTotalCovidCountToday(Integer totalCovidCountToday) {
		this.totalCovidCountToday = totalCovidCountToday;
	}

	public Integer getTotalActiveCount() {
		return totalActiveCount;
	}

	public void setTotalActiveCount(Integer totalActiveCount) {
		this.totalActiveCount = totalActiveCount;
	}

	public Integer getTotalActiveCountToday() {
		return totalActiveCountToday;
	}

	public void setTotalActiveCountToday(Integer totalActiveCountToday) {
		this.totalActiveCountToday = totalActiveCountToday;
	}

	public Integer getTotalRecoveredCount() {
		return totalRecoveredCount;
	}

	public void setTotalRecoveredCount(Integer totalRecoveredCount) {
		this.totalRecoveredCount = totalRecoveredCount;
	}

	public Integer getGetTotalRecoveredCountToday() {
		return getTotalRecoveredCountToday;
	}

	public void setGetTotalRecoveredCountToday(Integer getTotalRecoveredCountToday) {
		this.getTotalRecoveredCountToday = getTotalRecoveredCountToday;
	}

	public Integer getTotalDeceaseCount() {
		return totalDeceaseCount;
	}

	public void setTotalDeceaseCount(Integer totalDeceaseCount) {
		this.totalDeceaseCount = totalDeceaseCount;
	}

	public Integer getTotalDecasedCountToday() {
		return totalDecasedCountToday;
	}

	public void setTotalDecasedCountToday(Integer totalDecasedCountToday) {
		this.totalDecasedCountToday = totalDecasedCountToday;
	}


	@Override
	public String toString() {
		return "CountryWiseStatestics{" +
				"countryId=" + countryId +
				", totalCovidCount=" + totalCovidCount +
				", totalCovidCountToday=" + totalCovidCountToday +
				", totalActiveCount=" + totalActiveCount +
				", totalActiveCountToday=" + totalActiveCountToday +
				", totalRecoveredCount=" + totalRecoveredCount +
				", getTotalRecoveredCountToday=" + getTotalRecoveredCountToday +
				", totalDeceaseCount=" + totalDeceaseCount +
				", totalDecasedCountToday=" + totalDecasedCountToday +
				'}';
	}
}
