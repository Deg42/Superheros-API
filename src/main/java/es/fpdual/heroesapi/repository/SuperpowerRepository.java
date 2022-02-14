package es.fpdual.heroesapi.repository;

import java.util.List;

import es.fpdual.heroesapi.model.SuperpowerBean;


public interface SuperpowerRepository {

	List<SuperpowerBean> selectAll(long idHero);
		
	void insert(long idHero, List<SuperpowerBean> superpowers);
	
	void delete(long idHero);
	
}
