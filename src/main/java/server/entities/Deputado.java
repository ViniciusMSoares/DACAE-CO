package server.entities;

import javax.persistence.Entity;

@Entity
public class Deputado extends Pessoa {
	
	private String dataDeInicio;
	private int numLeis;

	public Deputado(Pessoa pessoa, String dataDeInicio) {
		super(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), pessoa.getInteresses(), pessoa.getPartido());
		this.dataDeInicio = dataDeInicio;
		this.numLeis = 0;
	}
	
	public Deputado () {}

	public String getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(String dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public int getNumLeis() {
		return numLeis;
	}

	public void setNumLeis(int numLeis) {
		this.numLeis = numLeis;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + dataDeInicio + " - " + numLeis + " Leis";
	}

}
