package es.fpdual.heroesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.heroesapi.model.SuperheroBean;
import es.fpdual.heroesapi.model.SuperpowerBean;
import es.fpdual.heroesapi.repository.SuperheroRepository;

@Service
@Transactional
public class SuperheroServiceImpl implements SuperheroService {

	@Autowired
	private SuperheroRepository repository;
	
	@Autowired
	private SuperpowerService superpowerService;

	@Override
	public List<SuperheroBean> selectAll() {
		List<SuperheroBean> superheros = this.repository.selectAll();

		if (superheros.isEmpty()) {
			return superheros;
		}

		superheros.forEach(superhero -> {
			List<SuperpowerBean> superpoderes = this.superpowerService.selectAll(superhero.getId());
			superhero.setSuperpowers(superpoderes);
		});

		return superheros;
	}

	@Override
	public SuperheroBean selectById(long id) {
		SuperheroBean superhero =  this.repository.selectById(id);
		
		if (superhero == null) {
			return superhero;
		}
		
		List<SuperpowerBean> superpoderes = this.superpowerService.selectAll(superhero.getId());
		superhero.setSuperpowers(superpoderes);
		
		return superhero;
		
	}

	@Override
	public void insert(SuperheroBean superhero) {
		this.repository.insert(superhero);
		this.superpowerService.insert(superhero.getId(), superhero.getSuperpowers());
	}

	@Override
	public void update(SuperheroBean superhero) {
		this.repository.update(superhero);
		this.superpowerService.delete(superhero.getId());
		this.superpowerService.insert(superhero.getId(), superhero.getSuperpowers());
	}

	@Override
	public void delete(long id) {
		this.superpowerService.delete(id);
		this.repository.delete(id);
		}

}
