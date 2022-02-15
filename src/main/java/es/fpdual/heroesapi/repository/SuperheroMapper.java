package es.fpdual.heroesapi.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.fpdual.heroesapi.model.SuperheroBean;

public class SuperheroMapper implements RowMapper<SuperheroBean> {

	@Override
	public SuperheroBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		SuperheroBean superhero = new SuperheroBean();
		superhero.setId(rs.getLong("ID"));
		superhero.setName(rs.getString("NAME"));
		superhero.setAlterego(rs.getString("ALTEREGO"));
		superhero.setImage(rs.getString("IMG"));
		
		return superhero;
	}

	

}
