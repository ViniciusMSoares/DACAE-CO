package server.entities.DTOs;

public class PropostaDTO {

	private String autor;
	private int ano;
	private String ementa;
	private String interesses;
	private String enderecoDoc;
	
	public PropostaDTO() {}

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

	public String getEnderecoDoc() {
		return enderecoDoc;
	}

	public void setEnderecoDoc(String enderecoDoc) {
		this.enderecoDoc = enderecoDoc;
	}

}
