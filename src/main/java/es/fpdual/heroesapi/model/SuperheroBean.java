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
	private List<WeaknessBean> weaknesses;

}
