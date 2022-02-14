package es.fpdual.heroesapi.service;

import java.util.List;

import es.fpdual.heroesapi.model.SuperpowerBean;

public interface SuperpowerService {

	List<SuperpowerBean> selectAll(long idHero);
	
	void insert(long idHero, List<SuperpowerBean> superpowers);
	
	void delete(long idHero);

}
