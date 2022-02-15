package es.fpdual.heroesapi.service;

import java.util.List;

import es.fpdual.heroesapi.model.WeaknessBean;

public interface WeaknessService {

		List<WeaknessBean> selectAll(long idHero);
		
		void insert(long idHero, List<WeaknessBean> weaknesses);
		
		void delete(long idHero);
	
}
