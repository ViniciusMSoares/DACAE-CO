package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import server.entities.Proposta;

public interface PropostaRepository extends ReactiveCrudRepository<Proposta, Long> {

}
