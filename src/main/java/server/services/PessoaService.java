package server.services;

import java.util.List;

import server.entities.Deputado;
import server.entities.Pessoa;
import server.entities.DTOs.DeputadoDTO;
import server.entities.DTOs.PessoaDTO;
import server.entities.DTOs.PessoaSPDTO;

public interface PessoaService {
	
	/**
	 * Find Pessoa by dni.
	 * @param dni
	 * @return
	 */
	Pessoa findByDni(String dni);
	
	/**
	 * Find all Pessoa.
	 * @return All Pessoa in the database;
	 */
	List<Pessoa> findAll();
	
	List<Deputado> findAllDeputado();
	
	/**
	 * Save Pessoa in to database.
	 * @param Pessoa
	 * @return
	 */
	Pessoa save(PessoaDTO pessoa);
	
	Pessoa save(PessoaSPDTO pessoa);
	
	Deputado save(DeputadoDTO deputado);
	
	/**
	 * Delete Pessoa by dni.
	 * @param dni
	 */
	void delete(Long dni);
}
