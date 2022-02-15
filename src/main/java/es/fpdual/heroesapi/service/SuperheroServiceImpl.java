package es.fpdual.heroesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.heroesapi.model.SuperheroBean;
import es.fpdual.heroesapi.model.SuperpowerBean;
import es.fpdual.heroesapi.model.WeaknessBean;
import es.fpdual.heroesapi.repository.SuperheroRepository;

@Service
@Transactional(rollbackFor = SuperheroException.class, noRollbackFor = ImageException.class)
public class SuperheroServiceImpl implements SuperheroService {

	@Autowired
	private SuperheroRepository repository;

	@Autowired
	private SuperpowerService superpowerService;

	@Autowired
	private WeaknessService weaknessService;

	@Override
	public List<SuperheroBean> selectAll() {
		List<SuperheroBean> superheros = this.repository.selectAll();

		if (superheros.isEmpty()) {
			return superheros;
		}

		superheros.forEach(superhero -> {
			List<SuperpowerBean> superpowers = this.superpowerService.selectAll(superhero.getId());
			superhero.setSuperpowers(superpowers);
		});

		superheros.forEach(superhero -> {
			List<WeaknessBean> weakness = this.weaknessService.selectAll(superhero.getId());
			superhero.setWeaknesses(weakness);
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

			List<SuperpowerBean> superpowers = this.superpowerService.selectAll(superhero.getId());
			superhero.setSuperpowers(superpowers);

			List<WeaknessBean> weaknesses = this.weaknessService.selectAll(superhero.getId());
			superhero.setWeaknesses(weaknesses);

			return superhero;

		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroException("ERROR: Superhero with id " + id + " not found");
		}

	}

	@Override
	public void insert(SuperheroBean superhero) throws SuperheroException, ImageException {
		try {
			SuperheroBean superheroExists = this.repository.selectById(superhero.getId());

			if (superheroExists != null) {
				throw new SuperheroException("ERROR: Superhero with id " + superhero.getId() + " already exists");
			}

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		this.repository.insert(superhero);

		if (superhero.getSuperpowers() == null || superhero.getSuperpowers().isEmpty()) {
			throw new SuperheroException("ERROR: Superhero needs at leats one superpower");
		}
		if (superhero.getWeaknesses() == null || superhero.getWeaknesses().isEmpty()) {
			throw new SuperheroException("ERROR: Superhero needs at leats one weakness");
		}
		if (superhero.getImage() == null || "".equals(superhero.getImage())) {
			throw new ImageException("INFO: Superhero created without image");
		}

		this.superpowerService.insert(superhero.getId(), superhero.getSuperpowers());
		this.weaknessService.insert(superhero.getId(), superhero.getWeaknesses());
	}

	@Override
	public void update(SuperheroBean superhero) throws SuperheroException, ImageException{
		try {
			this.repository.selectById(superhero.getId());
			this.repository.update(superhero);
			this.superpowerService.delete(superhero.getId());
			this.weaknessService.delete(superhero.getId());

			if (superhero.getSuperpowers() == null || superhero.getSuperpowers().isEmpty()) {
				throw new SuperheroException("ERROR: Superhero needs at least one superpower");
			}
			if (superhero.getWeaknesses() == null || superhero.getWeaknesses().isEmpty()) {
				throw new SuperheroException("ERROR: Superhero needs at least one weakness");
			}
			if (superhero.getImage() == null || "".equals(superhero.getImage())) {
				throw new ImageException("INFO: Superhero updated without image");
			}
			
			this.superpowerService.insert(superhero.getId(), superhero.getSuperpowers());
			this.weaknessService.insert(superhero.getId(), superhero.getWeaknesses());
		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroException("ERROR: Superhero with id " + superhero.getId() + " not found");
		}

	}

	@Override
	public void delete(long id) throws SuperheroException {
		try {
			this.repository.selectById(id);
			this.superpowerService.delete(id);
			this.weaknessService.delete(id);
			this.repository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroException("ERROR: Superhero with id " + id + " not found");
		}
	}

}
