package es.fpdual.heroesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.heroesapi.model.SuperpowerBean;
import es.fpdual.heroesapi.repository.SuperpowerRepository;

@Service
@Transactional
public class SuperpowerServiceImpl implements SuperpowerService {

	@Autowired
	private SuperpowerRepository repository;

	@Override
	public List<SuperpowerBean> selectAll() {
		return this.repository.selectAll();
	}

	@Override
	public SuperpowerBean selectById(long id) {
		return this.repository.selectById(id);
	}

	@Override
	public void insert(SuperpowerBean superhero) {
		this.repository.insert(superhero);
	}

	@Override
	public void update(SuperpowerBean superhero) {
		this.repository.update(superhero);
	}

	@Override
	public void delete(long id) {
		this.repository.delete(id);
	}

}
