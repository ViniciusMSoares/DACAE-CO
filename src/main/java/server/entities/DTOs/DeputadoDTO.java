package server.entities.DTOs;

public class DeputadoDTO {

	private String dni;
	
	private String dataDeInicio;
	
	public DeputadoDTO() {
	}
	
	public String getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(String dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
