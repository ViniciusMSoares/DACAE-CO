package server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa {
	
	private String nome;
	@Id
	private String dni;
	private String estado;
	private String interesses;
	private String partido;
	
	public Pessoa (String nome, String dni, String estado, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
	}
	
	public Pessoa (String nome, String dni, String estado, String interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = partido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

}
