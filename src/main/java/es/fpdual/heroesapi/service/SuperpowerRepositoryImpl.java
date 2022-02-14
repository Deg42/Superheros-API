package es.fpdual.heroesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.heroesapi.model.SuperpowerBean;
import es.fpdual.heroesapi.repository.SuperpowerRepository;

@Service
public class SuperpowerRepositoryImpl implements SuperpowerService {
	
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
	public void insert(SuperpowerBean superpower) {
		this.repository.insert(superpower);
	}

	@Override
	public void update(SuperpowerBean superpower) {
		this.repository.update(superpower);
	}

	@Override
	public void delete(long id) {
		this.repository.delete(id);
	}

}
