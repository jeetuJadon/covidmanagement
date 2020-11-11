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
		String sql = "select * from CUSTOMER_TYPE_DISCOUNT";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map row : rows) {
			String customerType = (String) row.get("CUS_TYPE");
			Double minValue = (Double) row.get("MIN_VALUE");
			Double maxValue = (Double)  (row.get("MAX_VALUE") ==null?null:row.get("MAX_VALUE"));
			Integer discount = (Integer) row.get("DISCOUNT_PRC");


			}

		}


}
