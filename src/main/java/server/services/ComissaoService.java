package server.services;

import java.util.List;

import server.entities.Comissao;
import server.entities.DTOs.ComissaoDTO;

public interface ComissaoService {
	
	/**
	 * Find Comissao by nome.
	 * @param nome
	 * @return
	 */
	Comissao findByNome(String nome);
	
	/**
	 * Find all Comissao.
	 * @return All Comissao in the database;
	 */
	List<Comissao> findAll();
	
	/**
	 * Save Comissao in to database.
	 * @param Comissao
	 * @return
	 */
	Comissao save(ComissaoDTO comissao);
	
	/**
	 * Delete Comissao by nome.
	 * @param dni
	 */
	void delete(String nome);

}
