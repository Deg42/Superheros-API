package es.fpdual.heroesapi.service;

import java.util.List;

import es.fpdual.heroesapi.model.SuperpowerBean;

public interface SuperpowerService {

	List<SuperpowerBean> selectAll();

	SuperpowerBean selectById(long id);

	void insert(SuperpowerBean superpower);

	void update(SuperpowerBean superpower);

	void delete(long id);

}
