package server.entities.DTOs;

public class VotacaoDTO {
	
	private String codigo;
	private String statusGovernista;
	private String proximoLocal;
	
	public VotacaoDTO() {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getStatusGovernista() {
		return statusGovernista;
	}

	public void setStatusGovernista(String statusGovernista) {
		this.statusGovernista = statusGovernista;
	}

	public String getProximoLocal() {
		return proximoLocal;
	}

	public void setProximoLocal(String proximoLocal) {
		this.proximoLocal = proximoLocal;
	}

}
