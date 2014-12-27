package com.tfc.uoc.edu.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProducteRowMapper implements RowMapper<Producte> {

	@Override
	public Producte mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setAuthority(rs.getString("authority"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(true);
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		
				
		Producte producte = new Producte();
		producte.setId(rs.getInt("id"));
		producte.setText(rs.getString("text"));
		producte.setUser(user);
		
		return producte;
	}
	

}
