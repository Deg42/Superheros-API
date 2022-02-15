package es.fpdual.heroesapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.fpdual.heroesapi.model.WeaknessBean;

@Repository
public class WeaknessRepositoryImpl implements WeaknessRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<WeaknessBean> selectAll(long idHero) {
		try {
			return this.template.query("SELECT ID, WEAKNESS FROM WEAKNESSES W "
					+ "INNER JOIN HERO_HAS_WEA HW ON W.ID = HW.ID_WEA "
					+ "WHERE HW.ID_HERO = ?", 
					new WeaknessMapper(), idHero);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void insert(long idHero, List<WeaknessBean> weaknesses) {
		try {
			weaknesses.stream().forEach(weakness -> {
				this.template.update("INSERT INTO HERO_HAS_WEA VALUES (?, ?)", idHero, weakness.getId());
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void delete(long idHero) {
		try {
			this.template.update("DELETE FROM HERO_HAS_WEA WHERE ID_HERO = ?", idHero);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
