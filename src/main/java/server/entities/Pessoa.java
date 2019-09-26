package server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table
public class Pessoa {
	
	private String nome;
	@Id
	private String dni;
	private String estado;
	private String interesses;
	private String partido;
	@JsonIgnore
	private String senha;
	
	public Pessoa () {}
	
	public Pessoa (String nome, String dni, String estado, String interesses, String senha) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.senha = senha;
	}
	
	public Pessoa (String nome, String dni, String estado, String interesses, String senha, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = partido;
		this.senha = senha;
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

	@Override
	public String toString() { //<Nome> - <DNI> (<Estado>) [ - <PARTIDO> ] [ - <Interesses> ]
		return nome + " - " + dni + " (" + estado + ")" + partidoToString() + interessesToString();
	}
	
	private String partidoToString() {
		String result = "";
		if (partido != null || partido.length() > 0) {
			result = " - " + partido;
		}
		return result;	
	}
	
	private String interessesToString() {
		String result = "";
		if (interesses != null || interesses.length() > 0) {
			result = " - " + interesses;
		}
		return result;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
