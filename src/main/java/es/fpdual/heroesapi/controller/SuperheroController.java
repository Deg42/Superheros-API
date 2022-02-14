package es.fpdual.heroesapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.heroesapi.model.SuperheroBean;

@RestController
@RequestMapping("/superheros")
public class SuperheroController {

	@GetMapping("/")
	public List<SuperheroBean> listAll() {
		List<SuperheroBean> heroesList = new ArrayList<SuperheroBean>();

		heroesList.add(new SuperheroBean(10, "Superman", "Clark Kent", null));
		heroesList.add(new SuperheroBean(11, "Hulk", "Bruce Banner", null));
		heroesList.add(new SuperheroBean(12, "Black Widow", "Natasha Romanoff", null));

		return heroesList;

	}

}
