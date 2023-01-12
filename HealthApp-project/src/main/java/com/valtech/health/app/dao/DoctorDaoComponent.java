package com.valtech.health.app.dao;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class DoctorDaoComponent implements DoctorDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void updateDoctorCommentsDao(String doctor_comments, int id) {
       String sql = "update DOCTORS_COMMENTS set doctor_comments= ? where id= ?";
       jdbcTemplate.update(sql, doctor_comments, id);
	}
}
