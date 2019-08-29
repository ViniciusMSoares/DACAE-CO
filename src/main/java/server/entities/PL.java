package server.entities;

import javax.persistence.Entity;

@Entity
public class PL extends Proposta {

	private boolean conclusivo;
	private static int count = 1;
	
	public PL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		super(dni, ano, ementa, interesses, url);
		this.conclusivo = conclusivo;
		this.setCodigo("PL " + count + "/" + ano);
		count++;
	}

	public PL() {}

	public boolean isConclusivo() {
		return conclusivo;
	}

	public void setConclusivo(boolean conclusivo) {
		this.conclusivo = conclusivo;
	}
	
	//Projeto de Lei - Código - DNI - Ementa - Conclusivo - Situação
	//Ex.: Projeto de Lei - PL 1/2019 - 123456789-0 - Altera valor da multa no CTB para
	//que dirigir com aparelho auditivo em um dos ouvidos - Conclusiva - EM VOTACAO (CCJC)
	@Override
	public String toString() {
		return "Projeto de Lei - " + getCodigo() + " - " + getAutor() + " - " + getEmenta() + " - " + conclusivoToString()
					+ " - " + getSituacao();
	}
	
	private String conclusivoToString() {
		if (conclusivo) {
			return "Conclusivo";
		}
		return "Não Conslusivo";
	}

}
