package services;

import java.util.List;

import entities.Pessoa;
import entities.DTOs.PessoaDTO;

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
	
	/**
	 * Save Pessoa in to database.
	 * @param Pessoa
	 * @return
	 */
	Pessoa save(PessoaDTO elemento);
	
	/**
	 * Delete Pessoa by dni.
	 * @param dni
	 */
	void delete(Long dni);
}
