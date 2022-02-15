package es.fpdual.heroesapi.repository;

import java.util.List;

import es.fpdual.heroesapi.model.WeaknessBean;

public interface WeaknessRepository {

	List<WeaknessBean> selectAll(long idHero);
	
	void insert(long idHero, List<WeaknessBean> weaknesses);
	
	void delete(long idHero);
}
