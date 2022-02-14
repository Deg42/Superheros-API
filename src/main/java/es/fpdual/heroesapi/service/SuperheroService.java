package es.fpdual.heroesapi.service;

import java.util.List;

import es.fpdual.heroesapi.model.SuperheroBean;

public interface SuperheroService {

	List<SuperheroBean> selectAll();

	SuperheroBean selectById(long id);

	void insert(SuperheroBean superhero);

	void update(SuperheroBean superhero);

	void delete(long id);

}
