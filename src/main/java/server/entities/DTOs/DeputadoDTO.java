package server.entities.DTOs;

public class DeputadoDTO extends PessoaDTO{

	private String dataDeInicio;
	
	public DeputadoDTO() {
		super();
	}
	
	public String getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(String dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

}
