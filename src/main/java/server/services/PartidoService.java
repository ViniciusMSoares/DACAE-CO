package server.services;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.entities.Partido;
import server.entities.DTOs.PartidoDTO;

public interface PartidoService {
	
	/**
	 * Find Partido by nome.
	 * @param nome
	 * @return
	 */
	Mono<Partido> findByNome(String nome);
	
	/**
	 * Find all Partido.
	 * @return All Partido in the database;
	 */
	Flux<Partido> findAll();
	
	/**
	 * Save Partido in to database.
	 * @param Partido
	 * @return
	 */
	Mono<Partido> save(PartidoDTO partido);
	
	/**
	 * Delete partido by nome.
	 * @param dni
	 */
	void delete(String partido);

	String baseGovernista();
}
