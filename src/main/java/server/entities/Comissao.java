package server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comissao {

	@Id
	private String tema;
	
	private String politicos;
	
	public Comissao() {}

	public Comissao(String tema, String politicos) {
		this.tema = tema;
		this.politicos = politicos;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getPoliticos() {
		return politicos;
	}

	public void setPoliticos(String politicos) {
		this.politicos = politicos;
	}

}
