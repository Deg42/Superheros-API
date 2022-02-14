package es.fpdual.heroesapi.repository;

import java.util.List;

import es.fpdual.heroesapi.model.SuperpowerBean;

public interface SuperpowerRepository {

	List<SuperpowerBean> selectAll();

	SuperpowerBean selectById(long id);

	void insert(SuperpowerBean superpower);

	void update(SuperpowerBean superpower);

	void delete(long id);

}
