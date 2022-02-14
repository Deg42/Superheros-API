package es.fpdual.heroesapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.fpdual.heroesapi.model.SuperheroBean;

@Repository
public class SuperheroRepositoryImpl implements SuperheroRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<SuperheroBean> selectAll() {
		try {
			return this.template.query("SELECT * FROM HEROES", new SuperheroeMapper());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public SuperheroBean selectById(long id) {
		try {
			return this.template.queryForObject("SELECT * FROM HEROES WHERE ID = ?", new SuperheroeMapper(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void insert(SuperheroBean superhero) {
			try {
			this.template.update("INSERT INTO HEROES VALUES (?, ?, ?, ?)", 
					superhero.getId(), 
					superhero.getName(),
					superhero.getAlterego(),
					superhero.getImage());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(SuperheroBean superhero) {		
		try {
			this.template.update("UPDATE HEROES SET NAME = ?, ALTEREGO = ?, IMG = ? WHERE ID = ?",
					superhero.getName(),
					superhero.getAlterego(),
					superhero.getImage(),
					superhero.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(long id) {		
		try {
			this.template.update("DELETE FROM HEROES WHERE ID = ?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
