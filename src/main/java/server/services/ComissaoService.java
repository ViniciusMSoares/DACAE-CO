package server.services;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.entities.Comissao;
import server.entities.DTOs.ComissaoDTO;

public interface ComissaoService {
	
	/**
	 * Find Comissao by nome.
	 * @param nome
	 * @return
	 */
	Mono<Comissao> findByNome(String nome);
	
	/**
	 * Find all Comissao.
	 * @return All Comissao in the database;
	 */
	Flux<Comissao> findAll();
	
	/**
	 * Save Comissao in to database.
	 * @param Comissao
	 * @return
	 */
	Mono<Comissao> save(ComissaoDTO comissao);
	
	/**
	 * Delete Comissao by nome.
	 * @param dni
	 */
	void delete(String nome);

}
