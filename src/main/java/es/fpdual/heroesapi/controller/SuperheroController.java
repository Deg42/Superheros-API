package es.fpdual.heroesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.heroesapi.model.SuperheroBean;
import es.fpdual.heroesapi.model.SuperpowerBean;
import es.fpdual.heroesapi.service.SuperheroService;
import es.fpdual.heroesapi.service.SuperpowerService;

@RestController
@RequestMapping("/superheros")
public class SuperheroController {

	@Autowired
	private SuperheroService service;
	
	@Autowired
	private SuperpowerService powerService;

	/*
	 * @GetMapping("/") public List<SuperheroBean> listAll() { List<SuperheroBean>
	 * heroesList = new ArrayList<SuperheroBean>();
	 * 
	 * heroesList.add(new SuperheroBean(10, "Superman", "Clark Kent", null));
	 * heroesList.add(new SuperheroBean(11, "Hulk", "Bruce Banner", null));
	 * heroesList.add(new SuperheroBean(12, "Black Widow", "Natasha Romanoff",
	 * null));
	 * 
	 * return heroesList;
	 * 
	 * }
	 */

	@GetMapping("/")
	public List<SuperheroBean> listAllSuperheroes() {
		return this.service.selectAll();
	}
	
	@GetMapping("/notCallable")
	public List<SuperpowerBean> listAllSuperpowersBatman() {
		return this.powerService.selectAll(1);
	}

	@GetMapping("/{id}")
	public SuperheroBean getSuperheroById(@PathVariable long id) {
		return this.service.selectById(id);
	}

	@PostMapping
	public void createSuperhero(@RequestBody SuperheroBean superhero) {
		this.service.insert(superhero);
	}
	
	@PatchMapping
	public void updateSuperhero(@RequestBody SuperheroBean superhero) {
		this.service.update(superhero);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSuperhero(@PathVariable long id) {
		this.service.delete(id);
	}

}
