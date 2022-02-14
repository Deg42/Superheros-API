package es.fpdual.heroesapi.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.fpdual.heroesapi.model.SuperpowerBean;

public class SuperpowerMapper implements RowMapper<SuperpowerBean> {

	@Override
	public SuperpowerBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SuperpowerBean superpower = new SuperpowerBean();
		superpower.setId(rs.getLong("ID"));
		superpower.setPower(rs.getString("POWER"));
		
		return superpower;
	}

	

}
