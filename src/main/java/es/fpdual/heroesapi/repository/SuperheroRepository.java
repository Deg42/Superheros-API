package es.fpdual.heroesapi.repository;

import java.util.List;

import es.fpdual.heroesapi.model.SuperheroBean;


public interface SuperheroRepository {

	List<SuperheroBean> selectAll();
	
	SuperheroBean selectById(long id);
	
	void insert(SuperheroBean superhero);
	
	void update(SuperheroBean superhero);
	
	void delete(long id);
	
}
