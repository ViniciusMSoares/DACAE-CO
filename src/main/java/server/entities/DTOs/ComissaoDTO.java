package server.entities.DTOs;

public class ComissaoDTO {
	
	private String tema;
	
	private String politicos;//mudar para lista

	public ComissaoDTO() {}

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
