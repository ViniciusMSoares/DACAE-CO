package server.entities;

import javax.persistence.Entity;

@Entity
public class PEC extends Proposta {
	
	private String artigo;
	private static int count = 1;

	public PEC(String dni, int ano, String ementa, String interesses, String url, String artigo) {
		super(dni, ano, ementa, interesses, url);
		this.artigo = artigo;
		this.setCodigo("PEC " + count + "/" + ano);
		count++;
	}

	public PEC() {}
	
	public String getArtigo() {
		return artigo;
	}

	public void setArtigo(String artigo) {
		this.artigo = artigo;
	}
	
	@Override
	public String toString() {
		return "Projeto de Emenda Constitucional - " + getCodigo() + " - " + getAutor() + " - " + getEmenta() + " - " + getArtigo()
					+ " - " + getSituacao();
	}

}
