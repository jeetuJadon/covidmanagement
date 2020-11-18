package com.covid.covidmanagement.repository;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class CovidManagementRepository {


	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void populateStockPrices() {
		getCustomerTypeDiscountMapping();
	}

//Default method for configuration
	private void getCustomerTypeDiscountMapping()  {
		String sql = "SELECT area.AREA_NAME,covidAnalysis.PATIENT_STATUS, covidAnalysis.STATUS_COUNT FROM T_COUNTRY_AREA area inner join " +

				" (select COUNTRY_ID , AREA_ID , PATIENT_STATUS, count(*) as STATUS_COUNT FROM T_PATIENT_DETAILS " +
				"group by COUNTRY_ID , AREA_ID , PATIENT_STATUS ) as covidAnalysis " +
				"on area.COUNTRY_ID  = covidAnalysis.COUNTRY_ID and area.AREA_ID = covidAnalysis.AREA_ID";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		System.out.println("Covid Cases Query");
        System.out.println(rows);
		/*
		for (Map row : rows) {
			String customerType = (String) row.get("CUS_TYPE");
			Double minValue = (Double) row.get("MIN_VALUE");
			Double maxValue = (Double)  (row.get("MAX_VALUE") ==null?null:row.get("MAX_VALUE"));
			Integer discount = (Integer) row.get("DISCOUNT_PRC");
          }*/

		}


}
