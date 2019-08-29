package server.entities.DTOs;

public class PLDTO extends PropostaDTO {

	private boolean conclusivo;
	
	public PLDTO() {}

	public boolean isConclusivo() {
		return conclusivo;
	}

	public void setConclusivo(boolean conclusivo) {
		this.conclusivo = conclusivo;
	}

}
