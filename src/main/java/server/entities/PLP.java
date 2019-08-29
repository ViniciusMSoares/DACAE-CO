package server.entities;

import javax.persistence.Entity;

@Entity
public class PLP extends Proposta {
	
	private String artigo;
	private static int count = 1;

	public PLP(String dni, int ano, String ementa, String interesses, String url, String artigo) {
		super(dni, ano, ementa, interesses, url);
		this.setArtigo(artigo);
		this.setCodigo("PLP " + count + "/" + ano);
		count++;
	}

	public PLP() {}

	public String getArtigo() {
		return artigo;
	}

	public void setArtigo(String artigo) {
		this.artigo = artigo;
	}
	
	@Override
	public String toString() {
		return "Projeto de Lei Complementar - " + getCodigo() + " - " + getAutor() + " - " + getEmenta() + " - " + getArtigo()
					+ " - " + getSituacao();
	}

}
