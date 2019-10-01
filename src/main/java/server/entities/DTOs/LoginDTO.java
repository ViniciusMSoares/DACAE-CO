package server.entities.DTOs;

public class LoginDTO {
	
	private String senha;
	private String dni;
	
	public LoginDTO() {
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
