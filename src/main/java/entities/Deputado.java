package entities;

import javax.persistence.Entity;

@Entity
public class Deputado extends Pessoa {
	
	private String dataDeInicio;

	public Deputado(String nome, String dni, String estado, String interesses, String partido, String dataDeInicio) {
		super(nome, dni, estado, interesses, partido);
		this.dataDeInicio = dataDeInicio;
	}

	public String getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(String dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

}
