package com.tfc.uoc.edu.spring.web.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("productesDao")
public class ProductesDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Producte> getProductes() {

		return jdbc.query("select * from offers", new RowMapper<Producte>() {

			public Producte mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producte offer = new Producte();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("mail"));
				System.out.println("Producte " + offer.getId() + " carregat : " + offer.getName());
				return offer;
			}

		});
	}
	
	public boolean update(Producte offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("update offers set name=:name, text=:text, mail=:email where id=:id", params) == 1;
	}
	
	public boolean create(Producte offer) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("insert into offers (name, text, mail) values (:name, :text, :email)", params) == 1;
	}
	
	@Transactional
	public int[] create(List<Producte> offers) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return jdbc.batchUpdate("insert into offers (id, name, text, mail) values (:id, :name, :text, :email)", params);
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from offers where id=:id", params) == 1;
	}

	public Producte getProducte(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers where id=:id", params,
				new RowMapper<Producte>() {

					public Producte mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Producte offer = new Producte();

						offer.setId(rs.getInt("id"));
						offer.setName(rs.getString("name"));
						offer.setText(rs.getString("text"));
						offer.setEmail(rs.getString("mail"));

						return offer;
					}

				});
	}
	
}
