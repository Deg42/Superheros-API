package es.fpdual.heroesapi.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuperheroBean {

	private long id;
	private String name;
	private String alterego;
	private String image;
	private List<SuperpowerBean> superpowers;

	public SuperheroBean(long id, String name, String alterego, String image, List<SuperpowerBean> superpowers) {
		this.id = id;
		this.name = name;
		this.alterego = alterego;
		this.image = image;
		this.superpowers = superpowers;
	}

}
