package es.fpdual.heroesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.heroesapi.model.SuperheroBean;
import es.fpdual.heroesapi.repository.SuperheroRepository;

@Service
@Transactional
public class SuperheroServiceImpl implements SuperheroService {

	@Autowired
	private SuperheroRepository repository;

	@Override
	public List<SuperheroBean> selectAll() {
		return this.repository.selectAll();
	}

	@Override
	public SuperheroBean selectById(long id) {
		return this.repository.selectById(id);
	}

	@Override
	public void insert(SuperheroBean superhero) {
		this.repository.insert(superhero);
	}

	@Override
	public void update(SuperheroBean superhero) {
		this.repository.update(superhero);
	}

	@Override
	public void delete(long id) {
		this.repository.delete(id);
	}

}
