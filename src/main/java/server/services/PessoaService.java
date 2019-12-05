package server.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.entities.Deputado;
import server.entities.Pessoa;
import server.entities.DTOs.DeputadoDTO;
import server.entities.DTOs.PessoaDTO;
import server.entities.DTOs.PessoaSPDTO;
import server.entities.DTOs.LoginDTO;

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
	Flux<Pessoa> findAll();
	
	Flux<Deputado> findAllDeputado();
	
	/**
	 * Save Pessoa in to database.
	 * @param Pessoa
	 * @return
	 */
	Mono<Pessoa> save(PessoaDTO pessoa);
	
	Mono<Pessoa> save(PessoaSPDTO pessoa);
	
	Mono<Deputado> save(DeputadoDTO deputado, String token);
	
	/**
	 * Delete Pessoa by dni.
	 * @param dni
	 */
	void delete(Long dni);
	
	ResponseEntity<String> login(LoginDTO login);
}
