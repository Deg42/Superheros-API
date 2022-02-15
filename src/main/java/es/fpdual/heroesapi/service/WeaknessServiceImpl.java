package es.fpdual.heroesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.heroesapi.model.WeaknessBean;
import es.fpdual.heroesapi.repository.WeaknessRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY) 
public class WeaknessServiceImpl implements WeaknessService {

	@Autowired
	private WeaknessRepository repository;

	@Override
	public List<WeaknessBean> selectAll(long idHero) {
		return this.repository.selectAll(idHero);
	}

	@Override
	public void insert(long idHero, List<WeaknessBean> weaknesses) {
		this.repository.insert(idHero, weaknesses);
	}

	@Override
	public void delete(long idHero) {
		this.repository.delete(idHero);
	}	

}
