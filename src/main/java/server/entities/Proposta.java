package server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Proposta {

	/*
	Autor (político)
	Ano
	Código (sequencial por tipo)
	Ementa
	Interesses relacionados
	Situação Atual
	Endereço do documento*/
	
	@Id
	private String codigo; //tipo seq ano
	
	private String autor; //dni
	private int ano;
	private String ementa;
	private String interesses;
	private String situacao;
	private String enderecoDoc;
	
	public Proposta(String dni, int ano, String ementa, String interesses, String url) {
		this.autor = dni;
		this.ano = ano;
		this.ementa = ementa;
		this.interesses = interesses;
		this.enderecoDoc = url;
		this.situacao = "EM VOTACAO (CCJC)";
	}
	
	public Proposta() {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getEnderecoDoc() {
		return enderecoDoc;
	}

	public void setEnderecoDoc(String enderecoDoc) {
		this.enderecoDoc = enderecoDoc;
	}

}
