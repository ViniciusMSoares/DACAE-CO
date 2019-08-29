package server.services;

import java.util.List;

import server.entities.PEC;
import server.entities.PL;
import server.entities.PLP;
import server.entities.Proposta;
import server.entities.DTOs.PECDTO;
import server.entities.DTOs.PLDTO;
import server.entities.DTOs.PLPDTO;
import server.entities.DTOs.VotacaoDTO;

public interface PropostaService {

	/**
	 * Find Proposta by codigo.
	 * @param codigo
	 * @return
	 */
	Proposta findByCodigo(String codigo);
	
	/**
	 * Find all Proposta.
	 * @return All Proposta in the database;
	 */
	List<Proposta> findAll();
	
	/**
	 * Save Proposta in to database.
	 * @param Proposta
	 * @return
	 */
	PL save(PLDTO proposta);
	
	PLP save(PLPDTO proposta);
	
	PEC save(PECDTO proposta);
	
	/**
	 * Delete Proposta by nome.
	 * @param dni
	 */
	void delete(String partido);

	boolean votar(VotacaoDTO votacao);
	
}
