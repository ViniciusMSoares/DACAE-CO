package server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partido implements Comparable {

	@Id
	private String partido;
	
	public Partido (String partido) {
		this.setPartido(partido);
	}
	
	public Partido () {}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	@Override
	public int compareTo(Object partido) {
		return this.partido.compareTo(((Partido) partido).getPartido());
	}

}
