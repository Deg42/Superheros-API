package es.fpdual.heroesapi.model;

import lombok.Data;

@Data
public class SuperheroBean {

	private long id;
	private String name;
	private String alterego;
	private String image;

	public SuperheroBean(long id, String name, String alterego, String image) {
		this.id = id;
		this.name = name;
		this.alterego = alterego;
		this.image = image;
	}

}
