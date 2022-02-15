package es.fpdual.heroesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.heroesapi.model.SuperheroBean;
import es.fpdual.heroesapi.model.SuperpowerBean;
import es.fpdual.heroesapi.repository.SuperheroRepository;

@Service
@Transactional(rollbackFor = SuperheroException.class)
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
	public SuperheroBean selectById(long id) throws SuperheroException {
		try {
			SuperheroBean superhero = this.repository.selectById(id);
			if (superhero == null) {
				return superhero;
			}

			List<SuperpowerBean> superpoderes = this.superpowerService.selectAll(superhero.getId());
			superhero.setSuperpowers(superpoderes);

			return superhero;

		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroException("Superhero with id " + id + " not found");
		}

	}

	@Override
	public void insert(SuperheroBean superhero) throws SuperheroException {
		try {
			SuperheroBean superheroExists = this.repository.selectById(superhero.getId());

			if (superheroExists != null) {
				throw new SuperheroException("Superhero with id " + superhero.getId() + " already exists");
			}
		} catch (EmptyResultDataAccessException e) {

		}
		this.repository.insert(superhero);

		if (superhero.getSuperpowers() == null || superhero.getSuperpowers().isEmpty()) {
			throw new SuperheroException("Superhero needs at leats one superpower");
		}

		this.superpowerService.insert(superhero.getId(), superhero.getSuperpowers());
	}

	@Override
	public void update(SuperheroBean superhero) throws SuperheroException {
		try {
			this.repository.selectById(superhero.getId());
			this.repository.update(superhero);
			this.superpowerService.delete(superhero.getId());

			if (superhero.getSuperpowers() == null || superhero.getSuperpowers().isEmpty()) {
				throw new SuperheroException("Superhero needs at leats one superpower");
			}

			this.superpowerService.insert(superhero.getId(), superhero.getSuperpowers());
		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroException("Superhero with id " + superhero.getId() + " not found");
		}

	}

	@Override
	public void delete(long id) throws SuperheroException {
		try {
			this.repository.selectById(id);
			this.superpowerService.delete(id);
			this.repository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroException("Superhero with id " + id + " not found");
		}
	}

}
