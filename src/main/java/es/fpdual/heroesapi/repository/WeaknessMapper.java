package es.fpdual.heroesapi.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.fpdual.heroesapi.model.WeaknessBean;

public class WeaknessMapper implements RowMapper<WeaknessBean> {

	@Override
	public WeaknessBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeaknessBean weakness = new WeaknessBean();
		weakness.setId(rs.getLong("ID"));
		weakness.setWeakness(rs.getString("WEAKNESS"));
		
		return weakness;
	}

}
