package es.fpdual.heroesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.heroesapi.model.SuperheroBean;
import es.fpdual.heroesapi.service.SuperheroException;
import es.fpdual.heroesapi.service.SuperheroService;

@RestController
@RequestMapping("/superheros")
public class SuperheroController {

	@Autowired
	private SuperheroService service;

	@GetMapping("/")
	public List<SuperheroBean> listAllSuperheroes() {
		return this.service.selectAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getSuperheroById(@PathVariable long id) {
		try {
			return new ResponseEntity<>(this.service.selectById(id), HttpStatus.OK);
		} catch (SuperheroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	public ResponseEntity<String> createSuperhero(@RequestBody SuperheroBean superhero) {
		try {
			this.service.insert(superhero);
			return new ResponseEntity<>("Superhero created", HttpStatus.OK);
		} catch (SuperheroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping
	public ResponseEntity<String> updateSuperhero(@RequestBody SuperheroBean superhero) {
		try {
			this.service.update(superhero);
			return new ResponseEntity<>("Superhero " + superhero.getName() + " updated", HttpStatus.OK);
		} catch (SuperheroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSuperhero(@PathVariable long id) {
		try {
			this.service.delete(id);
			return new ResponseEntity<>("Superhero with id " + id + " deleted", HttpStatus.OK);
		} catch (SuperheroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
