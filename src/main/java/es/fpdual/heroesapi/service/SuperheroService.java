package es.fpdual.heroesapi.service;

import java.util.List;

import es.fpdual.heroesapi.model.SuperheroBean;

public interface SuperheroService {

	List<SuperheroBean> selectAll();

	SuperheroBean selectById(long id) throws SuperheroException;

	void insert(SuperheroBean superhero) throws SuperheroException;

	void update(SuperheroBean superhero) throws SuperheroException;

	void delete(long id) throws SuperheroException;

}
