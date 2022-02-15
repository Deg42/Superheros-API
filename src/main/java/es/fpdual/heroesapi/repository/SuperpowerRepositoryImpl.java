package es.fpdual.heroesapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.fpdual.heroesapi.model.SuperpowerBean;

@Repository()
public class SuperpowerRepositoryImpl implements SuperpowerRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<SuperpowerBean> selectAll(long idHero) {
		try {
			return this.template.query("SELECT ID, POWER FROM SUPERPOWERS S "
					+ "INNER JOIN HERO_HAS_POW HP ON S.ID = HP.ID_POW " 
					+ "WHERE HP.ID_HERO = ?", 
					new SuperpowerMapper(), idHero);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void insert(long idHero, List<SuperpowerBean> superpowers) {
		try {
			superpowers.stream().forEach(superopower -> {
				this.template.update("INSERT INTO HERO_HAS_POW VALUES (?, ?)", idHero, superopower.getId());
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(long idHero) {
		try {
			this.template.update("DELETE FROM HERO_HAS_POW WHERE ID_HERO = ?", idHero);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
