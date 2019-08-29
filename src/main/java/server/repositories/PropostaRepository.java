package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

}
