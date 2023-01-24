package com.example.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class UserDaoImpl implements UserDao  {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void deleteUser(int id) {
		
		String sql = "delete user_details where user_id= ?";
		jdbcTemplate.update(sql, id);
	}
}
