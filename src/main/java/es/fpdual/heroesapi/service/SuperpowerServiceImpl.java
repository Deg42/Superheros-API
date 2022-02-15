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
	public List<SuperpowerBean> selectAll(long idHero) {
		return this.repository.selectAll(idHero);
	}

	@Override
	public void insert(long idHero, List<SuperpowerBean> superpowers) {
		this.repository.insert(idHero, superpowers);
	}

	@Override
	public void delete(long idHero) {
		this.repository.delete(idHero);
	}



	

}
