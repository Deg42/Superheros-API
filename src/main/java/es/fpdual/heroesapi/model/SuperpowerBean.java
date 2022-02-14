package es.fpdual.heroesapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuperpowerBean {

	private long id;
	private String power;
	
	public SuperpowerBean(long id, String power) {
		super();
		this.id = id;
		this.power = power;
	}

}
