package es.fpdual.heroesapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.fpdual.heroesapi.model.SuperpowerBean;

@Repository
public class SuperpowerRepositoryImpl implements SuperpowerRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<SuperpowerBean> selectAll() {
		try {
			return this.template.query("SELECT * FROM SUPERPOWERS", new SuperpowerMapper());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public SuperpowerBean selectById(long id) {
		try {
			return this.template.queryForObject("SELECT * FROM SUPERPOWERS WHERE ID = ?", new SuperpowerMapper(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void insert(SuperpowerBean superpower) {
			try {
			this.template.update("INSERT INTO SUPERPOWERS VALUES (?, ?)", 
					superpower.getId(), 
					superpower.getPower());		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(SuperpowerBean superpower) {		
		try {
			this.template.update("UPDATE SUPERPOWERS SET POWER = ? WHERE ID = ?",
					superpower.getPower(),
					superpower.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(long id) {		
		try {
			this.template.update("DELETE FROM SUPERPOWERS WHERE ID = ?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
